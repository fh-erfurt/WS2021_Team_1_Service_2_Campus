package de.fherfurt.campus.building;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnTriangle() {
        Building newBuilding = new Building();
        Point newPoint = new Point();
        newPoint.setX(2);
        newPoint.setY(4);
        Assertions.assertEquals("x: 2 y:4 Angle: 45", newBuilding.drawTriangle(newPoint, 45));

    }

    @Test
    void shouldReturnPoint() {
        Building newBuilding = new Building();
        Point newPoint = new Point();
        newPoint.setX(5);
        newPoint.setY(3);
        Assertions.assertEquals("x: 5  y:3 ", newBuilding.drawPoint(newPoint));
    }

    @Test
    void shouldReturnRectangle() {

    }
}