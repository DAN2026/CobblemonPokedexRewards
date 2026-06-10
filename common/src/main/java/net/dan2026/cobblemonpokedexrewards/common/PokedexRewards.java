package net.dan2026.cobblemonpokedexrewards.common;

import com.cobblemon.mod.common.api.gui.GuiUtilsKt;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public final class PokedexRewards {

    public static final String MOD_ID  = "cobblemonpokedexrewards";

    public static void render(GuiGraphics graphics) {

        GuiUtilsKt.drawCenteredText(
                graphics,
                null,
                Component.literal("Hello Cobblemon!"),
                100,
                100,
                0xFFFFFF,
                true
        );
    }


}
