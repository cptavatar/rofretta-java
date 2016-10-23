package net.alexrose.rofretta.core.note;

/**
 * A note has a name (A-C) and a modifier
 * indicating sharp or flat. It is immutable.
 *
 * I wanted to separate the concept of a pitch, which could be in
 * various octives, from the note since these note name names can be used
 * to describe elements of a chord or scale without a pitch as well (C maj for instance).
 *
 * Perhaps a rename is in order?
 */
public class Note {
    private final NoteName root;
    private final int modifier;


    public Note(NoteName note, int modifier) {
        this.modifier = modifier;
        this.root = note;

    }

    public NoteName getRoot() {
        return root;
    }

    public int getModifier() {
        return modifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (modifier != note.modifier) return false;
        return root == note.root;

    }

    @Override
    public int hashCode() {
        int result = root != null ? root.hashCode() : 0;
        result = 31 * result + modifier;
        return result;
    }
}
