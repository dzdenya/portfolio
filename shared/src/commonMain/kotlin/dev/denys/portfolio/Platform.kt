package dev.denys.portfolio

interface Platform {
	val name: String
}

expect fun getPlatform(): Platform