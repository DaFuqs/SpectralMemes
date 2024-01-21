package de.dafuqs.spectralmemes;

import net.fabricmc.api.*;

public class SpectralMemes implements ModInitializer {
	/**
	 * Runs the mod initializer.
	 */
	@Override
	public void onInitialize() {
		SpectralMemesItems.register();
	}
}
