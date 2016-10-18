package net.alexrose.rofretta.parsing;

import net.alexrose.rofretta.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * VoicingParser
 * This class is responsible for taking a string representation of a voicing, pulling the interesting bits
 * out of it, and returning back a voicing.
 */
public class VoicingParser {
    private static final Logger logger = LoggerFactory.getLogger(VoicingParser.class);
    private static final VoicingCatagorizer catagorizer = new VoicingCatagorizer();

    /**
     * Curry the tuning to create a parsing function
     *
     * @param tuning The instrument tuning we use for lines.
     * @return A function that parses lines.
     */
    public static Function<Optional<String>, Optional<Voicing>> createParser(Instrument tuning) {
        return (Optional<String> line) -> {
            try {
                if (line.isPresent()) {
                    String[] pieces = line.get().split("\\s+");

                    if (pieces.length != 4) {
                        throw new ParameterException("Should of had a finger, fret, root note,  and core name section. Found length=" + pieces.length);
                    }

                    int[] frets = parseInts(pieces[0], tuning.getNumStrings());
                    int[] fingers = parseInts(pieces[1], tuning.getNumStrings());

                    List<InstrumentString> strings = assemble(frets, fingers, tuning);
                    NoteName root = NoteName.valueOfPrettyName(pieces[2]);
                    ChordType chord = ChordType.valueOfAbbreviation(pieces[3]);
                    VoicingType voicing = catagorizer.catagorize(strings);

                    return Optional.of(new Voicing(root, chord, voicing, strings, tuning));
                }
            } catch (Exception e) {
                logger.debug("Error parsing line {} ", line, e);
            }
            return Optional.empty();
        };
    }

    /**
     * Take a line, trim it, and return back an Optional<String>
     * if it is a comment or empty.
     *
     * @param line
     * @return
     */
    public static Optional<String> trimAndFilterComments(String line){
        String trimmed = line.trim();

        //hmm, what to do for comments?
        //not an exception, lets return null for now and see how to improve
        //should be handled upstream
        if (trimmed.startsWith("#") || "".equals(trimmed)) {
            return Optional.empty();
        }
        return Optional.of(trimmed);
    }

    /**
     * Helper function function to directly apply the bits we would normally
     * apply during the stream. Use for testing.
     *
     * @param line
     * @param tuning
     * @return
     */
    public static Optional<Voicing> parse(String line, Instrument tuning) {
        return createParser(tuning).apply(trimAndFilterComments(line));
    }

    public static List<InstrumentString> parseStringsNoFrets(String strings, Instrument tuning) {
        return assemble(parseInts(strings, tuning.getNumStrings()), new int[tuning.getNumStrings()], tuning);
    }


    public static int[] parseInts(String strings, int size) {
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

    public static List<InstrumentString> assemble(int[] frets, int[] fingers, Instrument tuning) {
        List<InstrumentString> strings = new ArrayList<>(tuning.getNumStrings());
        for (int i = 0; i < tuning.getNumStrings(); i++) {
            strings.add(new InstrumentString(frets[i], fingers[i]));
        }
        return strings;
    }
}
