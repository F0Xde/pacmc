package net.axay.pacmc.cli.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.mordant.rendering.TextColors
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import net.axay.pacmc.app.features.Archive
import net.axay.pacmc.app.repoapi.repoApiContext
import net.axay.pacmc.cli.launchJob
import net.axay.pacmc.cli.terminal
import net.axay.pacmc.cli.terminal.archiveIdOption
import net.axay.pacmc.cli.terminal.optimalTerminalString
import net.axay.pacmc.cli.terminal.terminalFromString

class ListCommand : CliktCommand(
    name = "list",
    help = "List content installed to an archive",
) {
    private val archiveName by archiveIdOption("The archive which contains the content that should be listed")

    override fun run() = launchJob {
        terminal.println("The archive '$archiveName' contains the following content:")
        val archive = Archive.terminalFromString(archiveName) ?: return@launchJob

        val installed = mutableListOf<Pair<String, String>>()
        val installedDependencies = mutableListOf<Pair<String, String>>()
        val installedMutex = Mutex()

        coroutineScope {
            archive.getInstalled().forEach { project ->
                launch {
                    val projectLine = async {
                        buildString {
                            append(project.optimalTerminalString())
                            if (project.dependency) {
                                append(" ${TextColors.cyan("(dependency)")}")
                            }
                        }
                    }
                    val descriptionLine = async {
                        TextColors.gray(
                            repoApiContext { it.getBasicProjectInfo(project.readModId()) }?.description
                                ?: "no description available"
                        )
                    }
                    val list = if (project.dependency) installedDependencies else installed
                    (projectLine.await() to descriptionLine.await()).let { installedMutex.withLock { list += it } }
                }
            }
        }

        terminal.println()
        (installed + installedDependencies).forEach { (projectLine, descriptionLine) ->
            terminal.println(projectLine)
            terminal.println("  $descriptionLine")
        }
    }
}
