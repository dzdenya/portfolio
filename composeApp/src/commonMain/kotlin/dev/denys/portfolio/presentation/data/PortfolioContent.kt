package dev.denys.portfolio.presentation.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material.icons.outlined.Storage
import dev.denys.portfolio.presentation.model.ActionLink
import dev.denys.portfolio.presentation.model.ContactEntry
import dev.denys.portfolio.presentation.model.SkillGroup

val portfolioActionLinks = listOf(
    ActionLink("Email Me", Icons.Filled.Email, "mailto:dzdenya@gmail.com"),
    ActionLink("Call", Icons.Filled.Phone, "tel:+34661455825"),
    ActionLink("Telegram", Icons.AutoMirrored.Filled.Send, "https://t.me/denys_zz"),
    ActionLink("WhatsApp", Icons.AutoMirrored.Outlined.Chat, "https://wa.me/34661455825"),
    ActionLink("LinkedIn", Icons.Filled.Work, "https://www.linkedin.com/in/denys-zvieriev"),
)

val portfolioSkills = listOf(
    SkillGroup("Languages", Icons.Filled.Code, listOf("Java", "Kotlin", "Python", "TypeScript")),
    SkillGroup("Frameworks", Icons.Outlined.AccountBox, listOf("Spring Boot", "Hibernate", "JPA", "Microservices")),
    SkillGroup("Cloud & DevOps", Icons.Outlined.Cloud, listOf("AWS", "Docker", "Kubernetes", "CI/CD")),
    SkillGroup("Databases", Icons.Outlined.Storage, listOf("PostgreSQL", "MongoDB", "Redis", "MySQL")),
)

val portfolioContacts = listOf(
    ContactEntry("Email", Icons.Filled.Email, "dzdenya@gmail.com", "mailto:dzdenya@gmail.com"),
    ContactEntry("Phone", Icons.Filled.Phone, "+34 661 455 825", "tel:+34661455825"),
    ContactEntry("Telegram", Icons.AutoMirrored.Filled.Send, "@denys_zz", "https://t.me/denys_zz"),
    ContactEntry("WhatsApp", Icons.AutoMirrored.Outlined.Chat, "+34 661 455 825", "https://wa.me/34661455825"),
    ContactEntry("LinkedIn", Icons.Filled.Work, "denys-zvieriev", "https://www.linkedin.com/in/denys-zvieriev"),
    ContactEntry("GitHub", Icons.Filled.Work, "denys-zvieriev", "https://github.com/dzdenya/portfolio"),
)
