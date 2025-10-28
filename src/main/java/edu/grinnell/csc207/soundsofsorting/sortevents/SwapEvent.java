package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> {
    private int i, j;

    /**
     * Constructor that records indices
     * @param i an index in the array that is affected by swap
     * @param j an index in the array that is affected by swap
     */
    public SwapEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Swaps the recorded indices of the array
     * @param arr the array to modify
     */
    public void apply(T[] arr) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
     * Shows that swap events are emphasized
     * @return true
     */
    public boolean isEmphasized() {
        return true;
    }
}
