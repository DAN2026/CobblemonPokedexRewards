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

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.gui.GuiUtilsKt;
import com.cobblemon.mod.common.client.gui.ScrollingWidget;
import net.dan2026.cobblemonpokedexrewards.common.data.RewardEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants.SCROLL_SLOT_SIZE;
import static com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants.SCROLL_SLOT_SPACING;
import static com.cobblemon.mod.common.util.MiscUtilsKt.cobblemonResource;

public class RewardSlot extends ScrollingWidget.Slot<RewardSlot> {


    private final List<RewardEntry> rowRewards;

    private final ResourceLocation slot = cobblemonResource("textures/gui/pokedex/pokedex_slot.png");

    private final ResourceLocation slotHovered = cobblemonResource("textures/gui/pokedex/slot_select.png");


    private int x = 0;

    private int y = 0;




    public RewardSlot(List<RewardEntry> rewardsInThisRow) {
        this.rowRewards = rewardsInThisRow;
    }

    @Override
    public void render(GuiGraphics context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float delta) {


        /*
        This will be eventually a row for now we * 0, but we need to multiply it by the index for the correct spacing
        between the slots.
         */

        int hoveredColumn = getHoveredSlotIndex(mouseX, mouseY);

        for (int i = 0; i < rowRewards.size(); i++) {
            int posX = x + ((SCROLL_SLOT_SPACING + SCROLL_SLOT_SIZE) * i);
            int posY = y + SCROLL_SLOT_SPACING + 1;

            renderIcon(context, posX, posY);

            if (i == hoveredColumn) {
                System.out.println("Hovered over: " + rowRewards.get(i).getName());

                renderHoveredIcon(context, posX, posY);
            }
        }

    }

    private void renderIcon(GuiGraphics context, int posX, int posY) {

        GuiUtilsKt.blitk(
                context.pose(),
                slot,
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

    private void renderHoveredIcon(GuiGraphics context, int posX, int posY) {

        GuiUtilsKt.blitk(
                context.pose(),
                slotHovered,
                (posX),
                (posY),
                SCROLL_SLOT_SIZE,
                SCROLL_SLOT_SIZE,
                0,
                SCROLL_SLOT_SIZE,
                SCROLL_SLOT_SIZE,
                SCROLL_SLOT_SIZE * 2,
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
    public boolean mouseClicked(double mouseX, double mouseY, int button) {

        int hoverIndex = getHoveredSlotIndex((int) mouseX, (int) mouseY);

        if (hoverIndex > -1 && hoverIndex < rowRewards.size()) {

            RewardEntry clickedReward = rowRewards.get(hoverIndex);

            System.out.println("Clicked on: " + clickedReward.getName());

            Minecraft.getInstance().getSoundManager().play(
                    SimpleSoundInstance.forUI(CobblemonSounds.POKEDEX_CLICK, 1.0F)
            );
            return true;
        }

        return false;
    }

    private int getHoveredSlotIndex(int mouseX, int mouseY) {

        for (int i = 0; i < rowRewards.size(); i++) {

            int startPosX = x + ((SCROLL_SLOT_SPACING + SCROLL_SLOT_SIZE) * i);
            int startPosY = y + SCROLL_SLOT_SPACING + 1;

            if (mouseX >= startPosX && mouseX <= startPosX + SCROLL_SLOT_SIZE &&
                    mouseY >= startPosY && mouseY <= startPosY + SCROLL_SLOT_SIZE) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public @NotNull Component getNarration() {

        String narration = rowRewards.stream()
                .map(RewardEntry::getName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("Empty Row");

        return Component.literal(narration);
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
