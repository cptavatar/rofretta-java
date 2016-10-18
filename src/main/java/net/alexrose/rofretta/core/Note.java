package net.alexrose.rofretta.core;

/**
 * Created by alex on 10/17/16.
 */
public class Note {
    private final NoteName root;
    private final int modifier;
    private final int midiValue;
    private final boolean disabled;

    public Note(String note) {
        NoteName root = null;
        int modifier = 0;
        for (char c : note.trim().toUpperCase().toCharArray()) {
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
                    modifier++;
                    break;
                case '\u266D':
                    modifier--;
                    break;
            }
        }
        this.modifier = modifier;
        this.root = (root == null) ? root : NoteName.DISABLED;
        this.midiValue = 60 - root.getOffset() + modifier;
        this.disabled = this.root == NoteName.DISABLED;
    }

    public Note(NoteName note, int modifier, boolean disabled, int midiValue) {
        this.modifier = modifier;
        this.root = note;
        this.disabled = disabled;
        this.midiValue = midiValue;

    }

    public NoteName getRoot() {
        return root;
    }

    public int getModifier() {
        return modifier;
    }

    public int getMidiValue() {
        return midiValue;
    }

    public boolean isDisabled() {
        return disabled;
    }
}
