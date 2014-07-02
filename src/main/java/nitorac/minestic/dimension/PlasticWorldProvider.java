package nitorac.minestic.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import nitorac.minestic.core.MineStic;
import nitorac.minestic.dimension.fx.PlasticSkyRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PlasticWorldProvider extends WorldProvider
{
	IRenderHandler skyRenderer;
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(MineStic.plasticBiome, MineStic.PlasticDimID);
		this.hasNoSky = false;
	}

	public IChunkProvider createChunkGenerator() {
		return new PlasticChunkProvider(this.worldObj, this.worldObj.getSeed(), hasNoSky);
	}

	public int getAverageGroundLevel() {
		return 0;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int par1, int par2)
    {
    	if(this.worldObj.getWorldTime() >= 13000)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
	
	@SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer()
    {
            return new PlasticSkyRenderer();
    }

	public String getDimensionName() {
		return "Plastic's Lands";
	}

    public String getSaveFolder()
    {
        return (dimensionId == 0 ? null : "Plastics_Lands");
    }
    
    public void resetRainAndThunder()
    {
        worldObj.getWorldInfo().setRainTime(10);
        worldObj.getWorldInfo().setRaining(true);
        worldObj.getWorldInfo().setThunderTime(20);
        worldObj.getWorldInfo().setThundering(true);
        worldObj.rainingStrength = 10.0F;
		worldObj.thunderingStrength = 15.0F;
    }

    public boolean canDoLightning(Chunk chunk)
    {
        return true;
    }
	
	@Override
	public double getHorizon()
	{
		return 44.0D;
	}
    
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public boolean isSkyColored()
	{
	         return true;
	}

	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
		if(this.worldObj.getWorldTime() >= 13000)
		{
	         return this.worldObj.getWorldVec3Pool().getVecFromPool(0.1, 0.0, 0.5);
		}
		else
		{
	         return this.worldObj.getWorldVec3Pool().getVecFromPool(0.05, 0.0, 0.2);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Vec3 getCloudColor(float par1, float par2)
	{
		return this.worldObj.getWorldVec3Pool().getVecFromPool(0.9, 0.1, 0.1);
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float par1, float par2)
    {
    	if(this.worldObj.getWorldTime() >= 13000)
		{
	         return this.worldObj.getWorldVec3Pool().getVecFromPool(0.1, 0.0, 0.5);
		}
		else
		{
	         return this.worldObj.getWorldVec3Pool().getVecFromPool(0.05, 0.0, 0.2);
		}
    }
	
    @Override
    public double getMovementFactor()
    {
    	return 20.0;
    }
    
	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return 200.0F;
	}


	public boolean canCoordinateBeSpawn(int par1, int par2) {
		return false;
	}

	public ChunkCoordinates getEntrancePortalLocation() {
		return new ChunkCoordinates(50, 5, 0);
	}
}