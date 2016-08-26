package net.alexrose.rofretta.chord.old;

import java.util.HashMap;
import java.util.Map;

/**
 * NoteName.java
 * 
 * This enumeration is used for note names for the 12 
 * basic notes
 * 
 * @author Alex Rose
 * @version 
 */
public enum NoteName {

    A(0, "A"),
    A_SHARP(1, "A\u266F"),
    B_FLAT(1, "B\u266D"),
    B(2, "B"),
    C(3, "C"),
    C_SHARP(4, "C\u266F"),
    D_FLAT(4, "D\u266D"),
    D(5, "D"),
    D_SHARP(6, "D\u266F"),
    E_FLAT(6, "E\u266D"),
    E(7, "E"),
    F(8, "F"),
    F_SHARP(9, "F\u266F"),
    G_FLAT(9, "G\u266D"),
    G(10, "G"),
    G_SHARP(11, "G\u266F"),
    A_FLAT(11, "A\u266D");
    
    private static Map<String,NoteName> notesByName = new HashMap();
    private static Map<Integer,NoteName> notesByOffset = new HashMap();
    
    static {
        for(NoteName note: NoteName.values()) {
            notesByName.put(note.getPrettyName(), note);
            
            //for values, default to sharps
            if(! note.getPrettyName().contains("\u266D")){
                notesByOffset.put(note.getOffset(), note);
            }
        }
    }
    
    private int offset = 0;
    private String prettyName;
    
    NoteName(int note, String name) {
        this.offset = note;
        this.prettyName = name;
    }

    public static NoteName valueOfPrettyName(String name) {
        return notesByName.get(name);
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