package live.ticticboooom.mods.mcguilib.components;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mcguilib.api.AbstractGuiPositionedInteractable;
import live.ticticboooom.mods.mcguilib.api.theme.button.ITextActionButtonTheme;
import live.ticticboooom.mods.mcguilib.util.TextureSizeUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.text.ITextComponent;

import java.util.function.Supplier;

public class GuiTextActionButton extends AbstractGuiPositionedInteractable {

    private final Supplier<ITextComponent> text;
    private final ITextActionButtonTheme theme;
    private Runnable action;

    public GuiTextActionButton(int x, int y, Supplier<ITextComponent> text, ITextActionButtonTheme theme, Runnable action) {
        super(x, y);
        this.text = text;
        this.theme = theme;
        this.action = action;
        width = getFilledWidth();
        height = getFilledHeight();
    }

    @Override
    protected void onClickInBounds(int mouseX, int mouseY) {
        action.run();
    }

    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY) {
        int leftWidth = TextureSizeUtil.getWidth(theme.getLeft());
        int leftHeight = TextureSizeUtil.getHeight(theme.getLeft());

        int rightWidth = TextureSizeUtil.getWidth(theme.getRight());
        int repeatWidth = TextureSizeUtil.getWidth(theme.getRepeat());

        int stringWidth = Minecraft.getInstance().fontRenderer.getStringWidth(text.get().getString());

        int repeatX = (int)Math.ceil(stringWidth / (double)repeatWidth);
        Minecraft.getInstance().getTextureManager().bindTexture(theme.getLeft());
        AbstractGui.blit(ms, x, y, leftWidth, leftHeight,0, 0, leftWidth, leftHeight, leftWidth, leftHeight);
        int xOffset = x + leftWidth;
        Minecraft.getInstance().getTextureManager().bindTexture(theme.getRepeat());
        for (int i = 0; i < repeatX; i++) {
            AbstractGui.blit(ms, xOffset, y, repeatWidth, leftHeight,0, 0, repeatWidth, leftHeight, repeatWidth, leftHeight);
            xOffset += repeatWidth;
        }
        Minecraft.getInstance().getTextureManager().bindTexture(theme.getRight());
        AbstractGui.blit(ms, xOffset, y, rightWidth, leftHeight,0, 0, rightWidth, leftHeight, rightWidth, leftHeight);

        Minecraft.getInstance().fontRenderer.drawText(ms, text.get(), (float) (x + leftWidth + ((repeatWidth * repeatX - stringWidth) / 2.0)), y + 5, 0x404040);
    }

    protected int getFilledWidth() {
        int leftWidth = TextureSizeUtil.getWidth(theme.getLeft());
        int rightWidth = TextureSizeUtil.getWidth(theme.getRight());
        int repeatWidth = TextureSizeUtil.getWidth(theme.getRepeat());

        int stringWidth = Minecraft.getInstance().fontRenderer.getStringWidth(text.get().getString());

        int repeatX = (int)Math.ceil(stringWidth / (double)repeatWidth);
        return  leftWidth + rightWidth + (repeatWidth * repeatX);
    }

    protected int getFilledHeight() {
        return TextureSizeUtil.getWidth(theme.getLeft());
    }
}
