package net.alexrose.rofretta.core;

import java.util.List;

/**
 * A voicing is the core of what we know about a core played on a fretted instrument
 * - what root, what frets are depressed, which fingers are used, etc.
 */
public class Voicing extends UnidentifiedVoicing {
    private final VoicingType type;
    private final NoteName root;
    private final ChordType chord;

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
        super(strings, tuning);
        this.root = root;
        this.chord = chord;
        this.type = type;
    }

    public VoicingType getType() {
        return type;
    }

    public NoteName getRoot() {
        return root;
    }

    public ChordType getChordType() {
        return chord;
    }
}

