package me.gamercoder215.kwidgets.fabric

import me.gamercoder215.kwidgets.Provider
import net.fabricmc.api.ClientModInitializer

class FabricProvider : ClientModInitializer, Provider {

    override fun onInitializeClient() {

    }

    // Provider

    override fun draw(text: String, x: Int, y: Int, color: Int, shadow: Boolean) {
        TODO("Not yet implemented")
    }
}