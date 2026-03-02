package dev.denys.portfolio.presentation.model

import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource

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
    val icon: DrawableResource,
    val value: String,
    val uri: String,
)
