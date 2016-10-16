package net.alexrose.rofretta.detection;

import net.alexrose.rofretta.core.ChordType;
import net.alexrose.rofretta.core.NoteName;
import net.alexrose.rofretta.core.Voicing;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alex on 10/11/16.
 */
public class VoicingDetectorTest {

    @Test
    public void detectSimpleOpen() throws Exception {
        VoicingDetector detector = new VoicingDetector();
        List<Voicing> retval = detector.detect("032010");
        assertEquals(1, retval.size());
        Voicing voicing = retval.get(0);
        assertEquals(ChordType.MAJOR, voicing.getChordType());
        assertEquals(NoteName.C, voicing.getRoot());
    }

}