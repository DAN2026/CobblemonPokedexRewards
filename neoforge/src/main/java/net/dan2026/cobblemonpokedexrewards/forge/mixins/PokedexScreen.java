/*
 *
 * CobblemonPokedexRewards - A NeoForge Minecraft Mod.
 *
 * Copyright (c) 2026 DAN2026. All rights reserved.
 *
 * This software is licensed under the CobblemonPokedexRewards License v1.0.
 *  A copy of this license should have been included with this software.
 *  If not, you can obtain a copy at [https://github.com/DAN2026/CobblemonPokedexRewards/blob/master/LICENSE].
 *
 */

package net.dan2026.cobblemonpokedexrewards.forge.mixins;

import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUI;
import net.dan2026.cobblemonpokedexrewards.common.client.gui.components.buttons.RewardButton;
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
public abstract class PokedexScreen extends Screen {

    @Unique
    private static final int BASE_WIDTH = 349;

    @Unique
    private static final int BASE_HEIGHT = 205;

    @Unique
    private static final int POS_X = 83;

    @Unique
    private static final int POS_Y = 12;

    protected PokedexScreen() { super(Component.empty());}

    /**
     * Injects into the {@code init} method to add custom renderable widgets
     * such as the reward button after the standard GUI elements are initialized.
     *
     * @param ci The callback information for the injection.
     */

    @Inject(method = "init", at = @At("TAIL"))
    private void renderButton(CallbackInfo ci) {

        int x = (this.width - BASE_WIDTH) / 2;
        int y = (this.height - BASE_HEIGHT) / 2;

        RewardButton rewardButton = new RewardButton(x + POS_X, y + POS_Y, this);

        this.addRenderableWidget(rewardButton);

    }

}