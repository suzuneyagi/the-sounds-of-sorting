package edu.grinnell.csc207.soundsofsorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    // An array of indices
    private Integer[] indices;

    // An array of boolean to show highlights
    private  Boolean[] highlight;

    /**
     * Constructor
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        initializeAndShuffle(n);
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        indices = new Integer[n]; //An array of indices (empty and has n spaces)
        highlight = new Boolean[n];
        clearAllHighlighted();

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        List<Integer> list = Arrays.asList(indices);
        Collections.shuffle(list);
        indices = list.toArray(new Integer[0]);

    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return indices;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        if (index >= 0 && index < highlight.length) {
            highlight[index] = true;
        }
    }
    
    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        if (index >= 0 && index < highlight.length) {
            return highlight[index];
        } else {
            return false;
        }
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        // Does this mean removing the highlighted indices or just make highlights to false?
        // I'll do the latter for now

        for (int i = 0; i < highlight.length; i++) {
            highlight[i] = false;
        }
    }
}
