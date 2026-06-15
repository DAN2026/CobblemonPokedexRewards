package net.dan2026.cobblemonpokedexrewards.forge.mixins;

import com.cobblemon.mod.common.api.gui.GuiUtilsKt;
import com.cobblemon.mod.common.client.CobblemonResources;
import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUI;
import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUIConstants;
import net.dan2026.cobblemonpokedexrewards.common.gui.buttons.PokedexRewardsTabButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.cobblemon.mod.common.client.render.RenderHelperKt;

@Mixin(PokedexGUI.class)
public abstract class PokedexGUIMixin extends Screen {

    @Unique
    private static final ResourceLocation REWARDS_BUTTON = ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/test.png");

    @Unique
    private static final ResourceLocation REWARD_ICON = ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/reward_icon.png");

    @Unique
    private static final ResourceLocation POKEDEX_HEADER_FILLER = ResourceLocation.fromNamespaceAndPath("cobblemonpokedexrewards", "textures/gui/pokedex_header_filler.png");

    protected PokedexGUIMixin() {
        super(Component.empty());
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void addRewardsButton(CallbackInfo ci) {
        int x = (this.width - 349) / 2;
        int y = (this.height - 205) / 2;

        this.addRenderableWidget(new PokedexRewardsTabButton(x + 121, y + 12));

    }


    @Inject(method = "render", at = @At("TAIL"))
    private void renderRewardsSprite(GuiGraphics context, int mouseX, int mouseY, float delta, CallbackInfo ci) {


        final int TEXT_PADDING = 25;

        final int TEXT_HEIGHT = 14;

        final int TEXT_WIDTH = 109;

        final float ICON_SCALE = 0.5f;

        final int ICON_PADDING = 13;


        int x = (this.width - PokedexGUIConstants.BASE_WIDTH) / 2;
        int y = (this.height - PokedexGUIConstants.BASE_HEIGHT) / 2;

        context.blit(POKEDEX_HEADER_FILLER, x + 102, y + 13, 0, 0, 141, 4, 140, 4);

//        GuiUtilsKt.blitk(
//                context.pose(),
//                REWARD_ICON,
//                (x + TEXT_WIDTH + ICON_PADDING) / ICON_SCALE,
//                (y + TEXT_HEIGHT + 1) / ICON_SCALE,
//                14,
//                14,
//                0,
//                0,
//                14,
//                14,
//                0,
//                1,
//                1,
//                1,
//                1F,
//                true,
//                ICON_SCALE
//        );
//
//        RenderHelperKt.drawScaledText(
//                context,
//                CobblemonResources.INSTANCE.getDEFAULT_LARGE(),
//                Component.literal("Rewards").withStyle(style -> style.withBold(true)),
//                x + TEXT_WIDTH + TEXT_PADDING,
//                y + TEXT_HEIGHT,
//                1F,
//                1F,
//                Integer.MAX_VALUE,
//                0xFFFFFF,
//                false,
//                true,
//                null,
//                null
//        );

    }


}
