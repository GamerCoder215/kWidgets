package me.gamercoder215.kwidgets

import me.gamercoder215.kwidgets.util.WPlayer
import java.util.*

interface Provider {

    // Fields

    val locale: Locale

    val fps: Int

    val ping: Long

    val player: WPlayer

    val version: String

    // Functions

    fun draw(text: String, x: Int, y: Int, size: Int, color: Int, shadow: Boolean = true)
        = draw(text, x, y, size.toFloat(), color, shadow)

    fun draw(text: String, x: Int, y: Int, size: Float, color: Int, shadow: Boolean = true)

    fun drawImage(image: String, x: Int, y: Int, width: Int, height: Int)

    companion object {
        lateinit var provider: Provider
    }

}