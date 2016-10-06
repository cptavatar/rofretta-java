package net.alexrose.rofretta.chord;


import net.alexrose.rofretta.chord.old.IntervalException;

/**
 * Enumeration covering known interval types.
 */
public enum Interval {
    PERFECT_UNISON("Unison", 0, "0")
    ,MINOR_SECOND("Minor Second", 1, "\u266D2")
    ,MAJOR_SECOND("Major second", 2, "2")
    ,MINOR_THIRD("Minor Third", 3, "\u266D3")
    ,MAJOR_THIRD("Major Third", 4, "3")
    ,PERFECT_FOURTH("Perfect Fourth", 5, "4")
    ,TRITONE("Tritone", 6, "\u266D5")
    ,PERFECT_FIFTH("Perfect Fifth", 7, "5")
    ,MINOR_SIXTH("Minor Sixth", 8, "\u266D6")
    ,MAJOR_SIXTH("Major Sixth", 9, "6")
    ,MINOR_SEVENTH("Minor Seventh", 10, "\u266D7")
    ,MAJOR_SEVENTH("Major Seventh", 11, "7")
    ,OCTIVE("Octive", 12, "8")
    ,MINOR_NINTH("Minor Ninth", 13, "\u266D9")
    ,MAJOR_NINTH("Major Ninth", 14, "9")
    ,MINOR_TENTH("Minor Tenth", 15, "\u266D10")
    ,MAJOR_TENTH("Major Tenth", 16, "10")
    ,PERFECT_ELEVENTH("Perfect Eleventh", 17, "11")
    ,AUGMENTED_ELEVENTH("Augmented Eleventh", 18, "\u266D12")
    ,PERFECT_TWELFTH("Perfect Twelfth", 19, "12")
    ,MINOR_THIRTEENTH("Minor Thirteenth", 20, "\u266D13")
    ,MAJOR_THIRTHEENTH("Major Thirteenth", 21, "13")
    ;

    private final String prettyName;
    private final byte offset;
    private final String shortName;


    Interval(String prettyName, int offset, String shortName){
        this.prettyName = prettyName;
        this.offset = (byte) offset;
        this.shortName = shortName;
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

    public String shortName() {
        return shortName;
    }

    public byte offset() {
        return offset;
    }
}