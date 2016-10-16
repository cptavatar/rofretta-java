package net.alexrose.rofretta.detection;

import net.alexrose.rofretta.core.Instrument;
import net.alexrose.rofretta.core.InstrumentString;
import net.alexrose.rofretta.core.Voicing;

import java.util.List;

/**
 * Created by alex on 10/11/16.
 */
public interface DetectionAlgorithm {

    List<Voicing> detect(List<InstrumentString> strings, Instrument tuning);
}
