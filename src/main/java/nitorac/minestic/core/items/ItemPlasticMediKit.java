package nitorac.minestic.core.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemPlasticMediKit extends Item
{
	public ItemPlasticMediKit()
    {
        this.maxStackSize = 4;
    }

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(player.capabilities.isCreativeMode == false)
		{
			if (player.getHealth() == 20 && player.getFoodStats().getFoodLevel() == 20)
			{
				player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + I18n.format("PlasticMediKit.FullHealth", new Object[0])));
			}
			else if (player.getHealth() != 20 || player.getFoodStats().getFoodLevel() != 20)
			{
			player.heal(6);
			player.getFoodStats().setFoodLevel(20);
			--stack.stackSize;
			}
		}
		else
		{
			player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + I18n.format("PlasticMediKit.Creative", new Object[0])));
		}
		return stack;
	}    
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		return EnumRarity.rare;
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack){
		return true;
	}
}