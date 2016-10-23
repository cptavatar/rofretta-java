package net.alexrose.rofretta.core.voicing;

import net.alexrose.rofretta.core.InstrumentString;
import net.alexrose.rofretta.core.note.Note;
import net.alexrose.rofretta.core.note.NoteFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Again, an attempt to seperate "state" from "behavior", rolling up
 * what I would have put in helper classes into a single "service" for now.
 */
public class VoicingService {

    public static List<Note> identifyPartialVoicing(UnidentifiedVoicing voicing) {
        return IntStream.range(0, voicing.getTuning().getNumStrings())
                .mapToObj(i -> voicing.midiNoteforString(i))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(i -> NoteFactory.note(i))
                .collect(Collectors.toList());
    }

    /**
     * Our algorithm we'll use for now (we can tweak later)
     * - if we find an open string, its an open core.
     * - if it has no open strings, but it has muted strings, we'll call it a shape
     * - if we hit all the strings and none are muted, we'll call it a bar core
     *
     * @param strings
     * @return
     */
    public static VoicingType catagorize(List<InstrumentString> strings) {
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
