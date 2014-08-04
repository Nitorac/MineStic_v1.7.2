package nitorac.minestic.core.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import nitorac.minestic.core.blocks_fluids.gui.PExtractorGUI;
import nitorac.minestic.core.blocks_fluids.gui.PExtractorInv;
import nitorac.minestic.core.tileentity.TileEntityPlasticExtractor;
import cpw.mods.fml.common.network.IGuiHandler;

public class PGuiHandler implements IGuiHandler
{
    public PGuiHandler(){}
 
    /**
     * Gets the server element.
     * This means, do something server side, when this ID gets called.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == 1)
        {
            // Create an Object of our TE, so we can give that to our inventory.
            TileEntityPlasticExtractor TileEntityPlasticExtractor = (TileEntityPlasticExtractor) world.getTileEntity(x, y, z);
            return new PExtractorInv(player.inventory, TileEntityPlasticExtractor);
        }
        return null;
    }
 
    /**
     * Gets the client element.
     * This means, do something client side, when this ID gets called.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == 1)
        {
            // Create an Object of our TE, so we can give that to our GUI.
            TileEntityPlasticExtractor TileEntityPlasticExtractor = (TileEntityPlasticExtractor) world.getTileEntity(x, y, z);
            return new PExtractorGUI(player.inventory, TileEntityPlasticExtractor);
        }
        return null;
    }
}