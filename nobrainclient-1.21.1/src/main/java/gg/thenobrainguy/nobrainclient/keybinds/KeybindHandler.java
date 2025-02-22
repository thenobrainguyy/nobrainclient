package gg.thenobrainguy.nobrainclient.keybinds;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import net.minecraft.text.Text;

public class KeybindHandler {
    public static KeyBinding openModulesKey;
    public static KeyBinding testKey;

    public static void registerKeybinds() {
        openModulesKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nobrainclient.open_modules",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.nobrainclient"
        ));

        testKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nobrainclient.testKey",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_MOUSE_BUTTON_MIDDLE,
                "category.nobrainclient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openModulesKey.wasPressed()) {
                // Action to perform when the key is pressed
                // Replace this with the actual code to open your modules menu
                client.player.sendMessage(Text.literal("Open Modules key pressed!"), false);
            }

            while (testKey.wasPressed()) {
                // Action to perform when the key is pressed
                // Replace this with the actual code to open your modules menu
                client.player.sendMessage(Text.literal("test key pressed!"), false);
            }

        });


    }
}