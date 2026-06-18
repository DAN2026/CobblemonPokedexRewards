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

package net.dan2026.cobblemonpokedexrewards.common.api;

import net.minecraft.client.gui.GuiGraphics;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

/**
 * An interface for all custom Pokédex UI components used in my mod.
 */

public interface PokedexComponent {

    Logger LOGGER = LogUtils.getLogger();

    /**
     * Renders the component based on the provided screen dimensions.
     * @param graphics The game's graphics.
     * @param screenWidth The total width of the GUI screen.
     * @param screenHeight The total height of the GUI screen.
     */

    void render(GuiGraphics graphics, int screenWidth, int screenHeight);

    /**
     * Returns the unique name of this component for identification.
     * @return the component name.
     */

    String getComponentName();

    /**
     * Logs whether the component has loaded.
     * This should be called within the component constructor if used.
     */

    default void logInitialization() {
        LOGGER.info("Component: {} has been initialized.", getComponentName());
    }

}