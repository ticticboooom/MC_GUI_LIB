package live.ticticboooom.mods.mcguilib.theme;

import live.ticticboooom.mods.mcguilib.MCG;
import live.ticticboooom.mods.mcguilib.api.theme.IImageTheme;
import live.ticticboooom.mods.mcguilib.api.theme.ITextTheme;
import net.minecraft.util.ResourceLocation;

public class DefaultTextTheme implements ITextTheme {

    private final float scale;

    public DefaultTextTheme(float scale) {

        this.scale = scale;
    }

    @Override
    public float getScale() {
        return scale;
    }

    @Override
    public int getColor() {
        return 0x404040;
    }
}
