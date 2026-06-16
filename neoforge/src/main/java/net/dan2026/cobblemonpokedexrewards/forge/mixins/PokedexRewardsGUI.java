package net.dan2026.cobblemonpokedexrewards.forge.mixins;

import com.cobblemon.mod.common.client.gui.pokedex.PokedexGUI;
import net.dan2026.cobblemonpokedexrewards.common.client.gui.components.buttons.RewardBtn;
import net.dan2026.cobblemonpokedexrewards.common.client.gui.components.header.Header;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PokedexGUI.class)
public abstract class PokedexRewardsGUI extends Screen {

    @Unique
    private final Header header = new Header();

    protected PokedexRewardsGUI() {
        super(Component.empty());
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void renderRewardBtn(CallbackInfo ci) {

        int x = (this.width - 349) / 2;
        int y = (this.height - 205) / 2;

        this.addRenderableWidget(new RewardBtn(x + 121, y + 12));
    }


    @Inject(method = "render", at = @At("TAIL"))
    private void renderHeader(GuiGraphics context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        header.render(context, this.width, this.height);
    }

}
