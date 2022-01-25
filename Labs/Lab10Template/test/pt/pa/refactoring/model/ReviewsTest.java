package pt.pa.refactoring.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewsTest {
    private Reviews reviews;

    @BeforeEach
    void setUp() {
        reviews = new Reviews();

        reviews.add(new Review("Nuno", "aaaaa", 2.3));
        reviews.add(new Review("Zé", "bbbbbbb", 3.2));
    }

    @Test
    @DisplayName("Test Total")
    void getTotal() {
        assertEquals(2, reviews.getTotal());
    }
}