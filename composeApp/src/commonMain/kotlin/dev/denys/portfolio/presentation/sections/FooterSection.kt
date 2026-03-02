package dev.denys.portfolio.presentation.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

@Composable
fun FooterSection() {
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
            val year = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).year
            Text(
                text = "© $year Denys Zvieriev. All rights reserved.",
                color = Color(0xFF9BA7BC),
                textAlign = if (isCompact) TextAlign.Center else TextAlign.Start,
            )
        }
    }
}
