package de.dafuqs.spectralmemes;

import net.fabricmc.api.*;
import net.minecraft.util.*;

public class SpectralMemes implements ModInitializer {
	
	public static final String MOD_ID = "spectral_memes";
	
	@Override
	public void onInitialize() {
		SpectralMemesSoundEvents.register();
		SpectralMemesItems.register();
	}
	
	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
	
}
