package live.ticticboooom.mods.mcguilib.theme;

import live.ticticboooom.mods.mcguilib.MCG;
import live.ticticboooom.mods.mcguilib.api.theme.IImageTheme;
import live.ticticboooom.mods.mcguilib.api.theme.button.ITextActionButtonTheme;
import net.minecraft.util.ResourceLocation;

public class DefaultImageTheme implements IImageTheme {
    private static final ResourceLocation BASE = new ResourceLocation(MCG.ID, "textures/gui/parts/button/base_gui.png");


    @Override
    public ResourceLocation getTexture() {
        return BASE;
    }
}
