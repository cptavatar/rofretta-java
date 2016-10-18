package net.alexrose.rofretta.core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created by alex on 10/17/16.
 */
public class VoicingNoteIdentifier {
    public static List<NoteName> identifyPartialVoicing(UnidentifiedVoicing voicing) {
        return IntStream.range(0, voicing.getTuning().getNumStrings())
                .mapToObj(i -> voicing.midiNoteforString(i))
                .map(num -> {
                    if (num.isPresent()) {
                        return NoteName.valueOfOffset(num.get() % 12);
                    }
                    return NoteName.DISABLED;
                })
                .collect(Collectors.toList());
    }
}


