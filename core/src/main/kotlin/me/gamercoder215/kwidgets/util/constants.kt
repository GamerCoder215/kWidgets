package me.gamercoder215.kwidgets.util

import java.awt.Color

val colors: Map<Color, String> =
    Color::class.java.declaredFields.filter { it.constant && it.type == Color::class.java && it.name[0].isUpperCase() }
        .associate { (it.get(null) as Color) to it.name }