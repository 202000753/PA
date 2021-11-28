package pt.pa.adts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerBSTTest {
    private IntegerBST integerBST;

    @BeforeEach
    void setUp() {
        integerBST= new IntegerBST(4);
        integerBST.insert(2);
        integerBST.insert(1);
        integerBST.insert(3);
        integerBST.insert(8);
        integerBST.insert(6);
        integerBST.insert(5);
        integerBST.insert(10);
        integerBST.insert(9);
        integerBST.insert(14);
    }


    @Test
    @DisplayName("Exists after Insert?")
    void test_elementExists_afterInsert(){
        integerBST.insert(7);
        assertTrue(integerBST.exists(7), "7 should exist");
        integerBST.insert(13);
        assertTrue(integerBST.exists(13), "13 should exist");
        integerBST.insert(0);
        assertTrue(integerBST.exists(0), "0 should exist");
    }

    @Test
    @DisplayName("Exists after Remove?")
    void test_elementDoNotExist_afterRemove(){
        integerBST.remove(4);
        assertFalse(integerBST.exists(4), "4 should not exist");
        integerBST.remove(2);
        assertFalse(integerBST.exists(2), "2 should not exist");
        integerBST.remove(1);
        assertFalse(integerBST.exists(1), "1 should not exist");
    }

    @Test
    @DisplayName("Is inOrder correct?")
    void isCorrect_inOrder_withSeveralTrees(){
        integerBST.insert(7);
        integerBST.remove(4);

        integerBST.toString();

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        integers.add(14);

        assertTrue(equals(integerBST.inOrder(), integers));
    }

    private boolean equals(Iterable<Integer> actual, List<Integer> expected) {
        int i = 0;
        int count = 0;
        for(int item : actual) {
            if(item != expected.get(i++)) return false;
            count++;
        }

        return count == expected.size();
    }

    @Test
    @DisplayName("Test EmptyContainerException in Sum")
    void isThrown_Exception_onSumOnEmptyTree(){
        for(int item : integerBST.inOrder()) {
            integerBST.remove(item);
        }

        assertThrows(EmptyContainerException.class, () ->{
            integerBST.sum();
        });
    }

    @Test
    @DisplayName("Is Sum correct?")
    void sum_isCorrect_afterInsertAndRemove(){
        integerBST.insert(0);
        integerBST.insert(7);
        integerBST.remove(5);

        int sum = 1+2+3+4+6+7+8+9+10+14;

        assertEquals(sum, integerBST.sum());
    }

    @Test
    @DisplayName("Test EmptyContainerException in SumInternal")
    void isThrown_Exception_onSumInternalsOnEmptyTree(){
        for(int item : integerBST.inOrder()) {
            integerBST.remove(item);
        }

        assertThrows(EmptyContainerException.class, () ->{
            integerBST.sumInternals();
        });
    }

    @Test
    @DisplayName("Is Sum correct?")
    void sumInternals_isCorrect_afterInsertAndRemove(){
        integerBST.insert(15);
        integerBST.remove(4);

        int sum = 34;

        assertEquals(sum, integerBST.sumInternals());
    }

    @Test
    @DisplayName("Is breadthOrder correct?")
    void breadthOrder_isCorrect_afterInsertAndRemove(){
        integerBST.remove(4);
        integerBST.remove(5);

        integerBST.toString();

        List<Integer> integers = new ArrayList<>();
        integers.add(6);
        integers.add(2);
        integers.add(8);
        integers.add(1);
        integers.add(3);
        integers.add(10);
        integers.add(9);
        integers.add(14);

        assertTrue(equals(integerBST.breadthOrder(), integers));
    }
}