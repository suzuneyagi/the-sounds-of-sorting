package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // render each element of the indices array in notes
        Integer[] indices = notes.getNotes();
        int height = getHeight();
        int widthRec = getWidth() / indices.length;

        for (int i = 0; i < indices.length; i++) {
            int heightRec = (int) (((double) indices[i] / (indices.length - 1)) * height);
            if (heightRec == 0) {
                heightRec = 5;
            }

            g.setColor(Color.BLACK);
            g.drawRect(widthRec * i, height - heightRec, widthRec, heightRec);

            // Change color when highlighted
            if (notes.isHighlighted(i)) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.cyan);
            }
            g.fillRect(widthRec * i, height - heightRec, widthRec, heightRec);
        }
    }
}