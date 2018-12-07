package com.rrdev.ui

import java.awt.Color
import kotlin.random.Random

object Color {

    fun randomColor(): Color {
        var red = 0
        var green = 0
        var blue = 0

        while (red + green + blue < 200){
            red = Random.nextInt(256)
            green = Random.nextInt(256)
            blue = Random.nextInt(256)
        }

        return Color(red, green, blue, 255)
    }
}