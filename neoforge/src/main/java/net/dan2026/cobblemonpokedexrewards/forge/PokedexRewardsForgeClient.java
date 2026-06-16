/*
 * CobblemonPokedexRewards - A NeoForge Minecraft Mod.
 *
 * Copyright (c) 2026 DAN2026. All rights reserved.
 * * This software is licensed under the CobblemonPokedexRewards License v1.0.
 * A copy of this license should have been included with this software.
 * If not, you can obtain a copy at [Link to your License/Repository].
 */

package net.dan2026.cobblemonpokedexrewards.forge;

import net.dan2026.cobblemonpokedexrewards.common.client.events.ClientEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.dan2026.cobblemonpokedexrewards.common.PokedexRewards;



@EventBusSubscriber(modid = PokedexRewards.MOD_ID, value = Dist.CLIENT)
public class PokedexRewardsForgeClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

        ClientEvents.register();

    }

}