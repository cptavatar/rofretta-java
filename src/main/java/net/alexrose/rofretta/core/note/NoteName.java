package net.alexrose.rofretta.core.note;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * NoteName.java
 * <p>
 * This enumeration is used for note names for the 12
 * basic notes
 */
public enum NoteName {


    DISABLED(-1, "", -1),

    C(0, "C", 0),
    D(2, "D", 1),
    E(4, "E", 2),
    F(5, "F", 3),
    G(7, "G", 4),
    A(9, "A", 5),
    B(11, "B", 6);


    private static final Map<String, NoteName> notesByName;
    private static final Map<Integer, NoteName> notesByIndex;
    private static final Map<Integer, NoteName> notesByOffset;

    static {
        LinkedHashMap<String, NoteName> nameMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, NoteName> indexMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, NoteName> offsetMap = new LinkedHashMap<>();
        for (NoteName note : NoteName.values()) {
            //for values, default to sharps
            if (!note.equals(DISABLED)) {
                nameMap.put(note.getPrettyName(), note);
                indexMap.put(note.getIndex(), note);
                offsetMap.put(note.getOffset(), note);
            }
        }
        notesByName = Collections.unmodifiableMap(nameMap);
        notesByIndex = Collections.unmodifiableMap(indexMap);
        notesByOffset = Collections.unmodifiableMap(offsetMap);
    }

    private final int offset;
    private final String prettyName;
    private final int index;

    NoteName(int note, String name, int index) {
        this.offset = note;
        this.prettyName = name;
        this.index = index;
    }

    public static NoteName valueOfPrettyName(String name) {
        return notesByName.get(name.toUpperCase());
    }

    public static NoteName valueOfIndex(int index) {
        return notesByIndex.get(index);
    }

    public static NoteName valueOfOffset(int offset) {
        return notesByOffset.get(offset);
    }

    public boolean isDisabled() {
        return (-1 == offset);
    }

    public String getPrettyName() {
        return prettyName;
    }

    public int getOffset() {
        return offset;
    }

    public int getIndex() {
        return index;
    }
}