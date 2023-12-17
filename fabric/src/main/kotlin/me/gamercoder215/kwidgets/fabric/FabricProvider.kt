package me.gamercoder215.kwidgets.fabric

import me.gamercoder215.kwidgets.Provider
import net.fabricmc.api.ClientModInitializer
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import java.util.*

class FabricProvider : ClientModInitializer, Provider {

    lateinit var minecraft: Minecraft
    lateinit var graphics: GuiGraphics

    override fun onInitializeClient() {
        Provider.provider = this
        minecraft = Minecraft.getInstance()
        graphics = GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource())
    }

    override val locale: Locale
        get() = Locale(minecraft.languageManager.selected.split("_").first(), minecraft.languageManager.selected.split("_").last().uppercase())

    override val fps: Int
        get() = minecraft.fps

    override val ping: Long
        get() = minecraft.currentServer?.ping ?: -1

    override val x: Int
        get() = minecraft.player?.x?.toInt() ?: 0

    override val y: Int
        get() = minecraft.player?.y?.toInt() ?: 0

    override val z: Int
        get() = minecraft.player?.z?.toInt() ?: 0

    // Provider

    override fun draw(text: String, x: Int, y: Int, size: Int, color: Int, shadow: Boolean) {
        graphics.drawString(minecraft.font, text, x, y, color, shadow)
    }
}