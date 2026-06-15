package net.dan2026.cobblemonpokedexrewards.common.gui.buttons;

import com.cobblemon.mod.common.api.gui.GuiUtilsKt;
import com.cobblemon.mod.common.client.CobblemonResources;
import com.cobblemon.mod.common.client.render.RenderHelperKt;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class PokedexRewardsTabButton extends Button {

    private static final ResourceLocation TEST_TEXTURE = ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/test.png");

    private static final ResourceLocation REWARD_ICON = ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/reward_icon.png");

    public PokedexRewardsTabButton(int x, int y) {
        super(x, y, 50, 11, Component.empty(), button -> onClick(), (button) -> Component.empty());
    }

    private static void onClick() {
        System.out.println("Rewards Tab Button Clicked");
    }

    @Override
    public void renderWidget(@NotNull GuiGraphics context, int mouseX, int mouseY, float delta) {

        int x = this.getX();
        int y = this.getY();

        final int verticalPadding = 2;

        final int leftTextPadding = 15;

        final float iconSize = .5f;

        final int leftIconPadding = 5;


        // Draw icon

        context.pose().pushPose();

        context.pose().translate(0, 0, 100);

        GuiUtilsKt.blitk(
                context.pose(),
                REWARD_ICON,
                (x + leftIconPadding) / iconSize,
                (y + verticalPadding) / iconSize,
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
                iconSize
        );

        context.pose().popPose();

        // Draw text

        RenderHelperKt.drawScaledText(
                context,
                CobblemonResources.INSTANCE.getDEFAULT_LARGE(),
                Component.literal("Rewards").withStyle(style -> style.withBold(true)),
                x + leftTextPadding,
                y + verticalPadding - 1,
                1f,
                1f,
                Integer.MAX_VALUE,
                0xFFFFFF,
                false,
                true,
                null,
                null
        );

        // Test Button overlay

        context.pose().pushPose();

        context.pose().translate(0, 0, 200);

        GuiUtilsKt.blitk(
                context.pose(),
                TEST_TEXTURE,
                x,
                y,
                11,
                50,
                0,
                0,
                16,
                16,
                0,
                1,
                1,
                1,
                .1f,
                true,
                1
        );

        context.pose().popPose();

    }
}