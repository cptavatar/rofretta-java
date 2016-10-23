package net.alexrose.rofretta.detection;

import net.alexrose.rofretta.core.ChordType;
import net.alexrose.rofretta.core.note.Note;
import net.alexrose.rofretta.core.note.NoteFactory;
import net.alexrose.rofretta.core.note.NoteService;
import net.alexrose.rofretta.core.voicing.UnidentifiedVoicing;
import net.alexrose.rofretta.core.voicing.Voicing;
import net.alexrose.rofretta.core.voicing.VoicingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The algorithm the NoteSetSizeDetector employs is to
 * - gather a set of the distinct notes that are stuck
 * - find a set of candidate chords that have set.size notes
 * - brute force check the possible candidates chords using each note of the set as a base,
 *   see if we end up with the result set when we construct.
 */
public class NoteSetSizeDetector implements DetectionAlgorithm {

    @Override
    public Optional<List<Voicing>> detect(UnidentifiedVoicing voicing) {
        Set<Note> distinctNotes = VoicingService.identifyPartialVoicing(voicing).stream()
                .filter((Note n) -> !NoteService.isDisabled(n))
                .collect(Collectors.toSet());

        final Set<Integer> enharmonicSet = distinctNotes.stream()
                .map((Note n) -> NoteService.enharmonicValue(n))
                .collect(Collectors.toSet());

        Optional<List<ChordType>> types = ChordType.chordTypesByIntervals(distinctNotes.size());

        if (types.isPresent()) {
            List<Voicing> retval = new ArrayList<>();
            for (ChordType type : types.get()) {
                for (Note root : distinctNotes) {
                    List<Note> notes = NoteFactory.notes(type, root);
                    if (enharmonicSet.equals(notes.stream().map((Note n) -> NoteService.enharmonicValue(n))
                            .collect(Collectors.toSet()))) {
                        Voicing candidate = new Voicing(
                                root, type, VoicingService.catagorize(voicing.getStrings()), voicing.getStrings(), voicing.getTuning()
                        );
                        retval.add(candidate);
                    }
                }
            }
            if (retval.size() > 0) {
                return Optional.of(retval);
            }
        }

        return Optional.empty();
    }


}
