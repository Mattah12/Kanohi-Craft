package github.mattah12.kanohicraft.items;

import github.mattah12.kanohicraft.KanohiCraft;
import net.minecraft.item.Item;

public class MaskKaukau extends Item {

    public MaskKaukau() {
        super(new Properties()
                .maxStackSize(64)
                .group(KanohiCraft.setup.itemGroup));
        setRegistryName("kanohicraft:maskkaukau");

    }
}
