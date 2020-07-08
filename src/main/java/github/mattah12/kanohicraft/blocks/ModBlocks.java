package github.mattah12.kanohicraft.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("kanohicraft:protoblock")
    public static ProtodermisBlock PROTODERMISBLOCK;

    @ObjectHolder("kanohicraft:protoore")
    public static ProtodermisOre PROTODERMISORE;

    @ObjectHolder("kanohicraft:protoenerg")
    public static ProtodermisEnergizer PROTODERMISENERGIZER;
    @ObjectHolder("kanohicraft:protoenerg")
    public static TileEntityType<ProtodermisEnergizerTile> PROTODERMISENERGIZER_TILE;

}
