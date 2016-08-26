package net.alexrose.rofretta.chord.old;

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
