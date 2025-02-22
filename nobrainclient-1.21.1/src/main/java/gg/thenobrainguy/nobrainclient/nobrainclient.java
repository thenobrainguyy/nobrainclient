package gg.thenobrainguy.nobrainclient;

import gg.thenobrainguy.nobrainclient.keybinds.KeybindHandler;


import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class nobrainclient implements ModInitializer {
	public static final String MOD_ID = "nobrainclient";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Initializing NoBrainClient");

		//titel
		String WINDOW_TITLE = "NoBrainClient* 1.21.1";
		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			if (client.getWindow() != null) {
				client.getWindow().setTitle(WINDOW_TITLE);
			}
		});

		//initialize keys
		KeybindHandler.registerKeybinds();

		//initialize dc-rpc
		//initializeDiscordRPC();
	}



}