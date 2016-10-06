package net.alexrose.rofretta.parsing;

import net.alexrose.rofretta.chord.Instrument;
import net.alexrose.rofretta.chord.Voicing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * VoicingFileParser is responsible for taking a file and turning it into list of voicings.
 */
public class VoicingFileParser {
    private static final Logger logger = LoggerFactory.getLogger(VoicingFileParser.class);

    public static List<Voicing> parseFile(String file) {
        List<Voicing> voicings = Collections.EMPTY_LIST;

        try (Stream<String> lines = Files.lines(Paths.get(file), Charset.defaultCharset())) {
            voicings = lines.map(VoicingParser::trimAndFilterComments)
                    .map(VoicingParser.createParser(Instrument.GUITAR_STANDARD))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            logger.error("Error processing voicing file", ex);
        }

        return voicings;
    }

}
