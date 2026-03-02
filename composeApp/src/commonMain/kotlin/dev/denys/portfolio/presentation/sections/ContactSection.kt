package dev.denys.portfolio.presentation.sections

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.denys.portfolio.presentation.model.ContactEntry
import org.jetbrains.compose.resources.vectorResource

@Composable
fun ContactSection(
    contacts: List<ContactEntry>,
    onOpenLink: (String) -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFF8FAFC), Color(0xFFFFFFFF)),
                ),
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
                    ContactCard(
                        contact = contact,
                        cardWidth = cardWidth,
                        onOpenLink = onOpenLink,
                    )
                }
            }
        }
    }
}

@Composable
private fun ContactCard(
    contact: ContactEntry,
    cardWidth: Dp,
    onOpenLink: (String) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val cardScale by animateFloatAsState(
        targetValue = if (isHovered) 1.02f else 1f,
        animationSpec = tween(durationMillis = 100),
        label = "contact-card-scale",
    )
    val iconTint by animateColorAsState(
        targetValue = if (isHovered) Color.White else Color(0xFF64748B),
        animationSpec = tween(durationMillis = 100),
        label = "contact-card-icon-tint",
    )
    val iconBackgroundColor by animateColorAsState(
        targetValue = if (isHovered) Color(0xFF1D4ED8) else Color(0xFFE2ECFF),
        animationSpec = tween(durationMillis = 100),
        label = "contact-card-icon-bg",
    )
    val cardBorderColor by animateColorAsState(
        targetValue = if (isHovered) Color(0xFF1D4ED8) else Color(0xFFDBE3EF),
        animationSpec = tween(durationMillis = 100),
        label = "contact-card-border",
    )

    Card(
        modifier = Modifier
            .width(cardWidth)
            .graphicsLayer {
                scaleX = cardScale
                scaleY = cardScale
            }
            .hoverable(interactionSource = interactionSource)
            .clickable { onOpenLink(contact.uri) },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color(0xFF0F172A),
        ),
        border = BorderStroke(1.dp, cardBorderColor),
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
                    .background(iconBackgroundColor, CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = vectorResource(contact.icon),
                    contentDescription = contact.label,
                    tint = iconTint,
                    modifier = Modifier.size(24.dp),
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
