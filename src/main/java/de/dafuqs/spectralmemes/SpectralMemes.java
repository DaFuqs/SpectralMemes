package de.dafuqs.spectralmemes;

import de.dafuqs.spectrum.entity.entity.*;
import de.dafuqs.spectrum.registries.*;
import net.fabricmc.api.*;
import net.fabricmc.fabric.api.event.player.*;
import net.minecraft.advancement.criterion.*;
import net.minecraft.item.*;
import net.minecraft.server.network.*;
import net.minecraft.util.*;

public class SpectralMemes implements ModInitializer {
	
	public static final String MOD_ID = "spectral_memes";
	
	@Override
	public void onInitialize() {
		SpectralMemesSoundEvents.register();
		SpectralMemesItems.register();
		
		UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (hitResult == null) {
				return ActionResult.PASS;
			}
			if(player.shouldCancelInteraction()) {
				return ActionResult.PASS;
			}
			
			if(entity instanceof KindlingEntity kindlingEntity) {
				if(kindlingEntity.isBaby()) {
					return ActionResult.PASS;
				}
				if(kindlingEntity.getAngerTime() > 0) {
					return ActionResult.PASS;
				}
				
				// 🍆 / 🍑 = 💘
				ItemStack handStack = player.getStackInHand(hand);
				if (!handStack.isIn(SpectralMemesItemTags.PEACHES) && !handStack.isIn(SpectralMemesItemTags.EGGPLANTS)) {
					return ActionResult.PASS;
				}
				
				if (!world.isClient()) {
					handStack.decrement(1);
					
					kindlingEntity.setTame(true);
					if (kindlingEntity.getOwnerUuid() == null && player instanceof ServerPlayerEntity serverPlayerEntity) {
						kindlingEntity.setOwnerUuid(player.getUuid());
						Criteria.TAME_ANIMAL.trigger(serverPlayerEntity, kindlingEntity);
					}
					
					kindlingEntity.lovePlayer(player);
					
					world.sendEntityStatus(kindlingEntity, (byte) 7); // heart particles
					kindlingEntity.playSoundIfNotSilent(SpectralMemesSoundEvents.ENTITY_KINDLING_LOVE);
					
					kindlingEntity.clipAndDrop();
				}
				
				return ActionResult.success(world.isClient());
			}
			
			return ActionResult.PASS;
		});
	}
	
	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
	
}
