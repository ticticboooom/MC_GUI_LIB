package live.ticticboooom.mods.mcguilib.test;

import live.ticticboooom.mods.mcguilib.components.GuiImageElement;
import live.ticticboooom.mods.mcguilib.components.GuiTextActionButton;
import live.ticticboooom.mods.mcguilib.components.GuiTextElement;
import live.ticticboooom.mods.mcguilib.screen.AbstractModularScreen;
import live.ticticboooom.mods.mcguilib.theme.DefaultImageTheme;
import live.ticticboooom.mods.mcguilib.theme.DefaultTextActionButtonTheme;
import live.ticticboooom.mods.mcguilib.theme.DefaultTextTheme;
import net.minecraft.util.text.StringTextComponent;

public class TestScreen extends AbstractModularScreen {

    private int counter = 0;

    @Override
    protected void setup() {
        super.setup();
        int y = height / 2 - 100;
        int x = width / 2 - 100;
        components.add(new GuiImageElement(x, y, new DefaultImageTheme()));
        components.add(new GuiTextActionButton(x + 10, y + 100, () -> new StringTextComponent("Test Words"), new DefaultTextActionButtonTheme(), () -> counter++));
        components.add(new GuiTextElement(x + 10, y + 10, () -> new StringTextComponent("Count: " + counter), new DefaultTextTheme(1.3f)));
    }
}
