package me.gamercoder215.kwidgets

interface Provider {

    fun draw(text: String, x: Int, y: Int, color: Int, shadow: Boolean = true)

    companion object {
        var provider: Provider? = null
    }

}