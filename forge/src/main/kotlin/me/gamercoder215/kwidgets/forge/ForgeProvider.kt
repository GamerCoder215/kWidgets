package me.gamercoder215.kwidgets.forge

import me.gamercoder215.kwidgets.Provider
import me.gamercoder215.kwidgets.Provider.Companion.provider
import me.gamercoder215.kwidgets.util.DEFAULT_FONT_SIZE
import me.gamercoder215.kwidgets.util.MOD_ID
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.renderer.blockentity.SignRenderer
import net.minecraftforge.fml.common.Mod
import java.util.*

@Mod(MOD_ID)
class ForgeProvider : Provider {

    val minecraft: Minecraft
    val graphics: GuiGraphics

    init {
        provider = this
        minecraft = Minecraft.getInstance()
        graphics = GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource())
    }

    // Provider

    // <editor-fold desc="Field Implementation" defaultState="collapsed">

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

    override val version: String
        get() = minecraft.launchedVersion

    // </editor-fold>

    // <editor-fold desc="Function Implementation" defaultstate="collapsed">

    override fun draw(text: String, x: Int, y: Int, size: Float, color: Int, shadow: Boolean) {
        val scale = size / DEFAULT_FONT_SIZE

        graphics.pose().pushPose()
        graphics.pose().scale(scale, scale, scale)
        graphics.drawString(minecraft.font, text, x, y, color, shadow)
        graphics.pose().popPose()
    }

    // </editor-fold>
}