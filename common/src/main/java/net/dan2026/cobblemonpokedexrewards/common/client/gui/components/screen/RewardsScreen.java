/*
 *
 * CobblemonPokedexRewards - A NeoForge Minecraft Mod.
 *
 * Copyright (c) 2026 DAN2026. All rights reserved.
 *
 * This software is licensed under the CobblemonPokedexRewards License v1.0.
 *  A copy of this license should have been included with this software.
 *  If not, you can obtain a copy at [https://github.com/DAN2026/CobblemonPokedexRewards/blob/master/LICENSE].
 *
 */

package net.dan2026.cobblemonpokedexrewards.common.client.gui.components.screen;

import com.cobblemon.mod.common.api.gui.GuiUtilsKt;
import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants;
import com.cobblemon.mod.common.client.pokedex.PokedexType;
import com.cobblemon.mod.common.item.PokedexItem;
import net.dan2026.cobblemonpokedexrewards.common.client.gui.components.buttons.PokedexButton;
import net.dan2026.cobblemonpokedexrewards.common.client.gui.components.buttons.RewardButton;
import net.dan2026.cobblemonpokedexrewards.common.client.gui.components.text.Title;
import net.dan2026.cobblemonpokedexrewards.common.client.gui.components.widget.RewardsScrollingWidget;
import net.dan2026.cobblemonpokedexrewards.common.data.RewardEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUI;

import java.util.List;


public class RewardsScreen extends Screen {

    private static final ResourceLocation POKEDEX_BACKGROUND = ResourceLocation.fromNamespaceAndPath("cobblemon", "textures/gui/pokedex/pokedex_screen.png");
    private static final ResourceLocation REWARD_ICON = ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/reward_icon.png");

    private PokedexType pokedexType = PokedexType.RED;

    private final Screen pokedexScreen;


    public RewardsScreen(Screen previousScreen) {
        super(Component.literal("Rewards"));

        this.pokedexScreen = previousScreen;
    }


    @Override
    public void render(GuiGraphics context, int mouseX, int mouseY, float delta) {

        int posX = (this.width - PokedexGUIConstants.BASE_WIDTH) / 2;
        int posY = (this.height - PokedexGUIConstants.BASE_HEIGHT) / 2;

        renderBase(context, posX, posY);

        renderBackground(context, posX, posY);

        renderIcon(context, posX, posY);

        renderTitle(context, posX, posY);


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
     * Renders the background of the pokedex GUI.
     * @param context Graphics
     * @param posX Position in the X axis
     * @param posY Position in the Y axis
     * @see PokedexType
     * @see PokedexGUI
     */

    private void renderBackground(GuiGraphics context, int posX, int posY){

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
     * Renders the reward icon.
     *
     * @param context The GuiGraphics instance.
     * @param posX The starting x position.
     * @param posY The starting y position.
     */

    private void renderIcon(GuiGraphics context, int posX, int posY) {

        float SCALE = 0.5f;

        GuiUtilsKt.blitk(
                context.pose(),
                REWARD_ICON,
                (posX + 26) / SCALE,
                (posY + 15) / SCALE,
                14,
                14,
                0,
                0,
                14,
                14,
                0,
                1,
                1,
                1,
                1f,
                true,
                SCALE
        );

    }


    /**
     * Renders the reward title for the dex.
     *
     * @param context The GuiGraphics instance.
     * @param posX The starting x position.
     * @param posY The starting y position.
     */

    private void renderTitle(GuiGraphics context, int posX, int posY){

        Title title = new Title(
                "Rewards",
                posX + 36,
                posY + 14,
                0xfcfcfc,
                1,
                Integer.MAX_VALUE
        );

        title.render(context, this.width, this.height);

    }


    /**
     * Checks the Pokédex type for which base texture should load.
     * Implement before calling renderBase.
     * @implNote
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

    @Override
    public void onClose() {
        Minecraft.getInstance().setScreen(pokedexScreen);
    }

    @Override
    protected void init() {
        super.init();

        int posX = (this.width - PokedexGUIConstants.BASE_WIDTH) / 2;
        int posY = (this.height - PokedexGUIConstants.BASE_HEIGHT) / 2;

        this.addRenderableWidget(
                new PokedexButton(
                        posX + 83,
                        posY + 15,
                        pokedexScreen
                )
        );

        RewardsScrollingWidget scrollWidget = new RewardsScrollingWidget(
                posX + 26,
                posY + 39
        );

        scrollWidget.createEntries(List.of(
                new RewardEntry("Test Reward 1", 10, RewardEntry.RewardType.ITEM, "minecraft:diamond"),
                new RewardEntry("Test Reward 2", 25, RewardEntry.RewardType.COMMAND, "/give @p minecraft:emerald"),
                new RewardEntry("Test Reward 3", 50, RewardEntry.RewardType.POKEMON, "cobblemon:pikachu"),
                new RewardEntry("Test Reward 4", 75, RewardEntry.RewardType.ITEM, "minecraft:gold_ingot"),
                new RewardEntry("Test Reward 5", 90, RewardEntry.RewardType.ITEM, "minecraft:netherite_ingot"),
                new RewardEntry("Test Reward 6", 100, RewardEntry.RewardType.POKEMON, "cobblemon:mewtwo"),
                new RewardEntry("Test Reward 7", 100, RewardEntry.RewardType.POKEMON, "cobblemon:mewtwo"),
                new RewardEntry("Test Reward 8", 100, RewardEntry.RewardType.POKEMON, "cobblemon:mewtwo")
        ));

        this.addRenderableWidget(scrollWidget);


    }
}
