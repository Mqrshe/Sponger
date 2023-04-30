package me.mqrshe.sponger;

import net.fabricmc.loader.api.FabricLoader;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;

public class FlawlessFrames {
    private static final Set<Object> ACTIVE = ConcurrentHashMap.newKeySet();

    static void onClientInitialization() {
        Function<String, Consumer<Boolean>> provider = name -> {
            Object token = new Object();
            return active -> {
                if (active) {
                    ACTIVE.add(token);
                } else {
                    ACTIVE.remove(token);
                }
            };
        };
        //noinspection unchecked – Since we can't parameterize Consumer.class, it's unchecked to pass a Consumer<Boolean> as a raw Consumer. The API guarantees we only get what we expect though.
        FabricLoader.getInstance()
                .getEntrypoints("frex_flawless_frames", Consumer.class)
                .forEach(api -> api.accept(provider));
    }

    /**
     Returns whether one or more mods have requested Flawless Frames to be active, and therefore frames should not be skipped.
     */
    public static boolean isActive() {
        return !ACTIVE.isEmpty();
    }
}