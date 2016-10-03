package net.alexrose.rofretta.parsing;

import net.alexrose.rofretta.chord.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Some tests to verify that we can build parse a voicing out of a string for a given tuning
 */
public class VoicingParserTest {


    @Test
    public void parse() throws Exception {
        VoicingParser parser = new VoicingParser();
        Voicing voicing = parser.parse("032010 x32x1x c maj", Instrument.GUITAR_STANDARD);

        assertEquals(ChordType.MAJOR, voicing.getChordType());
        assertEquals(NoteName.C, voicing.getRoot());

        List<InstrumentString> strings = voicing.getStrings();
        assertEquals(0, strings.get(0).getFret());
        assertEquals("", strings.get(0).getFinger().getDisplayValue());
        assertEquals(3, strings.get(1).getFret());
        assertEquals("3", strings.get(1).getFinger().getDisplayValue());
        assertEquals(2, strings.get(2).getFret());
        assertEquals("2", strings.get(2).getFinger().getDisplayValue());
        assertEquals(0, strings.get(3).getFret());
        assertEquals("", strings.get(3).getFinger().getDisplayValue());
        assertEquals(1, strings.get(4).getFret());
        assertEquals("1", strings.get(4).getFinger().getDisplayValue());
        assertEquals(0, strings.get(5).getFret());
        assertEquals("", strings.get(5).getFinger().getDisplayValue());

    }

    @Test
    public void parseInts() throws Exception {

    }

    @Test
    public void assemble() throws Exception {

    }

}