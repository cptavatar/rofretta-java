package net.alexrose.rofretta.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A voicing is the core of what we know about a core played on a fretted instrument
 * - what root, what frets are depressed, which fingers are used, etc.
 */
public class Voicing {

    private final NoteName root;
    private final ChordType chord;
    private final VoicingType type;
    private final List<InstrumentString> strings;
    private final Instrument tuning;

    /**
     * This constructor just gives you an
     * safe voicing to play with if you don't want to set args - you probably want the other one.
     *
     * @param tuning
     */
    public Voicing(Instrument tuning) {
        this.tuning = tuning;
        this.chord = ChordType.MAJOR;
        this.root = NoteName.A;
        this.type = VoicingType.OPEN;

        int numStrings = tuning.getNumStrings();

        List<InstrumentString> tmpStrings = new ArrayList<>(numStrings);
        for (int i = 0; i < numStrings; i++) {
            tmpStrings.add(new InstrumentString());
        }
        strings = Collections.unmodifiableList(tmpStrings);
    }

    /**
     * This is the voicing constructor you want...
     *
     * @param root
     * @param chord
     * @param type
     * @param strings
     * @param tuning
     */
    public Voicing(NoteName root, ChordType chord, VoicingType type, List<InstrumentString> strings, Instrument tuning) {
        this.root = root;
        this.chord = chord;
        this.type = type;
        this.tuning = tuning;
        this.strings = strings;
    }

   
    public NoteName getRoot() {
        return root;
    }


    public List<InstrumentString> getStrings() {
        return strings;
    }

    public Instrument getTuning() {
        return tuning;
    }

    public InstrumentString getFingering(int index) throws ParameterException {
        if (index > -1 && index < strings.size()) {
            return strings.get(index);
        } else {
            throw new ParameterException("Fingering index out of bounds.");
        }
    }

    public String getFingerDisplayValue(int index) throws ParameterException {
        if (index > -1 && index < strings.size()) {
            return strings.get(index).getFinger().getDisplayValue();
        } else {
            throw new ParameterException("Fingering index out of bounds.");
        }
    }
    
    public String getFretDisplayValue(int index) throws ParameterException {
        if (index > -1 && index < strings.size()) {
            return "" + strings.get(index).getFret();
        } else {
            throw new ParameterException("Fingering index out of bounds.");
        }
    }

    public int getFret(int whichString) {
        return strings.get(whichString).getFret();
    }
    
    public Finger getFinger(int whichString) {
        return strings.get(whichString).getFinger();
    }


    public ChordType getChordType() {
        return chord;
    }


    public VoicingType getVoicingType() {
        return type;
    }



}

