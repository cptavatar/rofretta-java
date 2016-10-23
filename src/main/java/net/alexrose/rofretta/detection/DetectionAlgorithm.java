package net.alexrose.rofretta.detection;

import net.alexrose.rofretta.core.voicing.UnidentifiedVoicing;
import net.alexrose.rofretta.core.voicing.Voicing;

import java.util.List;
import java.util.Optional;

/**
 * Contract for what a chord detection algorithm must implement.
 */
public interface DetectionAlgorithm {

    Optional<List<Voicing>> detect(UnidentifiedVoicing voicing);
}
