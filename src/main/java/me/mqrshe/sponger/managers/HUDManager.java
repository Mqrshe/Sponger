package me.mqrshe.sponger.managers;

import me.mqrshe.sponger.hud.HUDElement;
import me.mqrshe.sponger.hud.impl.ArmourHUD;
import me.mqrshe.sponger.hud.impl.CoordHUD;
import me.mqrshe.sponger.hud.impl.FpsHUD;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;

public class HUDManager {

    ArrayList<HUDElement> hudElements;

    public HUDManager(){
        (this.hudElements = new ArrayList<HUDElement>()).clear();
        addElement(new ArmourHUD());
        addElement(new FpsHUD());
        addElement(new CoordHUD());

    }

    public void addElement(HUDElement hudElement){
        this.hudElements.add(hudElement);
    }

    public ArrayList getHUDList(){
        return this.hudElements;
    }

    public void doRender(){
        if (MinecraftClient.getInstance().world == null) return;
        for (HUDElement h : hudElements){
            h.render();
        }
    }

}
