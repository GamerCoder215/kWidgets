package me.gamercoder215.kwidgets.widgets.images

import me.gamercoder215.kwidgets.Provider
import me.gamercoder215.kwidgets.widgets.AbstractWidget

abstract class ImageWidget(
    minWidth: Int,
    minHeight: Int,
    override val free: Boolean = false
) : AbstractWidget(minWidth, minHeight) {

    abstract val image: String

    override fun render(provider: Provider, x: Int, y: Int, currentWidth: Int, currentHeight: Int) {
        provider.drawImage(image, x, y, currentWidth, currentHeight)
    }

}