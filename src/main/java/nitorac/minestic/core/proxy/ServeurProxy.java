package nitorac.minestic.core.proxy;

import nitorac.minestic.core.tileentity.TileEntityPlasticExtractor;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServeurProxy
{
	public void registerRenderThings()
	{

	}
	
	public void registerNetworkStuff()
	{
		
	}
	
	public void registerTileEntity()
	{
		GameRegistry.registerTileEntity(TileEntityPlasticExtractor.class, "TileEntityPlasticExtractor");
	}
	
	public void registerRender()
	{
		
	}

}