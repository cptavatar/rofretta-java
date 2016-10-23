package net.alexrose.rofretta.core.note;


/**
 * Where to put the "logic" for dealing with notes.
 *
 * Since this is stateless, static is fine.
 *
 * Little experiment with seperating "behavior" from "state" - not sure I like it so for, smells a bit like
 * a util class.
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
