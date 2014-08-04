package nitorac.minestic.core.blocks_fluids.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nitorac.minestic.core.MineStic;

public class PExtractorSlotOut extends Slot
{
    public PExtractorSlotOut(IInventory inventory, int slotIndex, int x, int y)
    {
        super(inventory, slotIndex, x ,y);
    }
 
    @Override
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItem() == MineStic.PlasticDust;
    }
    
}