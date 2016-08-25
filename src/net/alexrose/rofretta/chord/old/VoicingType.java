package net.alexrose.rofretta.chord.old;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author  Alex
 * @version
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
    
    public static VoicingType valueOfPrettyName(String prettyName) {
        return typeByPrettyName.get(prettyName);
    }
    
    private final boolean movable;
    private final String prettyName;
    
    VoicingType(String name, boolean isMovable) {
       this.prettyName = name;
       movable = isMovable;
    }
    public boolean isMovable(){return movable;}
    public String getPrettyName() {return prettyName;}
    
}