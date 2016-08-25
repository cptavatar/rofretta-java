package net.alexrose.rofretta.chord.old;

import java.io.Serializable;

/**
 *
 * @author  Alex
 * @version
 */
public class Voicing implements Serializable, Cloneable {

    private NoteName root;
    private ChordType chord;
    private VoicingType type;
    private InstrumentString[] strings;
    private Instrument tuning;
    private int id;
    
    public Voicing(Instrument tuning) {
        this.tuning = tuning;
        this.chord = ChordType.MAJOR;
        this.root = NoteName.A;
        this.type = VoicingType.OPEN;
        
        int numStrings = tuning.getStringTunings().length;
        strings = new InstrumentString[numStrings];
        for (int i = 0; i < numStrings; i++) {
            strings[i] = new InstrumentString();
        }
    }

    public Voicing(NoteName root, ChordType chord, VoicingType type, InstrumentString[] strings, Instrument tuning) {
        this.root = root;
        this.chord = chord;
        this.type = type;
        this.tuning = tuning;
        setFingerings(strings);

    }

    public Voicing(Voicing oldChord, NoteName newRoot) throws ParameterException {

        throw new RuntimeException("Not implemented");
    }

   
    public NoteName getRoot() {
        return root;
    }

    public void setRoot(NoteName newRoot) {
        root = newRoot;
    }

    public InstrumentString[] getStrings() {
        return strings;
    }

    public Instrument getTuning() {
        return tuning;
    }

    public InstrumentString getFingering(int index) throws ParameterException {
        if (index > -1 && index < strings.length) {
            return strings[index];
        } else {
            throw new ParameterException("Fingering index out of bounds.");
        }
    }

    public String getFingerDisplayValue(int index) throws ParameterException {
        if (index > -1 && index < strings.length) {
            return strings[index].getFinger().getDisplayValue();
        } else {
            throw new ParameterException("Fingering index out of bounds.");
        }
    }
    
    public String getFretDisplayValue(int index) throws ParameterException {
         if (index > -1 && index < strings.length) {
            return "" + strings[index].getFret();
        } else {
            throw new ParameterException("Fingering index out of bounds.");
        }
    }
    public InstrumentString[] getFingerings() {
        return strings;
    }


    public void setFingering(InstrumentString string, int index)
            throws ParameterException {
        if (index > -1 && index < strings.length) {
            strings[index] = string;
        } else {
            throw new ParameterException(
                    "Index out of bounds for given number of strings.");
        }
    }

    public void setFingerings(InstrumentString[] newStrings) {
        if(newStrings.length != tuning.getStringTunings().length)
            throw new ParameterException("You must have one fingering per instrument string.");
        strings = newStrings;
    }

    public int getFret(int whichString) {
        return strings[whichString].getFret();
    }
    
    public Finger getFinger(int whichString) {
        return strings[whichString].getFinger();
    }
    
    public boolean isRoot (int whichString) {
        //@TODO fix me
        return false;
    }

    public ChordType getChordType() {
        return chord;
    }

    public void setChordType(ChordType chord) {
        this.chord = chord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VoicingType getVoicingType() {
        return type;
    }

    public void setVoicingType(VoicingType type) {
        this.type = type;
    }
    
    public void transpose(NoteName newRoot) throws ParameterException {
        
    }
    
    public void validate() throws ParameterException {
        
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Voicing clone = new Voicing(tuning);
        
        //first copy the references that are "clone safe"
        clone.id = id;
        clone.chord = chord;
        clone.root = root;
        clone.type = type;
        
        for(int i = 0; i < strings.length; i ++) {
            clone.strings[i] = (InstrumentString) strings[i].clone();
        }
        
        return clone;
    }
    
}

