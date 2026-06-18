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

package net.dan2026.cobblemonpokedexrewards.common.client.events;

import dev.architectury.event.events.client.ClientGuiEvent;

public class ClientEvents {

    public static void register() {

        ClientGuiEvent.RENDER_HUD.register((graphics, tickDelta) -> {
//            ClientGui.render(graphics);
        });

    }
}
