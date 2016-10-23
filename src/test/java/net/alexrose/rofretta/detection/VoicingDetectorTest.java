package net.alexrose.rofretta.detection;

import net.alexrose.rofretta.core.ChordType;
import net.alexrose.rofretta.core.note.NoteName;
import net.alexrose.rofretta.core.voicing.Voicing;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static net.alexrose.rofretta.core.AssertCore.assertNote;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alex on 10/11/16.
 */
public class VoicingDetectorTest {

    @Test
    public void detectSimpleOpen() throws Exception {
        VoicingDetector detector = new VoicingDetector();
        Optional<List<Voicing>> retval = detector.detect("032010");
        assertTrue(retval.isPresent());
        List<Voicing> list = retval.get();
        assertEquals(1, list.size());
        Voicing voicing = list.get(0);
        assertEquals(ChordType.MAJOR, voicing.getChordType());
        assertNote(voicing.getRoot(), NoteName.C, 0);
    }

}