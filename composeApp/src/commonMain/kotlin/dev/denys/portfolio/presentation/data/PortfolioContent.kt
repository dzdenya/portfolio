package dev.denys.portfolio.presentation.data

import dev.denys.portfolio.presentation.model.ContactEntry
import dev.denys.portfolio.presentation.model.SkillGroup
import portfolio.composeapp.generated.resources.*


val portfolioContacts = listOf(
    ContactEntry("Email", Res.drawable.mail, "dzdenya@gmail.com", "mailto:dzdenya@gmail.com"),
    ContactEntry("Phone", Res.drawable.phone, "+34 661 455 825", "tel:+34661455825"),
    ContactEntry("Telegram", Res.drawable.tg, "@denys_zz", "https://t.me/denys_zz"),
    ContactEntry("WhatsApp", Res.drawable.wa, "+34 661 455 825", "https://wa.me/34661455825"),
    ContactEntry("LinkedIn", Res.drawable.linkedin, "denys-zvieriev", "https://www.linkedin.com/in/denys-zvieriev"),
    ContactEntry("GitHub", Res.drawable.github, "denys-zvieriev", "https://github.com/dzdenya/portfolio"),
)

val portfolioSkills = listOf(
    SkillGroup("Languages", Res.drawable.code, listOf("Java", "Kotlin", "Python", "TypeScript")),
    SkillGroup("Frameworks", Res.drawable.boxes, listOf("Spring Boot", "Hibernate", "JPA", "Microservices")),
    SkillGroup("Cloud & DevOps", Res.drawable.cloud, listOf("AWS", "Docker", "Kubernetes", "CI/CD")),
    SkillGroup("Databases", Res.drawable.database, listOf("PostgreSQL", "MongoDB", "Redis", "MySQL")),
)
