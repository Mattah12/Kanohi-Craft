package github.mattah12.kanohicraft.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ProtodermisOre extends OreBlock {

    public ProtodermisOre(){
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(2.0f)
                .lightValue(10)
        );
        setRegistryName("protoore");
    }
}
