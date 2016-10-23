package net.alexrose.rofretta.detection;

import net.alexrose.rofretta.core.Instrument;
import net.alexrose.rofretta.core.voicing.UnidentifiedVoicing;
import net.alexrose.rofretta.core.voicing.Voicing;
import net.alexrose.rofretta.parsing.VoicingParser;

import java.util.List;
import java.util.Optional;

/**
 * You plucked something on the guitar that sounded good.
 * You saw your idol play something.
 * Your theory isn't hot or you're a bit lazy - what WAS that, probably?
 * <p>
 * The VoicingDetector will attempt to figure out it out for you.
 */
public class VoicingDetector {

    private DetectionAlgorithm algorithm = new NoteSetSizeDetector();

    public Optional<List<Voicing>> detect(String input) {
        return detect(new UnidentifiedVoicing(VoicingParser.parseStringsNoFrets(input, Instrument.GUITAR_STANDARD), Instrument.GUITAR_STANDARD));
    }

    public Optional<List<Voicing>> detect(UnidentifiedVoicing voicing) {
        return algorithm.detect(voicing);
    }
}
