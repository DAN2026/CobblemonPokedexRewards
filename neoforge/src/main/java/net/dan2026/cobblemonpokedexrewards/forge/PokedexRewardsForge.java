package net.dan2026.cobblemonpokedexrewards.forge;

import net.dan2026.cobblemonpokedexrewards.common.PokedexRewards;
import net.dan2026.cobblemonpokedexrewards.common.events.ClientEvents;
import net.neoforged.fml.common.Mod;

@Mod(PokedexRewards.MOD_ID)
public class PokedexRewardsForge {

    public PokedexRewardsForge() {

        ClientEvents.init();
    }

}