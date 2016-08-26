package net.alexrose.rofretta.ui;


import net.alexrose.rofretta.chord.old.Finger;
import net.alexrose.rofretta.chord.old.InstrumentString;
import net.alexrose.rofretta.chord.old.NoteName;
import net.alexrose.rofretta.chord.old.Voicing;

import java.awt.*;

/**
 * 
 * @author Alex Rose
 * @version
 */
public class FretboardPanel extends javax.swing.JPanel {

    final int YSIZE = 19;
    final int XSIZE = 15;
    private Voicing voicing;
    private boolean ignoreFingers = false;

    public FretboardPanel() {
        initComponents();
    }
    
    @Override
    public Dimension getSize() {
        return new Dimension(100, 350);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, 100, 350);
        g.setColor(Color.black);

        for (int i = 0; i < 6; i++) {
            g.drawLine(10 + i * XSIZE, 15, 10 + i * XSIZE, 319);
        }

        g.drawLine(10, 12, 10 + 5 * XSIZE, 12);
        g.drawLine(10, 13, 10 + 5 * XSIZE, 13);
        g.drawLine(10, 14, 10 + 5 * XSIZE, 14);
        for (int i = 0; i < 17; i++) {
            g.drawLine(10, 15 + i * YSIZE, 10 + 5 * XSIZE, 15 + i * YSIZE);
        }

        for (int i = 0; i < 4; i++) {
            g.setColor(Color.lightGray);
            g.fillOval(43, 58 + 2 * i * YSIZE, 10, 10);
            g.setColor(Color.gray);
            g.drawOval(43, 58 + 2 * i * YSIZE, 10, 10);
        }
        g.setColor(Color.lightGray);
        g.fillOval(43 - XSIZE, 58 + 9 * YSIZE, 10, 10);
        g.fillOval(43 + XSIZE, 58 + 9 * YSIZE, 10, 10);
        g.setColor(Color.gray);
        g.drawOval(43 - XSIZE, 58 + 9 * YSIZE, 10, 10);
        g.drawOval(43 + XSIZE, 58 + 9 * YSIZE, 10, 10);

        if (voicing != null) {

            g.setColor(Color.cyan);



            /* draw circles and letters */
            for (int i = 1; i < 7; i++) {
                
                int fret = voicing.getFret(i - 1);

                boolean isRoot = voicing.isRoot(i - 1);

                if (fret != 0 && fret != -1) {
                    if (isRoot) {
                        g.setColor(Color.green);
                        g.fillOval(4 + (i - 1) * XSIZE,
                                18 + (fret - 1) * YSIZE, 13, 13);
                        g.setColor(Color.black);
                        g.drawOval(4 + (i - 1) * XSIZE,
                                18 + (fret - 1) * YSIZE, 13, 13);
                    } else {
                        g.setColor(Color.black);
                        g.fillOval(4 + (i - 1) * XSIZE,
                                18 + (fret - 1) * YSIZE, 13, 13);
                        g.setColor(Color.yellow);
                    }
                    if(! ignoreFingers)
                        g.drawString("" + voicing.getFinger(i - 1 ).getDisplayValue(), 7 + (i - 1) * XSIZE, 29 + (fret - 1) * YSIZE);
                }
                g.setColor(Color.black);
                String note = lookupNote(i, fret);

                if (fret == -1) {
                    g.setColor(Color.red);
                // else if(isRoot)
                // g.setColor(Color.white);
                } else {
                    g.setColor(Color.blue);
                }
                if (note.length() > 1) {
                    g.drawString(note.substring(0, 2), 4 + (i - 1) * XSIZE, 333);
                } else {
                    g.drawString(note, 7 + (i - 1) * XSIZE, 333);
                }
            }
        }

    }

    private void initComponents() {
        setLayout(new java.awt.BorderLayout());
    }

    public String lookupNote(int string, int fret) {
        if (fret == -1) {
            return "X";
        }
        int index = 0;
        if (string == 1 || string == 6) {
            index = 7;
        } else if (string == 3) {
            index = 5;
        } else if (string == 4) {
            index = 10;
        } else if (string == 5) {
            index = 2;
        }
        return NoteName.valueOfOffset((index + fret) % 12).getPrettyName();
    }

    public void setVoicing(Voicing voicing) {
        this.voicing = voicing;
    }

    public void onMouseClick(java.awt.event.MouseEvent evt){
        int x = evt.getX();
        int y = evt.getY();

        int whichString = x/XSIZE ;
        int whichFret = y/YSIZE ;

        InstrumentString string = voicing.getStrings()[whichString];
        if(string.getFret() == whichFret){
            if(ignoreFingers)
                string.setFret(-1);
            else {
                Finger finger = string.getFinger();
                if(finger == Finger.UNKNOWN)
                    string.setFinger(Finger.INDEX);
                else if(finger.getValue() < finger.THUMB.getValue())
                    string.setFinger( Finger.valueOfId(finger.getValue() + 1));
                else {
                    string.setFret(-1);
                    string.setFinger(finger.UNKNOWN);
                }
            }
        }
        else if(whichFret > 16){
            string.setFret(-1);
        }
        else {
           string.setFret(whichFret);
        }

        
        this.repaint();

    }
}