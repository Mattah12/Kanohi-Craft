package github.mattah12.kanohicraft.items;

import github.mattah12.kanohicraft.KanohiCraft;
import net.minecraft.item.Item;

public class MaskKakama extends Item {

    public MaskKakama() {
        super(new Properties()
                .maxStackSize(64)
                .group(KanohiCraft.setup.itemGroup));
        setRegistryName("kanohicraft:maskkakama");

    }
}
