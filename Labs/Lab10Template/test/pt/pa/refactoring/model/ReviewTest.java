package pt.pa.refactoring.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewTest {
    private Review review;

    @BeforeEach
    void setUp() {
        review = new Review("Nuno", "AAA", 2.3);
    }

    @Test
    @DisplayName("Test Date")
    void testDate() throws Exception {
        LocalDateTime date = LocalDateTime.now();

        assertEquals(review.getDay(), date.getDayOfMonth());
        assertEquals(review.getMonth(), date.getMonthValue());
        assertEquals(review.getYear(), date.getYear());
        assertEquals(review.getHour(), date.getHour());
        assertEquals(review.getMinute(), date.getMinute());
    }
}