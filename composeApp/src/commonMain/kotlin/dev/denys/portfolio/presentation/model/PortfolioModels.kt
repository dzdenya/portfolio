package dev.denys.portfolio.presentation.model

import org.jetbrains.compose.resources.DrawableResource

data class SkillGroup(
    val category: String,
    val icon: DrawableResource,
    val items: List<String>,
)

data class ContactEntry(
    val label: String,
    val icon: DrawableResource,
    val value: String,
    val uri: String,
)
