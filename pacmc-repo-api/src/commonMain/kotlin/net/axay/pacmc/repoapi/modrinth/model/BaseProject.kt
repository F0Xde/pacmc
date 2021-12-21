/**
 * Labrinth
 *
 * This API is documented in the **OpenAPI format** and is available for download [here](/openapi.yaml).  # Cross-Origin Resource Sharing This API features Cross-Origin Resource Sharing (CORS) implemented in compliance with  [W3C spec](https://www.w3.org/TR/cors/). This allows for cross-domain communication from the browser. All responses have a wildcard same-origin which makes them completely public and accessible to everyone, including any code on any site.  # Authentication This API uses GitHub tokens for authentication. The token is in the `Authorization` header of the request. You can get a token [here](#operation/initAuth).    Example:  ```  Authorization: gho_pJ9dGXVKpfzZp4PUHSxYEq9hjk0h288Gwj4S  ``` 
 *
 * The version of the OpenAPI document: 13187de (v2)
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package net.axay.pacmc.repoapi.modrinth.model


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param slug The slug of a project, used for vanity URLs
 * @param title The title or name of the project
 * @param description A short description of the project
 * @param categories A list of the categories that the project is in
 * @param clientSide The client side support of the project
 * @param serverSide The server side support of the project
 */
@Serializable
data class BaseProject (

    /* The slug of a project, used for vanity URLs */
    @SerialName(value = "slug") val slug: kotlin.String? = null,

    /* The title or name of the project */
    @SerialName(value = "title") val title: kotlin.String? = null,

    /* A short description of the project */
    @SerialName(value = "description") val description: kotlin.String? = null,

    /* A list of the categories that the project is in */
    @SerialName(value = "categories") val categories: kotlin.collections.List<kotlin.String>? = null,

    /* The client side support of the project */
    @SerialName(value = "client_side") val clientSide: BaseProject.ClientSide? = null,

    /* The server side support of the project */
    @SerialName(value = "server_side") val serverSide: BaseProject.ServerSide? = null

) {

    /**
     * The client side support of the project
     *
     * Values: required,optional,unsupported
     */
    @Serializable
    enum class ClientSide(val value: kotlin.String) {
        @SerialName(value = "required") required("required"),
        @SerialName(value = "optional") optional("optional"),
        @SerialName(value = "unsupported") unsupported("unsupported");
    }
    /**
     * The server side support of the project
     *
     * Values: required,optional,unsupported
     */
    @Serializable
    enum class ServerSide(val value: kotlin.String) {
        @SerialName(value = "required") required("required"),
        @SerialName(value = "optional") optional("optional"),
        @SerialName(value = "unsupported") unsupported("unsupported");
    }
}

