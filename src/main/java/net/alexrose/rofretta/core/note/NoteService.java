package net.alexrose.rofretta.core.note;


/**
 * Created by alex on 10/22/16.
 */
public class NoteService {
    public static boolean isDisabled(Note note) {
        return (note.getRoot().getOffset() == -1);
    }

    public static int enharmonicValue(Note note) {
        if (isDisabled(note)) {
            return -1;
        }

        int calculatedValue = note.getRoot().getOffset() + note.getModifier();
        if (calculatedValue < 0) {
            calculatedValue = 12 + calculatedValue;
        } else if (calculatedValue > 11) {
            calculatedValue = calculatedValue - 12;
        }
        return calculatedValue;
    }

}
