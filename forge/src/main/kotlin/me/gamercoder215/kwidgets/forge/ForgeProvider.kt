package me.gamercoder215.kwidgets.forge

import me.gamercoder215.kwidgets.Provider
import me.gamercoder215.kwidgets.Provider.Companion.provider
import me.gamercoder215.kwidgets.util.DEFAULT_FONT_SIZE
import me.gamercoder215.kwidgets.util.MOD_ID
import me.gamercoder215.kwidgets.util.WComputer
import me.gamercoder215.kwidgets.util.WPlayer
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.renderer.blockentity.SignRenderer
import net.minecraft.resources.ResourceLocation
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

    override val player: WPlayer
        get() = ForgePlayer

    override val computer: WComputer
        get() = ForgeComputer

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