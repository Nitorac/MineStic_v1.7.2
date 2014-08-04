package nitorac.minestic.core.blocks_fluids.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nitorac.minestic.core.MineStic;
import nitorac.minestic.core.tileentity.TileEntityPlasticExtractor;

public class PExtractorGUI extends GuiContainer
{
    /**
     * See TestGUI
     */
    private static final ResourceLocation backgroundimage = new ResourceLocation(MineStic.modid.toLowerCase() + ":" + "textures/gui/PExtractor.png");
 
    public PExtractorGUI(InventoryPlayer inventoryPlayer, TileEntityPlasticExtractor TileEntityPlasticExtractor)
    {
        super(new PExtractorInv(inventoryPlayer, TileEntityPlasticExtractor));
        xSize = 176;
        ySize = 214;
    }
 
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        //Bind Texture
        this.mc.getTextureManager().bindTexture(backgroundimage);
        // set the x for the texture, Total width - textureSize / 2
        par2 = (this.width - xSize) / 2;
        // set the y for the texture, Total height - textureSize - 30 (up) / 2,
        int j = (this.height - ySize) / 2;
        // draw the texture
        drawTexturedModalRect(par2, j, 0, 0, xSize,  ySize);
    }
}