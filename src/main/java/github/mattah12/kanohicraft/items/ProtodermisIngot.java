package github.mattah12.kanohicraft.items;

import github.mattah12.kanohicraft.KanohiCraft;
import net.minecraft.item.Item;

public class ProtodermisIngot extends Item {

    public ProtodermisIngot() {
        super(new Item.Properties()
                .maxStackSize(64)
                .group(KanohiCraft.setup.itemGroup));
        setRegistryName("protoingot");

    }
}
