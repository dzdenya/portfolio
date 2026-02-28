package dev.denys.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.hero_background

@Composable
@Preview
fun App() {
	val actionLinks = listOf(
		ActionLink("Email Me", "mailto:dzdenya@gmail.com"),
		ActionLink("Call", "tel:+34661455825"),
		ActionLink("Telegram", "https://t.me/denys_zz"),
		ActionLink("WhatsApp", "https://wa.me/34661455825"),
		ActionLink("LinkedIn", "https://www.linkedin.com/in/denys-zvieriev"),
	)

	val skills = listOf(
		SkillGroup("Languages", listOf("Java", "Kotlin", "Python", "TypeScript")),
		SkillGroup("Frameworks", listOf("Spring Boot", "Hibernate", "JPA", "Microservices")),
		SkillGroup("Cloud & DevOps", listOf("AWS", "Docker", "Kubernetes", "CI/CD")),
		SkillGroup("Databases", listOf("PostgreSQL", "MongoDB", "Redis", "MySQL")),
	)

	val contacts = listOf(
		ContactEntry("EM", "Email", "dzdenya@gmail.com", "mailto:dzdenya@gmail.com"),
		ContactEntry("PH", "Phone", "+34 661 455 825", "tel:+34661455825"),
		ContactEntry("TG", "Telegram", "@denys_zz", "https://t.me/denys_zz"),
		ContactEntry("WA", "WhatsApp", "+34 661 455 825", "https://wa.me/34661455825"),
		ContactEntry("IN", "LinkedIn", "denys-zvieriev", "https://www.linkedin.com/in/denys-zvieriev"),
	)

	val uriHandler = LocalUriHandler.current

	MaterialTheme {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = Color(0xFF020617))
				.safeContentPadding()
				.verticalScroll(rememberScrollState()),
		) {
			HeroSection(
				actionLinks = actionLinks,
				onOpenLink = uriHandler::openUri,
			)
			SkillsSection(skills = skills)
			ContactSection(
				contacts = contacts,
				onOpenLink = uriHandler::openUri,
			)
			FooterSection()
		}
	}
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HeroSection(
	actionLinks: List<ActionLink>,
	onOpenLink: (String) -> Unit,
) {
	BoxWithConstraints(
		modifier = Modifier
			.fillMaxWidth()
			.heightIn(min = 680.dp)
			.clipToBounds(),
	) {
		val isCompact = maxWidth < 700.dp
		val headingSize = if (isCompact) 48.sp else 78.sp
		val subtitleSize = if (isCompact) 20.sp else 28.sp
		val bodySize = if (isCompact) 18.sp else 22.sp

		Image(
			painter = painterResource(Res.drawable.hero_background),
			contentDescription = "Background",
			contentScale = ContentScale.Crop,
			alpha = 0.98f,
			modifier = Modifier.fillMaxSize(),
		)
		Box(
			modifier = Modifier
				.fillMaxSize()
				.background(
					brush = Brush.linearGradient(
						colors = listOf(
							Color(0xFF1E3A8A).copy(alpha = 0.90f),
							Color(0xFF0F172A).copy(alpha = 0.90f),
							Color(0xFF020617).copy(alpha = 0.95f),
						)
					)
				),
		)

		Column(
			modifier = Modifier
				.align(Alignment.Center)
				.fillMaxWidth()
				.padding(horizontal = 20.dp, vertical = 88.dp)
				.widthIn(max = 1060.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(24.dp),
		) {
			Text(
				text = "Denys Zvieriev",
				color = Color.White,
				fontSize = headingSize,
				fontWeight = FontWeight.ExtraBold,
				textAlign = TextAlign.Center,
				lineHeight = headingSize * 1.05f,
			)

			Surface(
				shape = RoundedCornerShape(999.dp),
				color = Color(0x33256FF1),
				border = BorderStroke(1.dp, Color(0x6658A6FF)),
			) {
				Text(
					text = "Backend Software Engineer",
					modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp),
					color = Color(0xFFD5E5FF),
					fontSize = subtitleSize,
					fontWeight = FontWeight.Medium,
				)
			}

			Text(
				text = "With 8+ years of experience building scalable cloud-based microservices. Specialized in Java, Kotlin, and Spring Boot.",
				modifier = Modifier.widthIn(max = 900.dp),
				color = Color(0xFFD3DBEA),
				fontSize = bodySize,
				lineHeight = bodySize * 1.45f,
				textAlign = TextAlign.Center,
			)

			FlowRow(
				modifier = Modifier.widthIn(max = 980.dp),
				horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
				verticalArrangement = Arrangement.spacedBy(12.dp),
				maxItemsInEachRow = if (isCompact) 2 else 5,
			) {
				actionLinks.forEachIndexed { index, action ->
					ContactButton(
						label = action.label,
						isPrimary = index == 0,
						onClick = { onOpenLink(action.uri) },
					)
				}
			}
		}

		Box(
			modifier = Modifier
				.align(Alignment.BottomCenter)
				.padding(bottom = 24.dp)
				.width(24.dp)
				.height(40.dp)
				.border(1.5.dp, Color(0x4DFFFFFF), RoundedCornerShape(999.dp))
				.padding(top = 8.dp),
			contentAlignment = Alignment.TopCenter,
		) {
			Box(
				modifier = Modifier
					.width(3.dp)
					.height(10.dp)
					.background(Color(0xCCFFFFFF), RoundedCornerShape(999.dp)),
			)
		}
	}
}

