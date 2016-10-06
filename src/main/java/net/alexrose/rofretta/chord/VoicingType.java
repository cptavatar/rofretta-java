package net.alexrose.rofretta.chord;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration covering what "type" of voicing we have, so we know how to deal with
 * issues like transposition and drawing.
 */
public enum VoicingType {
    OPEN ("Open", false),
    BAR ("Bar", true),
    MOVABLE_SHAPE("Shape", true);
    
    public static final Map<String, VoicingType> typeByPrettyName = new HashMap();

    static {
        for(VoicingType type : VoicingType.values()) 
            typeByPrettyName.put(type.getPrettyName(), type);
    }
    
    private final boolean movable;
    private final String prettyName;


    VoicingType(String name, boolean isMovable) {
       this.prettyName = name;
       movable = isMovable;
    }

    public static VoicingType valueOfPrettyName(String prettyName) {
        return typeByPrettyName.get(prettyName);
    }

    public boolean isMovable(){return movable;}
    public String getPrettyName() {return prettyName;}
    
}