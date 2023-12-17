package me.gamercoder215.kwidgets.util

import java.awt.Color

const val MOD_ID = "kwidgets"
const val DEFAULT_FONT_SIZE = 11f

// Maps

val colors: Map<Color, String> =
    Color::class.java.declaredFields.filter { it.constant && it.type == Color::class.java && it.name[0].isUpperCase() }
        .associate { (it.get(null) as Color) to it.name }