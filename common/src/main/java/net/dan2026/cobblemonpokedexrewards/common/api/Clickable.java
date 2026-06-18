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

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

/**
 * An interface for components that respond to user mouse interactions.
 */
public interface Clickable {

    /**
     * The logger instance for recording click events.
     */

    Logger LOGGER = LogUtils.getLogger();

    /**
     * Executes the logic associated with a mouse click event.
     */

    void onClick();

    /**
     * Logs the click event with support for variable parameters.
     *
     * @param message The log message, optionally containing {} placeholders.
     * @param params  Any number of arguments to be inserted into the placeholders.
     */

    default void logClick(String message, Object... params) {
        LOGGER.info(message, params);
    }
}