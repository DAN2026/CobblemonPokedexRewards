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

package net.dan2026.cobblemonpokedexrewards.common.client.gui.components.widget;

import com.cobblemon.mod.common.api.gui.GuiUtilsKt;
import com.cobblemon.mod.common.client.gui.ScrollingWidget;
import net.dan2026.cobblemonpokedexrewards.common.data.RewardEntry;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants.SCROLL_SLOT_SIZE;
import static com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants.SCROLL_SLOT_SPACING;
import static com.cobblemon.mod.common.util.MiscUtilsKt.cobblemonResource;

public class RewardSlot extends ScrollingWidget.Slot<RewardSlot> {

    private final RewardEntry reward;

    private final ResourceLocation slotResource = cobblemonResource("textures/gui/pokedex/pokedex_slot.png");

    private int x = 0;

    private int y = 0;


    public RewardSlot(RewardEntry reward) {
        this.reward = reward;
    }

    @Override
    public void render(GuiGraphics context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float delta) {


        /*
        This will be eventually a row for now we * 0, but we need to multiply it by the index for the correct spacing
        between the slots.
         */

        int startPosX = x + ((SCROLL_SLOT_SPACING + SCROLL_SLOT_SIZE) * 0);
        int startPosY = y + SCROLL_SLOT_SPACING + 1;

        renderIcon(context, startPosX, startPosY);

    }

    private void renderIcon(GuiGraphics context, int posX, int posY) {

        GuiUtilsKt.blitk(
                context.pose(),
                slotResource,
                (posX),
                (posY),
                SCROLL_SLOT_SIZE,
                SCROLL_SLOT_SIZE,
                0,
                0,
                SCROLL_SLOT_SIZE,
                SCROLL_SLOT_SIZE,
                0,
                1,
                1,
                1,
                1f,
                true,
                1f
        );

    }

    @Override
    public @NotNull Component getNarration() {
        return Component.literal(reward.getName());
    }

    public RewardEntry getReward() {
        return reward;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
