package net.dan2026.cobblemonpokedexrewards.fabric;

import net.dan2026.cobblemonpokedexrewards.common.events.ClientEvents;
import net.fabricmc.api.ClientModInitializer;

public class PokedexRewardsFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientEvents.init();
    }
}