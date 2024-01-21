package de.dafuqs.spectralmemes;

import de.dafuqs.spectralmemes.items.*;

public class SpectralMemesItems {
	
	public static final Item ROD_OF_SUBMISSION = new RodOfSubmissionItem(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final Item STRATINE_PLUG = new StratinePlugItem(new Item.Settings().maxCount(1));
	
	public static void register() {
		register("rod_of_submission", ROD_OF_SUBMISSION, DyeColor.GRAY);
		register("statine_plug", STRATINE_PLUG, DyeColor.GRAY);
	}
	
}
