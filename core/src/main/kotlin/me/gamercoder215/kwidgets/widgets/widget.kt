package me.gamercoder215.kwidgets.widgets

import me.gamercoder215.kwidgets.Provider
import me.gamercoder215.kwidgets.widgets.simple.*
import java.lang.annotation.Inherited

// Registered Widgets

val widgets: Set<Class<out Widget>> = setOf(
    // Simple Widgets
    Time::class,
    Fps::class,
    Latency::class,
    Location::class,
    MinecraftVersion::class,
    OperatingSystem::class
).map { it.java }.toSet()

// Abstraction

interface Widget {

    val minWidth: Int

    val minHeight: Int

    val free: Boolean

    val updateInterval: Int

    fun render(provider: Provider, x: Int, y: Int, currentWidth: Int, currentHeight: Int)

    enum class Category {
        UTILITY, PERFORMANCE, FUN, OTHER
    }

}

abstract class AbstractWidget(
    override val minWidth: Int,
    override val minHeight: Int,
    override val free: Boolean = false,
    override val updateInterval: Int = -1
) : Widget {

    val settings: Map<WidgetSetting<*>, Any> = mutableMapOf()

}

enum class WSize(
    internal val width: Int,
    internal val height: Int = (width * 0.5625).toInt()
) {
    SMALL(32),
    MEDIUM(64),
    LARGE(128),
    EXTRA_LARGE(256),

    SMALL_SQUARE(32, 32),
    MEDIUM_SQUARE(64, 64),
    LARGE_SQUARE(128, 128),
    EXTRA_LARGE_SQUARE(256, 256)
}

// Annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
annotation class WInfo(
    val nameKey: String,
    val category: Widget.Category = Widget.Category.OTHER
)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
annotation class WMultaple(
    val max: Int = -1
)