package net.dan2026.cobblemonpokedexrewards.common.client.gui.components.header;

import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants;
import net.dan2026.cobblemonpokedexrewards.common.api.PokedexComponent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class Header implements PokedexComponent {

    private static final ResourceLocation HEADER =
            ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/pokedex_header_filler.png");


    public Header(){
        logInitialization();
    }


    @Override
    public void render(GuiGraphics graphics, int screenWidth, int screenHeight) {

        int x = (screenWidth - PokedexGUIConstants.BASE_WIDTH) / 2;
        int y = (screenHeight - PokedexGUIConstants.BASE_HEIGHT) / 2;

        graphics.blit(HEADER, x + 102, y + 13, 0, 0, 141, 4, 140, 4);

    }

    @Override
    public String getComponentName() {
        return "Pokedex Header";
    }


}
