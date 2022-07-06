package gtPlusPlus.xmod.gregtech.common.tileentities.machines.multi.production;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import gregtech.api.GregTech_API;
import gregtech.api.enums.TAE;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.*;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import gregtech.api.util.GTPP_Recipe;
import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.core.block.ModBlocks;
import gtPlusPlus.core.lib.CORE;
import gtPlusPlus.core.recipe.common.CI;
import gtPlusPlus.core.util.minecraft.ItemUtils;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.base.GregtechMeta_MultiBlockBase;
import gtPlusPlus.xmod.gregtech.common.blocks.textures.TexturesGtBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static gregtech.api.util.GT_StructureUtility.ofHatchAdder;

public class GregtechMetaTileEntity_MegaABS extends GregtechMeta_MultiBlockBase<GregtechMetaTileEntity_MegaABS>{

    private int mMode = 0;
    private boolean isUsingControllerCircuit = false;
    private static Item circuit;
    private int mCasing;
    private IStructureDefinition<GregtechMetaTileEntity_MegaABS> STRUCTURE_DEFINITION = null;


    public GregtechMetaTileEntity_MegaABS(final int aID, final String aName, final String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GregtechMetaTileEntity_MegaABS(final String aName) {
        super(aName);
    }

    @Override
    public IMetaTileEntity newMetaEntity(final IGregTechTileEntity aTileEntity) {
        return new GregtechMetaTileEntity_MegaABS(this.mName);
    }

    @Override
    public String getMachineType() {
        return "Fluid Alloy Cooker";
    }

    @Override
    protected GT_Multiblock_Tooltip_Builder createTooltip() {
        GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType(getMachineType())
                .addInfo("Controller Block for the Blazing Blast Smelter")
                .addInfo("Large version of the Alloy Blast Smelter")
                .addInfo("Allows Complex GT++ alloys to be created")
                .addInfo("The tier of the Energy Hatches decides which recipes can be run")
                .addInfo("Each Input Bus can have a different circuit to run specific recipes")
                .addPollutionAmount(getPollutionPerSecond(null))
                .addSeparator()
                .beginStructureBlock(3, 4, 3, true)
                .addController("Bottom Center")
                .addCasingInfo("Blast Smelter Casings", 10)
                .addCasingInfo("Blast Smelter Heat Containment Coils", 16)
                .addInputBus("Any Casing", 1)
                .addInputHatch("Any Casing", 1)
                .addOutputHatch("Any Casing", 1)
                .addEnergyHatch("Any Casing", 1)
                .addMaintenanceHatch("Any Casing", 1)
                .addMufflerHatch("Any Casing", 1)
                .toolTipFinisher(CORE.GT_Tooltip_Builder);
        return tt;
    }

    @Override
    public IStructureDefinition<GregtechMetaTileEntity_MegaABS> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<GregtechMetaTileEntity_MegaABS>builder()
                    .addShape(mName, transpose(new String[][]{
                            {"               ", "               ", "               ", "     CCCCC     ", "    CCCCCCC    ", "   CCCCCCCCC   ", "   CCCCCCCCC   ", "   CCCCCCCCC   ", "   CCCCCCCCC   ", "   CCCCCCCCC   ", "    CCCCCCC    ", "     CCCCC     ", "               ", "               ", "               "},
                            {"               ", "               ", "               ", "     HHCHH     ", "    H-----H    ", "   H-------H   ", "   H-------H   ", "   C-------C   ", "   H-------H   ", "   H-------H   ", "    H-----H    ", "     HHCHH     ", "               ", "               ", "               "},
                            {"               ", "               ", "               ", "     HHCHH     ", "    H-----H    ", "   H-------H   ", "   H-------H   ", "   C-------C   ", "   H-------H   ", "   H-------H   ", "    H-----H    ", "     HHCHH     ", "               ", "               ", "               "},
                            {"               ", "               ", "               ", "               ", "     HHCHH     ", "    HH---HH    ", "    H-----H    ", "    C-----C    ", "    H-----H    ", "    HH---HH    ", "     HHCHH     ", "               ", "               ", "               ", "               "},
                            {"               ", "               ", "               ", "               ", "               ", "      CCC      ", "     C---C     ", "     C---C     ", "     C---C     ", "      CCC      ", "               ", "               ", "               ", "               ", "               "},
                            {"               ", "               ", "               ", "               ", "               ", "      HHH      ", "     H---H     ", "     H---H     ", "     H---H     ", "      HHH      ", "               ", "               ", "               ", "               ", "               "},
                            {"               ", "               ", "               ", "               ", "               ", "      CCC      ", "     C---C     ", "     C---C     ", "     C---C     ", "      CCC      ", "               ", "               ", "               ", "               ", "               "},
                            {"               ", "               ", "               ", "               ", "               ", "      HHH      ", "     H---H     ", "     H---H     ", "     H---H     ", "      HHH      ", "               ", "               ", "               ", "               ", "               "},
                            {"               ", "               ", "               ", "               ", "               ", "      CCC      ", "     C---C     ", "     C---C     ", "     C---C     ", "      CCC      ", "               ", "               ", "               ", "               ", "               "},
                            {"               ", "               ", "               ", "               ", "     HHCHH     ", "    HH---HH    ", "    H-----H    ", "    C-----C    ", "    H-----H    ", "    HH---HH    ", "     HHCHH     ", "               ", "               ", "               ", "               "},
                            {"               ", "               ", "    HHHCHHH    ", "    HHHHHHH    ", "   HH-----HH   ", "  HH-------HH  ", "  HH-------HH  ", "  CC-------CC  ", "  HH-------HH  ", "  HH-------HH  ", "   HH-----HH   ", "    HHHHHHH    ", "    HHHCHHH    ", "               ", "               "},
                            {"               ", "    HHHCHHH    ", "   H-------H   ", "  HH-------HH  ", "  H---------H  ", " H-----------H ", " H-----------H ", " C-----------C ", " H-----------H ", " H-----------H ", "  H---------H  ", "  HH-------HH  ", "   H-------H   ", "    HHHCHHH    ", "               "},
                            {"     CCCCC     ", "   CC-----CC   ", "  C---------C  ", " C-----------C ", " C-----------C ", "C-------------C", "C-------------C", "C-------------C", "C-------------C", "C-------------C", " C-----------C ", " C-----------C ", "  C---------C  ", "   CC-----CC   ", "     CCCCC     "},
                            {"     HHCHH     ", "   HH-----HH   ", "  H---------H  ", " H-----------H ", " H-----------H ", "H-------------H", "H-------------H", "C-------------C", "H-------------H", "H-------------H", " H-----------H ", " H-----------H ", "  H---------H  ", "   HH-----HH   ", "     HHCHH     "},
                            {"     HHCHH     ", "   HH-----HH   ", "  H---------H  ", " H-----------H ", " H-----------H ", "H-------------H", "H-------------H", "C-------------C", "H-------------H", "H-------------H", " H-----------H ", " H-----------H ", "  H---------H  ", "   HH-----HH   ", "     HHCHH     "},
                            {"     HHCHH     ", "   HH-----HH   ", "  H---------H  ", " H-----------H ", " H-----------H ", "H-------------H", "H-------------H", "C-------------C", "H-------------H", "H-------------H", " H-----------H ", " H-----------H ", "  H---------H  ", "   HH-----HH   ", "     HHCHH     "},
                            {"     HHCHH     ", "   HH-----HH   ", "  H---------H  ", " H-----------H ", " H-----------H ", "H-------------H", "H-------------H", "C-------------C", "H-------------H", "H-------------H", " H-----------H ", " H-----------H ", "  H---------H  ", "   HH-----HH   ", "     HHCHH     "},
                            {"     HHCHH     ", "   HH-----HH   ", "  H---------H  ", " H-----------H ", " H-----------H ", "H-------------H", "H-------------H", "C-------------C", "H-------------H", "H-------------H", " H-----------H ", " H-----------H ", "  H---------H  ", "   HH-----HH   ", "     HHCHH     "},
                            {"     HHCHH     ", "   HH-----HH   ", "  H---------H  ", " H-----------H ", " H-----------H ", "H-------------H", "H-------------H", "C-------------C", "H-------------H", "H-------------H", " H-----------H ", " H-----------H ", "  H---------H  ", "   HH-----HH   ", "     HHCHH     "},
                            {"     HH~HH     ", "   HH-----HH   ", "  H---------H  ", " H-----------H ", " H-----------H ", "H-------------H", "H-------------H", "C-------------C", "H-------------H", "H-------------H", " H-----------H ", " H-----------H ", "  H---------H  ", "   HH-----HH   ", "     HHCHH     "},
                            {"     CCCCC     ", "   CCCCCCCCC   ", "  CCCCCCCCCCC  ", " CCCCCCCCCCCCC ", " CCCCCCCCCCCCC ", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", " CCCCCCCCCCCCC ", " CCCCCCCCCCCCC ", "  CCCCCCCCCCC  ", "   CCCCCCCCC   ", "     CCCCC     "}
                    }))
                    .addElement(
                            'C',
                            ofChain(
                                    ofHatchAdder(
                                            GregtechMetaTileEntity_MegaABS::addAlloyBlastSmelterList, TAE.GTPP_INDEX(15), 1
                                    ),
                                    onElementPass(
                                            x -> ++x.mCasing,
                                            ofBlock(
                                                    ModBlocks.blockCasingsMisc, 15
                                            )
                                    )
                            )
                    )
                    .addElement(
                            'H',
                            ofBlock(
                                    ModBlocks.blockCasingsMisc, 14
                            )
                    )
                    .build();
        }
        return STRUCTURE_DEFINITION;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(mName , stackSize, hintsOnly, 1, 3, 0);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        mCasing = 0;
        return checkPiece(mName, 1, 3, 0) && mCasing >= 10 && checkHatch();
    }

