package live.ticticboooom.mods.mcguilib.api.base;

import com.mojang.blaze3d.matrix.MatrixStack;

public interface IGuiRenderable {
    void render(MatrixStack ms, int mouseX, int mouseY);
}
