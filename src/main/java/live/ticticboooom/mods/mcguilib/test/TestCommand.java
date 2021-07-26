package live.ticticboooom.mods.mcguilib.test;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.command.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TestCommand {
    @SubscribeEvent
    public static void on(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("mcguilib").then(Commands.literal("test_gui").executes(x -> {
            Minecraft.getInstance().displayGuiScreen(new TestScreen());
            return 0;
        })));
    }
}
