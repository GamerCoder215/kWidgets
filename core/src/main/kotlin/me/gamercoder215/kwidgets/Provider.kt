package me.gamercoder215.kwidgets

import java.util.*

interface Provider {

    // Fields

    val locale: Locale

    val fps: Int

    val ping: Long

    val x: Int

    val y: Int

    val z: Int

    val version: String

    // Functions

    fun draw(text: String, x: Int, y: Int, size: Int, color: Int, shadow: Boolean = true)
        = draw(text, x, y, size.toFloat(), color, shadow)

    fun draw(text: String, x: Int, y: Int, size: Float, color: Int, shadow: Boolean = true)

    companion object {
        lateinit var provider: Provider
    }

}