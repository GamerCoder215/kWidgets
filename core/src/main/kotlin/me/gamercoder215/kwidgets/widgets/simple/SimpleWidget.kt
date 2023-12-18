package me.gamercoder215.kwidgets.widgets.simple

import me.gamercoder215.kwidgets.Provider
import me.gamercoder215.kwidgets.util.centeredX
import me.gamercoder215.kwidgets.util.centeredY
import me.gamercoder215.kwidgets.util.setting
import me.gamercoder215.kwidgets.widgets.AbstractWidget
import me.gamercoder215.kwidgets.widgets.WSetting
import me.gamercoder215.kwidgets.widgets.WSize
import me.gamercoder215.kwidgets.widgets.WidgetSetting
import java.awt.Color

abstract class SimpleWidget(
    minSize: WSize,
    override val free: Boolean = false
) : AbstractWidget(minSize.width, minSize.height) {

    abstract val text: String

    @WSetting("settings.widget.text-color")
    val color: WidgetSetting<Color> = WidgetSetting.color("text-color")

    override fun render(provider: Provider, x: Int, y: Int, currentWidth: Int, currentHeight: Int) {
        val cx = centeredX(x)
        val cy = centeredY(y) - 5

        provider.draw(text, cx, cy, 11, setting(color).rgb)
    }

}

