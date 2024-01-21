package de.dafuqs.spectralmemes;

import de.dafuqs.spectralmemes.items.*;
import de.dafuqs.spectrum.registries.color.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

public class SpectralMemesItems {
	
	public static final Item ROD_OF_SUBMISSION = new RodOfSubmissionItem(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final Item STRATINE_PLUG = new StratinePlugItem(new Item.Settings().maxCount(1));
	
	public static void register(String name, Item item, DyeColor dyeColor) {
		Registry.register(Registries.ITEM, SpectralMemes.id(name), item);
		ItemColors.ITEM_COLORS.registerColorMapping(item, dyeColor);
	}
	
	public static void register() {
		register("rod_of_submission", ROD_OF_SUBMISSION, DyeColor.GRAY);
		register("statine_plug", STRATINE_PLUG, DyeColor.GRAY);
	}
	
}
