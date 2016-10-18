package net.alexrose.rofretta.detection;

import net.alexrose.rofretta.core.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by alex on 10/11/16.
 */
public class ChordSizeDetector implements DetectionAlgorithm {

    @Override
    public List<Voicing> detect(UnidentifiedVoicing voicing) {
        Set<NoteName> distinctNotes = VoicingNoteIdentifier.identifyPartialVoicing(voicing).stream()
                .filter((NoteName n) -> !n.equals(NoteName.DISABLED))
                .collect(Collectors.toSet());

        Optional<List<ChordType>> types = ChordType.chordTypesByIntervals(distinctNotes.size());
        if (types.isPresent()) {
            types.flatMap()
        }

    }


}
