package dev.denys.portfolio.presentation.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val TelegramIcon: ImageVector
	get() {
		if (_telegramIcon != null) return _telegramIcon!!
		_telegramIcon = Builder(
			name = "Telegram",
			defaultWidth = 24.dp,
			defaultHeight = 24.dp,
			viewportWidth = 24f,
			viewportHeight = 24f
		).apply {
			
			// Main paper plane shape
			path(
				fill = null,
				stroke = SolidColor(Color(0xFF155DFC)),
				strokeLineWidth = 2f,
				strokeLineCap = StrokeCap.Round,
				strokeLineJoin = StrokeJoin.Round,
				pathFillType = PathFillType.NonZero
			) {
				moveTo(14.536f, 21.6861f)
				curveTo(14.574f, 21.7807f, 14.64f, 21.8615f, 14.7253f, 21.9176f)
				curveTo(14.8105f, 21.9737f, 14.9108f, 22.0023f, 15.0128f, 21.9997f)
				curveTo(15.1148f, 21.9971f, 15.2136f, 21.9633f, 15.2958f, 21.903f)
				curveTo(15.3781f, 21.8426f, 15.4399f, 21.7586f, 15.473f, 21.6621f)
				lineTo(21.973f, 2.66206f)
				curveTo(22.005f, 2.57345f, 22.0111f, 2.47756f, 21.9906f, 2.38561f)
				curveTo(21.9701f, 2.29366f, 21.9238f, 2.20945f, 21.8572f, 2.14283f)
				curveTo(21.7906f, 2.07622f, 21.7064f, 2.02995f, 21.6144f, 2.00945f)
				curveTo(21.5225f, 1.98894f, 21.4266f, 1.99505f, 21.338f, 2.02706f)
				lineTo(2.33799f, 8.52706f)
				curveTo(2.24148f, 8.56015f, 2.15741f, 8.62197f, 2.09706f, 8.70423f)
				curveTo(2.03671f, 8.78648f, 2.00296f, 8.88523f, 2.00035f, 8.98722f)
				curveTo(1.99773f, 9.0892f, 2.02638f, 9.18955f, 2.08245f, 9.27478f)
				curveTo(2.13851f, 9.36002f, 2.21931f, 9.42606f, 2.31399f, 9.46406f)
				lineTo(10.244f, 12.6441f)
				curveTo(10.4947f, 12.7444f, 10.7224f, 12.8945f, 10.9136f, 13.0853f)
				curveTo(11.1047f, 13.2761f, 11.2552f, 13.5036f, 11.356f, 13.7541f)
				lineTo(14.536f, 21.6861f)
				close()
			}
			
			// Inner diagonal line
			path(
				fill = null,
				stroke = SolidColor(Color(0xFF155DFC)),
				strokeLineWidth = 2f,
				strokeLineCap = StrokeCap.Round,
				strokeLineJoin = StrokeJoin.Round
			) {
				moveTo(21.854f, 2.14697f)
				lineTo(10.914f, 13.086f)
			}
			
		}.build()
		return _telegramIcon!!
	}

private var _telegramIcon: ImageVector? = null