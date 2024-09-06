package org.gampiot.robok.feature.editor.languages.java.store.models

import kotlinx.serialization.Serializable

@Serializable
data class Contributor(
    val className String,
    val classPackageName: String
)
