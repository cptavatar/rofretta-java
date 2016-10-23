package net.alexrose.rofretta.core.voicing;

import net.alexrose.rofretta.core.ChordType;
import net.alexrose.rofretta.core.Instrument;
import net.alexrose.rofretta.core.InstrumentString;
import net.alexrose.rofretta.core.note.Note;

import java.util.List;

/**
 * A voicing is the core of what we know about a core played on a fretted instrument
 * - what root, what frets are depressed, which fingers are used, etc.
 */
public class Voicing extends UnidentifiedVoicing {
    private final VoicingType type;
    private final Note root;
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
    public Voicing(Note root, ChordType chord, VoicingType type, List<InstrumentString> strings, Instrument tuning) {
        super(strings, tuning);
        this.root = root;
        this.chord = chord;
        this.type = type;
    }

    public VoicingType getType() {
        return type;
    }

    public Note getRoot() {
        return root;
    }

    public ChordType getChordType() {
        return chord;
    }
}

