package dev.denys.portfolio.presentation.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ActionLink(
    val label: String,
    val icon: ImageVector,
    val uri: String,
)

data class SkillGroup(
    val category: String,
    val icon: ImageVector,
    val items: List<String>,
)

data class ContactEntry(
    val label: String,
    val icon: ImageVector,
    val value: String,
    val uri: String,
)
