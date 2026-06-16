package net.dan2026.cobblemonpokedexrewards.common.client.events;

import dev.architectury.event.events.client.ClientGuiEvent;

public class ClientEvents {

    public static void register() {

        ClientGuiEvent.RENDER_HUD.register((graphics, tickDelta) -> {
//            ClientGui.render(graphics);
        });

    }
}
