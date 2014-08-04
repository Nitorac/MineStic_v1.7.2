package nitorac.minestic.core.blocks_fluids;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nitorac.minestic.core.MineStic;
import nitorac.minestic.core.tileentity.TileEntityPlasticExtractor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class PlasticExtractor extends BlockContainer
{
    /**
     * See TestTileBlock
     */
    public PlasticExtractor()
    {
        super(Material.rock);
        this.setCreativeTab(MineStic.PlasticTab1);
    }
 
    @Override
    public boolean hasTileEntity(int meta)
    {
        return true;
    }
 
    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileEntityPlasticExtractor();
    }
 
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par1, float par2, float par3, float par4)
    {
        entityPlayer.openGui(MineStic.modInstance, 1, world, x ,y, z);
        return true;
    }
 
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName());
    }
}