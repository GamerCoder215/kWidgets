package me.gamercoder215.kwidgets.widgets.image

import me.gamercoder215.kwidgets.Provider
import me.gamercoder215.kwidgets.widgets.AbstractWidget

abstract class MultiImageWidget(
    minWidth: Int,
    minHeight: Int,
    override val free: Boolean = false
) : AbstractWidget(minWidth, minHeight) {

    abstract val images: Iterable<String>

    override fun render(provider: Provider, x: Int, y: Int, currentWidth: Int, currentHeight: Int) {
        var cx = x
        var cy = y

        for (image in images) {
            provider.drawImage(image, cx, cy, currentWidth, currentHeight)
            cx += currentWidth
            cy += currentHeight
        }
    }

}