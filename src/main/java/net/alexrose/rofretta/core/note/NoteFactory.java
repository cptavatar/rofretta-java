package net.alexrose.rofretta.core.note;

import net.alexrose.rofretta.core.ChordType;
import net.alexrose.rofretta.core.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * So, you want a new note eh? But its complicated?
 * NoteFactory is here to help...
 */
public class NoteFactory {

    public static Note note(String note) {
        NoteName root = null;
        int modifier = 0;
        for (char c : note.trim().toCharArray()) {
            switch (c) {
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'A':
                case 'B':
                    root = NoteName.valueOf("" + c);
                    break;
                case '\u266F':
                case '#':
                    modifier++;
                    break;
                case '\u266D':
                case 'b':
                    modifier--;
                    break;
            }
        }
        return new Note(
                (root != null) ? root : NoteName.DISABLED,
                modifier);

    }

    public static Note note(int midiValue) {
        int baseValue = midiValue % 12;
        int modifier = 0;
        NoteName name = NoteName.valueOfOffset(baseValue);
        if (name != null) {
            return new Note(name, modifier);
        } else {
            return new Note(NoteName.valueOfOffset(baseValue - 1), 1);
        }

    }

    public static List<Note> notes(ChordType type, Note root) {
        List<Interval> intervals = type.getIntervals();
        List<Note> notes = new ArrayList<>(intervals.size() + 1);
        notes.add(root);
        intervals.forEach(interval -> notes.add(note(interval, root)));
        return notes;
    }

    public static Note note(Interval interval, Note root) {
        NoteName name = root.getRoot();
        int index = (name.getIndex() + interval.getDiatonicSteps()) % 7;
        NoteName newName = NoteName.valueOfIndex(index);
        int rootValue = NoteService.enharmonicValue(root);
        int newNoteBaseValue = NoteService.enharmonicValue(new Note(newName, 0));
        if (newNoteBaseValue < rootValue) {
            newNoteBaseValue = newNoteBaseValue + 12;
        }
        int modifier = interval.offset() - (newNoteBaseValue - rootValue);
        return new Note(newName, modifier);

    }
}
