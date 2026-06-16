/*
 * CobblemonPokedexRewards - A NeoForge Minecraft Mod.
 *
 * Copyright (c) 2026 DAN2026. All rights reserved.
 * * This software is licensed under the CobblemonPokedexRewards License v1.0.
 * A copy of this license should have been included with this software.
 * If not, you can obtain a copy at [Link to your License/Repository].
 */

package net.dan2026.cobblemonpokedexrewards.fabric;

import net.dan2026.cobblemonpokedexrewards.common.client.events.ClientEvents;
import net.fabricmc.api.ClientModInitializer;

public class PokedexRewardsFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ClientEvents.register();

    }

}
