package net.alexrose.rofretta.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            Arrays.asList(new Integer[]{40, 45, 50, 55, 59, 64}),
            24);

    private final List<Integer> midiNoteNumbers;
    private final String name;
    private final int maxFret;

    public Instrument(String name, List<Integer> tunings, int maxFret) {
        this.name = name;
        midiNoteNumbers = Collections.unmodifiableList(tunings);
        this.maxFret = maxFret;
    }

    public List<Integer> getStringTunings() {
        return midiNoteNumbers;
    }

    public int getNumStrings() {
        return midiNoteNumbers.size();
    }

}