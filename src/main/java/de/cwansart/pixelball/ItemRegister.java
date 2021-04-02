package de.cwansart.pixelball;

import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import de.cwansart.pixelball.pokeballs.DreamBallDisc;
import de.cwansart.pixelball.pokeballs.DreamBallLid;
import de.cwansart.pixelball.pokeballs.GSBallDisc;
import de.cwansart.pixelball.pokeballs.GSBallLid;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@EventBusSubscriber(modid = Main.MODID)
public class ItemRegister {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        List<Item> pokeballs = Arrays.asList(
                new GSBallDisc(EnumPokeballs.GSBall),
                new GSBallLid(EnumPokeballs.GSBall),
                new DreamBallDisc(EnumPokeballs.DreamBall),
                new DreamBallLid(EnumPokeballs.DreamBall)
        );

        IForgeRegistry<Item> registry = event.getRegistry();
        pokeballs.forEach(p -> {
            registry.register(p);
            ModelLoader.setCustomModelResourceLocation(p, 0, new ModelResourceLocation(Objects.requireNonNull(p.getRegistryName()), "inventory"));
        });
    }
}
