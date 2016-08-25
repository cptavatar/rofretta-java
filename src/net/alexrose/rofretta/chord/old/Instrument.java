package net.alexrose.rofretta.chord.old;

/**
 * Instrument is a class to capture the basic information about a stringed instrument, 
 * for instance how many strings does it have, how is it tuned, what is it called.
 * 
 * @author  Alex
 * @version
 */
public class Instrument {

    public static final Instrument GUITAR_STANDARD = new Instrument(
            "Guitar, Standard Tuning",
            new int[]{40, 45, 50, 55, 59, 64},
            24);
    
    private int[] midiNoteNumbers;
    private String name;
    private int maxFret;

    public Instrument(String name, int[] newTuning, int maxFret) {
        this.name = name;
        midiNoteNumbers = newTuning;
        this.maxFret = maxFret;
    }

    public int[] getStringTunings() {
        return midiNoteNumbers;
    }

    public boolean equals(Object candidate) {
        if (candidate.getClass() != this.getClass()) {
            return false;
        }
        if (candidate == this) {
            return true;
        }

        int[] b = ((Instrument) candidate).getStringTunings();

        if (b.length != midiNoteNumbers.length) {
            return false;
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] != midiNoteNumbers[i]) {
                return false;
            }
        }

        return true;
    }
}