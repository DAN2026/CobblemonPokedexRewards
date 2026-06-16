package net.dan2026.cobblemonpokedexrewards.common.client.gui.components.text;

import com.cobblemon.mod.common.client.CobblemonResources;
import com.cobblemon.mod.common.client.render.RenderHelperKt;
import net.dan2026.cobblemonpokedexrewards.common.api.PokedexComponent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class ButtonText implements PokedexComponent {

    private final String text;
    private final int x;
    private final int y;
    private final int colorHovered;
    private final int colorUnhovered;
    private final float scale;
    private final int maxWidth;
    private boolean isHovered;

    public ButtonText(String text, int x, int y, int colorHovered, int colorUnhovered, float scale, int maxWidth) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.colorHovered = colorHovered;
        this.colorUnhovered = colorUnhovered;
        this.scale = scale;
        this.maxWidth = maxWidth;
        this.isHovered = false;
    }


    /**
     * Renders the text associated for the render button.
     *
     * @param graphics The GuiGraphics instance.
     * @param screenWidth The width of the users screen.
     * @param screenHeight The height of the users screen.
     */

    @Override
    public void render(GuiGraphics graphics, int screenWidth, int screenHeight) {

        int activeColour = this.isHovered ? this.colorHovered : this.colorUnhovered;

        RenderHelperKt.drawScaledText(
                graphics,
                CobblemonResources.INSTANCE.getDEFAULT_LARGE(),
                Component.literal(this.text).withStyle(style -> style.withBold(true)),
                this.x,
                this.y,
                this.scale,
                this.scale,
                this.maxWidth,
                activeColour,
                false,
                true,
                null,
                null
        );
    }

    /**
     * Allows us to set whether the text is being hovered or not.
     * @param isHovered Whether the text is currently being hovered.
     */

    public void setHovered(boolean isHovered) {
        this.isHovered = isHovered;
    }

    @Override
    public String getComponentName() {
        return "Button Text";
    }
}
