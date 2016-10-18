package net.alexrose.rofretta.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 10/17/16.
 */
public class NoteNameResolver {

    public static List<NoteName> noteNames(ChordType type, NoteName root) {
        List<Interval> intervals = type.getIntervals();
        List<NoteName> names = new ArrayList<>(intervals.size() + 1);
        names.add(root);
        intervals.forEach(interval -> names.add(noteName(interval, root)));
        return names;
    }

    public static NoteName noteName(Interval interval, NoteName root) {

    }
}
