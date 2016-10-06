/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.alexrose.rofretta.chord;

import java.util.HashMap;
import java.util.Map;

/**
 * Finger is an enumeration for the various fingers on the human hand that
 * can be specified for fingering any giving chord voicing.
 */
public enum Finger {

    UNKNOWN(-1),
    INDEX(1),
    MIDDLE(2),
    RING(3),
    LITTLE(4),
    THUMB(5);
    
    private static Map<Integer, Finger> fingerById = new HashMap();
    static {
        for(Finger finger : Finger.values()) {
            fingerById.put(finger.id, finger);
        }
    }

    private final int id;
    
    /**
     * Custom constructor so we can specify an id.
     * @param value
     */
    Finger(int value) {
        this.id = value;
    }

    /**
     * Attempt to look up a Finger by its id instead of its value - for instance
     * -1 instead of "UNKNOWN"
     * @param id
     * @return
     */
    public static Finger valueOfId(int id) {
        Finger retval = fingerById.get(id);

        //if we can't find the specified index
        if(retval == null)
            return UNKNOWN;
        else
            return retval;
    }
    
    /**
     * Silly convenience method to make life a little easier - should 
     * probalby be moved to the presentation layer.
     * @return The id of the Finger as a string if the Finger is not unknown else
     * return the empty string.
     */
    public String getDisplayValue() {
        if(id > 0)
            return "" + id;
        
        return "";
    }

    public int getValue() {
        return id;
    }
}
