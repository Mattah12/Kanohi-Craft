package github.mattah12.kanohicraft.setup;

import github.mattah12.kanohicraft.blocks.ModBlocks;
import github.mattah12.kanohicraft.blocks.ProtodermisEnergizerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

    @Override
    public void init() {
        ScreenManager.registerFactory(ModBlocks.PROTODERMISENERGIZER_CONTAINER, ProtodermisEnergizerScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
