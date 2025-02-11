package com.thenobrainguy.nobrainclient;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class NoBrainClient implements ModInitializer {
	public static final String MOD_ID = "nobrainclient";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final Identifier PACKET_LOGGER = Identifier.of("nobrainsserver", "packet_logger");


	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Log block breaking events
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
			String message = "Packet triggered: Block broken by ";
			LOGGER.info(message);
			player.sendMessage(Text.of(message), false);
		});
	}
}