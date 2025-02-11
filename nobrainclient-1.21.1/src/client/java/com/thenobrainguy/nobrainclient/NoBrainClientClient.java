package com.thenobrainguy.nobrainclient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class NoBrainClientClient implements ClientModInitializer {

	String GAME_TITLE = "NoBrainClient* 1.21.1   \uD83E\uDD2F ";

	@Override
	public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        System.out.println("NoBrainClient is starting");

        //set titel
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (client.getWindow() != null) {
                client.getWindow().setTitle(GAME_TITLE);
            }
        });

        //set titel
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.getWindow() != null) {
                client.getWindow().setTitle(GAME_TITLE);
            }
        });


        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                String uuid = client.player.getUuidAsString(); // Get UUID before calling checkUuid()
                DatabaseManager.checkUuid(uuid);
            }
        });


    }
}