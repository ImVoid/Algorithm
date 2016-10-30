package test;

import org.junit.Test;
import sort.QuickSort;

import java.util.Arrays;

/**
 * Created by imliu on 2016/10/30.
 */
public class QuickSortTest {
    @Test
    public void testSort(){
        int[] array = new int[]{55,2,3,8,5,6,7,8,9};

        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
