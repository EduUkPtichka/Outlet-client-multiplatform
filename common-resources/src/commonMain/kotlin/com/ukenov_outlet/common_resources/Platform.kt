package com.ukenov_outlet.common_resources

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform