package live.ticticboooom.mods.mcguilib.components;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mcguilib.api.base.IGuiRenderable;
import live.ticticboooom.mods.mcguilib.api.theme.ITextTheme;
import live.ticticboooom.mods.mcguilib.api.theme.button.ITextActionButtonTheme;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;

import java.util.function.Supplier;

public class GuiTextElement implements IGuiRenderable {

    private final int x;
    private final int y;
    private final Supplier<ITextComponent> text;
    private final ITextTheme theme;

    public GuiTextElement(int x, int y, Supplier<ITextComponent> text, ITextTheme theme) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.theme = theme;
    }

    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY) {
        ms.push();
        ms.scale(theme.getScale(), theme.getScale(), 1);
        ms.translate(x / theme.getScale(), y / theme.getScale(), 0);
        Minecraft.getInstance().fontRenderer.drawText(ms, text.get(), 0, 0, theme.getColor());
        ms.pop();
    }
}
