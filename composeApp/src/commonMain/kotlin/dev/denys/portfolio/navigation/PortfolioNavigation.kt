package dev.denys.portfolio.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import dev.denys.portfolio.presentation.PortfolioHomeScreen
import dev.denys.portfolio.presentation.data.portfolioActionLinks
import dev.denys.portfolio.presentation.data.portfolioContacts
import dev.denys.portfolio.presentation.data.portfolioSkills

@Composable
fun PortfolioNavigation() {
    val uriHandler = LocalUriHandler.current

    MaterialTheme {
        PortfolioHomeScreen(
            actionLinks = portfolioActionLinks,
            skills = portfolioSkills,
            contacts = portfolioContacts,
            onOpenLink = uriHandler::openUri,
        )
    }
}
