/*
 * CobblemonPokedexRewards - A NeoForge Minecraft Mod.
 *
 * Copyright (c) 2026 DAN2026. All rights reserved.
 * * This software is licensed under the CobblemonPokedexRewards License v1.0.
 * A copy of this license should have been included with this software.
 * If not, you can obtain a copy at [Link to your License/Repository].
 */

package net.dan2026.cobblemonpokedexrewards.common.client.gui.components.buttons;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.gui.GuiUtilsKt;
import net.dan2026.cobblemonpokedexrewards.common.api.Clickable;
import net.dan2026.cobblemonpokedexrewards.common.api.PokedexComponent;
import net.dan2026.cobblemonpokedexrewards.common.util.TimeUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;


/**
 * Reward button for the Pokedex.
 */

public final class RewardButton extends Button implements PokedexComponent, Clickable {

    private static final ResourceLocation UNHOVERED_ICON = ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/reward_icon_unhovered.png");
    private static final ResourceLocation HOVERED_ICON = ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/reward_icon_hovered.png");

    private static final ResourceLocation TEST_TEXTURE = ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/test.png");

    private static final int BUTTON_WIDTH = 11;
    private static final int BUTTON_HEIGHT = 11;
    private static final int ICON_SIZE = 14;
    private static final int ICON_X_OFFSET = 2;
    private static final int ICON_Y_OFFSET = 2;
    private static final int Z_LEVEL = 100;
    private static final float ICON_SCALE = 0.5f;
    /**
     * Initialises a new Reward button at the specified coordinates.
     *
     * @param posX The x coordinate for the button.
     * @param posY The y coordinate for the button.
     */

    public RewardButton(int posX, int posY) {
        super(
                posX,
                posY,
                BUTTON_WIDTH,
                BUTTON_HEIGHT,
                Component.empty(),
                btn -> ((Clickable) btn).onClick(),
                (button) -> Component.empty()
        );

        logInitialization();

    }

    /**
     * Renders the button widget including its custom icon and text elements.
     *
     * @param context The GuiGraphics instance for rendering.
     * @param mouseX The current x position of the mouse.
     * @param mouseY The current y position of the mouse.
     * @param delta Partial tick time.
     */

    @Override
    public void renderWidget(@NotNull GuiGraphics context, int mouseX, int mouseY, float delta) {
        int posX = this.getX();
        int posY = this.getY();

        renderIcon(context, posX, posY);
        renderClickableArea(context, posX, posY);
    }

    /**
     * Renders the component based on the provided screen dimensions.
     *
     * @param graphics The game's render helper.
     * @param screenWidth The total width of the GUI screen.
     * @param screenHeight The total height of the GUI screen.
     */

    @Override
    public void render(GuiGraphics graphics, int screenWidth, int screenHeight) {
        this.renderWidget(graphics, 0, 0, 0);
    }

    @Override
    public String getComponentName() {
        return "Reward Button";
    }

    /**
     * Renders the button icon based on hover state.
     *
     * @param context The GuiGraphics instance.
     * @param posX The starting x position.
     * @param posY The starting y position.
     */

    private void renderIcon(GuiGraphics context, int posX, int posY) {

        ResourceLocation activeIcon = (this.isHovered) ? HOVERED_ICON : UNHOVERED_ICON;

        context.pose().pushPose();
        context.pose().translate(0, 0, Z_LEVEL);

        GuiUtilsKt.blitk(
                context.pose(),
                activeIcon,
                (posX + ICON_X_OFFSET) / ICON_SCALE,
                (posY + ICON_Y_OFFSET) / ICON_SCALE,
                ICON_SIZE,
                ICON_SIZE,
                0,
                0,
                ICON_SIZE,
                ICON_SIZE,
                0,
                1,
                1,
                1,
                1f,
                true,
                ICON_SCALE
        );

        context.pose().popPose();
    }

        /**
     * Renders the clickable area using a test texture.
     *
     * @param context The GuiGraphics instance.
     * @param posX The starting x position.
     * @param posY The starting y position.
     */

    @TestOnly
    private void renderClickableArea(GuiGraphics context, int posX, int posY){

        context.blit(
                TEST_TEXTURE,
                posX,
                posY,
                0,
                0,
                BUTTON_WIDTH,
                BUTTON_HEIGHT,
                16,
                16
        );
    }

    /**
     * Handles the click action for the reward button.
     */

    public void onClick() {

        Minecraft.getInstance().getSoundManager().play(
                SimpleSoundInstance.forUI(CobblemonSounds.POKEDEX_CLICK_SHORT, 1.0f)
        );

        logClick(" Reward Button clicked at {}", TimeUtils.getFormattedCurrentTime());
    }
}