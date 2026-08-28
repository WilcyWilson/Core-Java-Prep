package leetcodeprep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {
    @Test
    public void testTwoSum() {
        TwoSum t1 = new TwoSum();
        int[] result = t1.twoSumHashMap(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
        int [] array2 = new int[]{2, 7, 11, 15};
        int target2 = 15;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> t1.twoSumHashMap(array2, target2));

        assertEquals("Two sum solution not found for " + target2, exception.getMessage());
    }
}
