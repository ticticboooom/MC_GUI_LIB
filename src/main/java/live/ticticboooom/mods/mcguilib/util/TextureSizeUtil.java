package live.ticticboooom.mods.mcguilib.util;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TextureSizeUtil {
    public static int getWidth(ResourceLocation loc) {
        Minecraft.getInstance().getTextureManager().bindTexture(loc);
        return GlStateManager.getTexLevelParameter(GL11.GL_TEXTURE_2D, 0, GL11.GL_TEXTURE_WIDTH);
    }

    public static int getHeight(ResourceLocation loc) {
        Minecraft.getInstance().getTextureManager().bindTexture(loc);
        return GlStateManager.getTexLevelParameter(GL11.GL_TEXTURE_2D, 0, GL11.GL_TEXTURE_HEIGHT);
    }
}
