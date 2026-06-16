package net.dan2026.cobblemonpokedexrewards.fabric;

import net.dan2026.cobblemonpokedexrewards.common.client.events.ClientEvents;
import net.fabricmc.api.ClientModInitializer;

public class PokedexRewardsFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ClientEvents.register();

    }

}
