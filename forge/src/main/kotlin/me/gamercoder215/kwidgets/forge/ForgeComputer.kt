package me.gamercoder215.kwidgets.forge

import me.gamercoder215.kwidgets.util.WComputer
import net.minecraft.client.Minecraft

object ForgeComputer : WComputer {

    val minecraft: Minecraft
        get() = Minecraft.getInstance()

    override val fps: Int
        get() = minecraft.fps

    override val ping: Long
        get() = minecraft.currentServer?.ping ?: -1

    override val width: Int
        get() = minecraft.window.width

    override val height: Int
        get() = minecraft.window.height

    override val version: String
        get() = minecraft.launchedVersion

}