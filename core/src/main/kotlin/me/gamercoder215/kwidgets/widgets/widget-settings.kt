package me.gamercoder215.kwidgets.widgets

import me.gamercoder215.kwidgets.util.colors
import me.gamercoder215.kwidgets.util.sorted
import java.awt.Color
import java.lang.annotation.Inherited

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
annotation class WSetting(
    val nameKey: String,
    val descriptionKey: String = "<desc>"
)

class WidgetSetting<T>(
    val id: String,
    val clazz: Class<T>,
    val values: List<T>,
    val default: T = values[0],
    val toString: (T) -> String = { it.toString() },
) {

    companion object {
        fun boolean(id: String, default: Boolean = true): WidgetSetting<Boolean> =
            WidgetSetting(id, Boolean::class.java, listOf(true, false), default)

        fun <T : Enum<T>> enum(id: String, clazz: Class<T>, default: T = clazz.enumConstants[0]): WidgetSetting<T> =
            WidgetSetting(id, clazz, clazz.enumConstants.toList(), default)

        fun int(id: String, range: Iterable<Int>, default: Int = range.first()): WidgetSetting<Int> =
            WidgetSetting(id, Int::class.java, range.toList(), default)

        fun int(id: String, min: Int, max: Int, default: Int = min): WidgetSetting<Int> =
            int(id, min..max, default)

        fun color(id: String): WidgetSetting<Color> =
            WidgetSetting(id, Color::class.java, colors.sorted(), Color.WHITE) { colors[it]!! }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WidgetSetting<*>) return false

        if (id != other.id) return false
        if (clazz != other.clazz) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + clazz.hashCode()
        return result
    }

}