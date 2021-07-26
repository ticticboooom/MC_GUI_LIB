package live.ticticboooom.mods.mcguilib.components;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mcguilib.api.base.IGuiRenderable;
import live.ticticboooom.mods.mcguilib.api.theme.IImageTheme;
import live.ticticboooom.mods.mcguilib.util.TextureSizeUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;

public class GuiImageElement implements IGuiRenderable {

    private final int x;
    private final int y;
    private IImageTheme theme;

    public GuiImageElement(int x, int y, IImageTheme theme) {
        this.x = x;
        this.y = y;
        this.theme = theme;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY) {
        int w = TextureSizeUtil.getWidth(theme.getTexture());
        int h = TextureSizeUtil.getHeight(theme.getTexture());

        Minecraft.getInstance().getTextureManager().bindTexture(theme.getTexture());
        AbstractGui.blit(matrixStack, x, y, w, h, 0,0, w, h, w, h);
    }
}
