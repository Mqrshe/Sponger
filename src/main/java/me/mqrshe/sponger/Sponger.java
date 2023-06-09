package me.mqrshe.sponger;

import me.mqrshe.sponger.handlers.RenderEventHandler;
import me.mqrshe.sponger.managers.HUDManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Sponger implements ModInitializer {

	public static HUDManager hudManager;
	public static Sponger IMPL = new Sponger();
	public static final Logger LOGGER = LoggerFactory.getLogger("Sponger");


	@Override
	public void onInitialize() {
		LOGGER.info("Sponger Loaded");
		hudManager = new HUDManager();
		HudRenderCallback.EVENT.register(new RenderEventHandler());
		FlawlessFrames.onClientInitialization();

	}


}
