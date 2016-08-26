package net.alexrose.rofretta.chord;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 7/30/16.
 */
public enum Chord {
    MAJOR ("Major", "maj"),
    SUSPENDED ("Suspended", "sus"),
    MAJOR_FLAT_FIVE("Major Flat Five","maj-5" ),
    MAJOR_ADD_NINE("Major Add Nine", "add9"),
    MINOR ("Minor", "min"),
    AUGMENTED ("Augmented", "aug"),
    MAJOR_SIX ("Major Six", "maj6"),
    MAJOR_SIX_ADD_NINE ("Major Six Add Nine","maj6add9"),
    DOMINANT_SEVEN ("Dominant Seven", "dom7"),
    SEVEN_SUSPENDED ("Seven Suspended", "sus7"),
    MINOR_SEVEN ("Minor Seven", "min7"),
    MINOR_SEVEN_FLAT_FIVE ("Minor Seven Flat Five", "min7-5"),
    DIMINISHED_SEVEN ("Diminished Seven", "dim7"),
    SEVEN_SHARP_FIVE ("Seven Sharp Five", "7+5"),
    SEVEN_FLAT_FIVE ("Seven Flat Five", "7-5"),
    MAJOR_SEVEN ("Major Seven", "min7"),
    MINOR_MAJOR_SEVEN ("Minor Major Seven", "min+7"),
    SEVEN_SHARP_NINE ("Seven Sharp Nine", "7+9"),
    SEVEN_FLAT_NINE ("Seven Flat Nine", "7-9"),
    SEVEN_SHARP_FIVE_FLAT_NINE ("Seven Sharp Five Flat Nine" , "7+5-9"),
    NINTH ("Ninth", "9"),
    MINOR_NINE ("Minor Nine", "min9"),
    NINE_SHARP_FIVE ("Nine Sharp Five", "9+5"),
    NINE_FLAT_FIVE ("Nine Flat Five", "9-5"),
    MAJOR_NINE ("Major Nine", "maj9"),
    NINE_SHARP_ELEVEN ("Nine Sharp Eleven", "9+11"),
    MINOR_NINE_MAJOR_SEVEN ("Minor Nine Major Seven", "min9+7"),
    ELEVENTH ("Eleventh", "11"),
    MINOR_ELEVEN ("Minor Eleven", "min11"),
    THIRTEENTH ("Thirteenth", "13"),
    THIRTEENTH_FLAT_NINE ("Thirteenth Flat Nine", "13-9"),
    THIRTEENTH_FLAT_FIVE_FLAT_NINE ("Thirteenth Flat Five Flat Nine", "13-5-9"),
    MINOR_THIRTEENTH ("Minor Thirteenth", "min13");

    private static final Map<String, Chord> typeByPrettyName = new HashMap();
    private static final Map<String, Chord> typeByAbbreviation = new HashMap();

    static {
        for(Chord type: Chord.values())
            typeByPrettyName.put(type.getPrettyName(), type);
    }

    static {
        for(Chord type: Chord.values())
            typeByAbbreviation.put(type.getAbbreviation(), type);
    }

    private String prettyName, abbreviation;
    private Interval[] intervals;

    /**
     * Constuctor for chord types so we can specify pretty name.
     * @param prettyName The print pretty name of the enumeration.
     */
    Chord(String prettyName, String abbreviation,) {
        this.prettyName = prettyName;
        this.abbreviation = abbreviation;
    }

    /**
     * Look up the enum based on pretty name ("Major") instead of regular value
     * ("MAJOR").
     *
     * @param prettyName The pretty name of the chord type.
     * @return A chord type if one is found for the given pretty name else null.
     */
    public static Chord valueOfPrettyName(String prettyName){
        return typeByPrettyName.get(prettyName);
    }

    public static Chord valueOfAbbreviation(String abbreviation) {
        return typeByAbbreviation.get(abbreviation);
    }

    /**
     * Get the pretty name. 
     * @return A pretty name for the chord type
     */
    public String getPrettyName() {
        return prettyName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}

