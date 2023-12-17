@file:Suppress("unchecked_cast")

package me.gamercoder215.kwidgets.util

import me.gamercoder215.kwidgets.widgets.AbstractWidget
import me.gamercoder215.kwidgets.widgets.Widget
import me.gamercoder215.kwidgets.widgets.WidgetSetting
import java.lang.reflect.Field
import java.lang.reflect.Modifier

// Widget Util

fun Widget.centeredX(x: Int): Int = x - (minWidth / 2)
fun Widget.centeredY(y: Int): Int = y - (minHeight / 2)

fun <T> AbstractWidget.setting(setting: WidgetSetting<T>): T = settings[setting] as T

// Kotlin Util

val Field.static: Boolean
    get() = modifiers and Modifier.STATIC != 0

val Field.final: Boolean
    get() = modifiers and Modifier.FINAL != 0

val Field.constant: Boolean
    get() = static && final

fun <K, V : Comparable<V>> Map<K, V>.sorted(): List<K> = keys.sortedBy { get(it) }