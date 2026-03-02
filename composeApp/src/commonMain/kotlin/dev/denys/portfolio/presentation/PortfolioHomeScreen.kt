package dev.denys.portfolio.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.denys.portfolio.presentation.model.ContactEntry
import dev.denys.portfolio.presentation.model.SkillGroup
import dev.denys.portfolio.presentation.sections.ContactSection
import dev.denys.portfolio.presentation.sections.FooterSection
import dev.denys.portfolio.presentation.sections.HeroSection
import dev.denys.portfolio.presentation.sections.SkillsSection

@Composable
fun PortfolioHomeScreen(
    contacts: List<ContactEntry>,
    skills: List<SkillGroup>,
    onOpenLink: (String) -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
    ) {
        val viewportHeight = maxHeight

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF020617))
                .verticalScroll(rememberScrollState()),
        ) {
            HeroSection(
                sectionHeight = viewportHeight,
                contacts = contacts,
                onOpenLink = onOpenLink,
            )
            SkillsSection(skills = skills)
            ContactSection(
                contacts = contacts,
                onOpenLink = onOpenLink,
            )
            FooterSection()
        }
    }
}