    public final boolean addAlloyBlastSmelterList(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        if (aTileEntity == null) {
            return false;
        } else {
            IMetaTileEntity aMetaTileEntity = aTileEntity.getMetaTileEntity();
            if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_InputBus){
                return addToMachineList(aTileEntity, aBaseCasingIndex);
            } else if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_Maintenance){
                return addToMachineList(aTileEntity, aBaseCasingIndex);
            } else if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_Energy){
                return addToMachineList(aTileEntity, aBaseCasingIndex);
            } else if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_Muffler) {
                return addToMachineList(aTileEntity, aBaseCasingIndex);
            } else if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_Input) {
                return addToMachineList(aTileEntity, aBaseCasingIndex);
            } else if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_Output) {
                return addToMachineList(aTileEntity, aBaseCasingIndex);
            } else if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_OutputBus) {
                return addToMachineList(aTileEntity, aBaseCasingIndex);
            }
        }
        return false;
    }


    @Override
    public String getSound() {
        return GregTech_API.sSoundList.get(Integer.valueOf(208));
    }

    @Override
    protected IIconContainer getActiveOverlay() {
        return TexturesGtBlock.Overlay_Machine_Controller_Advanced_Active;
    }

    @Override
    protected IIconContainer getInactiveOverlay() {
        return TexturesGtBlock.Overlay_Machine_Controller_Advanced;
    }

    @Override
    protected int getCasingTextureId() {
        return TAE.GTPP_INDEX(15);
    }

    @Override
    public boolean hasSlotInGUI() {
        return true;
    }

    @Override
    public boolean requiresVanillaGtGUI() {
        return true;
    }

    @Override
    public String getCustomGUIResourceName() {
        return "ElectricBlastFurnace";
    }

    @Override
    public GT_Recipe.GT_Recipe_Map getRecipeMap() {
        return GTPP_Recipe.GTPP_Recipe_Map.sAlloyBlastSmelterRecipes;
    }

    @Override
    public boolean isCorrectMachinePart(final ItemStack aStack) {
        if (this.getBaseMetaTileEntity().isServerSide()) {
            //Get Controller Circuit
            if (circuit == null) {
                circuit = CI.getNumberedCircuit(0).getItem();
            }
            if (aStack != null && aStack.getItem() == circuit) {
                this.mMode = aStack.getItemDamage();
                return this.isUsingControllerCircuit = true;
            }
            else {
                if (aStack == null) {
                    this.isUsingControllerCircuit = false;
                    return true; //Allowed empty
                }
                Logger.WARNING("Not circuit in GUI inputs.");
                return this.isUsingControllerCircuit = false;
            }
        }
        Logger.WARNING("No Circuit, clientside.");
        return this.isUsingControllerCircuit = false;
    }

    @Override
    public boolean checkRecipe(final ItemStack aStack) {

        if (this.getBaseMetaTileEntity().isServerSide()) {
            //Get Controller Circuit
            this.isUsingControllerCircuit = isCorrectMachinePart(aStack);

            final ArrayList<ItemStack> tInputList = this.getStoredInputs();
            for (int i = 0; i < (tInputList.size() - 1); i++) {
                for (int j = i + 1; j < tInputList.size(); j++) {
                    if (GT_Utility.areStacksEqual(tInputList.get(i), tInputList.get(j))) {
                        if (tInputList.get(i).stackSize >= tInputList.get(j).stackSize) {
                            tInputList.remove(j--);
                        } else {
                            tInputList.remove(i--);
                            break;
                        }
                    }
                }
            }

            //Validity check
            if ((isUsingControllerCircuit && tInputList.size() < 1) || (!isUsingControllerCircuit && tInputList.size() < 2)) {
                Logger.WARNING("Not enough inputs.");
                return false;
            }
            else if (isUsingControllerCircuit  && tInputList.size() >= 1) {
                tInputList.add(CI.getNumberedCircuit(this.mMode));
            }


            final ItemStack[] tInputs = Arrays.copyOfRange(tInputList.toArray(new ItemStack[tInputList.size()]), 0, tInputList.size());

            final ArrayList<FluidStack> tFluidList = this.getStoredFluids();
            for (int i = 0; i < (tFluidList.size() - 1); i++) {
                for (int j = i + 1; j < tFluidList.size(); j++) {
                    if (GT_Utility.areFluidsEqual(tFluidList.get(i), tFluidList.get(j))) {
                        if (tFluidList.get(i).amount >= tFluidList.get(j).amount) {
                            tFluidList.remove(j--);
                        } else {
                            tFluidList.remove(i--);
                            break;
                        }
                    }
                }
            }
            final FluidStack[] tFluids = Arrays.copyOfRange(tFluidList.toArray(new FluidStack[tInputList.size()]), 0, 1);
            if (tInputList.size() > 1) {
                final long tVoltage = this.getMaxInputVoltage();
                final byte tTier = (byte) Math.max(1, GT_Utility.getTier(tVoltage));
                final GT_Recipe tRecipe = GTPP_Recipe.GTPP_Recipe_Map.sAlloyBlastSmelterRecipes.findRecipe(this.getBaseMetaTileEntity(), false, gregtech.api.enums.GT_Values.V[tTier], tFluids, tInputs);
                if ((tRecipe != null) && (tRecipe.isRecipeInputEqual(true, tFluids, tInputs))) {
                    Logger.WARNING("Found some Valid Inputs.");
                    this.mEfficiency = (10000 - ((this.getIdealStatus() - this.getRepairStatus()) * 1000));
                    this.mEfficiencyIncrease = 10000;
                    if (tRecipe.mEUt <= 16) {
                        this.mEUt = (tRecipe.mEUt * (1 << (tTier - 1)) * (1 << (tTier - 1)));
                        this.mMaxProgresstime = (tRecipe.mDuration / (1 << (tTier - 1)));
                    } else {
                        this.mEUt = tRecipe.mEUt;
                        this.mMaxProgresstime = tRecipe.mDuration;
                        while (this.mEUt <= gregtech.api.enums.GT_Values.V[(tTier - 1)]) {
                            this.mEUt *= 4;
                            this.mMaxProgresstime /= 2;
                        }
                    }
                    if (this.mEUt > 0) {
                        this.mEUt = (-this.mEUt);
                    }
                    this.mMaxProgresstime = Math.max(1, this.mMaxProgresstime);
                    this.mOutputFluids = new FluidStack[]{tRecipe.getFluidOutput(0)};
                    List<ItemStack> tOutPutItems = new ArrayList<ItemStack>();
                    for (ItemStack tOut : tRecipe.mOutputs) {
                        if (ItemUtils.checkForInvalidItems(tOut)) {
                            tOutPutItems.add(tOut);
                        }
                    }
                    if (tOutPutItems.size() > 0)
                        this.mOutputItems = tOutPutItems.toArray(new ItemStack[tOutPutItems.size()]);
                    this.updateSlots();
                    return true;
                }
            }
        }
        Logger.WARNING("Failed to find some Valid Inputs or Clientside.");
        return false;
    }

    @Override
    public int getMaxParallelRecipes() {
        return 1;
    }

    @Override
    public int getEuDiscountForParallelism() {
        return 0;
    }

    @Override
    public int getMaxEfficiency(final ItemStack aStack) {
        return 10000;
    }

    @Override
    public int getPollutionPerSecond(final ItemStack aStack) {
        return CORE.ConfigSwitches.pollutionPerSecondMultiABS;
    }

    @Override
    public int getDamageToComponent(final ItemStack aStack) {
        return 0;
    }

    @Override
    public int getAmountOfOutputs() {
        return 2;
    }

    @Override
    public boolean explodesOnComponentBreak(final ItemStack aStack) {
        return false;
    }
}
