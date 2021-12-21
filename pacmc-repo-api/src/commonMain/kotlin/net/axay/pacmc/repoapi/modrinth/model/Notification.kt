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
 * @param id The id of the notification
 * @param userId The id of the user who received the notification
 * @param type The type of notification
 * @param title The title of the notification
 * @param text The body text of the notification
 * @param link A link to the related project or version
 * @param read Whether the notification has been read or not
 * @param created The time at which the notification was created
 * @param actions A list of actions that can be performed
 */
@Serializable
data class Notification (

    /* The id of the notification */
    @SerialName(value = "id") val id: kotlin.String? = null,

    /* The id of the user who received the notification */
    @SerialName(value = "user_id") val userId: kotlin.String? = null,

    /* The type of notification */
    @SerialName(value = "type") val type: kotlin.String? = null,

    /* The title of the notification */
    @SerialName(value = "title") val title: kotlin.String? = null,

    /* The body text of the notification */
    @SerialName(value = "text") val text: kotlin.String? = null,

    /* A link to the related project or version */
    @SerialName(value = "link") val link: kotlin.String? = null,

    /* Whether the notification has been read or not */
    @SerialName(value = "read") val read: kotlin.Boolean? = null,

    /* The time at which the notification was created */
    @SerialName(value = "created") val created: kotlin.String? = null,

    /* A list of actions that can be performed */
    @SerialName(value = "actions") val actions: kotlin.collections.List<kotlin.String>? = null

)

