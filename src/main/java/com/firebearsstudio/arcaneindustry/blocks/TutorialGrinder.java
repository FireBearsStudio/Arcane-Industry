package com.firebearsstudio.arcaneindustry.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.firebearsstudio.arcaneindustry.Main;
import com.firebearsstudio.arcaneindustry.tileentity.GrinderTileEntity;

public class TutorialGrinder extends BlockContainer{

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	static boolean hasTileEntity;
	
	protected TutorialGrinder(String unlocalizedName) {
		super(Material.rock);
		this.setUnlocalizedName(unlocalizedName);
		this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setHardness(1.5F);
		this.stepSound = soundTypeSnow;
		this.blockParticleGravity = 1.0F;
		this.slipperiness = 0.6f;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.lightOpacity = 20;	// cast a light shadow
		this.setTickRandomly(false);
		this.useNeighborBrightness = false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return Item.getItemFromBlock(ModBlocks.grinder);
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		if (!world.isRemote) {
			// rotate block if the front side is blocked
			Block blockToNorth = world.getBlockState(pos.north()).getBlock();
			Block blockToSouth = world.getBlockState(pos.south()).getBlock();
			Block blockToWest = world.getBlockState(pos.west()).getBlock();
			Block blockToEast = world.getBlockState(pos.east()).getBlock();
			EnumFacing enumFacing = (EnumFacing)state.getValue(FACING);
			
			if (enumFacing == EnumFacing.NORTH && blockToNorth.isFullBlock() && !blockToSouth.isFullBlock()) {
				enumFacing = EnumFacing.SOUTH;
			} else if (enumFacing == EnumFacing.SOUTH && blockToSouth.isFullBlock() && !blockToNorth.isFullBlock()) {
				enumFacing = EnumFacing.NORTH;
			} else if (enumFacing == EnumFacing.WEST && blockToWest.isFullBlock() && !blockToEast.isFullBlock()) {
				enumFacing = EnumFacing.EAST;
			} else if (enumFacing == EnumFacing.EAST && blockToEast.isFullBlock() && !blockToWest.isFullBlock()) {
				enumFacing = EnumFacing.WEST;
			}
			
			world.setBlockState(pos, state.withProperty(FACING, enumFacing), 2);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			player.openGui(Main.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new GrinderTileEntity();
	}

	@Override
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()));
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		if (!hasTileEntity) {
			TileEntity tileEntity = world.getTileEntity(pos);
			
			if (tileEntity instanceof GrinderTileEntity) {
				InventoryHelper.dropInventoryItems(world, pos, (GrinderTileEntity)tileEntity);
				world.updateComparatorOutputLevel(pos, this);
			}
		}
		
		super.breakBlock(world, pos, state);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, BlockPos pos) {
		return Item.getItemFromBlock(ModBlocks.grinder);
	}
	
	@Override
	public int getRenderType() {
		return 3;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IBlockState getStateForEntityRender(IBlockState state) {
		return getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumFacing = EnumFacing.getFront(meta);
		
		if (enumFacing.getAxis() == EnumFacing.Axis.Y) {
			enumFacing = EnumFacing.NORTH;
		}
		
		return getDefaultState().withProperty(FACING, enumFacing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
	
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {FACING});
	}
	
	@SideOnly(Side.CLIENT)
	static final class SwitchEnumFacing {
		static final int[] enumFacingArray = new int[EnumFacing.values().length];
		
		static {
			try {
				enumFacingArray[EnumFacing.WEST.ordinal()] = 1;
			} catch(NoSuchFieldError var4) {
				;
			}
			try {
				enumFacingArray[EnumFacing.EAST.ordinal()] = 2;
			} catch(NoSuchFieldError var4) {
				;
			}
			try {
				enumFacingArray[EnumFacing.NORTH.ordinal()] = 3;
			} catch(NoSuchFieldError var4) {
				;
			}
			try {
				enumFacingArray[EnumFacing.SOUTH.ordinal()] = 4;
			} catch(NoSuchFieldError var4) {
				;// improve error handling
			}
		}
	}
}
