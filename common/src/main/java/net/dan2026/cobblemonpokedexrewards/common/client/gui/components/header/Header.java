/*
 * CobblemonPokedexRewards - A NeoForge Minecraft Mod.
 *
 * Copyright (c) 2026 DAN2026. All rights reserved.
 * * This software is licensed under the CobblemonPokedexRewards License v1.0.
 * A copy of this license should have been included with this software.
 * If not, you can obtain a copy at [Link to your License/Repository].
 */

package net.dan2026.cobblemonpokedexrewards.common.client.gui.components.header;

import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants;
import net.dan2026.cobblemonpokedexrewards.common.api.PokedexComponent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class Header implements PokedexComponent {

    private static final ResourceLocation HEADER =
            ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/pokedex_header_filler.png");


    public Header() {
        logInitialization();
    }


    @Override
    public void render(GuiGraphics graphics, int screenWidth, int screenHeight) {

        int x = (screenWidth - PokedexGUIConstants.BASE_WIDTH) / 2;
        int y = (screenHeight - PokedexGUIConstants.BASE_HEIGHT) / 2;

        graphics.blit(HEADER, x + 102, y + 13, 0, 0, 141, 4, 140, 4);

    }

    @Override
    public String getComponentName() {
        return "Pokedex Header";
    }


}
