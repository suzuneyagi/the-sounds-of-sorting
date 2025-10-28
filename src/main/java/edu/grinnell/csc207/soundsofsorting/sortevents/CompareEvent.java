package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> {
     private int i, j;

    /**
     * Constructor that records indices
     * @param i an index in the array that is affected by swap
     * @param j an index in the array that is affected by swap
     */
    public CompareEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Does nothing
     * @param arr the array to modify
     */
    public void apply(T[] arr) {
    }

    /**
     * Returns a list containing all the indices that this event affects.
     * @return a list of indices affected in the event
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> indices = Arrays.asList(i, j);
        return indices;
    }
   
    /**
     * Shows that compare events are not emphasized
     * @return false
     */
    public boolean isEmphasized() {
        return false;
    }
}
