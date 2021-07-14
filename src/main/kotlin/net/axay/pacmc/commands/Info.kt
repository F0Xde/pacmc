package net.axay.pacmc.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.mordant.rendering.TextColors.green
import com.github.ajalt.mordant.rendering.TextColors.white
import com.github.ajalt.mordant.rendering.TextStyles.bold
import net.axay.pacmc.Values
import net.axay.pacmc.Values.dbFile
import net.axay.pacmc.terminal
import net.axay.pacmc.utils.OperatingSystem

object Info : CliktCommand(
    "Prints debug information"
) {
    override fun run() {
        val version = this::class.java.getResource("/pacmc_version.txt")?.readText() ?: "unknown version"

        terminal.println(
            """
                ${white(bold("pacmc") + " version ") + green(version)}
                
                dataLocalDir: ${Values.projectDirectories.dataLocalDir}
                databaseDir: $dbFile
                
                Your OS: ${OperatingSystem.current ?: "unknown"}
                Java version: ${Runtime.version()}
            """.trimIndent()
        )
    }
}
