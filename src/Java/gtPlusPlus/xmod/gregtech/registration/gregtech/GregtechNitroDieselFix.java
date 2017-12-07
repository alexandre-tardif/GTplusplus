package gtPlusPlus.xmod.gregtech.registration.gregtech;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import gregtech.GT_Mod;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TextureSet;
import gregtech.api.objects.MaterialStack;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gtPlusPlus.core.lib.CORE;
import gtPlusPlus.core.util.Utils;
import gtPlusPlus.core.util.reflect.ReflectionUtils;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class GregtechNitroDieselFix {

	@SuppressWarnings("unchecked")
	public static void run(){
		if (CORE.configSwitches.enableNitroFix){

			if (GT_Mod.VERSION == 509){
				Utils.LOG_INFO("[Nitro] Found GT 5.09.");
				Class<GT_Mod> clazz;
				try {
					clazz = (Class<GT_Mod>) Class.forName("gregtech.GT_Mod");
					Field mSubversion = ReflectionUtils.getField(clazz, "SUBVERSION");
					Utils.LOG_INFO("[Nitro] Reflected into GT_Mod.class");
					if (mSubversion != null){
						Utils.LOG_INFO("[Nitro] Sub Version field is not null.");
						int mSub = 0;
						mSub = mSubversion.getInt(clazz);
						if (mSub != 0){
							Utils.LOG_INFO("[Nitro] Sub Version is greater than 0.");
							if (mSub >= 30){
								Utils.LOG_INFO("[Nitro] Sub version is at least 30.");								
								Class mb = Class.forName("gregtech.api.enums.MaterialBuilder");
								Object df = mb.getConstructor(int.class, TextureSet.class, String.class).newInstance(975, TextureSet.SET_FLUID, "Nitro-Diesel [Old]");
								if (mb.isInstance(df)){
									
									Utils.LOG_INFO("[Nitro] Created new instance of Material builder, for Nitro fix.");
									
									//Get Methods
									Method addFluid = mb.getMethod("addFluid");
									Method addCell = mb.getMethod("addCell");									
									Method setColour = mb.getMethod("setColour", Dyes.class);
									Method setFuelPower = mb.getMethod("setFuelPower", int.class);
									Method setMaterials = mb.getMethod("setMaterialList", List.class);
									Method setTemp = mb.getMethod("setLiquidTemperature", int.class);
									Method setRGB = mb.getMethod("setRGB", int.class, int.class, int.class);							
									Method construct = mb.getMethod("constructMaterial");
									Utils.LOG_INFO("[Nitro] Got internal methods for setting fields.");
									
									//Invoke the methods
									addFluid.invoke(df);
									addCell.invoke(df);									
									setColour.invoke(df, Dyes.dyeLime);
									setFuelPower.invoke(df, 512000);
									setMaterials.invoke(df, Arrays.asList(new MaterialStack(Materials.Glyceryl, 1), new MaterialStack(Materials.Fuel, 4)));
									setTemp.invoke(df, 295);
									setRGB.invoke(df, 200, 255, 0);									
									construct.invoke(df);
									Utils.LOG_INFO("[Nitro] Invoked 8 method calls successfully.");	
									
									GT_Mod.gregtechproxy.addFluid("NitroFuel_Old", "Nitro Diesel [Old]", ((Materials) df), 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, ((Materials) df), 1L), ItemList.Cell_Empty.get(1L, new Object[0]), 1000);
									Utils.LOG_INFO("[Nitro] Added a fluid.");
									
									
									/**
									 * Do Recipe Stuff
									 */
	
									//Set up some Variables
									final Collection<GT_Recipe> xSingle = GT_Recipe.GT_Recipe_Map.sChemicalRecipes.mRecipeList;
									final Collection<GT_Recipe> xMulti = GT_Recipe.GT_Recipe_Map.sMultiblockChemicalRecipes.mRecipeList;
									final FluidStack mNitroStack = Materials.NitroFuel.getFluid(1000);
									GT_Recipe toRemoveSingle[] = new GT_Recipe[99];
									GT_Recipe toRemoveMulti[] = new GT_Recipe[99];									
									int mIndexSingle = 0;
									int mIndexMulti = 0;
									
									//Iterate Single Block recipes for Nitro production.
									for (GT_Recipe rnd : xSingle){
										for (FluidStack mOutputFluid : rnd.mFluidOutputs){
											if (mOutputFluid.isFluidEqual(mNitroStack)){
												toRemoveSingle[mIndexSingle++] = rnd;
											}
										}										
									}									
									Utils.LOG_INFO("[Nitro] Found "+mIndexSingle+" single block Chemical Reactor recipes to remove.");
									
									//Iterate Multi Block recipes for Nitro production.
									for (GT_Recipe rnd : xMulti){
										for (FluidStack mOutputFluid : rnd.mFluidOutputs){
											if (mOutputFluid.isFluidEqual(mNitroStack)){
												toRemoveMulti[mIndexMulti++] = rnd;
											}
										}										
									}
									Utils.LOG_INFO("[Nitro] Found "+mIndexMulti+" multi block Chemical Reactor recipes to remove.");
									
									//Remove Single Block recipes found.
									int mRemovedSingle = 0;
									int mRemovedMulti = 0;
									for (GT_Recipe single : toRemoveSingle){
										if (GT_Recipe.GT_Recipe_Map.sChemicalRecipes.mRecipeList.remove(single)){
											mRemovedSingle++;
										}
									}									
									Utils.LOG_INFO("[Nitro] Removed "+mRemovedSingle+" single block Chemical Reactor recipes.");
									
									//Remove Multi Block recipes found.
									for (GT_Recipe multi : toRemoveMulti){
										if (GT_Recipe.GT_Recipe_Map.sMultiblockChemicalRecipes.mRecipeList.remove(multi)){
											mRemovedMulti++;
										}
									}									
									Utils.LOG_INFO("[Nitro] Removed "+mRemovedMulti+" multi block Chemical Reactor recipes.");
									
									//Build a New Recipe set
									Materials mFuels[] = {Materials.LightFuel, Materials.Fuel, Materials.Diesel};									
									for (Materials fuel : mFuels){
										boolean didAdd[] = new boolean[3];
										Utils.LOG_INFO("[Nitro] Getting ready to add back in the old nitro-diesel recipe, using "+fuel.mDefaultLocalName+" as the fuel input.");
										didAdd[0] = GT_Values.RA.addMixerRecipe(fuel.getCells(4), Materials.Glycerol.getCells(1), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, ((Materials) df).getCells(5), 20, 30);
										didAdd[1] = GT_Values.RA.addMixerRecipe(fuel.getCells(4), GT_Values.NI, GT_Values.NI, GT_Values.NI, Materials.Glycerol.getFluid(1000L),((Materials) df).getFluid(5000L), ItemList.Cell_Empty.get(4L), 20, 30);
										didAdd[2] = GT_Values.RA.addMixerRecipe(Materials.Glycerol.getCells(1), GT_Values.NI,GT_Values.NI,GT_Values.NI, fuel.getFluid(4000L),((Materials) df).getFluid(5000L), ItemList.Cell_Empty.get(1L), 20, 30);
										Utils.LOG_INFO("[Nitro] Did the recipe add? 1: "+didAdd[0]+" |  2: "+didAdd[1]+" |  3: "+didAdd[2]);
									
									}								
									Utils.LOG_INFO("[Nitro] Getting ready to add back in the old glycerol recipe!");
							        GT_Values.RA.addChemicalRecipe(Materials.Nitrogen.getCells(1), Materials.Carbon.getDust(1), Materials.Water.getFluid(2000L), Materials.Glycerol.getFluid(3000L), ItemList.Cell_Empty.get(1), 3000, 30);
									Utils.LOG_INFO("[Nitro] Added recipes.");
									
									
									
									
									
									
								}
							}
						}
					}
				}
				catch (ClassNotFoundException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
					
				}				
			}
		}
	}
}