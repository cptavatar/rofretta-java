package net.alexrose.rofretta.parsing;

import net.alexrose.rofretta.chord.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * VoicingParser
 * This class is responsible for taking a string representation of a voicing, pulling the interesting bits
 * out of it, and returning back a voicing.
 */
public class VoicingParser {
    private static final Logger logger = LoggerFactory.getLogger(VoicingParser.class);
    private static final VoicingCatagorizer catagorizer = new VoicingCatagorizer();


    public Voicing parse(String line, Instrument tuning) {
        if (line == null) {
            return null;
        }

        String trimmed = line.trim();

        //hmm, what to do for comments?
        //not an exception, lets return null for now and see how to improve
        //should be handled upstream
        if (trimmed.startsWith("#") || "".equals(trimmed)) {
            logger.debug("Comment or empty line, skipping");
            return null;
        }

        String[] pieces = trimmed.split("\\s+");

        if (pieces.length != 4) {
            logger.error("Should of had a finger, fret, root note,  and chord name section. Sections found: {}, {}", pieces.length, line);
            return null;
        }

        int[] frets = parseInts(pieces[0], tuning.getNumStrings());
        int[] fingers = parseInts(pieces[1], tuning.getNumStrings());

        List<InstrumentString> strings = assemble(frets, fingers, tuning);
        NoteName root = NoteName.valueOfPrettyName(pieces[2]);
        ChordType chord = ChordType.valueOfAbbreviation(pieces[3]);
        VoicingType voicing = catagorizer.catagorize(strings);

        return new Voicing(root, chord, voicing, strings, tuning);
    }

    public int[] parseInts(String strings, int size) {
        int[] retval = new int[size];
        int index = 0;
        boolean carryOver = false;

        for (char c : strings.trim().toCharArray()) {
            switch (c) {
                case 'x':
                    retval[index] = -1;
                    index++;
                    //!x is not valid, clear flag
                    carryOver = false;
                    break;
                case '!':
                case '|':
                    carryOver = true;
                    break;
                default:
                    retval[index] = Integer.parseInt("" + c);
                    if (carryOver) {
                        retval[index] = retval[index] + 10;
                        carryOver = false;
                    }
                    index++;

            }

        }
        return retval;
    }

    public List<InstrumentString> assemble(int[] frets, int[] fingers, Instrument tuning) {
        List<InstrumentString> strings = new ArrayList<>(tuning.getNumStrings());
        for (int i = 0; i < tuning.getNumStrings(); i++) {
            strings.add(new InstrumentString(frets[i], fingers[i]));
        }
        return strings;
    }


}
