package net.joseph13user.tutorial.data.client;

import net.joseph13user.tutorial.TutorialMod;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.crafting.ConditionalAdvancement;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipesProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ResourceLocation ID = new ResourceLocation(TutorialMod.MOD_ID, "conditional");
//        ConditionalRecipe.builder()
//                .addCondition(
//                        and(
//                                modLoaded("minecraft"),
//                                itemExists("minecraft", "dirt")
//                        )
//                )
//                .addRecipe(
//                        ShapedRecipeBuilder.shaped(Blocks.DIAMOND_BLOCK, 64)
//                                .pattern("XXX")
//                                .pattern("XXX")
//                                .pattern("XXX")
//                                .define('X', Blocks.DIRT)
//                                .group("")
//                                .unlockedBy("has_dirt", has(Blocks.DIRT)) // DUMMY: Necessary, but not used when a custom advancement is provided through setAdvancement
//                                ::save
//                ).build(consumer, ID);

        ConditionalRecipe.builder()
                .addCondition(
                        and(
                                modLoaded("minecraft"),
                                itemExists("minecraft", "dirt")
                        )
                )
                .addRecipe(
                        ShapedRecipeBuilder.shaped(Blocks.DIAMOND_BLOCK, 64)
                                .pattern("XXX")
                                .pattern("XXX")
                                .pattern("XXX")
                                .define('X', Blocks.DIRT)
                                .group("")
                                .unlockedBy("has_dirt", has(Blocks.DIRT)) // DUMMY: Necessary, but not used when a custom advancement is provided through setAdvancement
                                ::save
                )
                .setAdvancement(ID,
                        ConditionalAdvancement.builder()
                                .addCondition(
                                        and(
                                                modLoaded("minecraft"),
                                                itemExists("minecraft", "dirt")
                                        )
                                )
                                .addAdvancement(
                                        Advancement.Builder.advancement()
                                                .parent(new ResourceLocation("minecraft", "root"))
                                                .display(Blocks.DIAMOND_BLOCK,
                                                        new StringTextComponent("Dirt2Diamonds"),
                                                        new StringTextComponent("The BEST crafting recipe in the game!"),
                                                        null, FrameType.TASK, false, false, false
                                                )
                                                .rewards(AdvancementRewards.Builder.recipe(ID))
                                                .addCriterion("has_dirt", has(Blocks.DIRT))
                                )
                )
                .build(consumer, ID);

//        ConditionalRecipe.builder()
//                .addCondition(
//                        not(
//                                and(
//                                        not(modLoaded("minecraft")),
//                                        itemExists("minecraft", "dirt"),
//                                        FALSE()
//                                )
//                        )
//                )
//                .addRecipe(
//                        ShapedRecipeBuilder.shaped(Blocks.DIAMOND_BLOCK, 64)
//                                .pattern("XXX")
//                                .pattern("XXX")
//                                .pattern("XXX")
//                                .define('X', Blocks.DIRT)
//                                .group("")
//                                .unlockedBy("has_dirt", has(Blocks.DIRT))
//                                ::save
//                )
//                .generateAdvancement()
//                .build(consumer, new ResourceLocation(TutorialMod.MOD_ID, "conditional2"));
    }

}
