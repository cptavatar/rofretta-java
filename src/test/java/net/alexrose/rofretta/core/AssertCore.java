package net.alexrose.rofretta.core;

import net.alexrose.rofretta.core.note.Note;
import net.alexrose.rofretta.core.note.NoteName;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 10/23/16.
 */
public class AssertCore {
    public static void assertNote(Note note, NoteName name, int modifier) {
        assertEquals(name, note.getRoot());
        assertEquals(modifier, note.getModifier());
    }
}
