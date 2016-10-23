package net.alexrose.rofretta.detection;

import net.alexrose.rofretta.core.voicing.UnidentifiedVoicing;
import net.alexrose.rofretta.core.voicing.Voicing;

import java.util.List;
import java.util.Optional;

/**
 * Created by alex on 10/11/16.
 */
public interface DetectionAlgorithm {

    Optional<List<Voicing>> detect(UnidentifiedVoicing voicing);
}
