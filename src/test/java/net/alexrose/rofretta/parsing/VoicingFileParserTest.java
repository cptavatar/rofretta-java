package net.alexrose.rofretta.parsing;

import net.alexrose.rofretta.core.ChordType;
import net.alexrose.rofretta.core.note.NoteName;
import net.alexrose.rofretta.core.voicing.Voicing;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests to validate that we can open up and parse a file
 */
public class VoicingFileParserTest {

    @Test
    public void parseFile() throws Exception {
        String path = this.getClass().getResource("/chords.txt").toURI().getPath();
        List<Voicing> voicings = VoicingFileParser.parseFile(path);
        assertEquals(1, voicings.size());
        Voicing voicing = voicings.get(0);
        assertEquals(ChordType.MAJOR, voicing.getChordType());
        assertEquals(NoteName.C, voicing.getRoot());
    }
}