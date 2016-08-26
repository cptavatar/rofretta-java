package net.alexrose.rofretta.chord.old;

import java.io.Serializable;

/**
 * InstrumentString represents the state of a string on an instrument: is the string 
 * being plucked or is it disabled, what fret (if any) is being depressed, what
 * finger (if any) is being used to depress tht 
 * 
 * @author  Alex
 * @version
 */
public class InstrumentString implements Serializable, Cloneable {

    private static final int DISABLED = -1;
    private int fret;
    private Finger finger;
   

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
     * Set the fingering
     *
     * @param newFingering
     *            the desired fingering.
     */
    public void setFinger(Finger finger) {
        this.finger = finger;
    }

    /**
     * @return The fret used.
     */
    public int getFret() {
        return fret;
    }

    /**
     * Set the fret used.
     * 
     * @param newFret
     *            The desired fret.
     */
    public void setFret(int fret) {
        this.fret = fret;
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
