package com.withive.hems.bean

import java.util.*

data class Greeting(val id: Long, val content: String) {
    val created: Long = Calendar.getInstance().timeInMillis
}