package gtPlusPlus.core.recipe;

import static gtPlusPlus.core.lib.CORE.GTNH;

import cpw.mods.fml.common.Loader;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.core.block.ModBlocks;
import gtPlusPlus.core.item.ModItems;
import gtPlusPlus.core.item.chemistry.AgriculturalChem;
import gtPlusPlus.core.item.crafting.ItemDummyResearch;
import gtPlusPlus.core.item.crafting.ItemDummyResearch.ASSEMBLY_LINE_RESEARCH;
import gtPlusPlus.core.lib.CORE;
import gtPlusPlus.core.lib.LoadedMods;
import gtPlusPlus.core.material.ALLOY;
import gtPlusPlus.core.material.ELEMENT;
import gtPlusPlus.core.material.Material;
import gtPlusPlus.core.recipe.common.CI;
import gtPlusPlus.core.util.minecraft.*;
import gtPlusPlus.core.util.minecraft.gregtech.PollutionUtils;
import gtPlusPlus.core.util.reflect.ReflectionUtils;
import gtPlusPlus.everglades.dimension.Dimension_Everglades;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import gtPlusPlus.xmod.gregtech.common.Meta_GT_Proxy;
import gtPlusPlus.xmod.gregtech.common.covers.CoverManager;
import gtPlusPlus.xmod.gregtech.common.helpers.VolumetricFlaskHelper;
import gtPlusPlus.xmod.gregtech.common.items.MetaCustomCoverItem;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RECIPES_Machines {

	//Outputs
	//static ItemStack RECIPE_BufferCore_ULV = new ItemStack(GregtechEnergyBuffer.itemBufferCore);
	public static ItemStack RECIPE_SteamCondenser;
	public static ItemStack RECIPE_IronBlastFurnace;
	public static ItemStack RECIPE_IronPlatedBricks;
	public static ItemStack RECIPE_Buffer_ULV = GregtechItemList.Energy_Buffer_1by1_ULV.get(1);
	public static ItemStack RECIPE_Buffer_LV = GregtechItemList.Energy_Buffer_1by1_LV.get(1);
	public static ItemStack RECIPE_Buffer_MV = GregtechItemList.Energy_Buffer_1by1_MV.get(1);
	public static ItemStack RECIPE_Buffer_HV = GregtechItemList.Energy_Buffer_1by1_HV.get(1);
	public static ItemStack RECIPE_Buffer_EV = GregtechItemList.Energy_Buffer_1by1_EV.get(1);
	public static ItemStack RECIPE_Buffer_IV = GregtechItemList.Energy_Buffer_1by1_IV.get(1);
	public static ItemStack RECIPE_Buffer_LuV = GregtechItemList.Energy_Buffer_1by1_LuV.get(1);
	public static ItemStack RECIPE_Buffer_ZPM = GregtechItemList.Energy_Buffer_1by1_ZPM.get(1);
	public static ItemStack RECIPE_Buffer_UV = GregtechItemList.Energy_Buffer_1by1_UV.get(1);
	public static ItemStack RECIPE_Buffer_MAX = GregtechItemList.Energy_Buffer_1by1_MAX.get(1);
	//Industrial Centrifuge
	public static ItemStack RECIPE_IndustrialCentrifugeController;
	public static ItemStack RECIPE_IndustrialCentrifugeCasing;
	//Industrial Coke Oven
	public static ItemStack RECIPE_IndustrialCokeOvenController;
	public static ItemStack RECIPE_IndustrialCokeOvenFrame;
	public static ItemStack RECIPE_IndustrialCokeOvenCasingA;
	public static ItemStack RECIPE_IndustrialCokeOvenCasingB;
	//Industrial Electrolyzer
	public static ItemStack RECIPE_IndustrialElectrolyzerController;
	public static ItemStack RECIPE_IndustrialElectrolyzerFrame;
	//Industrial Material Press
	public static ItemStack RECIPE_IndustrialMaterialPressController;
	public static ItemStack RECIPE_IndustrialMaterialPressFrame;
	//Industrial Maceration Stack
	public static ItemStack RECIPE_IndustrialMacerationStackController;
	public static ItemStack RECIPE_IndustrialMacerationStackFrame;
	//Industrial Wire Factory
	public static ItemStack RECIPE_IndustrialWireFactoryController;
	public static ItemStack RECIPE_IndustrialWireFactoryFrame;
	//Industrial Multi Tank
	public static ItemStack RECIPE_IndustrialMultiTankController;
	public static ItemStack RECIPE_IndustrialMultiTankFrame;
	//Industrial Matter Fabricator
	public static ItemStack RECIPE_IndustrialMatterFabController;
	public static ItemStack RECIPE_IndustrialMatterFabFrame;
	public static ItemStack RECIPE_IndustrialMatterFabCoil;
	//Industrial Blast Smelter
	public static ItemStack RECIPE_IndustrialBlastSmelterController;
	public static ItemStack RECIPE_IndustrialBlastSmelterFrame;
	public static ItemStack RECIPE_IndustrialBlastSmelterCoil;
	public static ItemStack RECIPE_IndustrialMegaBlastSmelterController;

	//Industrial Sieve
	public static ItemStack RECIPE_IndustrialSieveController;
	public static ItemStack RECIPE_IndustrialSieveFrame;
	public static ItemStack RECIPE_IndustrialSieveGrate;
	//Industrial Tree Farmer
	public static ItemStack RECIPE_TreeFarmController;
	public static ItemStack RECIPE_TreeFarmFrame;
	//Tesseracts
	public static ItemStack RECIPE_TesseractGenerator;
	public static ItemStack RECIPE_TesseractTerminal;
	//Thermal Boiler
	public static ItemStack RECIPE_ThermalBoilerController;
	public static ItemStack RECIPE_ThermalBoilerCasing;

	//Thorium Reactor
	public static ItemStack RECIPE_LFTRController;
	public static ItemStack RECIPE_LFTROuterCasing;
	public static ItemStack RECIPE_LFTRInnerCasing;

	//Milling
	public static ItemStack RECIPE_ISAMill_Controller;
	public static ItemStack RECIPE_ISAMill_Gearbox;
	public static ItemStack RECIPE_ISAMill_Casing;
	public static ItemStack RECIPE_ISAMill_Hatch;
	public static ItemStack RECIPE_Flotation_Controller;
	public static ItemStack RECIPE_Flotation_Casing;

	//Cyclotron
	public static ItemStack RECIPE_CyclotronController;
	public static ItemStack RECIPE_CyclotronOuterCasing;
	public static ItemStack RECIPE_CyclotronInnerCoil;


	//Buffer Cores
	public static ItemStack RECIPE_BufferCore_ULV = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore1", 1);
	public static ItemStack RECIPE_BufferCore_LV = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore2", 1);
	public static ItemStack RECIPE_BufferCore_MV = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore3", 1);
	public static ItemStack RECIPE_BufferCore_HV = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore4", 1);
	public static ItemStack RECIPE_BufferCore_EV = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore5", 1);
	public static ItemStack RECIPE_BufferCore_IV = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore6", 1);
	public static ItemStack RECIPE_BufferCore_LuV = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore7", 1);
	public static ItemStack RECIPE_BufferCore_ZPM = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore8", 1);
	public static ItemStack RECIPE_BufferCore_UV = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore9", 1);
	public static ItemStack RECIPE_BufferCore_MAX = ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore10", 1);


	//Wire
	public static String wireTier1 = "wireGt08Lead";
	public static String wireTier2 = "wireGt08Tin";
	public static String wireTier3 = "wireGt08Copper";
	public static String wireTier4 = "wireGt08Gold";
	public static String wireTier5 = "wireGt08Aluminium";
	public static String wireTier6 = "wireGt08Tungsten";
	public static String wireTier7 = "wireGt08Naquadah";
	public static String wireTier8 = "wireGt08Osmium";
	public static String wireTier9 = "wireGt08Superconductor";
	public static String wireTier10 = "wireGt16Superconductor";

	//Wire
	public static String cableTier1 = "cableGt04Lead";
	public static String cableTier2 = "cableGt04Tin";
	public static String cableTier3 = "cableGt04Copper";
	public static String cableTier4 = "cableGt04Gold";
	public static String cableTier5 = "cableGt04Aluminium";
	public static String cableTier6 = "cableGt04Tungsten";
	public static String cableTier7 = "cableGt04Naquadah";
	public static String cableTier8 = "cableGt04Osmium";
	public static String cableTier9 = "cableGt04NiobiumTitanium";
	public static String cableTier10 = "cableGt08NiobiumTitanium";

	public static String pipeTier1 = "pipeHuge"+"Clay";
	public static String pipeTier2 = "pipeHuge"+"Potin";
	public static String pipeTier3 = "pipeHuge"+"Steel";
	public static String pipeTier4 = "pipeHuge"+"StainlessSteel";
	public static String pipeTier5 = "pipeHuge"+"TungstenSteel";
	public static String pipeTier6 = "pipeHuge"+"MaragingSteel300";
	public static String pipeTier7 = "pipeHuge"+"Tantalloy60";
	public static String pipeTier8 = "pipeHuge"+"Tantalloy61";
	public static String pipeTier9 = "pipeHuge"+"Inconel792";
	public static String pipeTier10 = "pipeHuge"+"HastelloyX";
	public static String pipeTier11 = "pipeHuge"+"Europium";

	// EV/IV MACHINES
	public static ItemStack EV_MACHINE_Electrolyzer;
	public static ItemStack EV_MACHINE_Centrifuge;
	public static ItemStack EV_MACHINE_BendingMachine;
	public static ItemStack EV_MACHINE_Wiremill;
	public static ItemStack HV_MACHINE_Macerator;
	public static ItemStack EV_MACHINE_Macerator;
	public static ItemStack EV_MACHINE_Cutter;
	public static ItemStack EV_MACHINE_MassFabricator;
	public static ItemStack EV_MACHINE_Extruder;
	public static ItemStack EV_MACHINE_Sifter;
	public static ItemStack EV_MACHINE_ThermalCentrifuge;
	public static ItemStack EV_MACHINE_OreWasher;
	public static ItemStack EV_MACHINE_AlloySmelter;
	public static ItemStack EV_MACHINE_Mixer;


	//Cables
	public static String cableGt02Electrum = "cableGt02Electrum";


	//Plates
	public static String plateElectricalSteel= "plateElectricalSteel";
	public static String plateEnergeticAlloy= "plateEnergeticAlloy";
	public static String plateCobalt = "plateCobalt";
	public static String plateBronze = "plateBronze";
	public static String plateSteel = "plateSteel";

	//Pipes
	public static String pipeLargeCopper="pipeLargeCopper";
	public static String pipeHugeSteel="pipeHugeSteel";
	public static String pipeHugeStainlessSteel="pipeHugeStainlessSteel";
	public static String pipeHugeTitanium="pipeHugeTitanium";

	//Lava Boiler
	public static ItemStack boiler_Coal;
	public static ItemStack blockBricks = ItemUtils.getItemStackFromFQRN("minecraft:brick_block", 1);

	//Batteries
	public static String batteryBasic = "batteryBasic";
	public static String batteryAdvanced = "batteryAdvanced";
	public static String batteryElite = "batteryElite";
	public static String batteryMaster = "batteryMaster";
	public static String batteryUltimate = "batteryUltimate";
	public static ItemStack IC2MFE;
	public static ItemStack IC2MFSU;

	//Misc
	public static ItemStack INPUT_RCCokeOvenBlock;
	public static ItemStack INPUT_IECokeOvenBlock;

	//Output Determiner
	public static int Casing_Amount;



	public static final void loadRecipes(){
		run();
		Logger.INFO("Loading Recipes for the Various machine blocks.");
	}

	private static void run(){

		//Determines Casing Recipe Output
		if (CORE.MAIN_GREGTECH_5U_EXPERIMENTAL_FORK && !GTNH){
			Casing_Amount=2;
		}
		else {
			Casing_Amount=1;
		}	

		initModItems();
		tieredMachineHulls();
		controlCores();
		energyCores();
		wirelessChargers();
		largeArcFurnace();
		industrialVacuumFurnace();
		fakeMachineCasingCovers();
		ztonesCoverRecipes();
		overflowValveCovers();
		superBuses();
		roundRobinators();
		chunkloaders();
		distillus();
		algaeFarm();
		chemPlant();
		zyngen();
		milling();
		sparging();
		chisels();		
		rockBreaker();
		thermicFluidHeater();
		advHeatExchanger();
		
		gt4FarmManager();
		gt4Redstone();
		gt4Inventory();
		
		multiGeneratorArray();
		multiForgeHammer();
		multiMolecularTransformer();
		multiXlTurbines();
		multiSolarTower();
		multiElementalDuplicator();
		
		computerCube();
		
		resonanceChambers();
		modulators();
		

	}
	

	private static void thermicFluidHeater() {
		
		RecipeUtils.addShapedGregtechRecipe(
				CI.getPlate(5, 1), CI.circuitTier5, CI.getPlate(5, 1),
				pipeTier7, ItemList.Machine_IV_FluidHeater.get(1), pipeTier7,
				CI.getPlate(5, 1), CI.circuitTier4, CI.getPlate(5, 1),
				GregtechItemList.Controller_IndustrialFluidHeater.get(1));
	}

	private static void advHeatExchanger() {
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.Machine_Multi_HeatExchanger.get(1),
						CI.getDoublePlate(6, 8),
						CI.getScrew(6, 16),
						CI.getCircuit(5, 8)
				},
				CI.tieredMaterials[5].getMolten(144 * 8),
				GregtechItemList.XL_HeatExchanger.get(1),
				20 * 60,
				MaterialUtils.getVoltageForTier(6));

		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.Casing_StableTitanium.get(1),
						CI.getPlate(5, 4),
						CI.getScrew(5, 8),
				},
				CI.tieredMaterials[5].getMolten(144 * 2),
				GregtechItemList.Casing_XL_HeatExchanger.get(1),
				20 * 5,
				MaterialUtils.getVoltageForTier(6));
	}

	private static void computerCube() {
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(20),
						CI.getTieredGTPPMachineCasing(4, 1),
						CI.getCircuit(4, 8),
						CI.getFieldGenerator(2, 4),
						CI.getDoublePlate(4, 8),
						CI.getRobotArm(4, 8)
				}, 
				Materials.Redstone.getMolten(144 * 32), 
				GregtechItemList.Gregtech_Computer_Cube_Machine.get(1), 
				20 * 60 * 10, 
				MaterialUtils.getVoltageForTier(4));
		
	}


	private static void gt4FarmManager() {
		
		
		
		ItemList[] aInputHatches = new ItemList[] {
				ItemList.Hatch_Input_LV, ItemList.Hatch_Input_MV, ItemList.Hatch_Input_HV,
				ItemList.Hatch_Input_EV, ItemList.Hatch_Input_IV, ItemList.Hatch_Input_LuV,
				ItemList.Hatch_Input_ZPM, ItemList.Hatch_Input_UV
		};
		GregtechItemList[] aOutputMachines = new GregtechItemList[] {
				GregtechItemList.GT4_Crop_Harvester_LV, GregtechItemList.GT4_Crop_Harvester_MV, GregtechItemList.GT4_Crop_Harvester_HV,
				GregtechItemList.GT4_Crop_Harvester_EV, GregtechItemList.GT4_Crop_Harvester_IV, GregtechItemList.GT4_Crop_Harvester_LuV,
				GregtechItemList.GT4_Crop_Harvester_ZPM, GregtechItemList.GT4_Crop_Harvester_UV
		};	
		
		int aTier = 1;
		for (int i=0;i<8;i++) {
			RecipeUtils.addShapedRecipe(
					CI.getRobotArm(aTier, 1), CI.getSensor(aTier, 1), CI.getRobotArm(aTier, 1),
					ItemUtils.getOrePrefixStack(OrePrefixes.toolHeadSense, CI.tieredMaterials[aTier], 1), CI.getTieredMachineHull(aTier, 1), ItemUtils.getOrePrefixStack(OrePrefixes.toolHeadSense, CI.tieredMaterials[aTier], 1),
					CI.getTieredCircuitOreDictName(aTier), aInputHatches[i].get(1), CI.getTieredCircuitOreDictName(aTier), 
					aOutputMachines[i].get(1));
			aTier++;
		}
		
	}

	private static void gt4Redstone() {
		
		RecipeUtils.addShapedRecipe(
				"plateIron", "plateGlass", "plateIron",
				"plateGlass", ItemUtils.getSimpleStack(Blocks.redstone_lamp), "plateGlass",
				"plateIron", "plateGlass", "plateIron",
				GregtechItemList.GT4_Redstone_Lamp.get(2));
		RecipeUtils.addShapedRecipe(
				"plateAluminium", "plateGlass", "plateAluminium",
				"plateGlass", ItemUtils.getSimpleStack(Blocks.redstone_lamp), "plateGlass",
				"plateAluminium", "plateGlass", "plateAluminium",
				GregtechItemList.GT4_Redstone_Lamp.get(8));

		RecipeUtils.addShapedRecipe(
				"plateIron", "plateIron", "plateIron",
				ItemUtils.getSimpleStack(Items.comparator), ItemList.Cover_Screen.get(1), ItemUtils.getSimpleStack(Items.comparator),
				"plateIron", "plateIron", "plateIron",
				GregtechItemList.GT4_Redstone_Display.get(2));
		RecipeUtils.addShapedRecipe(
				"plateAluminium", "plateAluminium", "plateAluminium",
				ItemUtils.getSimpleStack(Items.comparator), ItemList.Cover_Screen.get(1), ItemUtils.getSimpleStack(Items.comparator),
				"plateAluminium", "plateAluminium", "plateAluminium",
				GregtechItemList.GT4_Redstone_Display.get(8));
		
		RecipeUtils.addShapedRecipe(
				"plateIron", "plateIron", "plateIron",
				ItemUtils.getSimpleStack(Items.comparator), ItemList.Cover_EnergyDetector.get(1), ItemUtils.getSimpleStack(Items.comparator),
				"plateIron", "plateIron", "plateIron",
				GregtechItemList.GT4_Redstone_Scale.get(2));
		RecipeUtils.addShapedRecipe(
				"plateAluminium", "plateAluminium", "plateAluminium",
				ItemUtils.getSimpleStack(Items.comparator), ItemList.Cover_EnergyDetector.get(1), ItemUtils.getSimpleStack(Items.comparator),
				"plateAluminium", "plateAluminium", "plateAluminium",
				GregtechItemList.GT4_Redstone_Scale.get(8));
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getTieredMachineHull(1), 
						ItemUtils.getSimpleStack(Blocks.stone_button, 16)
				}, 
				null,
				GregtechItemList.GT4_Redstone_Button_Panel.get(1), 
				800,
				4);

		RecipeUtils.addShapedRecipe(
				"plateIron", ItemUtils.getSimpleStack(Items.repeater), "plateIron",
				ItemUtils.getSimpleStack(Items.comparator), CI.getTieredCircuitOreDictName(1), ItemUtils.getSimpleStack(Items.comparator),
				"plateIron", ItemUtils.getSimpleStack(Items.repeater), "plateIron",
				GregtechItemList.GT4_Redstone_Circuit.get(1));
		RecipeUtils.addShapedRecipe(
				"plateAluminium", ItemUtils.getSimpleStack(Items.repeater), "plateAluminium",
				ItemUtils.getSimpleStack(Items.comparator), CI.getTieredCircuitOreDictName(1), ItemUtils.getSimpleStack(Items.comparator),
				"plateAluminium", ItemUtils.getSimpleStack(Items.repeater), "plateAluminium",
				GregtechItemList.GT4_Redstone_Circuit.get(2));		
		
	}

	private static void gt4Inventory() {
		
		ItemList[] aEnergyHatches = new ItemList[] {
				ItemList.Hatch_Energy_LV, ItemList.Hatch_Energy_MV, ItemList.Hatch_Energy_HV,
				ItemList.Hatch_Energy_EV, ItemList.Hatch_Energy_IV, ItemList.Hatch_Energy_LuV,
				ItemList.Hatch_Energy_ZPM, ItemList.Hatch_Energy_UV
		};
		
		ItemList[] aRegulators = new ItemList[] {
				ItemList.Automation_Regulator_LV, ItemList.Automation_Regulator_MV, ItemList.Automation_Regulator_HV,
				ItemList.Automation_Regulator_EV, ItemList.Automation_Regulator_IV, ItemList.Automation_Regulator_LuV,
				ItemList.Automation_Regulator_ZPM, ItemList.Automation_Regulator_UV
		};
		
		GregtechItemList[] aOutputInventoryManager = new GregtechItemList[] {
				GregtechItemList.GT4_Electric_Inventory_Manager_LV, GregtechItemList.GT4_Electric_Inventory_Manager_MV, GregtechItemList.GT4_Electric_Inventory_Manager_HV,
				GregtechItemList.GT4_Electric_Inventory_Manager_EV, GregtechItemList.GT4_Electric_Inventory_Manager_IV, GregtechItemList.GT4_Electric_Inventory_Manager_LuV,
				GregtechItemList.GT4_Electric_Inventory_Manager_ZPM, GregtechItemList.GT4_Electric_Inventory_Manager_UV
		};	
		
		int aTier = 1;
		for (int i=0;i<8;i++) {
			RecipeUtils.addShapedRecipe(
					CI.getTieredCircuitOreDictName(aTier), aRegulators[i].get(1), CI.getTieredCircuitOreDictName(aTier),
					CI.getRobotArm(aTier, 1), CI.getTieredMachineHull(aTier), CI.getRobotArm(aTier, 1),
					CI.getTieredCircuitOreDictName(aTier), aEnergyHatches[i].get(1), CI.getTieredCircuitOreDictName(aTier),
					aOutputInventoryManager[i].get(1));
			aTier++;
		}
		
		GregtechItemList[] aOutputElectricCraftingTable = new GregtechItemList[] {
				GregtechItemList.GT4_Electric_Auto_Workbench_LV, GregtechItemList.GT4_Electric_Auto_Workbench_MV, GregtechItemList.GT4_Electric_Auto_Workbench_HV,
				GregtechItemList.GT4_Electric_Auto_Workbench_EV, GregtechItemList.GT4_Electric_Auto_Workbench_IV, GregtechItemList.GT4_Electric_Auto_Workbench_LuV,
				GregtechItemList.GT4_Electric_Auto_Workbench_ZPM, GregtechItemList.GT4_Electric_Auto_Workbench_UV
		};	
		
		aTier = 1;
		for (int i=0;i<8;i++) {
			RecipeUtils.addShapedRecipe(
					ItemUtils.getOrePrefixStack(OrePrefixes.plate, CI.tieredMaterials[aTier], 1), ItemUtils.getSimpleStack(Blocks.crafting_table), ItemUtils.getOrePrefixStack(OrePrefixes.plate, CI.tieredMaterials[aTier], 1),
					CI.getTieredCircuitOreDictName(aTier), CI.getTieredMachineHull(aTier), CI.getTieredCircuitOreDictName(aTier),
					ItemUtils.getOrePrefixStack(OrePrefixes.plate, CI.tieredMaterials[aTier], 1), CI.getRobotArm(aTier, 1), ItemUtils.getOrePrefixStack(OrePrefixes.plate, CI.tieredMaterials[aTier], 1),
					aOutputElectricCraftingTable[i].get(1));
			aTier++;
		}
		
	}

	private static void multiGeneratorArray() {

        GT_ModHandler.addCraftingRecipe(
        		GregtechItemList.Generator_Array_Controller.get(1L),
        		CI.bitsd, 
        		new Object[]{"CTC", "FMF", "CBC",
        				'M', CI.getTieredGTPPMachineCasing(4, 1),
        				'B', OrePrefixes.pipeHuge.get(Materials.StainlessSteel),
        				'C', OrePrefixes.circuit.get(Materials.Data),
        				'F', ItemList.Electric_Pump_EV,
        				'T', CI.getSensor(4, 1)});
	}

	private static void multiForgeHammer() {
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getTieredGTPPMachineCasing(4, 1), 
						ItemList.Machine_IV_Hammer.get(1),
						CI.getPlate(4, 8),
						CI.getBolt(5, 32),
						ELEMENT.getInstance().ZIRCONIUM.getFineWire(32),
						ItemUtils.getItemStackOfAmountFromOreDict("circuitElite", 4)
				}, 
				CI.getTieredFluid(4, 144 * 12),
				GregtechItemList.Controller_IndustrialForgeHammer.get(1), 
				20 * 30,
				MaterialUtils.getVoltageForTier(5));
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getTieredGTPPMachineCasing(3, 1),
						ItemList.Casing_HeatProof.get(1),
						CI.getPlate(4, 2),
						CI.getBolt(4, 8),
						ALLOY.BABBIT_ALLOY.getFineWire(16),
						ItemUtils.getItemStackOfAmountFromOreDict("circuitGood", 4)
				}, 
				CI.getTieredFluid(4, 144 * 2),
				GregtechItemList.Casing_IndustrialForgeHammer.get(1), 
				20 * 30,
				MaterialUtils.getVoltageForTier(4));
		
	}

	private static void multiMolecularTransformer() {
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getTieredGTPPMachineCasing(6, 1), 
						CI.getPlate(5, 16),
						CI.getBolt(5, 32),
						ALLOY.HG1223.getFineWire(64),
						CI.getEmitter(4, 8),
						ItemUtils.getItemStackOfAmountFromOreDict("circuitMaster", 10)
				}, 
				CI.getTieredFluid(5, 144 * 16),
				ItemDummyResearch.getResearchStack(ASSEMBLY_LINE_RESEARCH.RESEARCH_11_MOLECULAR_TRANSFORMER, 1), 
				20 * 60,
				MaterialUtils.getVoltageForTier(5));
		
		CORE.RA.addAssemblylineRecipe(
				ItemDummyResearch.getResearchStack(ASSEMBLY_LINE_RESEARCH.RESEARCH_11_MOLECULAR_TRANSFORMER, 1), 
				20 * 60 * 30,
				new Object[] {
						ALLOY.HG1223.getFineWire(64),
						ALLOY.HG1223.getFineWire(64),
						ItemList.Electric_Motor_IV.get(GTNH ? 32 : 16),
						ItemList.Energy_LapotronicOrb.get(GTNH ? 32 : 16),
						CI.getTieredComponent(OrePrefixes.cableGt12, 6, GTNH ? 32 : 16),
						CI.getTieredComponent(OrePrefixes.wireGt16, 5, GTNH ? 64 : 32),
						ALLOY.ZERON_100.getFrameBox(4),
						ALLOY.ZIRCONIUM_CARBIDE.getPlateDouble(32),
						ALLOY.BABBIT_ALLOY.getPlate(64),
						ALLOY.LEAGRISIUM.getGear(GTNH ? 16 : 8),
						new Object[] {CI.getTieredCircuitOreDictName(4), 64},
						new Object[] {CI.getTieredCircuitOreDictName(5), 32},
						new Object[] {CI.getTieredCircuitOreDictName(6), 16},
						GregtechItemList.Laser_Lens_WoodsGlass.get(1),
				}, 
				new FluidStack[] {
						ALLOY.NITINOL_60.getFluidStack(144 * 9 * (GTNH ? 4 : 2)),
						ALLOY.INCOLOY_MA956.getFluidStack(144 * 9 * (GTNH ? 32 : 8)),
						ALLOY.KANTHAL.getFluidStack(144 * 1 * (GTNH ? 16 : 4)),
				},
				GregtechItemList.Controller_MolecularTransformer.get(1), 
				20 * 60 * 10 * (GTNH ? 2 : 1),
				(int) MaterialUtils.getVoltageForTier(6));
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(16),
						CI.getPlate(6, 4),
						CI.getScrew(6, 8),
						ELEMENT.getInstance().PALLADIUM.getFineWire(16),
						CI.getSensor(5, 2),
						ItemUtils.getItemStackOfAmountFromOreDict("circuitElite", 4)
				}, 
				CI.getTieredFluid(5, 144 * 4),
				GregtechItemList.Casing_Molecular_Transformer_1.get(1), 
				20 * 20,
				MaterialUtils.getVoltageForTier(5));
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(16),
						CI.getPlate(5, 4),
						CI.getScrew(5, 8),
						ItemList.Casing_Coil_Nichrome.get(2),
						CI.getFieldGenerator(3, 2),
						ItemUtils.getItemStackOfAmountFromOreDict("circuitData", 8)
				}, 
				CI.getTieredFluid(5, 144 * 4),
				GregtechItemList.Casing_Molecular_Transformer_2.get(1), 
				20 * 20,
				MaterialUtils.getVoltageForTier(5));
		

		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(16),
						ItemUtils.getSimpleStack(Blocks.glowstone, 16),
						CI.getGear(5, 8),
						ELEMENT.getInstance().TITANIUM.getWire04(4),
						CI.getFieldGenerator(4, 2),
						ItemUtils.getItemStackOfAmountFromOreDict("circuitData", 8)
				}, 
				CI.getTieredFluid(5, 144 * 4),
				GregtechItemList.Casing_Molecular_Transformer_3.get(1), 
				20 * 60,
				MaterialUtils.getVoltageForTier(5));
		
	}

	private static void multiXlTurbines() {
		
		RecipeUtils.addShapedRecipe(
				CI.getDoublePlate(4, 1), CI.getElectricMotor(3, 1), CI.getDoublePlate(4, 1),
				ItemUtils.getItemStackOfAmountFromOreDict("cellLubricant", 1), ItemList.Casing_Gearbox_Titanium.get(1), ItemUtils.getItemStackOfAmountFromOreDict("cellLubricant", 1),
				CI.getDoublePlate(4, 1), CI.getElectricMotor(3, 1), CI.getDoublePlate(4, 1),
				GregtechItemList.Casing_Turbine_Shaft.get(1));
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.Casing_Turbine.get(1),
						CI.getPlate(4, 4),
						CI.getScrew(4, 8),
						CI.getCircuit(4, 4),
						CI.getGear(3, 8)
				}, 
				CI.tieredMaterials[3].getMolten(144 * 8),
				GregtechItemList.Hatch_Turbine_Rotor.get(1), 
				20 * 60,
				MaterialUtils.getVoltageForTier(4));
		
		// Steam
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.Casing_Turbine.get(1),
						CI.getPlate(3, 4),
						CI.getScrew(3, 8),
				}, 
				CI.tieredMaterials[2].getMolten(144 * 2),
				GregtechItemList.Casing_Turbine_LP.get(1), 
				20 * 5,
				MaterialUtils.getVoltageForTier(3));
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.LargeSteamTurbine.get(1),
						CI.getPlate(4, 8),
						CI.getScrew(4, 16),
						CI.getGear(4, 4),
						CI.getCircuit(4, 8)
				}, 
				CI.tieredMaterials[4].getMolten(144 * 8),
				GregtechItemList.Large_Steam_Turbine.get(1), 
				20 * 60,
				MaterialUtils.getVoltageForTier(4));
		
		// Gas
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.Casing_Turbine1.get(1),
						CI.getPlate(4, 4),
						CI.getScrew(4, 8),
				}, 
				CI.tieredMaterials[3].getMolten(144 * 2),
				GregtechItemList.Casing_Turbine_Gas.get(1), 
				20 * 5,
				MaterialUtils.getVoltageForTier(4));
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.LargeGasTurbine.get(1),
						CI.getPlate(5, 8),
						CI.getScrew(5, 16),
						CI.getGear(5, 4),
						CI.getCircuit(5, 8)
				}, 
				CI.tieredMaterials[5].getMolten(144 * 8),
				GregtechItemList.Large_Gas_Turbine.get(1), 
				20 * 60,
				MaterialUtils.getVoltageForTier(5));
		
		// HP Steam
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.Casing_Turbine2.get(1),
						CI.getPlate(5, 4),
						CI.getScrew(5, 8),
				}, 
				CI.tieredMaterials[4].getMolten(144 * 2),
				GregtechItemList.Casing_Turbine_HP.get(1), 
				20 * 5,
				MaterialUtils.getVoltageForTier(5));
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.LargeHPSteamTurbine.get(1),
						CI.getPlate(6, 8),
						CI.getScrew(6, 16),
						CI.getGear(6, 4),
						CI.getCircuit(6, 8)
				}, 
				CI.tieredMaterials[6].getMolten(144 * 8),
				GregtechItemList.Large_HPSteam_Turbine.get(1), 
				20 * 60,
				MaterialUtils.getVoltageForTier(6));
		
		// Plasma
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.Casing_Turbine3.get(1),
						CI.getPlate(6, 4),
						CI.getScrew(6, 8),
				}, 
				CI.tieredMaterials[5].getMolten(144 * 2),
				GregtechItemList.Casing_Turbine_Plasma.get(1), 
				20 * 5,
				MaterialUtils.getVoltageForTier(6));
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(18),
						ItemList.LargePlasmaTurbine.get(1),
						CI.getPlate(7, 8),
						CI.getScrew(7, 16),
						CI.getGear(7, 4),
						CI.getCircuit(7, 8)
				}, 
				CI.tieredMaterials[7].getMolten(144 * 8),
				GregtechItemList.Large_Plasma_Turbine.get(1), 
				20 * 60,
				MaterialUtils.getVoltageForTier(7));
		
		
	}

	private static void multiSolarTower() {
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(17),
						CI.getTieredGTPPMachineCasing(3, 4),
						ALLOY.MARAGING250.getPlate(8),
						ALLOY.MARAGING250.getBolt(8),
						ALLOY.MARAGING250.getScrew(8),
						CI.getCircuit(5, 8)
				}, 
				CI.getTieredFluid(3, 144 * 16),
				GregtechItemList.Industrial_Solar_Tower.get(1), 
				20 * 30,
				MaterialUtils.getVoltageForTier(4));
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(17),
						ALLOY.MARAGING350.getFrameBox(1),
						ALLOY.STAINLESS_STEEL.getPlate(4),
						ALLOY.MARAGING350.getScrew(8)
				}, 
				CI.getTieredFluid(3, 144 * 4),
				GregtechItemList.Casing_SolarTower_Structural.get(1), 
				20 * 30,
				MaterialUtils.getVoltageForTier(3));
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(17),
						ALLOY.MARAGING250.getFrameBox(1),
						ALLOY.STAINLESS_STEEL.getPlate(4),
						ALLOY.MARAGING250.getBolt(16),
						ELEMENT.getInstance().ALUMINIUM.getScrew(8)
				}, 
				CI.getTieredFluid(3, 144 * 4),
				GregtechItemList.Casing_SolarTower_SaltContainment.get(1), 
				20 * 30,
				MaterialUtils.getVoltageForTier(3));
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(17),
						ALLOY.MARAGING250.getFrameBox(1),
						ALLOY.STEEL_BLACK.getPlate(4),
						ALLOY.MARAGING250.getScrew(8)
				}, 
				CI.getAlternativeTieredFluid(3, 144 * 4),
				GregtechItemList.Casing_SolarTower_HeatContainment.get(1), 
				20 * 30,
				MaterialUtils.getVoltageForTier(3));
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(17),
						CI.getTieredGTPPMachineCasing(2, 1),
						CI.getPlate(3, 2),
						CI.getGear(3, 4),
						CI.getElectricMotor(3, 2),
						CI.getCircuit(3, 4)
						
				}, 
				CI.getTertiaryTieredFluid(3, 144 * 4),
				GregtechItemList.Solar_Tower_Reflector.get(1), 
				20 * 60,
				MaterialUtils.getVoltageForTier(3));
		
	}

	private static void multiElementalDuplicator() {
		
		CORE.RA.addAssemblylineRecipe(
				ItemList.Machine_IV_Replicator.get(1), 
				20 * 60 * 60 * 12,
				new Object[] {
						CI.getTieredMachineHull(7, 4),
						CI.getFieldGenerator(5, GTNH ? 32 : 16),
						CI.getElectricMotor(7, GTNH ? 32 : 16),
						CI.getElectricPiston(7, GTNH ? 16 : 4),
						CI.getEnergyCore(6, GTNH ? 8 : 2),
						CI.getPlate(7, GTNH ? 32 : 16),
						CI.getScrew(7, GTNH ? 64 : 32),
						CI.getBolt(6, GTNH ? 64 : 32),
						CI.getTieredComponent(OrePrefixes.rod, 6, GTNH ? 20 : 10),
						new Object[] {CI.getTieredCircuitOreDictName(7), 20},
						ItemList.Tool_DataOrb.get(32),
						GregtechItemList.Laser_Lens_Special.get(1)
				}, 
				new FluidStack[] {
						CI.getTieredFluid(7, 144 * 32),
						CI.getAlternativeTieredFluid(6, 144 * 16),
						CI.getTertiaryTieredFluid(6, 144 * 16),
						ALLOY.BABBIT_ALLOY.getFluidStack(128 * 144),

				},
				GregtechItemList.Controller_ElementalDuplicator.get(1), 
				20 * 60 * 60 * (GTNH ? 2 : 1),
				(int) MaterialUtils.getVoltageForTier(7));
		
		CORE.RA.addAssemblylineRecipe(
				GregtechItemList.Modulator_III.get(1), 
				20 * 60 * 60 * 4,
				new Object[] {
						CI.getTieredGTPPMachineCasing(7, 2),
						CI.getFieldGenerator(4, GTNH ? 8 : 4),
						CI.getEnergyCore(4, GTNH ? 8 : 2),
						CI.getPlate(7, GTNH ? 16 : 8),
						CI.getScrew(6, GTNH ? 32 : 16),
						CI.getBolt(6, GTNH ? 32 : 16),
						CI.getTieredComponent(OrePrefixes.rod, 5, GTNH ? 32 : 16),
						new Object[] {CI.getTieredCircuitOreDictName(6), 32},
						ItemList.Tool_DataOrb.get(32),
				}, 
				new FluidStack[] {
						CI.getTieredFluid(6, 144 * 16),
						CI.getAlternativeTieredFluid(5, 144 * 8),
						CI.getTertiaryTieredFluid(5, 144 * 8),
						ALLOY.BABBIT_ALLOY.getFluidStack(64 * 144),

				},
				GregtechItemList.Hatch_Input_Elemental_Duplicator.get(1), 
				20 * 60 * 60 * (GTNH ? 4 : 2),
				(int) MaterialUtils.getVoltageForTier(6));
		
		CORE.RA.addAssemblylineRecipe(
				GregtechItemList.ResonanceChamber_III.get(1), 
				20 * 60 * 60 * 2,
				new Object[] {
						CI.getTieredMachineHull(6, 5),
						CI.getFieldGenerator(3, GTNH ? 32 : 16),
						CI.getEnergyCore(2, GTNH ? 8 : 2),
						CI.getPlate(7, GTNH ? 8 : 4),
						CI.getScrew(7, GTNH ? 8 : 4),
						CI.getBolt(6, GTNH ? 16 : 8),
						CI.getTieredComponent(OrePrefixes.rod, 5, GTNH ? 8 : 4),
						new Object[] {CI.getTieredCircuitOreDictName(5), 4},
						ItemList.Tool_DataStick.get(4),
				}, 
				new FluidStack[] {
						CI.getTieredFluid(5, 144 * 16),
						CI.getAlternativeTieredFluid(4, 144 * 8),
						CI.getTertiaryTieredFluid(4, 144 * 8),
						ALLOY.BABBIT_ALLOY.getFluidStack(16 * 144),

				},
				GregtechItemList.Casing_ElementalDuplicator.get(1), 
				20 * 60 * (GTNH ? 20 : 10),
				(int) MaterialUtils.getVoltageForTier(6));
		
	}

	private static void resonanceChambers() {		
		int aFieldTier = 1;
		int aCasingTier = 4;
		for (int i = 0; i < 4; i++) {
			RecipeUtils.addShapedRecipe(
					CI.getDoublePlate(aCasingTier, 1), CI.getFieldGenerator(aFieldTier, 1), CI.getDoublePlate(aCasingTier, 1),
					CI.getFieldGenerator(aFieldTier, 1), CI.getTieredMachineCasing(aCasingTier), CI.getFieldGenerator(aFieldTier, 1),
					CI.getDoublePlate(aCasingTier, 1), CI.getFieldGenerator(aFieldTier, 1), CI.getDoublePlate(aCasingTier, 1), 
					ItemUtils.simpleMetaStack(ModBlocks.blockSpecialMultiCasings2, i, 1));
			aCasingTier++;
			aFieldTier++;
		}		
	}

	private static void modulators() {
		int aCasingTier = 4;
		for (int i = 4; i < 8; i++) {
			RecipeUtils.addShapedRecipe(
					CI.getTieredCircuitOreDictName(aCasingTier), CI.getPlate(aCasingTier, 1), CI.getTieredCircuitOreDictName(aCasingTier),
					CI.getPlate(aCasingTier, 1), CI.getTieredMachineCasing(aCasingTier), CI.getPlate(aCasingTier, 1),
					CI.getTieredCircuitOreDictName(aCasingTier), CI.getPlate(aCasingTier, 1), CI.getTieredCircuitOreDictName(aCasingTier), 
					ItemUtils.simpleMetaStack(ModBlocks.blockSpecialMultiCasings2, i, 1));
			aCasingTier++;
		}	
	}
	
	private static void zyngen() {
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(6),
						CI.getTieredMachineHull(4),
						ItemList.Machine_IV_AlloySmelter.get(1),
						CI.getGear(3, 16),
						CI.getBolt(3, 64),
						CI.getPlate(4, 16)
				}, 
				CI.getAlternativeTieredFluid(4, 144 * 8), 
				GregtechItemList.Industrial_AlloySmelter.get(1),
				20 * 30, 
				MaterialUtils.getVoltageForTier(4));
				
	}

	private static void chemPlant() {
		

        GT_ModHandler.addCraftingRecipe(
        		GregtechItemList.Casing_Machine_Custom_1.get(2L, new Object[0]),
        		CI.bits, 
        		new Object[]{
        				"PhP",
        				"PFP",
        				"PwP",
        				'P',
        				OrePrefixes.plate.get(Materials.Bronze),
        				'F',
        				OrePrefixes.frameGt.get(Materials.Bronze)
        				}
        		);
        
        GT_ModHandler.addCraftingRecipe(
        		GregtechItemList.Casing_Machine_Custom_2.get(2L, new Object[0]),
        		CI.bits, 
        		new Object[]{
        				"PPP",
        				"hFw",
        				"PPP",
        				'P',
        				OrePrefixes.plate.get(Materials.Aluminium),
        				'F',
        				OrePrefixes.frameGt.get(Materials.Aluminium)
        				}
        		);

		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedBioCircuit(19),
						CI.getTieredGTPPMachineCasing(1, 6),
						CI.getTieredComponentOfMaterial(Materials.Steel, OrePrefixes.gearGt, 6),
						CI.getTieredComponentOfMaterial(Materials.Aluminium, OrePrefixes.plate, 32),
						CI.getTieredComponentOfMaterial(Materials.CobaltBrass, OrePrefixes.dust, 16),
						CI.getTieredComponent(OrePrefixes.frameGt, 2, 4),
				}, 
				ALLOY.STEEL.getFluidStack(2 * (144 * 4)), 
				GregtechItemList.ChemicalPlant_Controller.get(1), 
				120 * 20, 
				MaterialUtils.getVoltageForTier(2));
		

		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedBioCircuit(15),
						CI.getTieredGTPPMachineCasing(1, 2),
						ItemList.Hatch_Input_Bus_MV.get(1),
						CI.getTieredComponentOfMaterial(Materials.Bronze, OrePrefixes.gearGt, 8),
						CI.getTieredComponentOfMaterial(Materials.Lead, OrePrefixes.plate, 48),
						CI.getTieredComponentOfMaterial(Materials.SolderingAlloy, OrePrefixes.wireFine, 16),
				}, 
				ALLOY.BRONZE.getFluidStack(2 * (144 * 4)), 
				GregtechItemList.Bus_Catalysts.get(1), 
				60 * 20, 
				MaterialUtils.getVoltageForTier(2));

	}

	private static void algaeFarm() {

		// Give the shitty algae a use :)
		CORE.RA.addDistilleryRecipe(
				ItemUtils.getSimpleStack(AgriculturalChem.mAlgaeBiosmass, 32),
				null,
				null,
				ItemUtils.getSimpleStack(AgriculturalChem.mGreenAlgaeBiosmass, 4),
				20 * 15,
				16, 
				false);

		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedBioCircuit(21),
						CI.getTieredGTPPMachineCasing(0, 4),
						CI.getTieredComponentOfMaterial(Materials.Iron, OrePrefixes.rod, 12),
						CI.getTieredComponentOfMaterial(Materials.Wood, OrePrefixes.plate, 32),
						CI.getTieredComponentOfMaterial(Materials.Bronze, OrePrefixes.bolt, 16),
						CI.getTieredComponentOfMaterial(Materials.Redstone, OrePrefixes.dust, 32),
				}, 
				ALLOY.POTIN.getFluidStack(2 * (144 * 4)), 
				GregtechItemList.AlgaeFarm_Controller.get(1), 
				60 * 20, 
				MaterialUtils.getVoltageForTier(1));	


	}

	private static void distillus() {

		CORE.RA.addChemicalPlantRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(19),
						ItemList.Distillation_Tower.get(2),
						GregtechItemList.GTPP_Casing_IV.get(16),
						CI.getTieredComponent(OrePrefixes.circuit, 6, 8)
				}, 
				new FluidStack[] {
						ALLOY.AQUATIC_STEEL.getFluidStack(144 * 32),
						ALLOY.BABBIT_ALLOY.getFluidStack(144 * 16),
						ALLOY.BRONZE.getFluidStack(144 * 64),
						ALLOY.KANTHAL.getFluidStack(144 * 16),
				}, 
				new ItemStack[] {
						GregtechItemList.Machine_Adv_DistillationTower.get(1)
				}, 
				new FluidStack[] {

				},
				20 * 600, 
				MaterialUtils.getVoltageForTier(6), 
				5);

	}

	private static void chunkloaders() {

		ItemStack aOutputs[] = new ItemStack[] {
				GregtechItemList.GT_Chunkloader_HV.get(1L),
				GregtechItemList.GT_Chunkloader_IV.get(1L),
				GregtechItemList.GT_Chunkloader_ZPM.get(1L),
		};

		int aIndex = 0;

		for (int i=3;i<8;i++) {	
			if (i == 4 || i == 6) {
				continue;
			}			
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							CI.getNumberedAdvancedCircuit(21),
							CI.getElectricPiston(i, 10),
							CI.getFieldGenerator(i + 1, 6),
							CI.getPlate(i, 16),
							CI.getTransmissionComponent(i - 1, 8),
							CI.getTieredComponent(OrePrefixes.cableGt08, i, 16)
					}, 
					ALLOY.EGLIN_STEEL.getFluidStack(i * (144 * 4)), 
					aOutputs[aIndex++].copy(), 
					300 * 20, 
					MaterialUtils.getVoltageForTier(i));			
		}


	}

	private static void overflowValveCovers() {
		ItemStack aOutputs[] = new ItemStack[] {
				GregtechItemList.Cover_Overflow_ULV.get(1L),
				GregtechItemList.Cover_Overflow_LV.get(1L),
				GregtechItemList.Cover_Overflow_MV.get(1L),
				GregtechItemList.Cover_Overflow_HV.get(1L),
				GregtechItemList.Cover_Overflow_EV.get(1L),
				GregtechItemList.Cover_Overflow_IV.get(1L),	
		};

		for (int i=0;i<6;i++) {			
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							CI.getNumberedBioCircuit(19),
							CI.getElectricPump(i, 2),
							CI.getElectricMotor(i, 2),
							CI.getPlate(i, 4)
					}, 
					FluidUtils.getWater((i+1) * 750), 
					aOutputs[i].copy(), 
					20 * 20, 
					MaterialUtils.getVoltageForTier(i));			
		}

	}

	private static void tieredMachineHulls() {

		GregtechItemList[] aHulls = new GregtechItemList[] {
				GregtechItemList.GTPP_Casing_ULV,
				GregtechItemList.GTPP_Casing_LV,
				GregtechItemList.GTPP_Casing_MV,
				GregtechItemList.GTPP_Casing_HV,
				GregtechItemList.GTPP_Casing_EV,
				GregtechItemList.GTPP_Casing_IV,
				GregtechItemList.GTPP_Casing_LuV,
				GregtechItemList.GTPP_Casing_ZPM,
				GregtechItemList.GTPP_Casing_UV,
				GregtechItemList.GTPP_Casing_MAX
		};

		for (int i=0;i<10;i++) {			
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							CI.getNumberedBioCircuit(20),
							CI.getTieredMachineCasing(i),
							CI.getPlate(i, 8),
							CI.getGear(i, 2),
							CI.getTieredComponent(OrePrefixes.cableGt02, i, 4),
							CI.getTieredComponent(OrePrefixes.circuit, i, 2)
					},
					CI.getAlternativeTieredFluid(i, 144 * (i+1) * 2), 
					aHulls[i].get(1), 
					20 * 20, 
					MaterialUtils.getVoltageForTier(i));			
		}

	}

	private static void initModItems(){
		if (LoadedMods.IndustrialCraft2){
			IC2MFE = ItemUtils.getItemStackWithMeta(LoadedMods.IndustrialCraft2, "IC2:blockElectric", "IC2_MFE", 1, 1);
			IC2MFSU = ItemUtils.getItemStackWithMeta(LoadedMods.IndustrialCraft2, "IC2:blockElectric", "IC2_MFSU", 2, 1);
		}
		if (LoadedMods.Gregtech){

			//Lava Boiler
			boiler_Coal = ItemList.Machine_Bronze_Boiler.get(1);

			//IV MACHINES
			if (!GTNH){			
				EV_MACHINE_Electrolyzer = ItemList.Machine_EV_Electrolyzer.get(1);
				EV_MACHINE_BendingMachine= ItemList.Machine_EV_Bender.get(1);
				EV_MACHINE_Wiremill= ItemList.Machine_EV_Wiremill.get(1);
				HV_MACHINE_Macerator= ItemList.Machine_HV_Macerator.get(1);
				EV_MACHINE_Macerator= ItemList.Machine_EV_Macerator.get(1);
				EV_MACHINE_MassFabricator= ItemList.Machine_EV_Massfab.get(1);
				EV_MACHINE_Centrifuge= ItemList.Machine_EV_Centrifuge.get(1);
				EV_MACHINE_Cutter = ItemList.Machine_EV_Cutter.get(1);
				EV_MACHINE_Extruder = ItemList.Machine_EV_Extruder.get(1);
				EV_MACHINE_Sifter = ItemList.Machine_HV_Sifter.get(1);
				EV_MACHINE_ThermalCentrifuge = ItemList.Machine_EV_ThermalCentrifuge.get(1);
				EV_MACHINE_OreWasher = ItemList.Machine_EV_OreWasher.get(1);
				EV_MACHINE_AlloySmelter = ItemList.Machine_EV_AlloySmelter.get(1);  
				EV_MACHINE_Mixer = ItemList.Machine_EV_Mixer.get(1);
			}
			//Balanced opposites
			else {			    
				EV_MACHINE_Electrolyzer = ItemList.Machine_IV_Electrolyzer.get(1);
				EV_MACHINE_BendingMachine= ItemList.Machine_IV_Bender.get(1);
				EV_MACHINE_Wiremill= ItemList.Machine_IV_Wiremill.get(1);
				HV_MACHINE_Macerator= ItemList.Machine_EV_Macerator.get(1);
				EV_MACHINE_Macerator= ItemList.Machine_IV_Macerator.get(1);			
				EV_MACHINE_MassFabricator= CORE.MAIN_GREGTECH_5U_EXPERIMENTAL_FORK ? ItemUtils.getValueOfItemList("Machine_LuV_Massfab", ItemList.Machine_IV_Massfab).get(1) : ItemList.Machine_IV_Massfab.get(1);
				EV_MACHINE_Centrifuge= ItemList.Machine_IV_Centrifuge.get(1);
				EV_MACHINE_Cutter = ItemList.Machine_IV_Cutter.get(1);
				EV_MACHINE_Extruder = ItemList.Machine_IV_Extruder.get(1);
				EV_MACHINE_Sifter = ItemList.Machine_HV_Sifter.get(1);
				EV_MACHINE_ThermalCentrifuge = ItemList.Machine_IV_ThermalCentrifuge.get(1);
				EV_MACHINE_OreWasher = ItemList.Machine_IV_OreWasher.get(1);
				EV_MACHINE_AlloySmelter = ItemList.Machine_IV_AlloySmelter.get(1);  
				EV_MACHINE_Mixer = ItemList.Machine_IV_Mixer.get(1);
			}



		}
		if (CORE.ConfigSwitches.enableMultiblock_IndustrialCokeOven){
			if(LoadedMods.Railcraft){
				//Misc
				INPUT_RCCokeOvenBlock = ItemUtils.getItemStackWithMeta(LoadedMods.Railcraft, "Railcraft:machine.alpha", "Coke_Oven_RC", 7, 1);
			}
			if(LoadedMods.ImmersiveEngineering){
				//Misc
				INPUT_IECokeOvenBlock = ItemUtils.getItemStackWithMeta(LoadedMods.ImmersiveEngineering, "ImmersiveEngineering:stoneDecoration", "Coke_Oven_IE", 1, 1);
			}
		}
		runModRecipes();
	}

	private static void runModRecipes(){
		if (LoadedMods.Gregtech){

			//Computer Cube			
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							ItemUtils.getSimpleStack(CI.getDataOrb(), 4 * (GTNH ? 2 : 1)),						
							ItemList.Cover_Screen.get(4),
							CI.machineHull_IV,
							ItemUtils.getItemStackOfAmountFromOreDict(CI.getTieredCircuitOreDictName(7), 2)
					}, 
					ELEMENT.getInstance().TANTALUM.getFluidStack(144 * 16), 
					GregtechItemList.Gregtech_Computer_Cube.get(1),
					60 * 20 * 3, 
					8000);

			//Circuit programmer			
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							ItemUtils.getSimpleStack(CI.robotArm_LV, 4 * (GTNH ? 2 : 1)),						
							ItemList.Cover_Controller.get(1, CI.electricMotor_MV),
							CI.machineHull_MV,
							ItemUtils.getItemStackOfAmountFromOreDict(CI.getTieredCircuitOreDictName(1), 2),
							ItemUtils.getItemStackOfAmountFromOreDict(CI.getTieredCircuitOreDictName(2), 2)
					}, 
					ELEMENT.getInstance().IRON.getFluidStack(144 * 4), 
					ItemUtils.getSimpleStack(ModBlocks.blockCircuitProgrammer),
					60 * 10 * 1, 
					30);

			//Lead Lined Chest		
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							CI.machineHull_LV,
							ItemUtils.getItemStackOfAmountFromOreDict("plateRubber", 32),
							ItemUtils.getItemStackOfAmountFromOreDict("plateDenseLead", 9),
							ItemUtils.getSimpleStack(Blocks.chest)
					}, 
					ELEMENT.getInstance().LEAD.getFluidStack(144 * 16), 
					ItemUtils.getSimpleStack(ModBlocks.blockDecayablesChest),
					60 * 10 * 3, 
					60);

			//RTG	
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							ItemUtils.getItemStackWithMeta(true, "IC2:blockGenerator:6", "IC2-RTG", 6, 1),
							ALLOY.NITINOL_60.getPlate(GTNH ? 32 : 8),
							ALLOY.MARAGING350.getGear(GTNH ? 16 : 4),
							ItemUtils.getSimpleStack(GTNH ? CI.fieldGenerator_IV : CI.fieldGenerator_EV, 8 ),
							ItemUtils.getItemStackOfAmountFromOreDict("wireFinePlatinum", GTNH ? 64 : 32),
							ItemUtils.getItemStackOfAmountFromOreDict(CI.getTieredCircuitOreDictName(GTNH ? 7 : 6), GTNH ? 5 : 4)
					}, 
					ALLOY.NIOBIUM_CARBIDE.getFluidStack(144 * 16), 
					GregtechItemList.RTG.get(1),
					60 * 20 * 10, 
					8000);

			// Super Jukebox		
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							CI.machineHull_LV,
							ItemUtils.getItemStackOfAmountFromOreDict("circuitBasic", 4),
							ItemUtils.getItemStackOfAmountFromOreDict("plateTumbaga", 8),
							ItemUtils.getSimpleStack(Blocks.jukebox)
					}, 
					ELEMENT.getInstance().COPPER.getFluidStack(144 * 2), 
					ItemUtils.getSimpleStack(ModBlocks.blockCustomJukebox),
					20 * 30, 
					30);

			ItemStack aFluidRegulator1 = ItemUtils.getValueOfItemList("FluidRegulator_MV",GTNH ? 4 : 2, ItemList.Electric_Pump_HV);
			ItemStack aFluidRegulator2 = ItemUtils.getValueOfItemList("FluidRegulator_IV", GTNH ? 4 : 2, ItemUtils.getValueOfItemList("Electric_Pump_LuV", GTNH ? 8 : 4, ItemList.Electric_Pump_IV));

			//Poo Collector		
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							CI.machineHull_MV,
							aFluidRegulator1,
							CI.getTieredComponent(OrePrefixes.pipeMedium, 2, GTNH ? 4 : 2),
							ALLOY.EGLIN_STEEL.getPlate(GTNH ? 8 : 4),
							ALLOY.POTIN.getScrew(GTNH ? 12 : 6)
					}, 
					ALLOY.TUMBAGA.getFluidStack(144 * 4), 
					ItemUtils.getSimpleStack(ModBlocks.blockPooCollector),
					20 * 60, 
					30);

			//Adv. Poo Collector		
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							CI.getTieredMachineHull(-1),
							ItemUtils.getSimpleStack(ModBlocks.blockPooCollector),
							aFluidRegulator2,
							CI.getTieredComponent(OrePrefixes.pipeHuge, 6, GTNH ? 8 : 4),
							CI.getTieredComponent(OrePrefixes.screw, 6, GTNH ? 32 : 16)
					}, 
					CI.getAlternativeTieredFluid(5, 144 * 9), 
					ItemUtils.getSimpleStack(ModBlocks.blockPooCollector, 8, 1),
					20 * 60 * 5, 
					500);


			//Basic Steam Turbine
			RecipeUtils.addShapedGregtechRecipe(
					CI.getTieredComponent(OrePrefixes.pipeSmall, 0, 1), "circuitPrimitive", CI.getTieredComponent(OrePrefixes.pipeSmall, 0, 1),
					ALLOY.TUMBAGA.getRotor(1), CI.machineCasing_ULV, ALLOY.TUMBAGA.getRotor(1),
					CI.getElectricMotor(0, 1), "cableGt01RedAlloy", CI.getElectricMotor(0, 1),
					GregtechItemList.Generator_Steam_Turbine_ULV.get(1));

			//Basic Gas Turbine
			RecipeUtils.addShapedGregtechRecipe(
					"circuitPrimitive", ALLOY.TUMBAGA.getRotor(1), "circuitPrimitive",
					ALLOY.TUMBAGA.getRotor(1), CI.machineCasing_ULV, ALLOY.TUMBAGA.getRotor(1),
					CI.getElectricMotor(0, 1), "cableGt01RedAlloy", CI.getElectricMotor(0, 1),
					GregtechItemList.Generator_Gas_Turbine_ULV.get(1));

			//Basic Combustion Turbine
			RecipeUtils.addShapedGregtechRecipe(
					CI.getElectricPiston(0, 1), "circuitPrimitive", CI.getElectricPiston(0, 1),
					CI.getElectricMotor(0, 1), CI.machineCasing_ULV, CI.getElectricMotor(0, 1),
					ALLOY.TUMBAGA.getGear(1), "cableGt01RedAlloy", ALLOY.TUMBAGA.getGear(1),
					GregtechItemList.Generator_Diesel_ULV.get(1));



			//Steam Condenser
			if (CORE.ConfigSwitches.enableMachine_SteamConverter ){
				RECIPE_SteamCondenser = GregtechItemList.Condensor_MAX.get(1);
				RecipeUtils.addShapedGregtechRecipe(
						pipeLargeCopper, pipeHugeSteel, pipeLargeCopper,
						plateEnergeticAlloy, CI.electricPump_HV, plateEnergeticAlloy,
						plateEnergeticAlloy, pipeLargeCopper, plateEnergeticAlloy,
						RECIPE_SteamCondenser);
			}

			ItemStack aBronzeBricks = ItemUtils.simpleMetaStack(GregTech_API.sBlockCasings1, 10, 1);
			// Steam Macerator Multi
			RecipeUtils.addShapedGregtechRecipe(
					aBronzeBricks, "gemDiamond", aBronzeBricks,
					"craftingPiston", ALLOY.TUMBAGA.getFrameBox(1), "craftingPiston",
					aBronzeBricks, "gemDiamond", aBronzeBricks,
					GregtechItemList.Controller_SteamMaceratorMulti.get(1));
			// Steam Compressor Multi
			RecipeUtils.addShapedGregtechRecipe(
					aBronzeBricks, "craftingPiston", aBronzeBricks,
					ALLOY.TUMBAGA.getGear(1), ALLOY.TUMBAGA.getFrameBox(1), ALLOY.TUMBAGA.getGear(1),
					aBronzeBricks, "craftingPiston", aBronzeBricks,
					GregtechItemList.Controller_SteamCompressorMulti.get(1));

			// Steam Hatch
			RecipeUtils.addShapedGregtechRecipe(
					"plateBronze", "pipeMediumBronze", "plateBronze",
					"plateBronze", GregtechItemList.GT_FluidTank_ULV.get(1), "plateBronze",
					"plateBronze", "pipeMediumBronze", "plateBronze",
					GregtechItemList.Hatch_Input_Steam.get(1));
			
			// Steam Input Bus
			RecipeUtils.addShapedGregtechRecipe(
					"plateBronze", ALLOY.TUMBAGA.getPlate(1), "plateBronze",
					"plateTin", ItemUtils.getSimpleStack(Blocks.hopper), "plateTin",
					"plateBronze", ALLOY.TUMBAGA.getPlate(1), "plateBronze",
					GregtechItemList.Hatch_Input_Bus_Steam.get(1));
			
			// Steam Output Bus
			RecipeUtils.addShapedGregtechRecipe(
					"plateBronze", "plateTin", "plateBronze",
					ALLOY.TUMBAGA.getPlate(1), ItemUtils.getSimpleStack(Blocks.hopper), ALLOY.TUMBAGA.getPlate(1),
					"plateBronze", "plateTin", "plateBronze",
					GregtechItemList.Hatch_Output_Bus_Steam.get(1));
			

			//RF Convertor
			if (LoadedMods.CoFHCore && CORE.ConfigSwitches.enableMachine_RF_Convetor){
				RecipeUtils.addShapedGregtechRecipe(
						CI.getPlate(4, 1), CI.getTieredCircuitOreDictName(5), CI.getPlate(4, 1),
						CI.getTransmissionComponent(3, 1), CI.getTieredGTPPMachineCasing(4, 1), CI.getTransmissionComponent(3, 1),
						CI.getPlate(4, 1), plateEnergeticAlloy, CI.getPlate(4, 1),
						GregtechItemList.Energy_Buffer_RF_Convertor.get(1));
			}
			
			// Egg Box			
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							CI.getNumberedAdvancedCircuit(8),
							CI.getTieredMachineHull(3),
							ItemUtils.getSimpleStack(Items.egg, 64),
							ItemUtils.getSimpleStack(ModItems.itemRope, 32),
							CI.getPlate(4, GTNH ? 16 : 8)
					}, 
					FluidUtils.getFluidStack("mobessence", 4096), 
					ItemUtils.getSimpleStack(ModBlocks.blockEggBox, 1),
					20 * 60, 
					480);
			
			//Flask Configurator
			if (Meta_GT_Proxy.sDoesVolumetricFlaskExist) {				
				CORE.RA.addSixSlotAssemblingRecipe(
						new ItemStack[] {
								CI.getNumberedAdvancedCircuit(8),
								CI.getTieredMachineHull(2),
								ItemUtils.getSimpleStack(ModBlocks.blockCircuitProgrammer),
								VolumetricFlaskHelper.getVolumetricFlask(8),
								CI.getTieredComponent(OrePrefixes.pipeSmall, 2, GTNH ? 4 : 2),
								CI.getPlate(2, GTNH ? 8 : 4)
						}, 
						CI.getAlternativeTieredFluid(1, 144 * 8), 
						ItemUtils.getSimpleStack(ModBlocks.blockVolumetricFlaskSetter, 1),
						20 * 60, 
						120);
			}


			if (CORE.ConfigSwitches.enableMultiblock_IronBlastFurnace){

				RECIPE_IronBlastFurnace = GregtechItemList.Machine_Iron_BlastFurnace.get(1);
				RECIPE_IronPlatedBricks = GregtechItemList.Casing_IronPlatedBricks.get(Casing_Amount);

				//Iron BF
				RecipeUtils.addShapedGregtechRecipe(
						"plateDoubleAnyIron", "craftingFurnace", "plateDoubleAnyIron",
						boiler_Coal, CI.machineCasing_ULV, boiler_Coal,
						"plateDoubleAnyIron", "bucketLava", "plateDoubleAnyIron",
						RECIPE_IronBlastFurnace);
				//Iron plated Bricks
				RecipeUtils.addShapedGregtechRecipe(
						"plateAnyIron", RECIPES_Tools.craftingToolHardHammer, "plateAnyIron",
						"plateAnyIron", blockBricks, "plateAnyIron",
						"plateAnyIron", RECIPES_Tools.craftingToolWrench, "plateAnyIron",
						RECIPE_IronPlatedBricks);

				//Add recycle recipes for the Iron Plated Bricks
				//GT_ModHandler.addPulverisationRecipe(RECIPE_IronPlatedBricks, ItemUtils.getItemStackOfAmountFromOreDictNoBroken("dustIron", 6), ItemUtils.getItemStackOfAmountFromOreDictNoBroken("dustClay", 2), true);
				CORE.RA.addPulverisationRecipe(
						RECIPE_IronPlatedBricks,
						ItemUtils.getItemStackOfAmountFromOreDictNoBroken("dustIron", 6),
						ItemUtils.getItemStackOfAmountFromOreDictNoBroken("dustClay", 2),
						null);
				GT_Values.RA.addArcFurnaceRecipe(RECIPE_IronPlatedBricks, new ItemStack[]{ItemUtils.getItemStackOfAmountFromOreDictNoBroken("ingotWroughtIron", 6), ItemUtils.getItemStackOfAmountFromOreDictNoBroken("dustAsh", 2)}, new int[]{0}, 32*20, 32);
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialCentrifuge){
				//Industrial Centrifuge
				RECIPE_IndustrialCentrifugeController = GregtechItemList.Industrial_Centrifuge.get(1);
				RECIPE_IndustrialCentrifugeCasing = GregtechItemList.Casing_Centrifuge1.get(Casing_Amount);

				//Industrial Centrifuge
				RecipeUtils.addShapedGregtechRecipe(
						CI.circuitTier5, pipeHugeStainlessSteel, CI.circuitTier5,
						CI.component_Plate[6], EV_MACHINE_Centrifuge, CI.component_Plate[6],
						CI.component_Plate[8], CI.machineCasing_IV, CI.component_Plate[8],
						RECIPE_IndustrialCentrifugeController);
				//Centrifuge Casing
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[6], "stickTumbaga", CI.component_Plate[6],
						CI.component_Plate[8], "stickTumbaga", CI.component_Plate[8],
						CI.component_Plate[6], "stickTumbaga", CI.component_Plate[6],
						RECIPE_IndustrialCentrifugeCasing);
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialCokeOven){
				//Industrial Coke Oven
				RECIPE_IndustrialCokeOvenController = GregtechItemList.Industrial_CokeOven.get(1);
				RECIPE_IndustrialCokeOvenFrame = GregtechItemList.Casing_CokeOven.get(Casing_Amount);
				RECIPE_IndustrialCokeOvenCasingA = GregtechItemList.Casing_CokeOven_Coil1.get(Casing_Amount);
				RECIPE_IndustrialCokeOvenCasingB = GregtechItemList.Casing_CokeOven_Coil2.get(Casing_Amount);

				if (LoadedMods.Railcraft){
					//Industrial Coke Oven
					RecipeUtils.addShapedGregtechRecipe(
							plateCobalt, CI.circuitTier4, plateCobalt,
							CI.machineCasing_HV, INPUT_RCCokeOvenBlock, CI.machineCasing_HV,
							plateCobalt, CI.circuitTier5, plateCobalt,
							RECIPE_IndustrialCokeOvenController);
				}
				if (LoadedMods.ImmersiveEngineering){
					//Industrial Coke Oven
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[8], CI.circuitTier4, CI.component_Plate[8],
							CI.machineCasing_HV, INPUT_IECokeOvenBlock, CI.machineCasing_HV,
							CI.component_Plate[8], CI.circuitTier3, CI.component_Plate[8],
							RECIPE_IndustrialCokeOvenController);
				}
				//Coke Oven Frame Casing
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[7], CI.component_Rod[7], CI.component_Plate[7],
						CI.component_Rod[7], "frameGtTantalloy61", CI.component_Rod[7],
						CI.component_Plate[7], CI.component_Rod[7], CI.component_Plate[7],
						RECIPE_IndustrialCokeOvenFrame);
				//Coke Oven Coil 1
				RecipeUtils.addShapedGregtechRecipe(
						plateBronze, plateBronze, plateBronze,
						"frameGtBronze", CI.gearboxCasing_Tier_1, "frameGtBronze",
						plateBronze, plateBronze, plateBronze,
						RECIPE_IndustrialCokeOvenCasingA);
				//Coke Oven Coil 2
				RecipeUtils.addShapedGregtechRecipe(
						plateSteel, plateSteel, plateSteel,
						"frameGtSteel", CI.gearboxCasing_Tier_2, "frameGtSteel",
						plateSteel, plateSteel, plateSteel,
						RECIPE_IndustrialCokeOvenCasingB);
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialElectrolyzer){
				//Industrial Electrolyzer
				RECIPE_IndustrialElectrolyzerController = GregtechItemList.Industrial_Electrolyzer.get(1);
				RECIPE_IndustrialElectrolyzerFrame = GregtechItemList.Casing_Electrolyzer.get(Casing_Amount);

				//Electrolyzer Frame Casing
				RecipeUtils.addShapedGregtechRecipe(
						"platePotin", "stickLongChrome", "platePotin",
						"stickLongPotin", "frameGtPotin", "stickLongPotin",
						"platePotin", "stickLongPotin", "platePotin",
						RECIPE_IndustrialElectrolyzerFrame);
				//Industrial Electrolyzer
				RecipeUtils.addShapedGregtechRecipe(
						"plateStellite", CI.circuitTier5, "plateStellite",
						CI.machineCasing_EV, EV_MACHINE_Electrolyzer, CI.machineCasing_EV,
						"plateStellite", "rotorStellite", "plateStellite",
						RECIPE_IndustrialElectrolyzerController);
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialPlatePress){
				//Industrial Material Press
				RECIPE_IndustrialMaterialPressController = GregtechItemList.Industrial_PlatePress.get(1);
				RECIPE_IndustrialMaterialPressFrame = GregtechItemList.Casing_MaterialPress.get(Casing_Amount);

				//Material Press Frame Casing
				RecipeUtils.addShapedGregtechRecipe(
						"plateTitanium", "stickLongTumbaga", "plateTitanium",
						"stickTantalloy60", "frameGtTumbaga", "stickTantalloy60",
						"plateTitanium", "stickLongTumbaga", "plateTitanium",
						RECIPE_IndustrialMaterialPressFrame);
				//Industrial Material Press
				RecipeUtils.addShapedGregtechRecipe(
						"plateTitanium", CI.circuitTier5, "plateTitanium",
						CI.machineCasing_EV, EV_MACHINE_BendingMachine, CI.machineCasing_EV,
						"plateTitanium", CI.circuitTier5, "plateTitanium",
						RECIPE_IndustrialMaterialPressController);
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialMacerationStack){
				//Industrial Maceration Stack
				RECIPE_IndustrialMacerationStackController = GregtechItemList.Industrial_MacerationStack.get(1);
				RECIPE_IndustrialMacerationStackFrame = GregtechItemList.Casing_MacerationStack.get(Casing_Amount);

				//Maceration Frame Casing
				RecipeUtils.addShapedGregtechRecipe(
						"platePalladium", "platePalladium", "platePalladium",
						"stickPlatinum", "frameGtInconel625", "stickPlatinum",
						"platePalladium", "stickLongPalladium", "platePalladium",
						RECIPE_IndustrialMacerationStackFrame);
				//Industrial Maceration stack
				RecipeUtils.addShapedGregtechRecipe(
						"plateTungstenCarbide", EV_MACHINE_Macerator, "plateTungstenCarbide",
						HV_MACHINE_Macerator, CI.circuitTier7, HV_MACHINE_Macerator,
						"plateTungstenCarbide", CI.machineCasing_IV, "plateTungstenCarbide",
						RECIPE_IndustrialMacerationStackController);
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialWireMill){
				//Industrial Wire Factory
				RECIPE_IndustrialWireFactoryController = GregtechItemList.Industrial_WireFactory.get(1);
				RECIPE_IndustrialWireFactoryFrame = GregtechItemList.Casing_WireFactory.get(Casing_Amount);

				//Wire Factory Frame Casing
				RecipeUtils.addShapedGregtechRecipe(
						"plateBlueSteel", "stickBlueSteel", "plateBlueSteel",
						"stickBlueSteel", "frameGtBlueSteel", "stickBlueSteel",
						"plateBlueSteel", "stickBlueSteel", "plateBlueSteel",
						RECIPE_IndustrialWireFactoryFrame);
				//Industrial Wire Factory
				RecipeUtils.addShapedGregtechRecipe(
						"plateZeron100", CI.machineCasing_IV, "plateZeron100",
						CI.circuitTier5, EV_MACHINE_Wiremill, CI.circuitTier5,
						"plateZeron100", CI.machineCasing_IV, "plateZeron100",
						RECIPE_IndustrialWireFactoryController);
			}



			//Tiered Tanks
			if (CORE.ConfigSwitches.enableMachine_FluidTanks){
				Logger.WARNING("Is New Horizons Loaded? "+GTNH);
				if (!GTNH){
					
					// Allows clearing stored fluids.
					GregtechItemList[] aTanks = new GregtechItemList[] {
							GregtechItemList.GT_FluidTank_ULV, GregtechItemList.GT_FluidTank_LV, GregtechItemList.GT_FluidTank_MV,
							GregtechItemList.GT_FluidTank_HV, GregtechItemList.GT_FluidTank_EV, GregtechItemList.GT_FluidTank_IV,
							GregtechItemList.GT_FluidTank_LuV, GregtechItemList.GT_FluidTank_ZPM, GregtechItemList.GT_FluidTank_UV,
							GregtechItemList.GT_FluidTank_MAX};
					for (GregtechItemList aTank : aTanks) {
						RecipeUtils.addShapedGregtechRecipe(
								aTank.get(1), null, null,
								null, null, null,
								null, null, null,
								aTank.get(1));
					}	
					
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[1], CI.component_Plate[1], CI.component_Plate[1],
							CI.component_Plate[1], pipeTier1, CI.component_Plate[1],
							CI.component_Plate[1], GregtechItemList.Fluid_Cell_144L.get(1), CI.component_Plate[1],
							GregtechItemList.GT_FluidTank_ULV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[2], CI.component_Plate[2], CI.component_Plate[2],
							CI.component_Plate[2], pipeTier2, CI.component_Plate[2],
							CI.component_Plate[2], CI.electricPump_LV, CI.component_Plate[2],
							GregtechItemList.GT_FluidTank_LV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[3], CI.component_Plate[3], CI.component_Plate[3],
							CI.component_Plate[3], pipeTier3, CI.component_Plate[3],
							CI.component_Plate[3], CI.electricPump_MV, CI.component_Plate[3],
							GregtechItemList.GT_FluidTank_MV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[4], CI.component_Plate[4], CI.component_Plate[4],
							CI.component_Plate[4], pipeTier4, CI.component_Plate[4],
							CI.component_Plate[4], CI.electricPump_HV, CI.component_Plate[4],
							GregtechItemList.GT_FluidTank_HV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[5], CI.component_Plate[5], CI.component_Plate[5],
							CI.component_Plate[5], pipeTier5, CI.component_Plate[5],
							CI.component_Plate[5], CI.electricPump_EV, CI.component_Plate[5],
							GregtechItemList.GT_FluidTank_EV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[6], CI.component_Plate[6], CI.component_Plate[6],
							CI.component_Plate[6], pipeTier6, CI.component_Plate[6],
							CI.component_Plate[6], CI.electricPump_IV, CI.component_Plate[6],
							GregtechItemList.GT_FluidTank_IV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[7], CI.component_Plate[7], CI.component_Plate[7],
							CI.component_Plate[7], pipeTier7, CI.component_Plate[7],
							CI.component_Plate[7], CI.electricPump_LuV, CI.component_Plate[7],
							GregtechItemList.GT_FluidTank_LuV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[8], CI.component_Plate[8], CI.component_Plate[8],
							CI.component_Plate[8], pipeTier8, CI.component_Plate[8],
							CI.component_Plate[8], CI.electricPump_ZPM, CI.component_Plate[8],
							GregtechItemList.GT_FluidTank_ZPM.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[9], CI.component_Plate[9], CI.component_Plate[9],
							CI.component_Plate[9], pipeTier9, CI.component_Plate[9],
							CI.component_Plate[9], CI.electricPump_UV, CI.component_Plate[9],
							GregtechItemList.GT_FluidTank_UV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[10], CI.component_Plate[10], CI.component_Plate[10],
							CI.component_Plate[10], pipeTier10, CI.component_Plate[10],
							CI.component_Plate[10], CI.electricPump_MAX, CI.component_Plate[10],
							GregtechItemList.GT_FluidTank_MAX.get(1));
				}
				else {

					CI.component_Plate[1] = "plateTin";
					pipeTier1 = "pipeLargeClay";
					CI.circuitTier1 = ItemList.Circuit_Primitive.get(1);
					CI.component_Plate[2] = "plateCopper";
					pipeTier2 = "pipeHugeClay";
					CI.component_Plate[3] = "plateBronze";
					pipeTier3 = "pipeMediumBronze";
					CI.component_Plate[4] = "plateIron";
					pipeTier4 = "pipeMediumSteel";
					CI.component_Plate[5] = "plateSteel";
					CI.component_Plate[6] = "plateRedstone";
					CI.component_Plate[7] = "plateAluminium";
					CI.component_Plate[8] = "plateDarkSteel";
					ItemStack waterBucket = ItemUtils.getSimpleStack(Items.water_bucket);

					// Allows clearing stored fluids.
					GregtechItemList[] aTanks = new GregtechItemList[] {GregtechItemList.GT_FluidTank_ULV, GregtechItemList.GT_FluidTank_LV, GregtechItemList.GT_FluidTank_MV, GregtechItemList.GT_FluidTank_HV};
					for (GregtechItemList aTank : aTanks) {
						RecipeUtils.addShapedGregtechRecipe(
								aTank.get(1), null, null,
								null, null, null,
								null, null, null,
								aTank.get(1));
					}					
					
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[1], CI.component_Plate[5], CI.component_Plate[1],
							CI.component_Plate[4], pipeTier1, CI.component_Plate[4],
							CI.component_Plate[4], waterBucket, CI.component_Plate[4],
							GregtechItemList.GT_FluidTank_ULV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[5], CI.component_Plate[4], CI.component_Plate[5],
							CI.component_Plate[3], pipeTier2, CI.component_Plate[3],
							CI.component_Plate[3], CI.electricPump_LV, CI.component_Plate[3],
							GregtechItemList.GT_FluidTank_LV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.component_Plate[8], CI.component_Plate[3], CI.component_Plate[8],
							CI.component_Plate[5], pipeTier3, CI.component_Plate[5],
							CI.component_Plate[5], CI.electricPump_LV, CI.component_Plate[5],
							GregtechItemList.GT_FluidTank_MV.get(1));
					RecipeUtils.addShapedGregtechRecipe(
							CI.circuitTier1, CI.component_Plate[7], CI.circuitTier1,
							CI.component_Plate[8], pipeTier4, CI.component_Plate[8],
							CI.circuitTier1, CI.electricPump_MV, CI.circuitTier1,
							GregtechItemList.GT_FluidTank_HV.get(1));
				}
			}

			if (CORE.ConfigSwitches.enableMultiblock_MultiTank){
				//Industrial Multi Tank
				//RECIPE_IndustrialMultiTankController = GregtechItemList.Industrial_MultiTank.get(1);
				RECIPE_IndustrialMultiTankFrame = GregtechItemList.Casing_MultitankExterior.get(Casing_Amount);

				//Industrial Multi Tank Casing
				RecipeUtils.addShapedGregtechRecipe(
						"stickGrisium", "plateGrisium", "stickGrisium",
						"plateGrisium", "frameGtGrisium", "plateGrisium",
						"plateGrisium", "plateGrisium", "plateGrisium",
						RECIPE_IndustrialMultiTankFrame);
				//Industrial Multi Tank
				RecipeUtils.addShapedGregtechRecipe(
						"pipeHugeTantalloy60", "gearGrisium", "pipeHugeTantalloy60",
						CI.circuitTier4, RECIPE_IndustrialMultiTankFrame, CI.circuitTier4,
						"plateDoubleGrisium", "rotorGrisium", "plateDoubleGrisium",
						RECIPE_IndustrialMultiTankController);
			}
			//TODO

			//Semi-Fluid Generators			
			ItemStack[][] aSemiFluidInputs = new ItemStack[3][6];
			aSemiFluidInputs[0] = new ItemStack[]{
					CI.getNumberedBioCircuit(14),
					CI.getTieredMachineHull(1, 1),
					CI.getElectricPiston(1, GTNH ? 4 : 2),
					CI.getTieredComponent(OrePrefixes.circuit, 1, GTNH ? 4 : 2),
					CI.getPlate(1, GTNH ? 8 : 4),
					CI.getGear(1, GTNH ? 4 : 2)
			};
			aSemiFluidInputs[1] = new ItemStack[]{
					CI.getNumberedCircuit(14),
					CI.getTieredMachineHull(2, 1),
					CI.getElectricPiston(2, GTNH ? 4 : 2),
					CI.getTieredComponent(OrePrefixes.circuit, 2, GTNH ? 4 : 2),
					CI.getPlate(2, GTNH ? 8 : 4),
					CI.getGear(2, GTNH ? 4 : 2)
			};
			aSemiFluidInputs[2] = new ItemStack[]{
					CI.getNumberedAdvancedCircuit(14),
					CI.getTieredMachineHull(3, 1),
					CI.getElectricPiston(3, GTNH ? 4 : 2),
					CI.getTieredComponent(OrePrefixes.circuit, 3, GTNH ? 4 : 2),
					CI.getPlate(3, GTNH ? 8 : 4),
					CI.getGear(3, GTNH ? 4 : 2)
			};
			FluidStack[] aSemiFluidFluidInputs = new FluidStack[] {
					ALLOY.BRONZE.getFluidStack(144 * 8),
					ALLOY.STEEL.getFluidStack(144 * 8),
					ELEMENT.getInstance().ALUMINIUM.getFluidStack(144 * 8),
			};

			//ItemUtils.simpleMetaStack("IC2:blockGenerator:7", 7, 1);			
			ItemStack[] aSemifluids = new ItemStack[] {GregtechItemList.Generator_SemiFluid_LV.get(1), GregtechItemList.Generator_SemiFluid_MV.get(1), GregtechItemList.Generator_SemiFluid_HV.get(1)};
			for (int o=0;o<3;o++) {
				CORE.RA.addSixSlotAssemblingRecipe(
						aSemiFluidInputs[o],
						aSemiFluidFluidInputs[o],
						aSemifluids[o],
						20 * 30,
						MaterialUtils.getVoltageForTier(o+1));
			}			

			if (CORE.ConfigSwitches.enableMultiblock_AlloyBlastSmelter){
				//Industrial Blast Smelter
				RECIPE_IndustrialBlastSmelterController = GregtechItemList.Industrial_AlloyBlastSmelter.get(1);
				RECIPE_IndustrialBlastSmelterFrame = GregtechItemList.Casing_BlastSmelter.get(Casing_Amount);
				RECIPE_IndustrialBlastSmelterCoil = GregtechItemList.Casing_Coil_BlastSmelter.get(Casing_Amount);
				RECIPE_IndustrialMegaBlastSmelterController = GregtechItemList.Industrial_MegaAlloyBlastSmelter.get(1);

				//Blast Smelter
				RecipeUtils.addShapedGregtechRecipe(
						"plateZirconiumCarbide", CI.circuitTier4, "plateZirconiumCarbide",
						cableTier4, EV_MACHINE_AlloySmelter, cableTier4,
						"plateZirconiumCarbide", CI.circuitTier3, "plateZirconiumCarbide",
						RECIPE_IndustrialBlastSmelterController);
				//Blast Smelter Frame Casing
				RecipeUtils.addShapedGregtechRecipe(
						"plateZirconiumCarbide", CI.component_Rod[5], "plateZirconiumCarbide",
						CI.component_Rod[5], "frameGtTumbaga", CI.component_Rod[5],
						"plateZirconiumCarbide", CI.component_Rod[5], "plateZirconiumCarbide",
						RECIPE_IndustrialBlastSmelterFrame);
				//Blast Smelter Coil
				RecipeUtils.addShapedGregtechRecipe(
						"plateStaballoy", "plateStaballoy", "plateStaballoy",
						"frameGtStaballoy", CI.gearboxCasing_Tier_3, "frameGtStaballoy",
						"plateStaballoy", "plateStaballoy", "plateStaballoy",
						RECIPE_IndustrialBlastSmelterCoil);
				//Mega Blast Smelter (Blazing Blast Smelter Controller)
				RecipeUtils.addShapedGregtechRecipe(
						"plateZirconiumCarbide", CI.circuitTier4, "plateZirconiumCarbide",
						cableTier4, EV_MACHINE_AlloySmelter, cableTier4,
						"plateZirconiumCarbide", CI.circuitTier3, "plateZirconiumCarbide",
						RECIPE_IndustrialMegaBlastSmelterController);
			}

			if (CORE.ConfigSwitches.enableMultiblock_MatterFabricator){
				//Industrial Matter Fabricator
				RECIPE_IndustrialMatterFabController = GregtechItemList.Industrial_MassFab.get(1);
				RECIPE_IndustrialMatterFabFrame = GregtechItemList.Casing_MatterFab.get(Casing_Amount);
				RECIPE_IndustrialMatterFabCoil = GregtechItemList.Casing_MatterGen.get(Casing_Amount);

				//Matter Fabricator CPU
				RecipeUtils.addShapedGregtechRecipe(
						CI.getDoublePlate(8, 1), CI.circuitTier5, CI.getPlate(8, 1),
						cableTier8, CI.machineCasing_LuV, cableTier8,
						CI.getPlate(8, 1), CI.circuitTier5, CI.getPlate(8, 1),
						RECIPE_IndustrialMatterFabController);
				//Matter Fabricator Frame Casing
				RecipeUtils.addShapedGregtechRecipe(
						"plateNiobiumCarbide", CI.component_Rod[8], "plateNiobiumCarbide",
						CI.component_Rod[8], "frameGtInconel690", CI.component_Rod[8],
						"plateNiobiumCarbide", CI.component_Rod[8], "plateNiobiumCarbide",
						RECIPE_IndustrialMatterFabFrame);
				//Matter Fabricator Coil
				RecipeUtils.addShapedGregtechRecipe(
						CI.getPlate(6, 1), CI.getPlate(7, 1), CI.getPlate(6, 1),
						"frameGtStellite", CI.machineCasing_UV, "frameGtStellite",
						CI.getPlate(6, 1), CI.getPlate(7, 1), CI.getPlate(6, 1),
						RECIPE_IndustrialMatterFabCoil);
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialSifter){
				//Industrial Sieve
				RECIPE_IndustrialSieveController = GregtechItemList.Industrial_Sifter.get(1);
				RECIPE_IndustrialSieveFrame = GregtechItemList.Casing_Sifter.get(Casing_Amount);
				RECIPE_IndustrialSieveGrate = GregtechItemList.Casing_SifterGrate.get(Casing_Amount);

				//Industrial Sieve
				RecipeUtils.addShapedGregtechRecipe(
						"plateEglinSteel", CI.circuitTier3, "plateEglinSteel",
						cableTier4, EV_MACHINE_Sifter, cableTier4,
						"plateEglinSteel", CI.circuitTier3, "plateEglinSteel",
						RECIPE_IndustrialSieveController);
				//Industrial Sieve Casing
				RecipeUtils.addShapedGregtechRecipe(
						"plateEglinSteel", "plateEglinSteel", "plateEglinSteel",
						"plateEglinSteel", "frameGtTumbaga", "plateEglinSteel",
						"plateEglinSteel", "plateEglinSteel", "plateEglinSteel",
						RECIPE_IndustrialSieveFrame);
				//Industrial Sieve Grate
				RecipeUtils.addShapedGregtechRecipe(
						"frameGtEglinSteel", "wireFineSteel", "frameGtEglinSteel",
						"wireFineSteel", "wireFineSteel", "wireFineSteel",
						"frameGtEglinSteel", "wireFineSteel", "frameGtEglinSteel",
						RECIPE_IndustrialSieveGrate);
			}

			if (CORE.ConfigSwitches.enableMultiblock_TreeFarmer){
				//Industrial Tree Farmer
				RECIPE_TreeFarmController = GregtechItemList.Industrial_TreeFarm.get(1);
				RECIPE_TreeFarmFrame = GregtechItemList.Casing_PLACEHOLDER_TreeFarmer.get(Casing_Amount);
				//Industrial Tree Farm Controller
				if (!GTNH) {
					RecipeUtils.addShapedGregtechRecipe(
							"plateEglinSteel", "rotorEglinSteel", "plateEglinSteel",
							"cableGt02Steel", "pipeMediumSteel", "cableGt02Steel",
							"plateEglinSteel", CI.machineCasing_MV, "plateEglinSteel",
							RECIPE_TreeFarmController);
				}
				else {
					RecipeUtils.addShapedGregtechRecipe(
							"plateEglinSteel", "rotorEglinSteel", "plateEglinSteel",
							"cableGt02Silver", "pipeMediumStainlessSteel", "cableGt02Silver",
							"plateEglinSteel", CI.machineCasing_HV, "plateEglinSteel",
							RECIPE_TreeFarmController);
				}
				//Industrial Tree Farm Frame
				RecipeUtils.addShapedGregtechRecipe(
						ItemUtils.getSimpleStack(Blocks.dirt), ItemUtils.getSimpleStack(Blocks.dirt), ItemUtils.getSimpleStack(Blocks.dirt),
						"plankWood", "frameGtTumbaga", "plankWood",
						"plankWood", "plankWood", "plankWood",
						RECIPE_TreeFarmFrame);
			}

			if (CORE.ConfigSwitches.enableMachine_Tesseracts){
				//Tesseracts
				RECIPE_TesseractGenerator = GregtechItemList.GT4_Tesseract_Generator.get(1);
				RECIPE_TesseractTerminal = GregtechItemList.GT4_Tesseract_Terminal.get(1);
				//Tesseract Generator
				RecipeUtils.addShapedGregtechRecipe(
						"plateTitanium","circuitMaster","plateTitanium",
						"circuitMaster",ItemUtils.getSimpleStack(Blocks.ender_chest),"circuitMaster",
						"plateTitanium",GregtechItemList.Gregtech_Computer_Cube.get(1),"plateTitanium",
						RECIPE_TesseractGenerator);
				//Tesseract Terminal
				RecipeUtils.addShapedGregtechRecipe(
						"plateTitanium","circuitElite","plateTitanium",
						"circuitElite",ItemUtils.getSimpleStack(Blocks.ender_chest),"circuitElite",
						"plateTitanium",CI.machineHull_EV,"plateTitanium",
						RECIPE_TesseractTerminal);
			}

			if (CORE.ConfigSwitches.enableMachine_SimpleWasher){
				ItemStack plateWrought = ItemUtils.getItemStackOfAmountFromOreDict("plateWroughtIron", 1);
				ItemStack washerPipe;


				if (CORE.ConfigSwitches.enableCustom_Pipes){
					washerPipe = ItemUtils.getItemStackOfAmountFromOreDict("pipeLargeClay", 1);
					RecipeUtils.addShapedGregtechRecipe(
							plateWrought, CI.electricPump_LV, plateWrought,
							plateWrought, washerPipe, plateWrought,
							plateWrought, CI.machineCasing_ULV, plateWrought,
							GregtechItemList.SimpleDustWasher_ULV.get(1));
				}
				//Add Recipe
				washerPipe = ItemUtils.getItemStackOfAmountFromOreDict("pipeLargeCopper", 1);					
				RecipeUtils.addShapedGregtechRecipe(
						plateWrought, CI.electricPump_LV, plateWrought,
						plateWrought, washerPipe, plateWrought,
						plateWrought, CI.machineCasing_ULV, plateWrought,
						GregtechItemList.SimpleDustWasher_ULV.get(1));

				int aSimpleWasherTier = 2;
				int aSlot = 0;
				ItemStack[][] aInputsForSimpleWashers = new ItemStack[4][6];

				aInputsForSimpleWashers[0] = new ItemStack[] {
						CI.getTieredMachineHull(2),
						CI.getTieredComponent(OrePrefixes.screw, 2, GTNH ? 16 : 8),
						CI.getTieredComponent(OrePrefixes.plate, 1, GTNH ? 8 : 4),
						CI.getTieredComponent(OrePrefixes.rod, 2, GTNH ? 4 : 2),
						CI.getTieredComponent(OrePrefixes.circuit, 2, GTNH ? 3 : 1),

				};
				aInputsForSimpleWashers[1] = new ItemStack[] {
						CI.getTieredMachineHull(4),
						CI.getTieredComponent(OrePrefixes.screw, 4, GTNH ? 24 : 12),
						CI.getTieredComponent(OrePrefixes.plate, 3, GTNH ? 12 : 6),
						CI.getTieredComponent(OrePrefixes.rod, 4, GTNH ? 6 : 3),
						CI.getTieredComponent(OrePrefixes.circuit, 4, GTNH ? 4 : 2),

				};
				aInputsForSimpleWashers[2] = new ItemStack[] {
						CI.getTieredMachineHull(6),
						CI.getTieredComponent(OrePrefixes.screw, 6, GTNH ? 48 : 24),
						CI.getTieredComponent(OrePrefixes.plate, 5, GTNH ? 16 : 8),
						CI.getTieredComponent(OrePrefixes.rod, 6, GTNH ? 8 : 4),
						CI.getTieredComponent(OrePrefixes.circuit, 6, GTNH ? 6 : 3),

				};
				aInputsForSimpleWashers[3] = new ItemStack[] {
						CI.getTieredMachineHull(8),
						CI.getTieredComponent(OrePrefixes.screw, 8, GTNH ? 64 : 32),
						CI.getTieredComponent(OrePrefixes.plate, 7, GTNH ? 32 : 16),
						CI.getTieredComponent(OrePrefixes.rod, 8, GTNH ? 10 : 5),
						CI.getTieredComponent(OrePrefixes.circuit, 8, GTNH ? 8 : 4),

				};






				ItemStack[] aSimpleWashers = new ItemStack[] {GregtechItemList.SimpleDustWasher_MV.get(1), GregtechItemList.SimpleDustWasher_EV.get(1), GregtechItemList.SimpleDustWasher_LuV.get(1), GregtechItemList.SimpleDustWasher_UV.get(1)};
				for (int i=0;i<4;i++) {

					CORE.RA.addSixSlotAssemblingRecipe(
							aInputsForSimpleWashers[aSlot],
							CI.getTieredFluid(aSimpleWasherTier, 144 * aSimpleWasherTier), 
							aSimpleWashers[aSlot], 
							20 * 15 * aSimpleWasherTier,
							(int) GT_Values.V[aSimpleWasherTier]);

					aSimpleWasherTier += 2;
					aSlot++;
				}
			}

			if (CORE.ConfigSwitches.enableMachine_Pollution && PollutionUtils.isPollutionEnabled()){

				RecipeUtils.addShapedGregtechRecipe(
						"plateCarbon", "plateCarbon", "plateCarbon",
						"dustCarbon", "dustCarbon", "dustCarbon",
						"plateCarbon", "plateCarbon", "plateCarbon",
						ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 0, 1));

				RecipeUtils.addShapedGregtechRecipe(
						"plateCarbon", "plateCarbon", "plateCarbon",
						"cellLithiumPeroxide", "dustCarbon", "cellLithiumPeroxide",
						"plateCarbon", "plateCarbon", "plateCarbon",
						ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 1, 1));

				//Pollution Detector
				RecipeUtils.addShapedGregtechRecipe(
						"plateSteel", CI.sensor_LV, "plateSteel",
						"plateSteel", CI.electricMotor_LV, "plateSteel",
						CI.getTieredCircuit(1), CI.machineHull_LV, CI.getTieredCircuit(1),
						GregtechItemList.Pollution_Detector.get(1));

				//ULV
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[0], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 0, 1), CI.component_Plate[0],
						CI.component_Plate[0], CI.electricMotor_ULV, CI.component_Plate[0],
						CI.getTieredCircuit(0), CI.machineHull_ULV, CI.getTieredCircuit(0),
						GregtechItemList.Pollution_Cleaner_ULV.get(1));
				//LV
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[1], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 0, 1), CI.component_Plate[1],
						CI.component_Plate[1], CI.electricMotor_LV, CI.component_Plate[1],
						CI.getTieredCircuit(1), CI.machineHull_LV, CI.getTieredCircuit(1),
						GregtechItemList.Pollution_Cleaner_LV.get(1));
				//MV
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[2], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 0, 1), CI.component_Plate[2],
						CI.component_Plate[2], CI.electricMotor_MV, CI.component_Plate[2],
						CI.getTieredCircuit(2), CI.machineHull_MV, CI.getTieredCircuit(2),
						GregtechItemList.Pollution_Cleaner_MV.get(1));
				//HV
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[3], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 0, 1), CI.component_Plate[3],
						CI.component_Plate[3], CI.electricMotor_HV, CI.component_Plate[3],
						CI.getTieredCircuit(3), CI.machineHull_HV, CI.getTieredCircuit(3),
						GregtechItemList.Pollution_Cleaner_HV.get(1));
				//EV
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[4], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 0, 1), CI.component_Plate[4],
						CI.component_Plate[4], CI.electricMotor_EV, CI.component_Plate[4],
						CI.getTieredCircuit(4), CI.machineHull_EV, CI.getTieredCircuit(4),
						GregtechItemList.Pollution_Cleaner_EV.get(1));
				//IV
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[5], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 1, 1), CI.component_Plate[5],
						CI.component_Plate[5], CI.electricMotor_IV, CI.component_Plate[5],
						CI.getTieredCircuit(5), CI.machineHull_IV, CI.getTieredCircuit(5),
						GregtechItemList.Pollution_Cleaner_IV.get(1));
				//LuV
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[6], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 1, 1), CI.component_Plate[6],
						CI.component_Plate[6], CI.electricMotor_LuV, CI.component_Plate[6],
						CI.getTieredCircuit(6), CI.machineHull_LuV, CI.getTieredCircuit(6),
						GregtechItemList.Pollution_Cleaner_LuV.get(1));
				//ZPM
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[7], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 1, 1), CI.component_Plate[7],
						CI.component_Plate[7], CI.electricMotor_ZPM, CI.component_Plate[7],
						CI.getTieredCircuit(7), CI.machineHull_ZPM, CI.getTieredCircuit(7),
						GregtechItemList.Pollution_Cleaner_ZPM.get(1));
				//UV
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[8], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 1, 1), CI.component_Plate[8],
						CI.component_Plate[8], CI.electricMotor_UV, CI.component_Plate[8],
						CI.getTieredCircuit(8), CI.machineHull_UV, CI.getTieredCircuit(8),
						GregtechItemList.Pollution_Cleaner_UV.get(1));
				//MAX
				RecipeUtils.addShapedGregtechRecipe(
						CI.component_Plate[9], ItemUtils.simpleMetaStack(ModItems.itemAirFilter, 1, 1), CI.component_Plate[9],
						CI.component_Plate[9], CI.electricMotor_MAX, CI.component_Plate[9],
						CI.getTieredCircuit(9), CI.machineHull_MAX, CI.getTieredCircuit(9),
						GregtechItemList.Pollution_Cleaner_MAX.get(1));


			}

			if (CORE.ConfigSwitches.enableMultiblock_ThermalBoiler){
				RECIPE_ThermalBoilerController = GregtechItemList.GT4_Thermal_Boiler.get(1);
				RECIPE_ThermalBoilerCasing = GregtechItemList.Casing_ThermalContainment.get(GTNH ? 1 : 2);
				ItemStack centrifugeHV = GTNH ? ItemList.Machine_IV_Centrifuge.get(1) : ItemList.Machine_EV_Centrifuge.get(1);

				RecipeUtils.addShapedGregtechRecipe(
						"craftingGeothermalGenerator", centrifugeHV, "craftingGeothermalGenerator",
						"gearGtTitanium", CI.getTieredCircuitOreDictName(6), "gearGtTitanium",
						"craftingGeothermalGenerator", centrifugeHV, "craftingGeothermalGenerator",
						RECIPE_ThermalBoilerController);

				RecipeUtils.addShapedGregtechRecipe(
						"craftingGeothermalGenerator", centrifugeHV, "craftingGeothermalGenerator",
						"gearGtTungstenSteel", CI.getTieredCircuitOreDictName(5), "gearGtTungstenSteel",
						"craftingGeothermalGenerator", centrifugeHV, "craftingGeothermalGenerator",
						RECIPE_ThermalBoilerController);

				RecipeUtils.addShapedGregtechRecipe(
						ALLOY.MARAGING350.getPlate(1), "plateStainlessSteel", ALLOY.MARAGING350.getPlate(1),
						"circuitAdvanced", CI.machineCasing_HV, "circuitAdvanced",
						ALLOY.MARAGING350.getPlate(1), ALLOY.MARAGING350.getPlate(1), ALLOY.MARAGING350.getPlate(1),
						RECIPE_ThermalBoilerCasing);

				//Lava Filter Recipe
				CORE.RA.addSixSlotAssemblingRecipe(new ItemStack[] {
						CI.getNumberedCircuit(18),
						ItemUtils.getItemStackOfAmountFromOreDict("dustCarbon", GTNH ? 64 : 32),
						ItemUtils.getItemStackOfAmountFromOreDict("wireFineSteel", GTNH ? 64 : 32),
						ItemUtils.getItemStackOfAmountFromOreDict("ringTumbaga", GTNH ? 32 : 16),
						ItemUtils.getItemStackOfAmountFromOreDict("foilCopper", GTNH ? 8 : 4),
						ItemUtils.getItemStackWithMeta(LoadedMods.IndustrialCraft2, "IC2:itemPartCarbonMesh", "RawCarbonMesh", 0, 64),

				},
						CI.getTieredFluid(3, 144), 
						ItemUtils.getSimpleStack(ModItems.itemLavaFilter, GTNH ? 8 : 16), 
						1600,
						240
						);
			}

			//Air Intake Hatch
			ItemList FluidRegulator_IV = ItemUtils.getValueOfItemList("FluidRegulator_IV", ItemList.Pump_IV);				
			ItemStack aTieredFluidRegulator = CORE.MAIN_GREGTECH_5U_EXPERIMENTAL_FORK ? FluidRegulator_IV.get(1) : ItemList.Pump_IV.get(1);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[6], ItemList.Casing_Grate.get(1), CI.component_Plate[6],
					CI.component_Plate[6], CI.getFluidRegulator(5, 1), CI.component_Plate[6],
					CI.getTieredCircuit(5), ItemList.Hatch_Input_IV.get(1), CI.getTieredCircuit(5),
					GregtechItemList.Hatch_Air_Intake.get(1));
			
			
			RecipeUtils.addShapedGregtechRecipe(
					CI.getPlate(6, 1), ItemList.Casing_Gearbox_Titanium.get(1), CI.getPlate(6, 1),
					CI.getPlate(6, 1), CI.getFluidRegulator(5, 1), CI.getPlate(6, 1),
					CI.getTieredCircuit(6), ItemList.Hatch_Input_IV.get(1), CI.getTieredCircuit(6),
					GregtechItemList.Hatch_Reservoir.get(1));
			
			RecipeUtils.addShapedGregtechRecipe(
					CI.getPlate(7, 1), GregtechItemList.Hatch_Air_Intake.get(1), CI.getPlate(7, 1),
					CI.getPlate(7, 1), CI.getFluidRegulator(7, 1), CI.getPlate(7, 1),
					CI.getTieredCircuit(7), ItemList.Hatch_Input_ZPM.get(1), CI.getTieredCircuit(7),
					GregtechItemList.Hatch_Air_Intake_Extreme.get(1));
					
			if (CORE.ConfigSwitches.enableMultiblock_LiquidFluorideThoriumReactor){

				//Thorium Reactor
				RECIPE_LFTRController = GregtechItemList.ThoriumReactor.get(1);
				RECIPE_LFTRInnerCasing = GregtechItemList.Casing_Reactor_II.get(1); //Zeron
				RECIPE_LFTROuterCasing = GregtechItemList.Casing_Reactor_I.get(1); //Hastelloy

				ItemStack controlCircuit = ItemUtils.getSimpleStack(ModItems.itemCircuitLFTR);
				if(!GTNH) {
					RecipeUtils.addShapedGregtechRecipe(
							controlCircuit, "cableGt12NaquadahAlloy", controlCircuit,
							"plateDoubleHastelloyN", GregtechItemList.Gregtech_Computer_Cube.get(1), "plateDoubleHastelloyN",
							"plateThorium232", CI.machineHull_EV, "plateThorium232",
							RECIPE_LFTRController);
				} else  {
					RecipeUtils.addShapedGregtechRecipe(
							controlCircuit, "cableGt12Naquadah", controlCircuit,
							"plateDoubleHastelloyN", GregtechItemList.Gregtech_Computer_Cube.get(1), "plateDoubleHastelloyN",
							"plateThorium232", CI.machineHull_IV, "plateThorium232",
							RECIPE_LFTRController);
				}
				RecipeUtils.addShapedGregtechRecipe(
						"plateDoubleHastelloyC276", CI.craftingToolScrewdriver, "plateDoubleHastelloyC276",
						"gearGtTalonite", CI.fieldGenerator_MV, "gearGtTalonite",
						"plateDoubleHastelloyC276", CI.craftingToolHammer_Hard, "plateDoubleHastelloyC276",
						RECIPE_LFTRInnerCasing);

				ItemStack IC2HeatPlate = ItemUtils.getItemStackFromFQRN("IC2:reactorPlatingHeat", 1);
				RecipeUtils.addShapedGregtechRecipe(
						"plateDoubleHastelloyN", IC2HeatPlate, "plateDoubleHastelloyN",
						IC2HeatPlate, "frameGtHastelloyC276", IC2HeatPlate,
						"plateDoubleHastelloyN", IC2HeatPlate, "plateDoubleHastelloyN",
						RECIPE_LFTROuterCasing);

				//LFTR Control Circuit
				CORE.RA.addSixSlotAssemblingRecipe(new ItemStack[] {
						ItemUtils.getItemStackOfAmountFromOreDict(CI.getTieredCircuitOreDictName(6), 1),
						CI.fieldGenerator_HV
				},
						null, controlCircuit, 240*20, 500);


				//Fission Fuel Plant
				RecipeUtils.addShapedGregtechRecipe(
						CI.getTieredCircuitOreDictName(5), CI.craftingToolSolderingIron, CI.getTieredCircuitOreDictName(5),
						"plateDenseTungstenSteel", GregtechItemList.Gregtech_Computer_Cube.get(1), "plateDenseTungstenSteel",
						"gearGtStellite", CI.machineHull_IV, "gearGtStellite",
						GregtechItemList.Industrial_FuelRefinery.get(1));

				ItemStack mInnerTank;

				if (GTNH || !CORE.ConfigSwitches.enableMachine_FluidTanks){
					mInnerTank = ItemList.Quantum_Tank_LV.get(1);
				}
				else {
					mInnerTank = GregtechItemList.GT_FluidTank_EV.get(1);					
				}

				//Incoloy Casing
				RecipeUtils.addShapedGregtechRecipe(
						"plateIncoloyDS", "pipeHugeStaballoy", "plateIncoloyDS",
						"gearGtIncoloyDS", mInnerTank, "gearGtIncoloyDS",
						"plateIncoloyDS", "pipeHugeStaballoy", "plateIncoloyDS",
						GregtechItemList.Casing_Refinery_Internal.get(Casing_Amount));

				//Hastelloy-N Sealant Casing
				RecipeUtils.addShapedGregtechRecipe(
						"plateIncoloyMA956", "plateHastelloyN", "plateIncoloyMA956",
						"plateHastelloyN", "frameGtHastelloyC276", "plateHastelloyN",
						"plateIncoloyMA956", "plateHastelloyN", "plateIncoloyMA956",
						GregtechItemList.Casing_Refinery_External.get(Casing_Amount));

				//Hastelloy-X Structural Casing
				RecipeUtils.addShapedGregtechRecipe(
						"ringInconel792", "gearGtHastelloyX", CI.component_Plate[5],
						CI.craftingToolHammer_Hard, "frameGtHastelloyC276", CI.craftingToolWrench,
						CI.component_Plate[5], CI.getTieredMachineCasing(4), "ringInconel792",
						GregtechItemList.Casing_Refinery_Structural.get(Casing_Amount));				

				RecipeUtils.addShapedGregtechRecipe(
						CI.getPlate(5, 1), ALLOY.HASTELLOY_X.getPlateDouble(1), CI.getPlate(5, 1),
						CI.getPlate(5, 1), CI.getTieredMachineCasing(5), CI.getPlate(5, 1),
						CI.getRobotArm(5, 1), ItemList.Casing_FrostProof.get(1), CI.getRobotArm(5, 1),
						GregtechItemList.ColdTrap_IV.get(1));
				RecipeUtils.addShapedGregtechRecipe(
						CI.getPlate(7, 1), ALLOY.HS188A.getPlateDouble(1), CI.getPlate(7, 1),
						CI.getPlate(7, 1), GregtechItemList.ColdTrap_IV.get(1), CI.getPlate(7, 1),
						CI.getRobotArm(7, 1), ItemList.Casing_FrostProof.get(1), CI.getRobotArm(7, 1),
						GregtechItemList.ColdTrap_ZPM.get(1));

				RecipeUtils.addShapedGregtechRecipe(
						CI.getFieldGenerator(3, 1), CI.getRobotArm(5, 1), CI.getPlate(5, 1),
						ALLOY.HASTELLOY_N.getPlateDouble(1), ItemList.Machine_IV_ChemicalReactor.get(1), ALLOY.HASTELLOY_N.getPlateDouble(1),
						CI.getPlate(5, 1), ALLOY.HASTELLOY_N.getPlateDouble(1), CI.getFieldGenerator(3, 1),
						GregtechItemList.ReactorProcessingUnit_IV.get(1));
				RecipeUtils.addShapedGregtechRecipe(
						CI.getFieldGenerator(5, 1), CI.getRobotArm(7, 1), CI.getPlate(7, 1),
						ALLOY.HS188A.getPlateDouble(1), GregtechItemList.ReactorProcessingUnit_IV.get(1), ALLOY.HS188A.getPlateDouble(1),
						CI.getPlate(7, 1), ALLOY.HS188A.getPlateDouble(1), CI.getFieldGenerator(5, 1),
						GregtechItemList.ReactorProcessingUnit_ZPM.get(1));
				
			}

			//Shelves
			RecipeUtils.addShapedGregtechRecipe(
					"screwWood", "plateWood", "screwWood",
					CI.craftingToolHammer_Hard, "frameGtWood", CI.craftingToolHammer_Soft,
					"plateWood", "plateWood", "plateWood",
					GregtechItemList.GT4_Shelf.get(2));

			RecipeUtils.addShapelessGregtechRecipe(new ItemStack[] {GregtechItemList.GT4_Shelf.get(1)}, GregtechItemList.GT4_Shelf_Compartment.get(1));
			RecipeUtils.addShapelessGregtechRecipe(new ItemStack[] {GregtechItemList.GT4_Shelf_Compartment.get(1)}, GregtechItemList.GT4_Shelf_Desk.get(1));
			RecipeUtils.addShapelessGregtechRecipe(new ItemStack[] {GregtechItemList.GT4_Shelf_Desk.get(1)}, GregtechItemList.GT4_Shelf_Iron.get(1));
			RecipeUtils.addShapelessGregtechRecipe(new ItemStack[] {GregtechItemList.GT4_Shelf_Iron.get(1)}, GregtechItemList.GT4_Shelf_FileCabinet.get(1));
			RecipeUtils.addShapelessGregtechRecipe(new ItemStack[] {GregtechItemList.GT4_Shelf_FileCabinet.get(1)}, GregtechItemList.GT4_Shelf.get(1));


			//Cyclotron			
			if (CORE.ConfigSwitches.enableMultiblock_Cyclotron){
				RECIPE_CyclotronController = GregtechItemList.COMET_Cyclotron.get(1);
				RECIPE_CyclotronOuterCasing = GregtechItemList.Casing_Cyclotron_External.get(Casing_Amount);
				RECIPE_CyclotronInnerCoil = GregtechItemList.Casing_Cyclotron_Coil.get(1);

				//Outer Casing
				CORE.RA.addSixSlotAssemblingRecipe(				
						new ItemStack[] {
								ItemList.Casing_FrostProof.get(1),
								ItemUtils.simpleMetaStack("miscutils:itemDehydratorCoilWire", 0, GTNH ? 8 : 4),
								ALLOY.INCOLOY_DS.getPlate(GTNH ? 16 : 8),
								ALLOY.INCONEL_690.getScrew(GTNH ? 32 : 16),
								ALLOY.EGLIN_STEEL.getLongRod(GTNH ? 16 : 4),
								CI.getElectricPiston(3, GTNH ? 4 : 2)
						},					
						ALLOY.ZIRCONIUM_CARBIDE.getFluidStack(144 * 8), //Input Fluid					
						RECIPE_CyclotronOuterCasing,					
						30 * 20 * 2, 
						MaterialUtils.getVoltageForTier(4));


				//Inner Coil
				CORE.RA.addSixSlotAssemblingRecipe(				
						new ItemStack[] {
								ItemList.Casing_Coil_Nichrome.get(1),
								ItemUtils.simpleMetaStack("miscutils:itemDehydratorCoilWire", 1, GTNH ? 32 : 8),
								ALLOY.INCOLOY_MA956.getPlate(GTNH ? 16 : 8),
								ALLOY.TANTALLOY_61.getBolt(GTNH ? 32 : 16),
								ALLOY.INCOLOY_020.getScrew(GTNH ? 64 : 32),
								CI.getFieldGenerator(4, GTNH ? 2 : 1)
						},					
						ALLOY.HG1223.getFluidStack(144 * 5), //Input Fluid					
						RECIPE_CyclotronInnerCoil,					
						60 * 20 * 2, 
						MaterialUtils.getVoltageForTier(5));


				//Controller
				CORE.RA.addSixSlotAssemblingRecipe(				
						new ItemStack[] {
								CI.machineHull_IV,
								ItemUtils.getSimpleStack(RECIPE_CyclotronInnerCoil, GTNH ? 4 : 2),
								ALLOY.INCOLOY_020.getPlate(GTNH ? 16 : 8),
								ALLOY.TANTALLOY_61.getGear(GTNH ? 4 : 2),
								ALLOY.INCOLOY_MA956.getScrew(GTNH ? 64 : 16),
								ItemUtils.getItemStackOfAmountFromOreDict(CI.getTieredCircuitOreDictName(GTNH ? 6 : 5), GTNH ? 8 : 16)
						},					
						ALLOY.INCOLOY_020.getFluidStack(144 * 9), //Input Fluid					
						RECIPE_CyclotronController,					
						60 * 20 * 5, 
						MaterialUtils.getVoltageForTier(5));
			}

			// Mazut
			GT_ModHandler.addCraftingRecipe(
					GregtechItemList.Controller_LargeSemifluidGenerator.get(1L),
					CI.bitsd, 
					new Object[]{
							"PCP", 
							"EME", 
							"GWG",
							'M', ItemList.Hull_EV, 
							'P', ItemList.Electric_Piston_EV, 
							'E', ItemList.Electric_Pump_EV, 
							'C', OrePrefixes.circuit.get(Materials.Data), 
							'W', OrePrefixes.cableGt08.get(Materials.Electrum), 
							'G', ALLOY.INCONEL_792.getGear(1)
					});


			if (CORE.ConfigSwitches.enableMultiblock_PowerSubstation){
				RecipeUtils.addShapedRecipe(
						"screwTitanium", "plateIncoloy020", "screwTitanium",
						"plateIncoloy020", "frameGtIncoloyMA956", "plateIncoloy020",
						"screwTitanium", "plateIncoloy020", "screwTitanium",
						GregtechItemList.Casing_Power_SubStation.get(Casing_Amount));

				ItemStack mBattery = ItemUtils.getSimpleStack(ModItems.itemCircuitLFTR);

				RecipeUtils.addShapedRecipe(
						"plateIncoloyMA956", mBattery, "plateIncoloyMA956",
						GregtechItemList.Casing_Power_SubStation.get(1), GregtechItemList.Casing_Vanadium_Redox.get(1), GregtechItemList.Casing_Power_SubStation.get(1),
						"plateIncoloy020", "plateIncoloyMA956", "plateIncoloy020",
						GregtechItemList.PowerSubStation.get(1));
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialThermalCentrifuge){
				RecipeUtils.addShapedRecipe(
						"plateRedSteel", CI.craftingToolHammer_Hard, "plateRedSteel",
						"plateRedSteel", "frameGtBlackSteel", "plateRedSteel",
						"plateRedSteel", CI.craftingToolWrench, "plateRedSteel",
						GregtechItemList.Casing_ThermalCentrifuge.get(Casing_Amount));

				RecipeUtils.addShapedRecipe(
						"plateRedSteel","circuitData","plateRedSteel",
						"stickTalonite",EV_MACHINE_ThermalCentrifuge,"stickTalonite",
						"plateRedSteel","gearGtTalonite","plateRedSteel",
						GregtechItemList.Industrial_ThermalCentrifuge.get(1));
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialWashPlant){
				RecipeUtils.addShapedRecipe(
						"plateGrisium", CI.craftingToolHammer_Hard, "plateGrisium",
						"plateTalonite", "frameGtGrisium", "plateTalonite",
						"plateGrisium", CI.craftingToolWrench, "plateGrisium",
						GregtechItemList.Casing_WashPlant.get(Casing_Amount));

				RecipeUtils.addShapedRecipe( 
						"plateGrisium",CI.electricPump_MV,"plateGrisium",
						"plateTalonite",EV_MACHINE_OreWasher,"plateTalonite",
						"plateGrisium","circuitData","plateGrisium",
						GregtechItemList.Industrial_WashPlant.get(1));
			}

			if (CORE.ConfigSwitches.enableMultiblock_LargeAutoCrafter) {

				ItemStack aCoreBlock = CORE.MAIN_GREGTECH_5U_EXPERIMENTAL_FORK
						? ItemUtils.getValueOfItemList("Block_IridiumTungstensteel", 1, ItemUtils.getItemStackOfAmountFromOreDict("blockOsmiridium", 1))
								: ItemUtils.getItemStackOfAmountFromOreDict("blockOsmiridium", 1);

						aCoreBlock.stackSize = GTNH ? 2 : 1;

						CORE.RA.addSixSlotAssemblingRecipe(
								new ItemStack[] {
										ItemUtils.getSimpleStack(GregtechItemList.Casing_Multi_Use.get(1), GTNH ? 2 : 1),
										aCoreBlock, 
										CI.getTieredComponent(OrePrefixes.circuit, GTNH ? 3 : 2, 16),
										CI.getTieredComponent(OrePrefixes.screw, GTNH ? 6 : 5, 32),
										CI.getTieredComponent(OrePrefixes.bolt, GTNH ? 6 : 5, 12),
										CI.getTieredComponent(OrePrefixes.plate, GTNH ? 7 : 6, 8), },
								CI.getTertiaryTieredFluid(6, 144 * (GTNH ? 12 : 4)),
								GregtechItemList.Casing_Autocrafter.get(Casing_Amount), 20 * 60 * 2,
								MaterialUtils.getVoltageForTier(GTNH ? 6 : 5));

						CORE.RA.addSixSlotAssemblingRecipe(
								new ItemStack[] { 
										GregtechItemList.Casing_Refinery_Structural.get(4),
										ItemUtils.getSimpleStack(ModItems.itemCircuitLFTR, GTNH ? 2 : 1),
										CI.getTieredComponent(OrePrefixes.cableGt08, GTNH ? 7 : 6, GTNH ? 32 : 16),
										CI.getTransmissionComponent(GTNH ? 6 : 5, 2), 
										GregtechItemList.Gregtech_Computer_Cube.get(1),
								},
								CI.getTieredFluid(7, 144 * (GTNH ? 32 : 8)), GregtechItemList.GT4_Multi_Crafter.get(1),
								20 * 60 * 5, MaterialUtils.getVoltageForTier(GTNH ? 6 : 5));

						CORE.RA.addSixSlotAssemblingRecipe(
								new ItemStack[] {
										ItemUtils.getSimpleStack(GregtechItemList.Casing_Multi_Use.get(1), Casing_Amount),
										CI.getEmitter(GTNH ? 5 : 4, GTNH ? 4 : 2), CI.getRobotArm(GTNH ? 5 : 4, GTNH ? 4 : 2),
										CI.getTieredComponent(OrePrefixes.circuit, GTNH ? 3 : 2, 8),
										CI.getTieredComponent(OrePrefixes.screw, GTNH ? 4 : 3, 8),
										CI.getTieredComponent(OrePrefixes.plate, 5, GTNH ? 16 : 4), },
								CI.getAlternativeTieredFluid(5, 144 * 4), ItemUtils.getSimpleStack(ModBlocks.blockProjectTable),
								20 * 30 * 3, MaterialUtils.getVoltageForTier(GTNH ? 5 : 4));

			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialCuttingMachine){
				ItemStack plate = ALLOY.MARAGING300.getPlate(1);
				RecipeUtils.addShapedRecipe(
						plate, CI.craftingToolHammer_Hard, plate,
						"plateStellite", "frameGtTalonite", "plateStellite",
						plate, CI.craftingToolWrench, plate,
						GregtechItemList.Casing_CuttingFactoryFrame.get(Casing_Amount));

				RecipeUtils.addShapedRecipe( 
						plate,CI.getTieredCircuit(3),plate,
						"wireFinePlatinum", EV_MACHINE_Cutter, "wireFinePlatinum",
						plate,CI.getTieredCircuit(4),plate,
						GregtechItemList.Industrial_CuttingFactoryController.get(1));
			}

			//EV_MACHINE_Extruder
			if (CORE.ConfigSwitches.enableMultiblock_IndustrialExtrudingMachine){
				ItemStack plate = ALLOY.INCONEL_690.getPlate(1);
				RecipeUtils.addShapedRecipe(
						plate, CI.craftingToolHammer_Hard, plate,
						"plateTalonite", "frameGtStaballoy", "plateTalonite",
						plate, CI.craftingToolWrench, plate,
						GregtechItemList.Casing_Extruder.get(Casing_Amount));

				RecipeUtils.addShapedRecipe( 
						plate,CI.getTieredCircuit(4),plate,
						CI.electricPiston_EV, EV_MACHINE_Extruder, CI.electricPiston_EV,
						plate,CI.getTieredCircuit(4),plate,
						GregtechItemList.Industrial_Extruder.get(1));
			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialFishingPort){
				ItemStack plate = ALLOY.AQUATIC_STEEL.getPlate(1);
				RecipeUtils.addShapedRecipe(
						plate, CI.craftingToolHammer_Hard, plate,
						"plateEglinSteel", "frameGtEglinSteel", "plateEglinSteel",
						plate, CI.craftingToolWrench, plate,
						GregtechItemList.Casing_FishPond.get(Casing_Amount));

				RecipeUtils.addShapedRecipe( 
						plate,CI.getTieredCircuit(3),plate,
						"wireFineElectrum", ItemUtils.getSimpleStack(ModBlocks.blockFishTrap), "wireFineElectrum",
						plate,CI.getTieredCircuit(2),plate,
						GregtechItemList.Industrial_FishingPond.get(1));
			}

			if (true) {
				//Advanced Vacuum Freezer
				ItemStack plate = ALLOY.HG1223.getPlateDouble(1);
				ItemStack gear = ALLOY.INCOLOY_MA956.getGear(1);
				ItemStack frame = ALLOY.LAFIUM.getFrameBox(1);
				ItemStack cell1 = ItemList.Reactor_Coolant_He_6.get(1);
				ItemStack cell2 = ItemList.Reactor_Coolant_NaK_6.get(1);

				RecipeUtils.addShapedRecipe(
						plate, gear, plate,
						cell1, frame, cell2,
						plate, gear, plate,
						GregtechItemList.Casing_AdvancedVacuum.get(Casing_Amount));
				RecipeUtils.addShapedRecipe( 
						gear,CI.getTieredCircuit(6),gear,
						CI.electricPiston_IV, GregtechItemList.Casing_AdvancedVacuum.get(1), CI.electricPiston_IV,
						plate, GregtechItemList.Gregtech_Computer_Cube.get(1), plate,
						GregtechItemList.Industrial_Cryogenic_Freezer.get(1));			

				//Advanced Blast Furnace
				plate = ALLOY.HASTELLOY_N.getPlateDouble(1);
				gear = ALLOY.HASTELLOY_W.getGear(1);
				frame = ALLOY.HASTELLOY_X.getFrameBox(1);
				cell1 = ItemUtils.simpleMetaStack("IC2:reactorHeatSwitchDiamond:1", 1, 1);
				cell2 = ItemUtils.simpleMetaStack("IC2:reactorVentGold:1", 1, 1);
				ItemStack cell3 = ItemUtils.simpleMetaStack("IC2:reactorVentDiamond:1:1", 1, 1);

				RecipeUtils.addShapedRecipe(
						plate, cell1, plate,
						cell3, frame, cell2,
						plate, gear, plate,
						GregtechItemList.Casing_Adv_BlastFurnace.get(Casing_Amount));
				RecipeUtils.addShapedRecipe( 
						gear,CI.getTieredCircuit(6),gear,
						CI.robotArm_IV, GregtechItemList.Casing_Adv_BlastFurnace.get(1), CI.robotArm_IV,
						plate, GregtechItemList.Gregtech_Computer_Cube.get(1), plate,
						GregtechItemList.Machine_Adv_BlastFurnace.get(1));	

				//Advanced Implosion Compressor
				plate = ItemUtils.getItemStackOfAmountFromOreDict("plateAlloyIridium", 1);
				gear = ALLOY.LEAGRISIUM.getGear(1);
				frame = ALLOY.CINOBITE.getFrameBox(1);
				cell1 = ItemUtils.simpleMetaStack("IC2:reactorHeatSwitchDiamond:1", 1, 1);
				cell2 = ItemUtils.simpleMetaStack("IC2:reactorVentGold:1", 1, 1);

				RecipeUtils.addShapedRecipe( 
						gear,CI.getTieredCircuit(6),gear,
						CI.fieldGenerator_IV, CI.machineHull_ZPM, CI.robotArm_IV,
						plate, GregtechItemList.Gregtech_Computer_Cube.get(1), plate,
						GregtechItemList.Machine_Adv_ImplosionCompressor.get(1));	



				//Supply Depot
				plate = ALLOY.TUNGSTEN_CARBIDE.getPlateDouble(1);
				gear = ALLOY.TRINIUM_TITANIUM.getRing(1);
				frame = ALLOY.TUNGSTEN_CARBIDE.getFrameBox(1);
				cell1 = CI.conveyorModule_EV;
				cell2 = CI.electricMotor_IV;
				ItemStack casingAmazon = GregtechItemList.Casing_AmazonWarehouse.get(1);
				ItemStack aTieredUnboxinator = CORE.MAIN_GREGTECH_5U_EXPERIMENTAL_FORK ? ItemUtils.getValueOfItemList("Machine_LuV_Unboxinator", 1, ItemList.Machine_IV_Unboxinator.get(1)) : ItemList.Machine_IV_Unboxinator.get(1);


				RecipeUtils.addShapedRecipe(
						plate, ItemUtils.getItemStackOfAmountFromOreDict("cableGt12VanadiumGallium", 1), plate,
						cell1, frame, cell2,
						plate, gear, plate,
						GregtechItemList.Casing_AmazonWarehouse.get(Casing_Amount));
				RecipeUtils.addShapedRecipe( 
						casingAmazon, CI.getTieredCircuit(7), casingAmazon,
						CI.robotArm_LuV, aTieredUnboxinator, CI.robotArm_LuV,
						CI.conveyorModule_LuV, GregtechItemList.Gregtech_Computer_Cube.get(1), CI.conveyorModule_LuV,
						GregtechItemList.Amazon_Warehouse_Controller.get(1));


				//Industrial Mixing Machine
				RecipeUtils.addShapedRecipe( 
						"plateStaballoy",CI.getTieredCircuit(5),"plateStaballoy",
						"plateZirconiumCarbide", EV_MACHINE_Mixer, "plateZirconiumCarbide",
						"plateStaballoy",CI.getTieredCircuit(5),"plateStaballoy",
						GregtechItemList.Industrial_Mixer.get(1));

			}

			if (CORE.ConfigSwitches.enableMultiblock_IndustrialMultiMachine){				
				ItemStack plate = ALLOY.STABALLOY.getPlate(1);


				ItemStack o_Compressor;
				ItemStack o_Lathe;
				ItemStack o_Electromagnet;
				ItemStack o_Fermenter;
				ItemStack o_Distillery;
				ItemStack o_Extractor;
				if (GTNH) {
					o_Compressor = ItemList.Machine_IV_Compressor.get(1);
					o_Lathe = ItemList.Machine_IV_Lathe.get(1);
					o_Electromagnet = ItemList.Machine_IV_Polarizer.get(1);
					o_Fermenter = ItemList.Machine_IV_Fermenter.get(1);
					o_Distillery = ItemList.Machine_IV_FluidExtractor.get(1);
					o_Extractor = ItemList.Machine_IV_Extractor.get(1);	
				}
				else {
					o_Compressor = ItemList.Machine_EV_Compressor.get(1);
					o_Lathe = ItemList.Machine_EV_Lathe.get(1);
					o_Electromagnet = ItemList.Machine_EV_Polarizer.get(1);
					o_Fermenter = ItemList.Machine_EV_Fermenter.get(1);
					o_Distillery = ItemList.Machine_EV_FluidExtractor.get(1);
					o_Extractor = ItemList.Machine_EV_Extractor.get(1);	
				}					
				RecipeUtils.addShapedRecipe(
						plate, CI.craftingToolHammer_Hard, plate,
						"plateStainlessSteel", "frameGtZirconiumCarbide", "plateStainlessSteel",
						plate, CI.craftingToolWrench, plate,
						GregtechItemList.Casing_Multi_Use.get(Casing_Amount));

				RecipeUtils.addShapedRecipe( 
						o_Compressor, o_Lathe, o_Electromagnet,
						plate, ItemUtils.getSimpleStack(ModBlocks.blockProjectTable), plate,
						o_Fermenter, o_Distillery, o_Extractor,
						GregtechItemList.Industrial_MultiMachine.get(1));
			}




			/*
			 * 6/1/19 - Content additions
			 */

			if (CORE.MAIN_GREGTECH_5U_EXPERIMENTAL_FORK) {

				ItemStack aDrillController = ItemUtils.getValueOfItemList("OreDrill4", ItemList.Hull_UV).get(1);				

				//Drilling Platform
				/*CORE.RA.addSixSlotAssemblingRecipe(
						new ItemStack[] {
								aDrillController,
								ItemUtils.getItemStackOfAmountFromOreDict("frameGtTriniumNaquadahCarbonite", 3),
								ItemUtils.getItemStackOfAmountFromOreDict(CI.getTieredCircuitOreDictName(9), 2 * (GTNH ? 4 : 1)),
								ItemUtils.getSimpleStack((GTNH ? CI.conveyorModule_UV : CI.conveyorModule_ZPM), 2 * (GTNH ? 2 : 1)),
								ItemUtils.getSimpleStack((GTNH ? CI.electricPump_UV : CI.electricPump_ZPM), 4 * (GTNH ? 2 : 1)),
						},
						ALLOY.LAFIUM.getFluid(144 * 8  * (GTNH ? 2 : 1)),
						GregtechItemList.BedrockMiner_MKI.get(1),
						(int) GT_Values.V[5],
						(int) GT_Values.V[7]);*/

				//Drilling Platform Casings
				CORE.RA.addSixSlotAssemblingRecipe(
						new ItemStack[] {
								ItemUtils.getItemStackOfAmountFromOreDict("frameGtTriniumNaquadahCarbonite", 4),
								ItemUtils.getItemStackOfAmountFromOreDict("plateDoubleTriniumTitaniumAlloy", 1 * (GTNH ? 2 : 1)),
								ItemUtils.getItemStackOfAmountFromOreDict("gearGtPikyonium64B", 2 * (GTNH ? 2 : 1)),
								ALLOY.TRINIUM_REINFORCED_STEEL.getPlateDouble(4 * (GTNH ? 2 : 1)),
								ItemUtils.getSimpleStack((GTNH ? CI.machineHull_UV : CI.machineHull_LuV), 1 * (GTNH ? 2 : 1)),
						},
						ALLOY.MARAGING350.getFluidStack(144 * 16  * (GTNH ? 2 : 1)),
						GregtechItemList.Casing_BedrockMiner.get(1),
						(int) GT_Values.V[4],
						(int) GT_Values.V[6]);









			}










		}

		int aCostMultiplier = GTNH ? 2 : 1;	

		//Mystic Frame
		CORE.RA.addSixSlotAssemblingRecipe(				
				new ItemStack[] {
						GregtechItemList.Casing_Multi_Use.get(1),
						ItemList.Field_Generator_MV.get(1, CI.circuitTier7),
						ItemList.Field_Generator_HV.get(1, CI.circuitTier7),
						ItemList.Emitter_HV.get(1, CI.circuitTier7),
						ItemList.Sensor_HV.get(1, CI.circuitTier7),
						CI.getTieredComponent(OrePrefixes.plate, 7, 8 * aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.wireGt08, 8, 4 * aCostMultiplier),
				},					
				CI.getTieredFluid(6, (144 * 8)), //Input Fluid					
				ItemUtils.getSimpleStack(Dimension_Everglades.blockPortalFrame, 2),					
				45 * 20 * 1 * (6), 
				MaterialUtils.getVoltageForTier(6));


		//Player Doors
		ItemStack[] aDoorInputs = new ItemStack[] {
				ItemUtils.getSimpleStack(Blocks.log2),
				ItemUtils.getSimpleStack(Blocks.iron_block),
				ItemUtils.getSimpleStack(Blocks.glass),
				ItemUtils.getSimpleStack(Blocks.packed_ice),
				ItemUtils.getSimpleStack(Blocks.cactus),	
		};
		ItemStack[] aDoorOutputs = new ItemStack[] {
				ItemUtils.getSimpleStack(ModBlocks.blockPlayerDoorWooden),
				ItemUtils.getSimpleStack(ModBlocks.blockPlayerDoorIron),
				ItemUtils.getSimpleStack(ModBlocks.blockPlayerDoorCustom_Glass),
				ItemUtils.getSimpleStack(ModBlocks.blockPlayerDoorCustom_Ice),
				ItemUtils.getSimpleStack(ModBlocks.blockPlayerDoorCustom_Cactus),	
		};

		for (int y = 0; y < aDoorInputs.length; y++) {
			CORE.RA.addSixSlotAssemblingRecipe(				
					new ItemStack[] {
							ItemUtils.getSimpleStack(Items.iron_door),
							aDoorInputs[y],
							ItemList.Sensor_LV.get(1, CI.circuitTier7),
							CI.getTieredComponent(OrePrefixes.plate, 1, 2 * aCostMultiplier),
							CI.getTieredComponent(OrePrefixes.wireGt02, 1, 2 * aCostMultiplier),
							ItemUtils.getSimpleStack(Items.redstone, 16)
					},					
					CI.getTieredFluid(1, (144 * 2)), //Input Fluid					
					aDoorOutputs[y],					
					100, 
					MaterialUtils.getVoltageForTier(1));			
		}






		Logger.INFO("Done loading recipes for the Various machine blocks.");
	}


	private static void controlCores() {

		Material[] aMat_A = new Material[] {
				ALLOY.POTIN,
				ALLOY.ZIRCONIUM_CARBIDE,
				ALLOY.TANTALLOY_61,
				ALLOY.INCONEL_792,
				ALLOY.STABALLOY,
				ALLOY.TALONITE,
				ALLOY.HASTELLOY_N,
				ALLOY.HG1223,
				ALLOY.LAFIUM,
				ALLOY.PIKYONIUM
		};		
		Material[] aMat_B = new Material[] {
				ALLOY.TUMBAGA,
				ALLOY.SILICON_CARBIDE,
				ALLOY.EGLIN_STEEL,
				ALLOY.NICHROME,
				ALLOY.TUNGSTEN_CARBIDE,
				ALLOY.STELLITE,
				ALLOY.HASTELLOY_C276,
				ALLOY.NITINOL_60,
				ALLOY.ZERON_100,
				ALLOY.CINOBITE
		};

		Item aBaseCore = ModItems.itemControlCore;		
		ItemStack[] aInputPrevTier = new ItemStack[] {
				GTNH ? ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore3", 1) : ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore2", 1),
						ItemUtils.simpleMetaStack(aBaseCore, 0, 1),
						ItemUtils.simpleMetaStack(aBaseCore, 1, 1),
						ItemUtils.simpleMetaStack(aBaseCore, 2, 1),
						ItemUtils.simpleMetaStack(aBaseCore, 3, 1),
						ItemUtils.simpleMetaStack(aBaseCore, 4, 1),
						ItemUtils.simpleMetaStack(aBaseCore, 5, 1),
						ItemUtils.simpleMetaStack(aBaseCore, 6, 1),
						ItemUtils.simpleMetaStack(aBaseCore, 7, 1),
						ItemUtils.simpleMetaStack(aBaseCore, 8, 1),
		};		
		ItemStack[] aOutput = new ItemStack[] {
				ItemUtils.simpleMetaStack(aBaseCore, 0, 1),
				ItemUtils.simpleMetaStack(aBaseCore, 1, 1),
				ItemUtils.simpleMetaStack(aBaseCore, 2, 1),
				ItemUtils.simpleMetaStack(aBaseCore, 3, 1),
				ItemUtils.simpleMetaStack(aBaseCore, 4, 1),
				ItemUtils.simpleMetaStack(aBaseCore, 5, 1),
				ItemUtils.simpleMetaStack(aBaseCore, 6, 1),
				ItemUtils.simpleMetaStack(aBaseCore, 7, 1),
				ItemUtils.simpleMetaStack(aBaseCore, 8, 1),
				ItemUtils.simpleMetaStack(aBaseCore, 9, 1),

		};

		CORE.RA.addSixSlotAssemblingRecipe(				
				new ItemStack[] {
						CI.machineHull_HV,
						aOutput[1],
						aMat_A[1].getGear(GTNH ? 4 : 2),
						aMat_B[2].getPlateDouble(GTNH ? 16 : 8),
						ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+(GTNH ? "2" : "1"), GTNH ? 4 : 2),
						ItemUtils.getItemStackOfAmountFromOreDict(CI.getTieredCircuitOreDictName(GTNH ? 3 : 2), GTNH ? 10 : 5)
				},					
				aMat_B[3].getFluidStack(144 * 8), //Input Fluid					
				GregtechItemList.Hatch_Control_Core.get(1),					
				60 * 20 * 5, 
				MaterialUtils.getVoltageForTier(3));


		for (int i = 0; i < 10; i++) {			
			boolean aDub = false;
			ItemStack aPlateStack = aMat_A[i].getPlateDouble((GTNH ? 16 : 8) * (aDub ? 2 : 1));
			ItemStack aGearStack = aMat_B[i].getGear(GTNH ? 4 : 2 * (aDub ? 2 : 1));
			ItemStack aRodStack = aMat_A[i].getLongRod(GTNH ? 16 : 8 * (aDub ? 2 : 1));
			ItemStack aScrewStack = aMat_B[i].getScrew(32 * (aDub ? 2 : 1));

			if (!ItemUtils.checkForInvalidItems(aPlateStack)) {
				aPlateStack = aMat_A[i].getPlate((GTNH ? 16 : 8) * (aDub ? 2 : 1) * 2);
				if (!ItemUtils.checkForInvalidItems(aPlateStack)) {
					aPlateStack = aMat_B[i].getPlateDouble((GTNH ? 16 : 8) * (aDub ? 2 : 1));
					if (!ItemUtils.checkForInvalidItems(aPlateStack)) {
						aPlateStack = aMat_B[i].getPlate((GTNH ? 16 : 8) * (aDub ? 2 : 1) * 2);
					}
				}
			}
			if (!ItemUtils.checkForInvalidItems(aGearStack)) {
				aGearStack = aMat_A[i].getGear(GTNH ? 8 : 4 * (aDub ? 2 : 1));				
			}
			if (!ItemUtils.checkForInvalidItems(aRodStack)) {
				aRodStack = aMat_B[i].getLongRod(GTNH ? 32 : 16 * (aDub ? 2 : 1));				
			}
			if (!ItemUtils.checkForInvalidItems(aScrewStack)) {
				aScrewStack = aMat_A[i].getScrew(32 * (aDub ? 2 : 1));				
			}

			CORE.RA.addSixSlotAssemblingRecipe(				
					new ItemStack[] {
							CI.getEnergyCore(i, 4),
							aPlateStack,
							aGearStack,
							aRodStack,
							aScrewStack,
							ItemUtils.getItemStackOfAmountFromOreDict(CI.getTieredCircuitOreDictName((int) (4+Math.ceil((double) i / (double) 2))), GTNH ? (i * 2 * 2) : (i * 2))
					},					
					CI.getTieredFluid(i, 144 * 4 * (i+1)), //Input Fluid					
					aOutput[i],					
					60 * 20 * 1 * (i+1), 
					MaterialUtils.getVoltageForTier(i));
		}		
	}

	private static void energyCores() {

		//Simpler Recipes for normal Players, Force assembly crafting in GTNH
		if (!GTNH) {
			//Buffer Core
			/*RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[1], cableTier1, CI.component_Plate[1],
					"circuitPrimitive", "plateStaballoy", "circuitPrimitive",
					CI.component_Plate[1], cableTier1, CI.component_Plate[1],
					RECIPE_BufferCore_ULV);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[2], cableTier2, CI.component_Plate[2],
					RECIPE_BufferCore_ULV, CI.machineHull_HV, RECIPE_BufferCore_ULV,
					CI.component_Plate[2], cableTier2, CI.component_Plate[2],
					RECIPE_BufferCore_LV);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[3], cableTier3, CI.component_Plate[3],
					RECIPE_BufferCore_LV, CI.circuitTier2, RECIPE_BufferCore_LV,
					CI.component_Plate[3], cableTier3, CI.component_Plate[3],
					RECIPE_BufferCore_MV);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[4], cableTier4, CI.component_Plate[4],
					RECIPE_BufferCore_MV, CI.circuitTier3, RECIPE_BufferCore_MV,
					CI.component_Plate[4], cableTier4, CI.component_Plate[4],
					RECIPE_BufferCore_HV);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[5], cableTier5, CI.component_Plate[5],
					RECIPE_BufferCore_HV, CI.circuitTier4, RECIPE_BufferCore_HV,
					CI.component_Plate[5], cableTier5, CI.component_Plate[5],
					RECIPE_BufferCore_EV);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[6], cableTier6, CI.component_Plate[6],
					RECIPE_BufferCore_EV, CI.circuitTier5, RECIPE_BufferCore_EV,
					CI.component_Plate[6], cableTier6, CI.component_Plate[6],
					RECIPE_BufferCore_IV);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[7], cableTier7, CI.component_Plate[7],
					RECIPE_BufferCore_IV, CI.circuitTier6, RECIPE_BufferCore_IV,
					CI.component_Plate[7], cableTier7, CI.component_Plate[7],
					RECIPE_BufferCore_LuV);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[8], cableTier8, CI.component_Plate[8],
					RECIPE_BufferCore_LuV, CI.circuitTier7, RECIPE_BufferCore_LuV,
					CI.component_Plate[8], cableTier8, CI.component_Plate[8],
					RECIPE_BufferCore_ZPM);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[9], cableTier9, CI.component_Plate[9],
					RECIPE_BufferCore_ZPM, CI.circuitTier8, RECIPE_BufferCore_ZPM,
					CI.component_Plate[9], cableTier9, CI.component_Plate[9],
					RECIPE_BufferCore_UV);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[10], cableTier10, CI.component_Plate[10],
					RECIPE_BufferCore_UV, CI.circuitTier9, RECIPE_BufferCore_UV,
					CI.component_Plate[10], cableTier10, CI.component_Plate[10],
					RECIPE_BufferCore_MAX);*/


			/*RecipeUtils.addShapedGregtechRecipe(
					wireTier1, RECIPE_BufferCore_ULV, wireTier1,
					wireTier1, CI.machineCasing_ULV, wireTier1,
					CI.circuitPrimitive, CI.circuitTier1, CI.circuitPrimitive,
					RECIPE_Buffer_ULV);
			RecipeUtils.addShapedGregtechRecipe(
					wireTier2, RECIPE_BufferCore_LV, wireTier2,
					wireTier2, CI.machineCasing_LV, wireTier2,
					CI.circuitTier1, RECIPE_BufferCore_LV, CI.circuitTier1,
					RECIPE_Buffer_LV);
			RecipeUtils.addShapedGregtechRecipe(
					wireTier3, RECIPE_BufferCore_MV, wireTier3,
					wireTier3, CI.machineCasing_MV, wireTier3,
					CI.circuitTier2, RECIPE_BufferCore_MV, CI.circuitTier2,
					RECIPE_Buffer_MV);
			RecipeUtils.addShapedGregtechRecipe(
					wireTier4, RECIPE_BufferCore_HV, wireTier4,
					wireTier4, CI.machineCasing_HV, wireTier4,
					CI.circuitTier3, RECIPE_BufferCore_HV, CI.circuitTier3,
					RECIPE_Buffer_HV);
			RecipeUtils.addShapedGregtechRecipe(
					wireTier5, RECIPE_BufferCore_EV, wireTier5,
					wireTier5, CI.machineCasing_EV, wireTier5,
					CI.circuitTier4, RECIPE_BufferCore_EV, CI.circuitTier4,
					RECIPE_Buffer_EV);
			RecipeUtils.addShapedGregtechRecipe(
					wireTier6, RECIPE_BufferCore_IV, wireTier6,
					wireTier6, CI.machineCasing_IV, wireTier6,
					CI.circuitTier5, RECIPE_BufferCore_IV, CI.circuitTier5,
					RECIPE_Buffer_IV);
			RecipeUtils.addShapedGregtechRecipe(
					wireTier7, RECIPE_BufferCore_LuV, wireTier7,
					wireTier7, CI.machineCasing_LuV, wireTier7,
					CI.circuitTier6, RECIPE_BufferCore_LuV, CI.circuitTier6,
					RECIPE_Buffer_LuV);
			RecipeUtils.addShapedGregtechRecipe(
					wireTier8, RECIPE_BufferCore_ZPM, wireTier8,
					wireTier8, CI.machineCasing_ZPM, wireTier8,
					CI.circuitTier7, RECIPE_BufferCore_ZPM, CI.circuitTier7,
					RECIPE_Buffer_ZPM);
			RecipeUtils.addShapedGregtechRecipe(
					wireTier9, RECIPE_BufferCore_UV, wireTier9,
					wireTier9, CI.machineCasing_UV, wireTier9,
					CI.circuitTier8, RECIPE_BufferCore_UV, CI.circuitTier8,
					RECIPE_Buffer_UV);
			RecipeUtils.addShapedGregtechRecipe(
					CI.component_Plate[11], RECIPE_BufferCore_MAX, CI.component_Plate[11],
					wireTier10, CI.machineCasing_MAX, wireTier10,
					CI.circuitTier9, RECIPE_BufferCore_MAX, CI.circuitTier9,
					RECIPE_Buffer_MAX);*/
		}


		ItemStack[] aBufferOutput = new ItemStack[] {
				RECIPE_Buffer_ULV, RECIPE_Buffer_LV, RECIPE_Buffer_MV,
				RECIPE_Buffer_HV, RECIPE_Buffer_EV, RECIPE_Buffer_IV, 
				RECIPE_Buffer_LuV, RECIPE_Buffer_ZPM, RECIPE_Buffer_UV, RECIPE_Buffer_MAX };



		ItemStack[] aOutput = new ItemStack[] {
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"1", 1),
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"2", 1),
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"3", 1),
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"4", 1),
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"5", 1),
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"6", 1),
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"7", 1),
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"8", 1),
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"9", 1),
				ItemUtils.getItemStackFromFQRN("miscutils:item.itemBufferCore"+"10", 1)
		};		

		int aCostMultiplier = GTNH ? 4 : 1;	

		for (int i = 0; i < 10; i++) {			

			ItemStack aPrevTier = (i == 0 ? CI.getTieredMachineHull(GTNH ? 2 : 1) : aOutput[i-1]);
			aPrevTier.stackSize = GTNH ? 2 : 1;
			int aTier = (i + 1);
			CORE.RA.addSixSlotAssemblingRecipe(				
					new ItemStack[] {
							aPrevTier,
							CI.getTieredComponent(OrePrefixes.plate, aTier, 4 * aCostMultiplier),
							CI.getTieredComponent(OrePrefixes.cableGt04, i, 2 * aCostMultiplier),
							CI.getTieredComponent(OrePrefixes.circuit, aTier, 2 * aCostMultiplier),
							CI.getTieredComponent(OrePrefixes.screw, aTier, 6 * aCostMultiplier),
							CI.getTieredComponent(OrePrefixes.bolt, i, 12 * (GTNH ? 2 : 1)),
					},					
					CI.getTieredFluid(i, (144 * 4 * aTier)), //Input Fluid					
					aOutput[i],					
					45 * 10 * 1 * (aTier), 
					MaterialUtils.getVoltageForTier(i));

			//Energy Buffer
			CORE.RA.addSixSlotAssemblingRecipe(				
					new ItemStack[] {
							ItemUtils.getSimpleStack(aOutput[i], 4),
							CI.getTieredComponent(OrePrefixes.plate, aTier, 8 * aCostMultiplier),
							CI.getTieredComponent(OrePrefixes.wireGt08, i, 4 * aCostMultiplier),
							CI.getTieredComponent(OrePrefixes.circuit, i, 4 * aCostMultiplier),
							CI.getTieredComponent(OrePrefixes.stickLong, aTier, 4 * aCostMultiplier),
							CI.getTieredComponent(OrePrefixes.gearGt, i, 5 * (GTNH ? 2 : 1)),
					},					
					CI.getTieredFluid(aTier, (144 * 16 * aTier)), //Input Fluid					
					aBufferOutput[i],					
					45 * 20 * 1 * (aTier), 
					MaterialUtils.getVoltageForTier(i));

		}




	}

	private static void wirelessChargers() {

		ItemStack[] aChargers = new ItemStack[] {
				null,
				GregtechItemList.Charger_LV.get(1), 
				GregtechItemList.Charger_MV.get(1),
				GregtechItemList.Charger_HV.get(1), 
				GregtechItemList.Charger_EV.get(1), 
				GregtechItemList.Charger_IV.get(1), 
				GregtechItemList.Charger_LuV.get(1), 
				GregtechItemList.Charger_ZPM.get(1), 
				GregtechItemList.Charger_UV.get(1),
				GregtechItemList.Charger_MAX.get(1) 
		};

		int aCostMultiplier = GTNH ? 2 : 1;	

		for (int i = 0; i < 10; i++) {			
			if (i == 0) {
				continue;
			}			
			int aTier = (i + 1);			
			ItemStack[] aInputs = new ItemStack[] {
					CI.getTieredMachineHull(i, 1 * aCostMultiplier),
					CI.getTransmissionComponent(i, 2 * aCostMultiplier),
					CI.getFieldGenerator(i, 1 * aCostMultiplier),
					CI.getTieredComponent(OrePrefixes.plate, aTier, 4 * aCostMultiplier),
					CI.getTieredComponent(OrePrefixes.circuit, aTier, 2 * aCostMultiplier),
			};			
			CORE.RA.addSixSlotAssemblingRecipe(				
					aInputs,					
					CI.getAlternativeTieredFluid(i, (144 * 2 * aTier)), //Input Fluid					
					aChargers[i],					
					45 * 10 * 1 * (aTier), 
					MaterialUtils.getVoltageForTier(i));	

		}
	}

	private static void largeArcFurnace() {
		int aCostMultiplier = GTNH ? 2 : 1;		
		CORE.RA.addSixSlotAssemblingRecipe(				
				new ItemStack[] {
						CI.getTieredMachineHull(-1, 1 * aCostMultiplier),
						CI.getTransmissionComponent(2, 2 * aCostMultiplier),
						CI.getElectricPiston(4, 2 * aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.plate, 5, 4 * aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.pipeSmall, 4, 1 * aCostMultiplier),
				},					
				CI.getAlternativeTieredFluid(5, (144 * 2 * 4)), //Input Fluid					
				GregtechItemList.Casing_Industrial_Arc_Furnace.get(Casing_Amount),					
				20 * 10 * 1 * (6), 
				MaterialUtils.getVoltageForTier(5));		
		CORE.RA.addSixSlotAssemblingRecipe(				
				new ItemStack[] {
						GregtechItemList.Casing_Industrial_Arc_Furnace.get(Casing_Amount),
						CI.getFieldGenerator(4, 2 * aCostMultiplier),
						CI.getRobotArm(5, 4 * aCostMultiplier),
						CI.getEnergyCore(4, 2 * aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.plate, 6, 8 * aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.circuit, 5, 8 * aCostMultiplier),
				},					
				CI.getAlternativeTieredFluid(6, (144 * 4 * 5)), //Input Fluid					
				GregtechItemList.Industrial_Arc_Furnace.get(1),					
				60 * 20 * 8, 
				MaterialUtils.getVoltageForTier(6));
	}

	private static void industrialVacuumFurnace() {
		int aCostMultiplier = GTNH ? 2 : 1;	

		CORE.RA.addSixSlotAssemblingRecipe(				
				new ItemStack[] {
						CI.getTieredMachineHull(-1, 1 * aCostMultiplier),
						CI.getHeatCoil(2),
						CI.getElectricPiston(3, 2 * aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.plate, 6, 4 * aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.gearGt, 6, 2 * aCostMultiplier),
				},					
				CI.getTertiaryTieredFluid(5, (144 * 2 * 4 * aCostMultiplier)), //Input Fluid					
				GregtechItemList.Casing_Vacuum_Furnace.get(Casing_Amount),					
				20 * 10  * 6, 
				MaterialUtils.getVoltageForTier(6));	

		;

		CORE.RA.addSixSlotAssemblingRecipe(				
				new ItemStack[] {
						GregtechItemList.Casing_Vacuum_Furnace.get(aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.wireGt16, 7, 4 * aCostMultiplier),
						CI.getEnergyCore(6, 1 * aCostMultiplier),
						CI.getRobotArm(4, 4 * aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.plate, 7, 8 * aCostMultiplier),
						CI.getTieredComponent(OrePrefixes.circuit, 6, 8 * aCostMultiplier),
				},					
				CI.getTieredFluid(7, (144 * 4 * 5 * aCostMultiplier)), //Input Fluid					
				GregtechItemList.Controller_Vacuum_Furnace.get(1),					
				60 * 20 * 12, 
				MaterialUtils.getVoltageForTier(7));
	}
	
	private static void milling() {


		/*public static ItemStack RECIPE_ISAMill_Controller;
		public static ItemStack RECIPE_ISAMill_Gearbox;
		public static ItemStack RECIPE_ISAMill_Casing;
		public static ItemStack RECIPE_ISAMill_Hatch;
		public static ItemStack RECIPE_Flotation_Controller;
		public static ItemStack RECIPE_Flotation_Casing;*/

		// Isa Mill Controller
		CORE.RA.addAssemblylineRecipe(
				ItemList.Machine_IV_Macerator.get(1), 
				20 * 60 * 20,
				new Object[] {
						GregtechItemList.Casing_IsaMill_Gearbox.get(4),
						CI.getTieredGTPPMachineCasing(6, 4),
						ItemList.Component_Grinder_Tungsten.get(16),
						new Object[] {CI.getTieredCircuitOreDictName(6), 8},
						ALLOY.INCONEL_625.getGear(8),
						ALLOY.INCONEL_625.getPlate(32),
						ALLOY.ZERON_100.getPlateDouble(8),
						ALLOY.ZERON_100.getPlateDouble(8),
						ALLOY.ZERON_100.getScrew(64),
						CI.getTieredComponentOfMaterial(Materials.NiobiumTitanium, OrePrefixes.wireFine, 32),
						CI.getTieredComponentOfMaterial(Materials.NiobiumTitanium, OrePrefixes.wireFine, 32),
						CI.getTieredComponentOfMaterial(Materials.Titanium, OrePrefixes.foil, 16),
						CI.getTieredComponentOfMaterial(Materials.Titanium, OrePrefixes.foil, 16),

				}, 
				new FluidStack[] {
						CI.getTieredFluid(6, 16 * 144),
						CI.getAlternativeTieredFluid(6, 32 * 144),
						CI.getTertiaryTieredFluid(6, 32 * 144)
				}, 
				GregtechItemList.Controller_IsaMill.get(1),
				20 * 60 * 10, 
				MaterialUtils.getVoltageForTier(6));

		// Isa Mill Gearbox
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(7),
						ItemList.Casing_Gearbox_Titanium.get(2),
						ALLOY.INCONEL_625.getGear(4),
						CI.getTieredComponentOfMaterial(Materials.HSSE, OrePrefixes.gearGtSmall, 8),
						ALLOY.INCONEL_625.getPlate(16),
						ALLOY.ZERON_100.getBolt(16),
				}, 
				ALLOY.TUNGSTENSTEEL.getFluidStack(8 * 144), 
				GregtechItemList.Casing_IsaMill_Gearbox.get(1), 
				60 * 20 * 2, 
				MaterialUtils.getVoltageForTier(6));

		// Isa Mill Casing
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(7),
						CI.getTieredGTPPMachineCasing(5, 1),
						ALLOY.INCONEL_625.getPlate(8),
						ALLOY.ZERON_100.getRod(4),
						CI.getTieredComponentOfMaterial(Materials.HSSG, OrePrefixes.gearGtSmall, 4),
						ALLOY.ZERON_100.getScrew(8),
				}, 
				ELEMENT.getInstance().TITANIUM.getFluidStack(4 * 144), 
				GregtechItemList.Casing_IsaMill_Casing.get(1), 
				60 * 20 * 2, 
				MaterialUtils.getVoltageForTier(6));

		// Isa Mill Pipe
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(7),
						CI.getTieredGTPPMachineCasing(4, 2),
						ALLOY.INCONEL_625.getPlateDouble(4),
						ALLOY.INCOLOY_MA956.getRing(8),
						CI.getTieredComponentOfMaterial(Materials.HSSE, OrePrefixes.plate, 8),
						ALLOY.INCOLOY_MA956.getBolt(16),
				}, 
				ELEMENT.getInstance().ALUMINIUM.getFluidStack(8 * 144), 
				GregtechItemList.Casing_IsaMill_Pipe.get(1), 
				60 * 20 * 8, 
				MaterialUtils.getVoltageForTier(4));	

		// Flotation Cell Controller
		CORE.RA.addAssemblylineRecipe(
				ItemList.Distillation_Tower.get(1), 
				20 * 60 * 20,
				new Object[] {
						GregtechItemList.Casing_Flotation_Cell.get(4),
						CI.getTieredGTPPMachineCasing(5, 4),
						ItemList.Machine_IV_Distillery.get(1),
						new Object[] {CI.getTieredCircuitOreDictName(6), 8},
						ALLOY.STELLITE.getGear(8),
						ALLOY.STELLITE.getPlate(32),
						ALLOY.HASTELLOY_N.getPlateDouble(8),
						ALLOY.HASTELLOY_N.getPlateDouble(8),
						ALLOY.HASTELLOY_N.getScrew(64),
						CI.getTieredComponentOfMaterial(Materials.YttriumBariumCuprate, OrePrefixes.wireFine, 64),
						CI.getTieredComponentOfMaterial(Materials.YttriumBariumCuprate, OrePrefixes.wireFine, 64),
						CI.getTieredComponentOfMaterial(Materials.Platinum, OrePrefixes.foil, 32),
						CI.getTieredComponentOfMaterial(Materials.Platinum, OrePrefixes.foil, 32),

				}, 
				new FluidStack[] {
						CI.getTieredFluid(5, 16 * 144),
						CI.getAlternativeTieredFluid(4, 32 * 144),
						CI.getTertiaryTieredFluid(4, 32 * 144)
				}, 
				GregtechItemList.Controller_Flotation_Cell.get(1),
				20 * 60 * 10, 
				MaterialUtils.getVoltageForTier(6));

		// Flotation Cell Casing
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(7),
						CI.getTieredGTPPMachineCasing(4, 1),
						ALLOY.AQUATIC_STEEL.getPlate(8),
						ALLOY.STELLITE.getRing(8),
						CI.getTieredComponentOfMaterial(Materials.HSSG, OrePrefixes.plateDouble, 4),
						ALLOY.HASTELLOY_N.getScrew(8),
				}, 
				ALLOY.STAINLESS_STEEL.getFluidStack(8 * 144), 
				GregtechItemList.Casing_Flotation_Cell.get(1), 
				60 * 20 * 2, 
				MaterialUtils.getVoltageForTier(6));

		// Milling Bus
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(7),
						CI.getTieredGTPPMachineCasing(5, 1),
						ItemList.Hatch_Input_Bus_EV.get(1),
						CI.getTieredComponentOfMaterial(Materials.Titanium, OrePrefixes.gearGt, 8),
						CI.getTieredComponentOfMaterial(Materials.TungstenSteel, OrePrefixes.plate, 32),
						CI.getTieredComponentOfMaterial(Materials.SolderingAlloy, OrePrefixes.wireFine, 16),
				}, 
				ELEMENT.getInstance().TUNGSTEN.getFluidStack(8 * 144), 
				GregtechItemList.Bus_Milling_Balls.get(1), 
				60 * 20 * 4, 
				MaterialUtils.getVoltageForTier(5));

	}
	
	private static void sparging() {
		
		// Sparge Tower Research
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(8),
						ELEMENT.getInstance().HELIUM.getCell(8),
						ELEMENT.getInstance().FLUORINE.getCell(8),
						ALLOY.HS188A.getIngot(8),
						ItemList.Distillation_Tower.get(1)
				}, 
				null, 
				ItemDummyResearch.getResearchStack(ASSEMBLY_LINE_RESEARCH.RESEARCH_10_SPARGING, 1), 
				60 * 20 * 5, 
				MaterialUtils.getVoltageForTier(5));
		
		// Sparge Tower Controller
		CORE.RA.addAssemblylineRecipe(
				ItemDummyResearch.getResearchStack(ASSEMBLY_LINE_RESEARCH.RESEARCH_10_SPARGING, 1), 
				20 * 60 * 20,
				new Object[] {
						GregtechItemList.Casing_Sparge_Tower_Exterior.get(4),
						CI.getTieredGTPPMachineCasing(4, 4),
						ItemList.Machine_IV_Distillery.get(1),
						new Object[] {CI.getTieredCircuitOreDictName(5), 8},
						ALLOY.HS188A.getGear(8),
						ALLOY.HS188A.getPlate(32),
						ALLOY.HASTELLOY_N.getPlateDouble(8),
						ALLOY.HASTELLOY_N.getPlateDouble(8),
						ALLOY.HASTELLOY_N.getScrew(64),
						CI.getTieredComponentOfMaterial(Materials.YttriumBariumCuprate, OrePrefixes.wireFine, 64),
						CI.getTieredComponentOfMaterial(Materials.YttriumBariumCuprate, OrePrefixes.wireFine, 64),
						CI.getTieredComponentOfMaterial(Materials.Platinum, OrePrefixes.foil, 32),
						CI.getTieredComponentOfMaterial(Materials.Platinum, OrePrefixes.foil, 32),

				}, 
				new FluidStack[] {
						CI.getTieredFluid(4, 16 * 144),
						CI.getAlternativeTieredFluid(3, 32 * 144),
						CI.getTertiaryTieredFluid(3, 32 * 144)
				}, 
				GregtechItemList.Controller_Sparge_Tower.get(1),
				20 * 60 * 10, 
				MaterialUtils.getVoltageForTier(6));

		// Sparge Tower Casing
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(8),
						CI.getTieredGTPPMachineCasing(3, 1),
						ALLOY.HS188A.getPlate(8),
						ALLOY.HASTELLOY_N.getRing(4),
						CI.getTieredComponentOfMaterial(Materials.TungstenSteel, OrePrefixes.plateDouble, 4),
						ALLOY.HASTELLOY_N.getScrew(4),
				}, 
				ALLOY.STAINLESS_STEEL.getFluidStack(8 * 144), 
				GregtechItemList.Casing_Sparge_Tower_Exterior.get(1), 
				60 * 20 * 2, 
				MaterialUtils.getVoltageForTier(5));
	}
	
	private static void chisels() {
		ItemStack[] aChisels = new ItemStack[] {
				GregtechItemList.GT_Chisel_LV.get(1),
				GregtechItemList.GT_Chisel_MV.get(1),
				GregtechItemList.GT_Chisel_HV.get(1),
		};
		for (int i=1;i<4;i++) {
			CORE.RA.addSixSlotAssemblingRecipe(
					new ItemStack[] {
							CI.getNumberedBioCircuit(10+i),
							CI.getTieredMachineCasing(i),
							CI.getPlate(i, 4),
							CI.getElectricMotor(i, 2),
							CI.getConveyor(i, 2),
							CI.getRobotArm(i, 1)
					}, 
					CI.getTieredFluid(i, 144 * 4), 
					aChisels[i-1], 
					20 * 20, 
					MaterialUtils.getVoltageForTier(i));
		}
		
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedBioCircuit(14),
						aChisels[2],
						CI.getPlate(4, 8),
						CI.getElectricMotor(4, 8),
						CI.getConveyor(4, 8),
						CI.getRobotArm(4, 4)
				}, 
				CI.getTieredFluid(4, 144 * 8), 
				GregtechItemList.Controller_IndustrialAutoChisel.get(1), 
				20 * 20, 
				MaterialUtils.getVoltageForTier(4));
	
		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedBioCircuit(14),
						ItemList.Casing_SolidSteel.get(2),
						CI.getPlate(4, 2),
						CI.getTieredComponent(OrePrefixes.plate, 3, 4),
						CI.getTieredComponent(OrePrefixes.ring, 3, 8),
						CI.getTieredComponent(OrePrefixes.rod, 2, 4),
				}, 
				CI.getTieredFluid(2, 144 * 2), 
				GregtechItemList.Casing_IndustrialAutoChisel.get(1), 
				20 * 20, 
				MaterialUtils.getVoltageForTier(3));

		
		
	}
	
	private static void rockBreaker() {

		CORE.RA.addSixSlotAssemblingRecipe(
				new ItemStack[] {
						CI.getNumberedAdvancedCircuit(12),
						ItemList.Machine_EV_RockBreaker.get(1),
						ALLOY.STAINLESS_STEEL.getPlate(8),
						ALLOY.STAINLESS_STEEL.getRing(4),
						CI.getTieredComponentOfMaterial(Materials.Aluminium, OrePrefixes.plateDouble, 8),
						ALLOY.EGLIN_STEEL.getScrew(8),
				}, 
				ELEMENT.getInstance().ALUMINIUM.getFluidStack(144 * 8), 
				GregtechItemList.Controller_IndustrialRockBreaker.get(1), 
				60 * 20 * 2, 
				MaterialUtils.getVoltageForTier(4));
		
	}

	private static void fakeMachineCasingCovers() {	    
		GregtechItemList[] mMachineCasingCovers = new GregtechItemList[] {
				GregtechItemList.FakeMachineCasingPlate_ULV,
				GregtechItemList.FakeMachineCasingPlate_LV,
				GregtechItemList.FakeMachineCasingPlate_MV,
				GregtechItemList.FakeMachineCasingPlate_HV,
				GregtechItemList.FakeMachineCasingPlate_EV,
				GregtechItemList.FakeMachineCasingPlate_IV,
				GregtechItemList.FakeMachineCasingPlate_LuV,
				GregtechItemList.FakeMachineCasingPlate_ZPM,
				GregtechItemList.FakeMachineCasingPlate_UV,
				GregtechItemList.FakeMachineCasingPlate_MAX,
		};	    
		int aMaxTier = GT_Values.VOLTAGE_NAMES.length;	    
		if (!GTNH) {
			aMaxTier = 10;
		}
		ItemStack aTier[] = new ItemStack[aMaxTier];
		for (int i=0;i<aMaxTier;i++) {
			aTier[i] = ItemUtils.simpleMetaStack(CoverManager.Cover_Gt_Machine_Casing, i, 7);
		}
		// Deprecate old recipes
		for (int i=0;i<10;i++) {
			RecipeUtils.addShapelessGregtechRecipe(new ItemStack[] {mMachineCasingCovers[i].get(1)}, ItemUtils.getSimpleStack(aTier[i], 1));
		}
		// Add recipes for new ones
		for (int i = 0;i<aMaxTier;i++) {
			GT_Values.RA.addCutterRecipe(
					CI.getTieredMachineCasing(i),	                
					aTier[i],
					null,
					20 * 5 * i,
					(int) GT_Values.V[i]);
		}	    
	}

	private static void ztonesCoverRecipes() {	    

		if (!Loader.isModLoaded("Ztones")) {
			return;
		}
		Class ModBlocksClass = ReflectionUtils.getClass("com.riciJak.Ztones.init.ModBlocks");
		Block agon = ReflectionUtils.getFieldValue( ReflectionUtils.getField(ModBlocksClass, "agonBlock"));
		Block korp = ReflectionUtils.getFieldValue( ReflectionUtils.getField(ModBlocksClass, "korpBlock"));
		Block jelt = ReflectionUtils.getFieldValue( ReflectionUtils.getField(ModBlocksClass, "jeltBlock"));
		Block bitt = ReflectionUtils.getFieldValue( ReflectionUtils.getField(ModBlocksClass, "bittBlock"));
		Block iszm = ReflectionUtils.getFieldValue( ReflectionUtils.getField(ModBlocksClass, "iszmBlock"));

		// "agon", "iszm", "korp", "jelt", "bitt" 

		ItemStack[] aBlocks = new ItemStack[] {
				ItemUtils.getSimpleStack(agon),
				ItemUtils.getSimpleStack(iszm),
				ItemUtils.getSimpleStack(korp),
				ItemUtils.getSimpleStack(jelt),
				ItemUtils.getSimpleStack(bitt)
		};
		MetaCustomCoverItem[] aCovers = new MetaCustomCoverItem[] {
				CoverManager.Cover_Agon,
				CoverManager.Cover_Iszm,
				CoverManager.Cover_Korp,
				CoverManager.Cover_Jelt,
				CoverManager.Cover_Bitt
		};

		ItemStack aInputs[][] = new ItemStack[5][16];
		ItemStack aOutputs[][] = new ItemStack[5][16];
		for (int a=0;a<5;a++) {
			for (int i=0;i<16;i++) {
				aInputs[a][i] = ItemUtils.simpleMetaStack(aBlocks[a].getItem(), i, 1);
				aOutputs[a][i] = ItemUtils.simpleMetaStack(aCovers[a], i, 9);
			}
		}
		for (int a=0;a<5;a++) {
			for (int i = 0;i<16;i++) {
				if (GTNH) continue;
				ItemStack aInput = aInputs[a][i];
				ItemStack aOutput = aOutputs[a][i];	    	
				if (GT_Values.RA.addCutterRecipe(
						aInput,	                
						aOutput,
						null,
						20 * 5,
						16)) {
					Logger.INFO("Added Cutting recipe for "+aInput.getDisplayName());
				}

				if (CORE.RA.addSixSlotAssemblingRecipe(	        		
						new ItemStack[] {
								CI.getNumberedCircuit((i/4)+4),
								aOutput
						}, 
						FluidUtils.getWildcardFluidStack("glue", 250),
						aInput,
						20 * 10,
						16)) {
					Logger.INFO("Added Assembly recipe for "+aInput.getDisplayName());					
				}
			}	
		}
	}

	private static void superBuses() {
		GregtechItemList[] mSuperBusesInput = new GregtechItemList[] {
				GregtechItemList.Hatch_SuperBus_Input_ULV,
				GregtechItemList.Hatch_SuperBus_Input_LV,
				GregtechItemList.Hatch_SuperBus_Input_MV,
				GregtechItemList.Hatch_SuperBus_Input_HV,
				GregtechItemList.Hatch_SuperBus_Input_EV,
				GregtechItemList.Hatch_SuperBus_Input_IV,
				GregtechItemList.Hatch_SuperBus_Input_LuV,
				GregtechItemList.Hatch_SuperBus_Input_ZPM,
				GregtechItemList.Hatch_SuperBus_Input_UV,
				GregtechItemList.Hatch_SuperBus_Input_MAX,
		};  

		GregtechItemList[] mSuperBusesOutput = new GregtechItemList[] {
				GregtechItemList.Hatch_SuperBus_Output_ULV,
				GregtechItemList.Hatch_SuperBus_Output_LV,
				GregtechItemList.Hatch_SuperBus_Output_MV,
				GregtechItemList.Hatch_SuperBus_Output_HV,
				GregtechItemList.Hatch_SuperBus_Output_EV,
				GregtechItemList.Hatch_SuperBus_Output_IV,
				GregtechItemList.Hatch_SuperBus_Output_LuV,
				GregtechItemList.Hatch_SuperBus_Output_ZPM,
				GregtechItemList.Hatch_SuperBus_Output_UV,
				GregtechItemList.Hatch_SuperBus_Output_MAX,
		};

		ItemStack[] mInputHatch = new ItemStack[] {
				ItemList.Hatch_Input_Bus_EV.get(1),
				ItemList.Hatch_Input_Bus_IV.get(1),
				ItemList.Hatch_Input_Bus_LuV.get(1),
				ItemList.Hatch_Input_Bus_ZPM.get(1),
				ItemList.Hatch_Input_Bus_UV.get(1),
				ItemList.Hatch_Input_Bus_MAX.get(1),
				GregtechItemList.Hatch_SuperBus_Input_LV.get(1),
				GregtechItemList.Hatch_SuperBus_Input_MV.get(1),
				GregtechItemList.Hatch_SuperBus_Input_HV.get(1),
				GregtechItemList.Hatch_SuperBus_Input_EV.get(1),
		};

		ItemStack[] mOutputHatch = new ItemStack[] {
				ItemList.Hatch_Output_Bus_EV.get(1),
				ItemList.Hatch_Output_Bus_IV.get(1),
				ItemList.Hatch_Output_Bus_LuV.get(1),
				ItemList.Hatch_Output_Bus_ZPM.get(1),
				ItemList.Hatch_Output_Bus_UV.get(1),
				ItemList.Hatch_Output_Bus_MAX.get(1),
				GregtechItemList.Hatch_SuperBus_Output_LV.get(1),
				GregtechItemList.Hatch_SuperBus_Output_MV.get(1),
				GregtechItemList.Hatch_SuperBus_Output_HV.get(1),
				GregtechItemList.Hatch_SuperBus_Output_EV.get(1),
		};

		// Special Case recipes for ULV buses
		{

			int i = 0;
			ItemStack[] aInputs1 = new ItemStack[] {
					CI.getNumberedCircuit(17),
					mInputHatch[i],
					CI.getElectricMotor(i, GTNH ? 8 : 2),
					CI.getConveyor(i, GTNH ? 10 : 5),
					CI.getBolt(i, GTNH ? 32 : 16),
					CI.getTieredComponent(OrePrefixes.circuit, i, GTNH ? 4 : 2)                   
			};
			Logger.INFO("[FIND] "+ItemUtils.getArrayStackNames(aInputs1));
			ItemStack[] aOutputs1 = new ItemStack[] {
					CI.getNumberedCircuit(18),
					mOutputHatch[i],
					CI.getElectricPiston(i, GTNH ? 8 : 2),
					CI.getConveyor(i, GTNH ? 10 : 5),
					CI.getGear(i, GTNH ? 6 : 3),
					CI.getTieredComponent(OrePrefixes.circuit, i, GTNH ? 4 : 2)                   
			};
			Logger.INFO("[FIND] "+ItemUtils.getArrayStackNames(aOutputs1));

			FluidStack a1 = CI.getAlternativeTieredFluid(i, 144 * 8);
			FluidStack a2 = CI.getTertiaryTieredFluid(i, 144 * 8);


			Logger.INFO("[FIND] Input Bus Fluid: "+ItemUtils.getFluidName(a1));
			Logger.INFO("[FIND] Output Bus Fluid: "+ItemUtils.getFluidName(a2));


			CORE.RA.addSixSlotAssemblingRecipe(aInputs1,
					a1,
					mSuperBusesInput[i].get(1),
					20 * 30 * 2 * i,
					(int) GT_Values.V[i]);

			CORE.RA.addSixSlotAssemblingRecipe(aOutputs1,
					a2,
					mSuperBusesOutput[i].get(1),
					20 * 30 * 2 * i,
					(int) GT_Values.V[i]);


		}

		//Input Buses
		for (int i = 1; i < 10; i++) {
			CORE.RA.addSixSlotAssemblingRecipe(new ItemStack[] {
					CI.getNumberedCircuit(17),
					mInputHatch[i],
					CI.getElectricMotor(i, GTNH ? 8 : 2),
					CI.getConveyor(i, GTNH ? 10 : 5),
					CI.getBolt(i, GTNH ? 32 : 16),
					CI.getTieredComponent(OrePrefixes.circuit, i, GTNH ? 4 : 2)                   
			},
					CI.getAlternativeTieredFluid(i, 144 * 8),
					mSuperBusesInput[i].get(1), 20 * 30 * 2 * i,
					(int) GT_Values.V[i]);
		}
		//Output Buses
		for (int i = 1; i < 10; i++) {
			CORE.RA.addSixSlotAssemblingRecipe(new ItemStack[] {
					CI.getNumberedCircuit(18),
					mOutputHatch[i],
					CI.getElectricPiston(i, GTNH ? 8 : 2),
					CI.getConveyor(i, GTNH ? 10 : 5),
					CI.getGear(i, GTNH ? 6 : 3),
					CI.getTieredComponent(OrePrefixes.circuit, i, GTNH ? 4 : 2)                   
			},
					CI.getTertiaryTieredFluid(i, 144 * 8),
					mSuperBusesOutput[i].get(1), 20 * 30 * 2 * i,
					(int) GT_Values.V[i]);
		}


	}

	private static void roundRobinators() {

		RecipeUtils.addShapedGregtechRecipe(
				ItemUtils.getSimpleStack(Blocks.hopper), "circuitPrimitive", ItemUtils.getSimpleStack(Blocks.hopper), 
				CI.craftingToolWrench, CI.machineCasing_ULV, CI.craftingToolScrewdriver, 
				ItemUtils.getSimpleStack(Blocks.hopper), "circuitPrimitive", ItemUtils.getSimpleStack(Blocks.hopper),
				ItemUtils.simpleMetaStack(ModBlocks.blockRoundRobinator, 0, 1));		

		ItemStack[] aRobinators = new ItemStack[] {
				ItemUtils.simpleMetaStack(ModBlocks.blockRoundRobinator, 0, 1),
				ItemUtils.simpleMetaStack(ModBlocks.blockRoundRobinator, 1, 1),
				ItemUtils.simpleMetaStack(ModBlocks.blockRoundRobinator, 2, 1),
				ItemUtils.simpleMetaStack(ModBlocks.blockRoundRobinator, 3, 1),
				ItemUtils.simpleMetaStack(ModBlocks.blockRoundRobinator, 4, 1),
		};

		int aCostMultiplier = GTNH ? 2 : 1;	

		for (int i = 0; i < 5; i++) {			
			if (i == 0) {
				CORE.RA.addSixSlotAssemblingRecipe(				
						new ItemStack[] {
								CI.getNumberedCircuit(17),
								CI.getTieredMachineCasing(0),
								ItemUtils.getSimpleStack(Blocks.hopper, 4),
								CI.getTieredComponent(OrePrefixes.circuit, 0, 2)
						},					
						GT_Values.NF, //Input Fluid					
						aRobinators[i],					
						45 * 10 * 1, 
						8);
				continue;
			}			
			int aTier = i+1;
			ItemStack[] aInputs = new ItemStack[] {
					aRobinators[i-1],
					CI.getTieredMachineHull(aTier, 1 * aCostMultiplier),
					CI.getConveyor(aTier, 2 * aCostMultiplier),
					CI.getElectricMotor(aTier, 2 * aCostMultiplier),
					CI.getTieredComponent(OrePrefixes.plate, aTier, 4 * aCostMultiplier),
					CI.getTieredComponent(OrePrefixes.circuit, i, 2 * aCostMultiplier),
			};		

			CORE.RA.addSixSlotAssemblingRecipe(				
					aInputs,					
					GT_Values.NF, //Input Fluid					
					aRobinators[i],					
					45 * 10 * 1 * (i+1), 
					MaterialUtils.getVoltageForTier(i));	

		}
	}

}
