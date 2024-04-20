package de.dafuqs.spectralmemes;

import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.*;
import net.minecraft.util.*;

public class SpectralMemesItemTags {
	
	public static final TagKey<Item> EGGPLANTS = common("eggplants");
	public static final TagKey<Item> PEACHES = common("peaches");
	
	private static TagKey<Item> of(String id) {
		return TagKey.of(RegistryKeys.ITEM, SpectralMemes.id(id));
	}
	
	private static TagKey<Item> common(String id) {
		return TagKey.of(RegistryKeys.ITEM, new Identifier("c", id));
	}
	
}
