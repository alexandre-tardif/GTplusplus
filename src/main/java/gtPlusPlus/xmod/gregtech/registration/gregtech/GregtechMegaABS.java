package gtPlusPlus.xmod.gregtech.registration.gregtech;

import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.core.lib.CORE;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import gtPlusPlus.xmod.gregtech.common.tileentities.machines.multi.production.GregtechMetaTileEntity_MegaABS;

public class GregtechMegaABS {

    public static void run() {
        if (gtPlusPlus.core.lib.LoadedMods.Gregtech) {
            Logger.INFO("Gregtech5u Content | Registering Blazing Blast Smelter (Mega ABS) Multiblock.");
            if (CORE.ConfigSwitches.enableMultiblock_BlazingBlastSmelter) {
                run1();
            }
        }

    }

    private static void run1() {
        // Blazing Blast Smelter (Mega Alloy Blast Smelter) Multiblock
        GregtechItemList.Industrial_MegaAlloyBlastSmelter.set(new GregtechMetaTileEntity_MegaABS(31080,
                "blazingblastsmelter.controller.tier.single", "Blazing Blast Smelter").getStackForm(1L));

    }
}
