package com.example.tutorialmod.util;

import com.example.tutorialmod.item.ModItems;
import com.example.tutorialmod.villager.ModCustomVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.village.TradeOffers;

public class ModCustomTrades {
    public static void registerModCustomTrades() {
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
//                factories.add(new TradeOffers.BuyItemFactory(ModItems.PROSPECTOR, 32 ,1, 2));//主体是村民购买
//                factories.add(new TradeOffers.SellItemFactory(ModItems.PROSPECTOR, 64, 1, 8, 2));//主体是村民出售
//        });
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2, factories -> {
//                factories.add(new TradeOffers.ProcessItemFactory(ModItems.PROSPECTOR, 1, 64, ModItems.BINGONIMBUS_2000, 1, 1, 16, 0.5F));
//        });
        TradeOfferHelper.registerVillagerOffers(ModCustomVillagers.MAGICIAN, 1, factories -> {
            factories.add(new TradeOffers.BuyItemFactory(ModItems.PROSPECTOR, 1,1, 2, 32));//主体是村民购买
            factories.add(new TradeOffers.SellItemFactory(ModItems.PROSPECTOR, 64, 1, 8, 2));//主体是村民出售
        });
        TradeOfferHelper.registerVillagerOffers(ModCustomVillagers.MAGICIAN, 2, factories -> {
            factories.add(new TradeOffers.ProcessItemFactory(ModItems.PROSPECTOR, 1, 64, ModItems.BINGONIMBUS_2000, 1, 1, 16, 0.5F));
        });
    }
}
