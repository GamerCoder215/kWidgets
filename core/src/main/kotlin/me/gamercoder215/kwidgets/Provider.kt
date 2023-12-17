package me.gamercoder215.kwidgets

import java.util.*

interface Provider {

    val locale: Locale

    val fps: Int

    val ping: Long

    val x: Int

    val y: Int

    val z: Int

    fun draw(text: String, x: Int, y: Int, size: Int, color: Int, shadow: Boolean = true)

    companion object {
        lateinit var provider: Provider
    }

}