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