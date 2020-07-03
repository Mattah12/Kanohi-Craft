package github.mattah12.kanohicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ProtodermisBlock extends Block {

    public ProtodermisBlock(){
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
                .lightValue(10)
        );
        setRegistryName("protoblock");
    }
}
