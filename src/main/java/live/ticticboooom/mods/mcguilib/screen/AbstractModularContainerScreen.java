package live.ticticboooom.mods.mcguilib.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mcguilib.api.base.IGuiInteractable;
import live.ticticboooom.mods.mcguilib.api.base.IGuiRenderable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModularContainerScreen<T extends Container> extends ContainerScreen<T> {

    protected List<IGuiRenderable> components = new ArrayList<>();
    protected boolean hasSetup = false;


    public AbstractModularContainerScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }


    protected void setup() {
        components.clear();
    }

    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
        if (!hasSetup) {
            setup();
        }
        for (IGuiRenderable component : components) {
            component.render(ms, mouseX, mouseY);
        }
        super.render(ms, mouseX, mouseY, partialTicks);
    }


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (IGuiRenderable component : components) {
            if (component instanceof IGuiInteractable){
                ((IGuiInteractable) component).onClick((int)mouseX, (int)mouseY);
            }
        }
        return true;
    }

    @Override
    public void resize(Minecraft minecraft, int width, int height) {
        super.resize(minecraft, width, height);
        this.hasSetup = false;
        this.components.clear();
    }
}
