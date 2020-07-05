package github.mattah12.kanohicraft.setup;

import github.mattah12.kanohicraft.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("kanohicraft") {
        @Override
        public ItemStack createIcon() {
            //return new ItemStack(ModBlocks.PROTODERMISBLOCK);
            return new ItemStack(ModBlocks.PROTODERMISORE);
        }
    };

    public void init(){

    }
}
