package net.joseph13user.tutorial.setup;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)) );

    static void register() {}
}
