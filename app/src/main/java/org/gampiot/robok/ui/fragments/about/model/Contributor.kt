package org.gampiot.robok.ui.fragments.about.model

import kotlinx.serialization.Serializable

@Serializable
data class Contributor(
    val avatar_url: String,
    val login: String,
    val role: String,
    val html_url: String
)