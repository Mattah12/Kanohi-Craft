package github.mattah12.kanohicraft;

import github.mattah12.kanohicraft.blocks.*;
import github.mattah12.kanohicraft.items.ProtodermisIngot;
import github.mattah12.kanohicraft.setup.ClientProxy;
import github.mattah12.kanohicraft.setup.IProxy;
import github.mattah12.kanohicraft.setup.ModSetup;
import github.mattah12.kanohicraft.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Mattah12
 */

@Mod(KanohiCraft.MODID)
public class KanohiCraft {

    public static final String MODID ="kanohicraft";

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public KanohiCraft(){
        //Register the com.github.mattah12.kanohicraft.setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event){
        setup.init();
        proxy.init();
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new ProtodermisBlock()) ;
            event.getRegistry().register(new ProtodermisOre());
            event.getRegistry().register(new ProtodermisEnergizer());

        }
        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
            event.getRegistry().register(new BlockItem(ModBlocks.PROTODERMISBLOCK, properties).setRegistryName("protoblock")) ;
            event.getRegistry().register(new BlockItem(ModBlocks.PROTODERMISORE, properties).setRegistryName("protoore"));
            event.getRegistry().register(new BlockItem(ModBlocks.PROTODERMISENERGIZER, properties).setRegistryName("protoenerg"));
            event.getRegistry().register(new ProtodermisIngot());
        }
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event){
            event.getRegistry().register(TileEntityType.Builder.create(ProtodermisEnergizerTile::new, ModBlocks.PROTODERMISENERGIZER).build(null).setRegistryName("protoenerg"));
        }

        public static void onContainerRegistry (final RegistryEvent.Register<ContainerType<?>> event){
            event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new ProtodermisEnergizerContainer(windowId, KanohiCraft.proxy.getClientWorld(),pos,inv, KanohiCraft.proxy.getClientPlayer());
            }).setRegistryName("protoenerg"));

        }
    }
}
