package pt.pa.adts;

import static org.junit.jupiter.api.Assertions.*;

class MyRectangleTest {

    @org.junit.jupiter.api.Test
    void isPerfect_returnsTrue_whenRectangleIsPerfect() {
        MyRectangle rect = new MyRectangle("One", 10.0, 20.0, 30.0, 40.0);
        assertTrue(rect.isPerfect());
        rect = new MyRectangle("Two", 20.0, 40.0);
        assertTrue(rect.isPerfect());
    }

    @org.junit.jupiter.api.Test
    void isPerfect_returnsTrue_whenRectangleIsNotPerfect() {
        MyRectangle rect1 = new MyRectangle("One", 10.0, 20.0, 10.0, 40.0);
        MyRectangle rect2 = new MyRectangle("Two", 80.0, 10.0);
        assertAll(
                () -> assertFalse(rect1.isPerfect()),
                () -> assertFalse(rect2.isPerfect())
        );
    }
}