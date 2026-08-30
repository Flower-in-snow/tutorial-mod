package com.example.tutorialmod;

import com.example.tutorialmod.screen.ModScreenHandlers;
import com.example.tutorialmod.screen.PolishingMachineScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.POLISHING_MACHINE_SCREEN_HANDLER, PolishingMachineScreen::new);
        //第二个参数的来源要查看register类，发现里面有个接口，再点进接口，发现是单方法接口 → 又是函数式接口 → lambda 或 ::new
    }
}
