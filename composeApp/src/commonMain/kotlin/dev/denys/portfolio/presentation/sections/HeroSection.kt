package dev.denys.portfolio.presentation.sections

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.denys.portfolio.presentation.components.ContactButton
import dev.denys.portfolio.presentation.model.ContactEntry
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.hero_background

@Composable
fun HeroSection(
    sectionHeight: Dp,
    contacts: List<ContactEntry>,
    onOpenLink: (String) -> Unit,
) {
    val indicatorOffset by rememberInfiniteTransition(label = "scroll-indicator")
        .animateFloat(
            initialValue = 0f,
            targetValue = 8f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 750, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse,
            ),
            label = "indicator-bounce",
        )

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(sectionHeight)
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
                        ),
                    ),
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
                maxItemsInEachRow = if (isCompact) 2 else 6,
            ) {
                contacts.forEachIndexed { index, contact ->
                    ContactButton(
                        label = contact.label,
                        icon = vectorResource(contact.icon),
                        onClick = { onOpenLink(contact.uri) },
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
                    .offset(y = indicatorOffset.dp)
                    .background(Color(0xCCFFFFFF), RoundedCornerShape(999.dp)),
            )
        }
    }
}
