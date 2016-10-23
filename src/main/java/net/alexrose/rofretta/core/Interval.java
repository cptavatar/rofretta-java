package net.alexrose.rofretta.core;


/**
 * Enumeration covering known interval types.
 */
public enum Interval {
    PERFECT_UNISON("Unison", 0, "0", 0),
    MINOR_SECOND("Minor Second", 1, "\u266D2", 1),
    MAJOR_SECOND("Major second", 2, "2", 1), MINOR_THIRD("Minor Third", 3, "\u266D3", 2), MAJOR_THIRD("Major Third", 4, "3", 2), PERFECT_FOURTH("Perfect Fourth", 5, "4", 3), TRITONE("Tritone", 6, "\u266D5", 4), PERFECT_FIFTH("Perfect Fifth", 7, "5", 4), AUGMENTED_FIFTH("Augmented Fifth", 8, "\u266F5", 4), MINOR_SIXTH("Minor Sixth", 8, "\u266D6", 5), MAJOR_SIXTH("Major Sixth", 9, "6", 5), DIMINISHED_SEVENTH("Diminished Seventh", 9, "\u266D\u266D7", 6), MINOR_SEVENTH("Minor Seventh", 10, "\u266D7", 6), MAJOR_SEVENTH("Major Seventh", 11, "7", 6), OCTIVE("Octive", 12, "8", 7), MINOR_NINTH("Minor Ninth", 13, "\u266D9", 8), MAJOR_NINTH("Major Ninth", 14, "9", 8), AUGMENTED_NINTH("Augmented Ninth", 15, "\u266F9", 8), MINOR_TENTH("Minor Tenth", 15, "\u266D10", 9), MAJOR_TENTH("Major Tenth", 16, "10", 9), PERFECT_ELEVENTH("Perfect Eleventh", 17, "11", 10), AUGMENTED_ELEVENTH("Augmented Eleventh", 18, "\u266F11", 10), PERFECT_TWELFTH("Perfect Twelfth", 19, "12", 11), MINOR_THIRTEENTH("Minor Thirteenth", 20, "\u266D13", 12), MAJOR_THIRTHEENTH("Major Thirteenth", 21, "13", 12)
    ;

    private final String prettyName;
    private final int offset;
    private final String shortName;
    private final int diatonicSteps;


    Interval(String prettyName, int offset, String shortName, int diatonicSteps) {
        this.prettyName = prettyName;
        this.offset = offset;
        this.shortName = shortName;
        this.diatonicSteps = diatonicSteps;
    }

    public static Interval intervalByInt(int size ) {
        Interval[] intervals = Interval.values();
        if(size >= 0 && size < intervals.length)
            return intervals[size];

        throw new IntervalException();
    }

    public String prettyName() {
        return prettyName;
    }

    public int getDiatonicSteps() {
        return diatonicSteps;
    }

    public String shortName() {
        return shortName;
    }

    public int offset() {
        return offset;
    }
}