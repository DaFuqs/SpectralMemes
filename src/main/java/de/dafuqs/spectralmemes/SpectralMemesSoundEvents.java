package de.dafuqs.spectralmemes;

import net.minecraft.registry.*;
import net.minecraft.sound.*;
import net.minecraft.util.*;

public class SpectralMemesSoundEvents {
	
	public static final SoundEvent ENTITY_KINDLING_LOVE = register("entity.kindling.love");
	
	private static SoundEvent register(String id) {
		Identifier identifier = SpectralMemes.id(id);
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
	}
	
	public static void register() {

	}
	
}
