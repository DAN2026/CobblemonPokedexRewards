package net.dan2026.cobblemonpokedexrewards.common.events;

import dev.architectury.event.events.client.ClientGuiEvent;
import net.dan2026.cobblemonpokedexrewards.common.gui.ClientGui;

public class ClientEvents {

    public static void register() {

        ClientGuiEvent.RENDER_HUD.register((graphics, tickDelta) -> {
//            ClientGui.render(graphics);
        });

    }
}
