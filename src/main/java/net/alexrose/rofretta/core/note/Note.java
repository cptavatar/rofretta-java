package net.alexrose.rofretta.core.note;

/**
 * Created by alex on 10/17/16.
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
