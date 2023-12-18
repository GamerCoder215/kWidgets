package me.gamercoder215.kwidgets.fabric

import me.gamercoder215.kwidgets.util.WPlayer
import net.minecraft.client.Minecraft
import net.minecraft.client.player.LocalPlayer

object FabricPlayer : WPlayer {

    val minecraft: Minecraft
        get() = Minecraft.getInstance()

    val player: LocalPlayer?
        get() = minecraft.player

    override val x: Double
        get() = player?.x ?: 0.0

    override val y: Double
        get() = player?.y ?: 0.0

    override val z: Double
        get() = player?.z ?: 0.0

    override val worldName: String
        get() = player?.level()?.dimension()?.location()?.path ?: "world"
}