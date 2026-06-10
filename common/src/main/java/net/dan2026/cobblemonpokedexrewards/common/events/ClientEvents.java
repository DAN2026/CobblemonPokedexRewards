package net.dan2026.cobblemonpokedexrewards.common.events;

import dev.architectury.event.events.client.ClientGuiEvent;
import net.dan2026.cobblemonpokedexrewards.common.PokedexRewards;

public class ClientEvents {

    public static void init() {

        ClientGuiEvent.RENDER_HUD.register((graphics, tickDelta) -> {
            PokedexRewards.render(graphics);
        });

    }
}
