package me.mqrshe.sponger;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Sponger implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("sponger");

	@Override
	public void onInitialize() {
		//initialize



		LOGGER.info("Sponger Loaded");
		System.out.println("Simple armor hud loaded!");
	}

}

