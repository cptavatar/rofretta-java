package net.alexrose.rofretta.core.note;

import net.alexrose.rofretta.core.ChordType;
import org.junit.Test;

import java.util.List;

import static net.alexrose.rofretta.core.AssertCore.assertNote;
import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 10/23/16.
 */
public class NoteFactoryTest {
    @Test
    public void noteByString() throws Exception {
        Note note = NoteFactory.note("Bb");
        assertNote(note, NoteName.B, -1);
    }

    @Test
    public void noteByNumber() throws Exception {
        Note note = NoteFactory.note(60);
        assertNote(note, NoteName.C, 0);

        note = NoteFactory.note(63);
        assertNote(note, NoteName.D, 1);

    }

    @Test
    public void notes() throws Exception {
        Note root = new Note(NoteName.A, 0);
        List<Note> notes = NoteFactory.notes(ChordType.MAJOR, root);
        assertEquals(3, notes.size());
        assertNote(notes.get(0), NoteName.A, 0);
        assertNote(notes.get(1), NoteName.C, 1);
        assertNote(notes.get(2), NoteName.E, 0);

        root = new Note(NoteName.D, -1);
        notes = NoteFactory.notes(ChordType.DIMINISHED_SEVEN, root);
        assertEquals(4, notes.size());
        assertNote(notes.get(0), NoteName.D, -1);
        assertNote(notes.get(1), NoteName.F, -1);
        assertNote(notes.get(2), NoteName.A, -2);
        assertNote(notes.get(3), NoteName.C, -2);

    }


}