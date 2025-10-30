package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray1() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public static Integer[] makeTestArray2() {
        return new Integer[] {
        };
    }

    public static Integer[] makeTestArray3() {
        return new Integer[] {
            5, 4, 3, 2, 1
        };
    }

    public static Integer[] makeTestArray4() {
        return new Integer[] {
            14, 1, 2, 3, 4, 5, 6, 7, 8,
            9, 10, 11, 12, 13
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray1();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSort_empty(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray2();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSort_short(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray3();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSort_long(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray4();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
        testSort_empty(Sorts::bubbleSort);
        testSort_short(Sorts::bubbleSort);
        testSort_long(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
        testSort_empty(Sorts::insertionSort);
        testSort_short(Sorts::insertionSort);
        testSort_long(Sorts::bubbleSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
        testSort_empty(Sorts::selectionSort);
        testSort_short(Sorts::selectionSort);
        testSort_long(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
        testSort_empty(Sorts::mergeSort);
        testSort_short(Sorts::mergeSort);
        testSort_long(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
        testSort_empty(Sorts::quickSort);
        testSort_short(Sorts::quickSort);
        testSort_long(Sorts::quickSort);
    }

    @Test
    public void testShellSort() {
        testSort(Sorts::shellSort);
        testSort_empty(Sorts::shellSort);
        testSort_short(Sorts::shellSort);
        testSort_long(Sorts::shellSort);
    }

    @Test
    public void testEventSortInsertion() {
        Integer[] arr = makeTestArray1();
        Integer[] arrCopied = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> eventList = Sorts.insertionSort(arr);
        Sorts.eventSort(arrCopied, eventList);
        assertTrue(sorted(arrCopied));
    }

    @Test
    public void testEventSortSelection() {
        Integer[] arr = makeTestArray1();
        Integer[] arrCopied = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> eventList = Sorts.selectionSort(arr);
        Sorts.eventSort(arrCopied, eventList);
        assertTrue(sorted(arrCopied));
    }

    @Test
    public void testEventSortBubble() {
        Integer[] arr = makeTestArray1();
        Integer[] arrCopied = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> eventList = Sorts.bubbleSort(arr);
        Sorts.eventSort(arrCopied, eventList);
        assertTrue(sorted(arrCopied));
    }

    @Test
    public void testEventSortMerge() {
        Integer[] arr = makeTestArray1();
        Integer[] arrCopied = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> eventList = Sorts.mergeSort(arr);
        Sorts.eventSort(arrCopied, eventList);
        assertTrue(sorted(arrCopied));
    }

    @Test
    public void testEventSortQuick() {
        Integer[] arr = makeTestArray1();
        Integer[] arrCopied = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> eventList = Sorts.quickSort(arr);
        Sorts.eventSort(arrCopied, eventList);
        assertTrue(sorted(arrCopied));
    }

    @Test
    public void testEventSortShell() {
        Integer[] arr = makeTestArray1();
        Integer[] arrCopied = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> eventList = Sorts.shellSort(arr);
        Sorts.eventSort(arrCopied, eventList);
        assertTrue(sorted(arrCopied));
    }
}