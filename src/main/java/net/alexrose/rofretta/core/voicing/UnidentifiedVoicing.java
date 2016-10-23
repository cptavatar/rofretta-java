package net.alexrose.rofretta.core.voicing;

import net.alexrose.rofretta.core.Finger;
import net.alexrose.rofretta.core.Instrument;
import net.alexrose.rofretta.core.InstrumentString;
import net.alexrose.rofretta.core.ParameterException;

import java.util.List;
import java.util.Optional;

/**
 * UnidentifiedVoicing is the basic attributes of the voicing:
 * - what the tuning is
 * - what the strings are playing
 *
 * That we can then pass around before we identify it
 */
public class UnidentifiedVoicing {

    private final List<InstrumentString> strings;
    private final Instrument tuning;

    public UnidentifiedVoicing(List<InstrumentString> strings, Instrument tuning) {
        this.tuning = tuning;
        this.strings = strings;
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

    public Optional<Integer> midiNoteforString(int whichString) {
        InstrumentString string = strings.get(whichString);

        if (!string.isDisabled()) {
            return Optional.of(string.getFret() + getTuning().getStringTunings().get(whichString));
        }
        return Optional.empty();
    }
}
