package dev.denys.portfolio.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import dev.denys.portfolio.presentation.PortfolioHomeScreen
import dev.denys.portfolio.presentation.data.portfolioContacts
import dev.denys.portfolio.presentation.data.portfolioSkills

@Composable
fun PortfolioNavigation() {
    val uriHandler = LocalUriHandler.current

    MaterialTheme {
        PortfolioHomeScreen(
            contacts = portfolioContacts,
            skills = portfolioSkills,
            onOpenLink = uriHandler::openUri,
        )
    }
}
