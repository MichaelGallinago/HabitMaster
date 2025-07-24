package net.micg.habitmaster

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform