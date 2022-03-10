package de.fherfurt.campus.building;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


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
        Assertions.assertEquals("[2, 4, 45]", Arrays.toString(newBuilding.drawTriangle(newPoint, 45)));

    }

    @Test
    void shouldReturnPoint() {
        Building newBuilding = new Building();
        Point newPoint = new Point();
        newPoint.setX(5);
        newPoint.setY(3);
        Assertions.assertEquals("[5, 3]", Arrays.toString(newBuilding.drawPoint(newPoint)));
    }

    @Test
    void shouldReturnRectangle() {
        Building newBuilding = new Building();
        Point Point1 = new Point();
        Point1.setX(5);
        Point1.setY(3);
        Point Point2 = new Point();
        Point2.setX(4);
        Point2.setY(2);
        Point Point3 = new Point();
        Point1.setX(7);
        Point1.setY(1);
        Point Point4 = new Point();
        Point1.setX(8);
        Point1.setY(4);
        Assertions.assertEquals("[4, 2, -4, -2, 0, 0, -8, -4]", Arrays.toString(newBuilding.drawRectangle(Point1, Point2, Point3, Point4)));
    }
}