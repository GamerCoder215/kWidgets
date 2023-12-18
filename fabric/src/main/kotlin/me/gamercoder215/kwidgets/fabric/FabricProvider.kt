package me.gamercoder215.kwidgets.fabric

import me.gamercoder215.kwidgets.Provider
import me.gamercoder215.kwidgets.Provider.Companion.provider
import me.gamercoder215.kwidgets.util.DEFAULT_FONT_SIZE
import me.gamercoder215.kwidgets.util.WPlayer
import net.fabricmc.api.ClientModInitializer
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.resources.ResourceLocation
import java.util.*

class FabricProvider : ClientModInitializer, Provider {

    lateinit var minecraft: Minecraft
    lateinit var graphics: GuiGraphics

    override fun onInitializeClient() {
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

    override val version: String
        get() = minecraft.launchedVersion

    override val player: WPlayer
        get() = FabricPlayer

    // </editor-fold>

    // <editor-fold desc="Function Implementation" defaultstate="collapsed">

    override fun draw(text: String, x: Int, y: Int, size: Float, color: Int, shadow: Boolean) {
        val scale = size / DEFAULT_FONT_SIZE

        graphics.pose().pushPose()
        graphics.pose().scale(scale, scale, scale)
        graphics.drawString(minecraft.font, text, x, y, color, shadow)
        graphics.pose().popPose()
    }

    override fun drawImage(image: String, x: Int, y: Int, width: Int, height: Int) {
        graphics.pose().pushPose()
        graphics.blitSprite(ResourceLocation(image), x, y, width, height)
        graphics.pose().popPose()
    }

    // </editor-fold>
}