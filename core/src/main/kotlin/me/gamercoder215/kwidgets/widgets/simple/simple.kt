package me.gamercoder215.kwidgets.widgets.simple

import me.gamercoder215.kwidgets.Provider.Companion.provider
import me.gamercoder215.kwidgets.util.setting
import me.gamercoder215.kwidgets.widgets.WInfo
import me.gamercoder215.kwidgets.widgets.WSetting
import me.gamercoder215.kwidgets.widgets.WSize
import me.gamercoder215.kwidgets.widgets.WSize.MEDIUM
import me.gamercoder215.kwidgets.widgets.WSize.SMALL
import me.gamercoder215.kwidgets.widgets.Widget.Category.PERFORMANCE
import me.gamercoder215.kwidgets.widgets.Widget.Category.UTILITY
import me.gamercoder215.kwidgets.widgets.WidgetSetting.Companion.boolean
import java.text.SimpleDateFormat
import java.util.*

// Simple Text

open class SimpleTextWidget(override val text: String, size: WSize, override val updateInterval: Int = -1) : SimpleWidget(size)

@WInfo("widgets.fps", PERFORMANCE)
class Fps : SimpleTextWidget("${provider.fps} FPS", SMALL, 1)

@WInfo("widgets.ping", PERFORMANCE)
class Ping : SimpleTextWidget("${provider.ping} ms", SMALL, 1)

@WInfo("widgets.location", UTILITY)
class Location : SimpleTextWidget("${provider.x}, ${provider.y}, ${provider.z}", SMALL, 1)

// Text

@WInfo("widgets.time", UTILITY)
class Time : SimpleWidget(MEDIUM) {

    override val updateInterval: Int = 20

    @WSetting("settings.widgets.time.numberical_day")
    val numberical = boolean("use-numberical-day", false)

    @WSetting("settings.widgets.time.24h")
    val use24h = boolean("use-24h", false)

    @WSetting("settings.widgets.time.day")
    val day = boolean("show-day")

    @WSetting("settings.widgets.time.seconds")
    val seconds = boolean("show-seconds", false)

    @WSetting("settings.widgets.time.timezone")
    val timeZone = boolean("show-timezone", false)

    fun buildFormat(locale: Locale): String = buildString {
        val numberical = setting(numberical)
        val use24h = setting(use24h)
        val day = setting(day)
        val seconds = setting(seconds)
        val timeZone = setting(timeZone)

        if (day)
            if (numberical)
                if (locale.country == "US") append("MM/dd/yyyy") else append("dd/MM/yyyy")
            else
                append("MMM dd, yyyy '|' ")

        if (use24h) append("H") else append("h")
        append(":mm")

        if (seconds) append(":ss")
        if (!use24h) append(" a")
        if (timeZone) append(" (z)")
    }

    override val text: String
        get() {
            val locale = provider.locale
            val format = SimpleDateFormat(buildFormat(locale), locale)

            return format.format(Date())
        }
}