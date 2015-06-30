package com.firebearsstudio.arcaneindustry.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.firebearsstudio.arcaneindustry.Main;
import com.firebearsstudio.arcaneindustry.inventory.GrinderContainer;
import com.firebearsstudio.arcaneindustry.tileentity.GrinderTileEntity;

public class GrinderGui extends GuiContainer {

	static final ResourceLocation grinderGuiTexture = new ResourceLocation(Main.MOD_ID + ":textures/gui/container/grinder.png");
	final InventoryPlayer playerInventory;
	final GrinderTileEntity tileGrinder;

	// coords of gui elements
	final int GRIND_BAR_XPOS = 79;
	final int GRIND_BAR_YPOS = 34;
	final int GRIND_BAR_ICON_U = 176;	// x pos of white arrow icon
	final int GRIND_BAR_ICON_V = 0;		// y pos of white arrow icon
	final int GRIND_BAR_WIDTH = 24;
	final int GRIND_BAR_HEIGHT = 17;
	
	public GrinderGui(InventoryPlayer playerInv, GrinderTileEntity grinder) {
		super(new GrinderContainer(playerInv, grinder));
		
		xSize = 176;
		ySize = 166;
		
		playerInventory = playerInv;
		this.tileGrinder = grinder;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// bind the image texture
		Minecraft.getMinecraft().getTextureManager().bindTexture(grinderGuiTexture);
		// draw the image
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		// get cook progress as a double between 0 and 1
		double cookProgress = tileGrinder.fractionOfCookTimeComplete();
		// draw the cook progress bar
		drawTexturedModalRect(guiLeft + GRIND_BAR_XPOS, guiTop + GRIND_BAR_YPOS, GRIND_BAR_ICON_U, GRIND_BAR_ICON_V, (int)(cookProgress * GRIND_BAR_WIDTH), GRIND_BAR_HEIGHT);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);

		final int LABEL_XPOS = 5;
		final int LABEL_YPOS = 5;
		
		String s = tileGrinder.getDisplayName().getUnformattedText();
		fontRendererObj.drawString(s, LABEL_XPOS, LABEL_YPOS, Color.DARK_GRAY.getRGB());
		//fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		fontRendererObj.drawString(playerInventory.getDisplayName().getUnformattedText(), 8, ySize - 96 + 2, 4210752);
		
		List<String> hoveringText = new ArrayList<String>();
		
		// if the mouse is over the progress bar add the progress bar hovering text
		if (isinRect(guiLeft + GRIND_BAR_XPOS, guiTop + GRIND_BAR_YPOS, GRIND_BAR_WIDTH, GRIND_BAR_HEIGHT, mouseX, mouseY)) {
			int cookPercentage = (int)(tileGrinder.fractionOfCookTimeComplete() * 100);
			hoveringText.add(cookPercentage + "%");
		}
		
		// if hoveringText is not empty draw the hovering text
		if (!hoveringText.isEmpty()) {
			drawHoveringText(hoveringText, mouseX - guiLeft, mouseY - guiTop, fontRendererObj);
		}
		
		// you must rebin the texture and reset the color if you still need to use it after drawing a string
	}
	
	// Returns true if the given x, y coordinates are within the given rectangle
	public static boolean isinRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
		return ((mouseX >= x && mouseX <= x + xSize) && (mouseY >= y && mouseY <= y + ySize));
	}

	int getProgressLevel(int progressIndicatorPixelWidth) {
		int ticksGrindingItemSoFar = tileGrinder.getField(2);
		int ticksPerItem = tileGrinder.getField(3);
		return ticksPerItem != 0 && ticksGrindingItemSoFar != 0 ?
				ticksGrindingItemSoFar * progressIndicatorPixelWidth / ticksPerItem : 0;
	}
}
