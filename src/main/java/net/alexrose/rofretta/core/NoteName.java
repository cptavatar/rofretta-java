package net.alexrose.rofretta.core;

import java.util.HashMap;
import java.util.Map;

/**
 * NoteName.java
 * 
 * This enumeration is used for note names for the 12 
 * basic notes
 */
public enum NoteName {


    DISABLED(-1, ""),

    C(0, "C"),
    D(2, "D"),
    E(4, "E"),
    F(5, "F"),
    G(7, "G"),
    A(9, "A"),
    B(11, "B");

    
    private static Map<String,NoteName> notesByName = new HashMap();
    private static Map<Integer,NoteName> notesByOffset = new HashMap();
    
    static {
        for(NoteName note: NoteName.values()) {
            notesByName.put(note.getPrettyName(), note);
            
            //for values, default to sharps
            if (!note.getPrettyName().contains("\u266D") || "".equals(note.getPrettyName())) {
                notesByOffset.put(note.getOffset(), note);
            }
        }
    }

    private final int offset;
    private final String prettyName;
    
    NoteName(int note, String name) {
        this.offset = note;
        this.prettyName = name;
    }

    public static NoteName valueOfPrettyName(String name) {
        return notesByName.get(name.toUpperCase());
    }

    public static NoteName valueOfOffset(int relativeValue) {
        return notesByOffset.get(relativeValue);
    }

    public String getPrettyName() {
        return prettyName;
    }

    public int getOffset() {
        return offset;
    }
}