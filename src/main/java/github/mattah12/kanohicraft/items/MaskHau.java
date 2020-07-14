package github.mattah12.kanohicraft.items;

import github.mattah12.kanohicraft.KanohiCraft;
import net.minecraft.item.Item;

public class MaskHau extends Item {

    public MaskHau() {
        super(new Item.Properties()
                .maxStackSize(64)
                .group(KanohiCraft.setup.itemGroup));
        setRegistryName("kanohicraft:maskhau");

    }
}
