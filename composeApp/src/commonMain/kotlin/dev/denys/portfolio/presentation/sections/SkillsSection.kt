package dev.denys.portfolio.presentation.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.denys.portfolio.presentation.components.RowWithDot
import dev.denys.portfolio.presentation.model.SkillGroup

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillsSection(skills: List<SkillGroup>) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF0F172A), Color(0xFF111827)),
                ),
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
                                contentAlignment = Alignment.Center,
                            ) {
                                Icon(
                                    imageVector = skill.icon,
                                    contentDescription = skill.category,
                                    tint = Color.White,
                                    modifier = Modifier.size(24.dp),
                                )
                            }
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
