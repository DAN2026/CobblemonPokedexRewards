package net.dan2026.cobblemonpokedexrewards.common.client.gui.components.screen;

import com.cobblemon.mod.common.api.gui.GuiUtilsKt;
import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants;
import com.cobblemon.mod.common.client.pokedex.PokedexType;
import com.cobblemon.mod.common.item.PokedexItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUI;


public class RewardsScreen extends Screen {

    private static final ResourceLocation POKEDEX_BACKGROUND = ResourceLocation.fromNamespaceAndPath("cobblemon", "textures/gui/pokedex/pokedex_screen.png");

    private PokedexType pokedexType = PokedexType.RED;

    public RewardsScreen() {
        super(Component.literal("Rewards"));
    }


    @Override
    public void render(GuiGraphics context, int mouseX, int mouseY, float delta) {

        int posX = (this.width - PokedexGUIConstants.BASE_WIDTH) / 2;
        int posY = (this.height - PokedexGUIConstants.BASE_HEIGHT) / 2;

        renderBase(context, posX, posY);

        GuiUtilsKt.blitk(
                context.pose(),
                POKEDEX_BACKGROUND,
                posX, posY,
                PokedexGUIConstants.BASE_HEIGHT,
                PokedexGUIConstants.BASE_WIDTH,
                0, 0,
                PokedexGUIConstants.BASE_WIDTH,
                PokedexGUIConstants.BASE_HEIGHT,
                0,
                1, 1, 1, 1F,
                true,
                1F
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    protected void renderBlurredBackground(float f) {
    }

    @Override
    protected void renderMenuBackground(GuiGraphics guiGraphics) {
    }


    /**
     * Renders the base of the pokedex GUI.
     * @param context Graphics
     * @param posX Position in the X axis
     * @param posY Position in the Y axis
     * @see PokedexType
     * @see PokedexGUI
     */

    private void renderBase(GuiGraphics context, int posX, int posY){

        checkPokedexType();

        GuiUtilsKt.blitk(
                context.pose(),
                pokedexType.getTexturePath(),
                posX,
                posY,
                PokedexGUIConstants.BASE_HEIGHT,
                PokedexGUIConstants.BASE_WIDTH,
                0,
                0,
                PokedexGUIConstants.BASE_WIDTH,
                PokedexGUIConstants.BASE_HEIGHT,
                0,
                1,
                1,
                1,
                1F,
                true
        );
    }


    /**
     * Checks the Pokédex type for which base texture should load.
     * @implNote Implement before calling renderBase.
     */


    private void checkPokedexType(){
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player == null) return;

        ItemStack heldItem = player.getMainHandItem();

        if (heldItem.getItem() instanceof PokedexItem pokedexItem) {
            pokedexType = pokedexItem.getType();
        }
    }

}
