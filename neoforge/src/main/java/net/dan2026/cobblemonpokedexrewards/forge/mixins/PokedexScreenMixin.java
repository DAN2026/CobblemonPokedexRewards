/*
 * CobblemonPokedexRewards - A NeoForge Minecraft Mod.
 *
 * Copyright (c) 2026 DAN2026. All rights reserved.
 * * This software is licensed under the CobblemonPokedexRewards License v1.0.
 * A copy of this license should have been included with this software.
 * If not, you can obtain a copy at [Link to your License/Repository].
 */

package net.dan2026.cobblemonpokedexrewards.forge.mixins;

import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUI;
import net.dan2026.cobblemonpokedexrewards.common.client.gui.components.buttons.RewardBtn;
import net.dan2026.cobblemonpokedexrewards.common.client.gui.components.header.Header;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixin class for the {@link PokedexGUI} to inject custom UI components
 * and render logic without modifying the base class source code.
 */

@Mixin(PokedexGUI.class)
public abstract class PokedexScreenMixin extends Screen {

    /**
     * The reference width of the Pokédex GUI for coordinate calculations.
     */

    @Unique
    private static final int BASE_WIDTH = 349;

    /**
     * The reference height of the Pokédex GUI for coordinate calculations.
     */

    @Unique
    private static final int BASE_HEIGHT = 205;

    /**
     * The custom header component displayed in the Pokédex GUI.
     */

    @Unique
    private final Header cobblemonPokedexRewards$header = new Header();

    protected PokedexScreenMixin() {
        super(Component.empty());
    }

    /**
     * Injects into the {@code init} method to add custom renderable widgets
     * such as the reward button after the standard GUI elements are initialized.
     *
     * @param ci The callback information for the injection.
     */

    @Inject(method = "init", at = @At("TAIL"))
    private void onInit(CallbackInfo ci) {
        int x = (this.width - BASE_WIDTH) / 2;
        int y = (this.height - BASE_HEIGHT) / 2;
        this.addRenderableWidget(new RewardBtn(x + 121, y + 12));
    }

    /**
     * Injects into the {@code render} method to draw additional UI layers
     * like the header after the base GUI has finished rendering.
     *
     * @param context The graphics context for rendering elements.
     * @param mouseX  The current X coordinate of the mouse.
     * @param mouseY  The current Y coordinate of the mouse.
     * @param delta   The partial tick time for smooth rendering.
     * @param ci      The callback information for the injection.
     */

    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(GuiGraphics context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        cobblemonPokedexRewards$header.render(context, this.width, this.height);
    }
}