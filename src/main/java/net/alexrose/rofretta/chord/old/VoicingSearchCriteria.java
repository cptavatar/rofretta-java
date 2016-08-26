package net.alexrose.rofretta.chord.old;

import java.io.Serializable;

/**
 *
 * @author  Alex
 * @version
 */
public class VoicingSearchCriteria implements Serializable{
    private NoteName root;
    private ChordType chordType;
    private VoicingType voicingType;
    private Instrument tuning;

    public ChordType getChordType() {
        return chordType;
    }

    public void setChordType(ChordType chordType) {
        this.chordType = chordType;
    }

    public NoteName getRoot() {
        return root;
    }

    public void setRoot(NoteName root) {
        this.root = root;
    }

    public Instrument getTuning() {
        return tuning;
    }

    public void setTuning(Instrument tuning) {
        this.tuning = tuning;
    }

    public VoicingType getVoicingType() {
        return voicingType;
    }

    public void setVoicingType(VoicingType voicingType) {
        this.voicingType = voicingType;
    }
    
    public void validate() throws ParameterException {
        
    }

    public boolean voicingMatchesSpec(Voicing voicing) {
        return false;
    }
    
}
