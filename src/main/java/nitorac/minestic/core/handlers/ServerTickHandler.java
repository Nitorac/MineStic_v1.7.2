package nitorac.minestic.core.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import nitorac.minestic.core.MineStic;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ServerTickHandler
{
	private Minecraft mc;
	
	public ServerTickHandler(Minecraft mc)
	{
		this.mc = mc;
	}
	
	/*@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event)
	{
		
			
	}*/
}