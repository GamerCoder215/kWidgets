package me.gamercoder215.kwidgets

abstract class AbstractWidget(
    override val height: Int,
    override val width: Int,
    override val free: Boolean = false,
) : Widget