package net.alexrose.rofretta.chord;

import java.util.List;

/**
 * The catagorizer has one job - give it a list of strings and it will
 * tell you what "type" of voicing it is
 */
public class VoicingCatagorizer {

    /**
     * Our algorithm we'll use for now (we can tweak later)
     * - if we find an open string, its an open chord.
     * - if it has no open strings, but it has muted strings, we'll call it a shape
     * - if we hit all the strings and none are muted, we'll call it a bar chord
     *
     * @param strings
     * @return
     */
    public VoicingType catagorize(List<InstrumentString> strings) {
        boolean mutedFound = false;
        for (InstrumentString string : strings) {
            if (string.getFret() == 0) {
                return VoicingType.OPEN;
            }
            if (string.getFret() == -1) {
                mutedFound = true;
            }
        }

        if (mutedFound) {
            return VoicingType.MOVABLE_SHAPE;
        }

        return VoicingType.BAR;
    }
}
