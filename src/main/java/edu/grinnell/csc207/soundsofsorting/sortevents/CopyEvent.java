package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    T value;
    int index;

    /**
     * Constructor that records the element thata is copied and the index of the destination
     * @param element the element in the array that is copied to the destination
     * @param index the index of the destination that is modified 
     */
    public CopyEvent(T value, int index) {
        this.value = value;
        this.index = index;
    }

    /**
     * Inserts the copy of the recorded value into the recorded index of the array, overwriting the value
     * @param arr the array to modify
     */
    @Override
    public void apply(T[] arr) {
        arr[index] = value;
    }

    /**
     * Returns a list containing all the indices that this event affects.
     * @return the destination index as it is the only index that is affected
     */
    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> indices = Arrays.asList(index);
        return indices;
    }

     /**
     * Shows that compare events are emphasized
     * @return false
     */
    @Override
    public boolean isEmphasized() {
        return true;
    }
}
