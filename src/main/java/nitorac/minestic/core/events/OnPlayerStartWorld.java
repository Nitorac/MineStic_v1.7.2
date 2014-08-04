package nitorac.minestic.core.events;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import nitorac.minestic.core.MineStic;

import org.apache.commons.io.FileUtils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class OnPlayerStartWorld
{
	public static String localVersion = MineStic.version;
	
	@SubscribeEvent
	public final void openStream(PlayerEvent.PlayerLoggedInEvent e) throws IOException
	{
		try {
				URL url = new URL("http://electroteam.bl.ee/MineSticversion.txt");
				File file = File.createTempFile("minesticVersion", ".txt");
				file.deleteOnExit();
				FileUtils.copyURLToFile(url, file);
				String remoteVersion = FileUtils.readFileToString(file);
				
				if(remoteVersion.equals(localVersion))
				{
					e.player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + "" + EnumChatFormatting.BOLD + "Minestic " + EnumChatFormatting.GRAY + "V" + remoteVersion + EnumChatFormatting.AQUA + I18n.format("startWorldwithoutUpdate", new Object[0])));
				}
				else
				{
					e.player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + I18n.format("startWorldUpdate.1", new Object[0]) + EnumChatFormatting.BOLD + "MineStic" + EnumChatFormatting.RED + I18n.format("startWorldUpdate.2", new Object[0]) + EnumChatFormatting.GRAY + "V" + localVersion + EnumChatFormatting.RED + " --> " + EnumChatFormatting.GRAY + "V" + remoteVersion + EnumChatFormatting.RED + ")"));
					e.player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + I18n.format("startWorldUpdate.3", new Object[0]) + EnumChatFormatting.DARK_AQUA+""+EnumChatFormatting.UNDERLINE + "-link-"));
					}
			}
			catch (IOException ex)
			{
				e.player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Vous n'etes pas connecte a Internet"));
			}
		}
	}
