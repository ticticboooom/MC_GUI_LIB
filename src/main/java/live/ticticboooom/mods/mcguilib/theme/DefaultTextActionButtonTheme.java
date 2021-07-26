package live.ticticboooom.mods.mcguilib.theme;

import live.ticticboooom.mods.mcguilib.MCG;
import live.ticticboooom.mods.mcguilib.api.theme.button.ITextActionButtonTheme;
import net.minecraft.util.ResourceLocation;

public class DefaultTextActionButtonTheme implements ITextActionButtonTheme {
    private static final ResourceLocation LEFT = new ResourceLocation(MCG.ID, "textures/gui/parts/button/button_left.png");
    private static final ResourceLocation RIGHT = new ResourceLocation(MCG.ID, "textures/gui/parts/button/button_right.png");
    private static final ResourceLocation REPEAT = new ResourceLocation(MCG.ID, "textures/gui/parts/button/button_repeat.png");

    @Override
    public ResourceLocation getLeft() {
        return LEFT;
    }

    @Override
    public ResourceLocation getRight() {
        return RIGHT;
    }

    @Override
    public ResourceLocation getRepeat() {
        return REPEAT;
    }
}
