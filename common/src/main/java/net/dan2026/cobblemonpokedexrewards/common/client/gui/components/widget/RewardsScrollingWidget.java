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

import com.cobblemon.mod.common.client.gui.ScrollingWidget;
import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants;
import net.dan2026.cobblemonpokedexrewards.common.data.RewardEntry;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.TraceableEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants.SCROLL_SLOT_SIZE;
import static com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants.SCROLL_SLOT_SPACING;

public class RewardsScrollingWidget extends ScrollingWidget<RewardSlot> {

    private final int pX;

    private final int pY;

    public RewardsScrollingWidget(int pX, int pY) {
        super(
                pY - PokedexGUIConstants.SCROLL_BASE_HEIGHT,
                pX,
                PokedexGUIConstants.HALF_OVERLAY_WIDTH,
                PokedexGUIConstants.SCROLL_BASE_HEIGHT,
                PokedexGUIConstants.SCROLL_SLOT_SIZE + 2,
                5
        );

        this.pX = pX;
        this.pY = pY;
    }

    public void createEntries(List<RewardEntry> allRewards) {

        System.out.println(allRewards.size());

        boolean largerIcons = allRewards.size() < 25;

        int rowAmount = 5;

        for (int i = 0; i < allRewards.size(); i += rowAmount) {

            int end = Math.min(i + 5, allRewards.size());

            List<RewardEntry> rewardEntries = allRewards.subList(i, end);

            addEntry(new RewardSlot(rewardEntries, largerIcons));
        }
    }

    @Override
    public int getScrollbarPosition() {
        return pX + this.width - 3;
    }

    @Override
    protected void renderItem(@NotNull GuiGraphics context, int mouseX, int mouseY, float delta, int index, int x, int y, int entryWidth, int entryHeight) {

        RewardSlot slot = this.getEntry(index);

        slot.setX(x);
        slot.setY(y);

        slot.render(context, index, y, x, entryWidth, entryHeight, mouseX, mouseY, false, delta);

    }

    @Override
    public @NotNull RewardSlot getEntry(int index) {
        return children().get(index);
    }

    @Override
    public void renderScrollbar(@NotNull GuiGraphics context, int mouseX, int mouseY, float delta) {

        int xLeft = getScrollbarPosition();
        int xRight = xLeft + 3;

        int barHeight = getBottom() - getY();

        int yBottom = (int) (((float) barHeight * (float) barHeight) / (float) getMaxPosition());
        yBottom = Mth.clamp(yBottom, 32, barHeight - 8);
        int yTop = (int) (getScrollAmount() * (float) (barHeight - yBottom) / (float) getMaxScroll()) + getY();

        if (yTop < getY()) {
            yTop = getY();
        }

        context.fill(xLeft, getY() + 3, xRight, getBottom() - 3, FastColor.ARGB32.color(255, 58, 150, 182));
        context.fill(xLeft, yTop + 3, xRight, yTop + yBottom - 3, FastColor.ARGB32.color(255, 252, 252, 252));
    }

}