@Composable
private fun ContactButton(
	label: String,
	isPrimary: Boolean,
	onClick: () -> Unit,
) {
	Surface(
		modifier = Modifier
			.clip(RoundedCornerShape(14.dp))
			.clickable(onClick = onClick),
		shape = RoundedCornerShape(14.dp),
		color = if (isPrimary) Color(0xFF2563EB) else Color(0x1FFFFFFF),
		border = BorderStroke(
			width = 1.dp,
			color = if (isPrimary) Color(0xFF2563EB) else Color(0x35FFFFFF),
		),
	) {
		Text(
			text = label,
			modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
			color = Color.White,
			fontWeight = FontWeight.Medium,
		)
	}
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SkillsSection(skills: List<SkillGroup>) {
	BoxWithConstraints(
		modifier = Modifier
			.fillMaxWidth()
			.background(
				brush = Brush.verticalGradient(
					colors = listOf(Color(0xFF0F172A), Color(0xFF111827)),
				)
			)
			.padding(horizontal = 20.dp, vertical = 80.dp),
	) {
		val columns = when {
			maxWidth >= 1240.dp -> 4
			maxWidth >= 860.dp -> 2
			else -> 1
		}
		val compactHeading = maxWidth < 700.dp
		val gap = 16.dp
		val cardWidth = ((maxWidth - gap * (columns - 1)) / columns).coerceAtLeast(240.dp)

		Column(
			modifier = Modifier
				.align(Alignment.Center)
				.fillMaxWidth()
				.widthIn(max = 1120.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(14.dp),
		) {
			Text(
				text = "Technical Expertise",
				color = Color.White,
				fontSize = if (compactHeading) 38.sp else 54.sp,
				fontWeight = FontWeight.Bold,
				textAlign = TextAlign.Center,
			)
			Text(
				text = "A comprehensive skill set built over 8+ years of hands-on experience",
				modifier = Modifier.widthIn(max = 760.dp),
				color = Color(0xFF97A5BC),
				fontSize = 20.sp,
				textAlign = TextAlign.Center,
			)

			FlowRow(
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = 24.dp),
				maxItemsInEachRow = columns,
				horizontalArrangement = Arrangement.spacedBy(gap),
				verticalArrangement = Arrangement.spacedBy(gap),
			) {
				skills.forEach { skill ->
					Card(
						modifier = Modifier
							.width(cardWidth)
							.heightIn(min = 248.dp),
						colors = CardDefaults.cardColors(
							containerColor = Color(0xFF1E293B),
							contentColor = Color(0xFFE2E8F0),
						),
						border = BorderStroke(1.dp, Color(0xFF334155)),
					) {
						Column(
							modifier = Modifier
								.fillMaxWidth()
								.padding(22.dp),
							verticalArrangement = Arrangement.spacedBy(14.dp),
						) {
							Box(
								modifier = Modifier
									.size(44.dp)
									.background(Color(0xFF1D4ED8), RoundedCornerShape(12.dp)),
							)
							Text(
								text = skill.category,
								fontSize = 24.sp,
								fontWeight = FontWeight.SemiBold,
								color = Color.White,
							)

							Column(
								verticalArrangement = Arrangement.spacedBy(10.dp),
							) {
								skill.items.forEach { item ->
									SkillItem(item)
								}
							}
						}
					}
				}
			}
		}
	}
}

@Composable
private fun SkillItem(text: String) {
	RowWithDot {
		Text(
			text = text,
			color = Color(0xFFC1CEDF),
			fontSize = 17.sp,
		)
	}
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ContactSection(
	contacts: List<ContactEntry>,
	onOpenLink: (String) -> Unit,
) {
	BoxWithConstraints(
		modifier = Modifier
			.fillMaxWidth()
			.background(
				brush = Brush.verticalGradient(
					colors = listOf(Color(0xFFF8FAFC), Color(0xFFFFFFFF)),
				)
			)
			.padding(horizontal = 20.dp, vertical = 80.dp),
	) {
		val columns = when {
			maxWidth >= 1240.dp -> 3
			maxWidth >= 860.dp -> 2
			else -> 1
		}
		val compactHeading = maxWidth < 700.dp
		val gap = 16.dp
		val cardWidth = ((maxWidth - gap * (columns - 1)) / columns).coerceAtLeast(250.dp)

		Column(
			modifier = Modifier
				.align(Alignment.Center)
				.fillMaxWidth()
				.widthIn(max = 1120.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(14.dp),
		) {
			Text(
				text = "Get In Touch",
				color = Color(0xFF0F172A),
				fontSize = if (compactHeading) 38.sp else 54.sp,
				fontWeight = FontWeight.Bold,
				textAlign = TextAlign.Center,
			)
			Text(
				text = "I'm always open to discussing new opportunities, projects, or just a quick chat about technology.",
				modifier = Modifier.widthIn(max = 760.dp),
				color = Color(0xFF475569),
				fontSize = 20.sp,
				textAlign = TextAlign.Center,
			)

			FlowRow(
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = 24.dp),
				maxItemsInEachRow = columns,
				horizontalArrangement = Arrangement.spacedBy(gap),
				verticalArrangement = Arrangement.spacedBy(gap),
			) {
				contacts.forEach { contact ->
					Card(
						modifier = Modifier
							.width(cardWidth)
							.clickable { onOpenLink(contact.uri) },
						colors = CardDefaults.cardColors(
							containerColor = Color.White,
							contentColor = Color(0xFF0F172A),
						),
						border = BorderStroke(1.dp, Color(0xFFDBE3EF)),
					) {
						Column(
							modifier = Modifier
								.fillMaxWidth()
								.padding(horizontal = 20.dp, vertical = 22.dp),
							horizontalAlignment = Alignment.CenterHorizontally,
							verticalArrangement = Arrangement.spacedBy(10.dp),
						) {
							Box(
								modifier = Modifier
									.size(52.dp)
									.background(Color(0xFFE2ECFF), CircleShape),
								contentAlignment = Alignment.Center,
							) {
								Text(
									text = contact.icon,
									color = Color(0xFF1D4ED8),
									fontWeight = FontWeight.Bold,
									fontSize = 16.sp,
								)
							}
							Text(
								text = contact.label,
								color = Color(0xFF64748B),
								fontSize = 14.sp,
							)
							Text(
								text = contact.value,
								color = Color(0xFF0F172A),
								fontSize = 18.sp,
								fontWeight = FontWeight.Medium,
								textAlign = TextAlign.Center,
							)
						}
					}
				}
			}
		}
	}
}

@Composable
private fun FooterSection() {
	BoxWithConstraints(
		modifier = Modifier
			.fillMaxWidth()
			.background(Color(0xFF020617))
			.padding(horizontal = 20.dp, vertical = 28.dp),
	) {
		val isCompact = maxWidth < 720.dp

		Column(
			modifier = Modifier
				.align(Alignment.Center)
				.fillMaxWidth()
				.widthIn(max = 1120.dp),
			horizontalAlignment = if (isCompact) Alignment.CenterHorizontally else Alignment.Start,
			verticalArrangement = Arrangement.spacedBy(10.dp),
		) {
			Text(
				text = "© Denys Zvieriev. All rights reserved.",
				color = Color(0xFF9BA7BC),
				textAlign = if (isCompact) TextAlign.Center else TextAlign.Start,
			)

			RowWithDot(
				dotColor = Color(0xFF22C55E),
				horizontalAlignment = if (isCompact) Alignment.CenterHorizontally else Alignment.Start,
			) {
				Text(
					text = "Available for new opportunities",
					color = Color(0xFFBAC4D5),
				)
			}
		}
	}
}

@Composable
private fun RowWithDot(
	dotColor: Color = Color(0xFF60A5FA),
	horizontalAlignment: Alignment.Horizontal = Alignment.Start,
	content: @Composable () -> Unit,
) {
	Column(horizontalAlignment = horizontalAlignment) {
		Row(
			horizontalArrangement = Arrangement.spacedBy(10.dp),
		) {
			Box(
				modifier = Modifier
					.padding(top = 7.dp)
					.size(8.dp)
					.background(dotColor, CircleShape),
			)
			content()
		}
	}
}

private data class ActionLink(
	val label: String,
	val uri: String,
)

private data class SkillGroup(
	val category: String,
	val items: List<String>,
)

private data class ContactEntry(
	val icon: String,
	val label: String,
	val value: String,
	val uri: String,
)
