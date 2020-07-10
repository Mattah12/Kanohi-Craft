package github.mattah12.kanohicraft.blocks;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static github.mattah12.kanohicraft.blocks.ModBlocks.PROTODERMISENERGIZER_TILE;

public class ProtodermisEnergizerTile extends TileEntity implements ITickableTileEntity {

    private ItemStackHandler handler;

    public ProtodermisEnergizerTile() {
        super(PROTODERMISENERGIZER_TILE);
    }

    @Override
    public void tick(){
    }

    @Override
    public void read(CompoundNBT tag){
        CompoundNBT invTag = tag.getCompound("inv");
        getHandler().deserializeNBT(invTag);
        super.read(tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        CompoundNBT compund = getHandler().serializeNBT();
        tag.put("inv", compund);
        return super.write(tag);
    }

    private ItemStackHandler getHandler(){
        if(handler == null){
            handler = new ItemStackHandler(1){
                @Override
                public boolean isItemValid(int slot, @Nonnull ItemStack stack){
                    return stack.getItem() == Items.COAL;
                }
                @Nonnull
                @Override
                public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate){
                    if (stack.getItem() != Items.COAL){
                        return stack;
                    }
                    return super.insertItem(slot, stack, simulate);
                }
            };
        }
        return handler;
    }


    @Nonnull
    @Override
    public <T>LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return LazyOptional.of(() -> (T) getHandler());
        }
        return super.getCapability(cap, side);
    }
}
