package nitorac.minestic.core.creative_tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import nitorac.minestic.core.MineStic;

public class PlasticTab1 extends CreativeTabs {

public PlasticTab1(String tabLabel)
	{
		super(tabLabel);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
			return Item.getItemFromBlock(MineStic.PlasticChaud);
	}

}