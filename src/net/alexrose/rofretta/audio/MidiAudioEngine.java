/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.alexrose.rofretta.audio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

/**
 *
 * @author alex
 */
public class MidiAudioEngine implements AudioEngine {

    public static void main(String[] args) {
     /*   try {
            ShortMessage myMsg = new ShortMessage();
            // Play the note Middle C (60) moderately loud
            // (velocity = 93)on channel 4 (zero-based).
            myMsg.setMessage(ShortMessage.NOTE_ON, 4, 60, 93);
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            Instrument[] instruments = synth.getLoadedInstruments();
            System.out.println("Loaded instruments:" + instruments.length);
            for(Instrument instrument: instruments) {
                System.out.println(instrument.getName());
            }
            

            Receiver synthRcvr = synth.getReceiver();
            synthRcvr.send(myMsg, -1); // -1 means no time stamp
            MidiChannel chan[] = synth.getChannels();
            // Check for null; maybe not all 16 channels exist.
            if (chan[1] != null) {
                System.out.println("Program: " + chan[1].getProgram());
                chan[1].noteOn(60, 93);
            }
         } catch  (MidiUnavailableException ex) {
            Logger.getLogger(MidiAudioEngine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(MidiAudioEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
        */

       try {
           Synthesizer synth = MidiSystem.getSynthesizer();
           synth.open();

           final MidiChannel[] mc    = synth.getChannels();
           Instrument[]        instr = synth.getDefaultSoundbank().getInstruments();
           for(int i = 0; i < instr.length; i++) {
             //  System.out.printf("%03d: %s \n" , i , instr[i].getName());
           }

           synth.loadInstrument(instr[30]);  // Bottle Blow
           for (int i = 0; i < 120; ++i) {
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {}
               mc[1].noteOn(i,200);
           }
       } catch (MidiUnavailableException e) {}
   




    }
}
