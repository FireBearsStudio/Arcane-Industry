package com.firebearsstudio.arcaneindustry.blocks;

import net.minecraft.util.IStringSerializable;

public enum EnumType implements IStringSerializable {
    WHITE(0, "white"),
    BLACK(1, "black");

    private int ID;
    private String name;
    
    private EnumType(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
    	return getName();
    }

    public int getID() {
        return ID;
    }
    
    public String getNameFromMeta(int meta) {
    	return EnumType.values()[meta].name;
    }
}