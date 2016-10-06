package net.alexrose.rofretta.core;

import java.io.Serializable;

/**
 * InstrumentString represents the state of a string on an instrument: is the string 
 * being plucked or is it disabled, what fret (if any) is being depressed, what
 * finger (if any) is being used to depress tht 
 *
 */
public class InstrumentString implements Serializable {

    private static final int DISABLED = -1;
    private final int fret;
    private final Finger finger;
   

    public InstrumentString() {
        fret = DISABLED;
        finger = Finger.UNKNOWN;
    }
    
    public InstrumentString(int fret, Finger finger) {
        this.fret = fret;
        this.finger = finger;
    }

    public InstrumentString(int fret, int finger) {
        this.fret = fret;
        this.finger = Finger.valueOfId(finger);
    }

    /**
     * @return The fingering for the string.
     */
    public Finger getFinger() {
        return finger;
    }

    /**
     * @return The fret used.
     */
    public int getFret() {
        return fret;
    }


    public boolean equals(Object candidate) {
        if (candidate.getClass() != this.getClass()) {
            return false;
        }
        if (candidate == this) {
            return true;
        }
        InstrumentString b = (InstrumentString) candidate;
        return (fret == b.getFret()) && finger.equals(b.getFinger());
    }


}
