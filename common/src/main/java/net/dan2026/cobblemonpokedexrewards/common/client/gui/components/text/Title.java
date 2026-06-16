package net.dan2026.cobblemonpokedexrewards.common.client.gui.components.text;

import com.cobblemon.mod.common.client.CobblemonResources;
import com.cobblemon.mod.common.client.render.RenderHelperKt;
import net.dan2026.cobblemonpokedexrewards.common.api.PokedexComponent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class Title implements PokedexComponent {

    private final String text;
    private final int x;
    private final int y;
    private final int color;
    private final int text_scale;
    private final int max_width;

    public Title(String text, int x, int y, int color, int text_scale, int max_width) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
        this.text_scale = text_scale;
        this.max_width = max_width;
    }



    @Override
    public void render(GuiGraphics graphics, int screenWidth, int screenHeight) {
        RenderHelperKt.drawScaledText(
                graphics,
                CobblemonResources.INSTANCE.getDEFAULT_LARGE(),
                Component.literal(this.text).withStyle(style -> style.withBold(true)),
                this.x,
                this.y,
                text_scale,
                text_scale,
                max_width,
                this.color,
                false,
                true,
                null,
                null
        );
    }

    @Override
    public String getComponentName() {
        return "Pokedex Title";
    }
}
