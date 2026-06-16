/*
 * CobblemonPokedexRewards - A NeoForge Minecraft Mod.
 *
 * Copyright (c) 2026 DAN2026. All rights reserved.
 * * This software is licensed under the CobblemonPokedexRewards License v1.0.
 * A copy of this license should have been included with this software.
 * If not, you can obtain a copy at [Link to your License/Repository].
 */

package net.dan2026.cobblemonpokedexrewards.common.util;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


    /**
     * Utility class for time-related operations.
     */

public final class TimeUtils {

    /**
     * Formatter for the requested pattern: dd/mm/yy : hh/mm/ss
     */

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy : HH/mm/ss");

    // To stop instantiation
        
    private TimeUtils() {}

    /**
     * Gets the current local date and time as a formatted string.
     *
     * @return A string in the format "dd/mm/yy : hh/mm/ss".
     */

    public static @NotNull String getFormattedCurrentTime() {
        return LocalDateTime.now().format(FORMATTER);
    }
}