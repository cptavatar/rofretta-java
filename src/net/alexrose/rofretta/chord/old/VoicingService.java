package net.alexrose.rofretta.chord.old;

import net.alexrose.rofretta.chord.old.Voicing;
import net.alexrose.rofretta.chord.old.VoicingSearchCriteria;

/**
 *
 * @author  Alex
 * @version
 */
public interface VoicingService {
    public void saveVoicing(Voicing voicing);
    public void deleteVoicing(Voicing voicing);
    public Voicing[] findVoicing(VoicingSearchCriteria spec);
}
