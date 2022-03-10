package de.fherfurt.campus.building;

public class Building {
    public String streetOrientation;
    public int buildingNumber;
    public Unit type;

    public char drawTriangle(Point position, int angle){
        /**draws Triangle that points in direction*/
        System.out.println("x: " + position.x + "\ny: " + position.y + "\nAngle: " + angle);
        return 0;
    }

    public char drawPoint(Point position){
        /**draws Point at position*/
        System.out.println("x: " + position.x + "\ny: "+ position.y);
        return 0;
    }

    public char drawRectangle(Point p1, Point p2, Point p3, Point p4){
        /**calculates vectors between four points and draws them*/
        System.out.println("Edge 1: " + (p1.x - p2.x) + "/" + (p1.y - p2.y) +
                           "Edge 2: " + (p3.x - p2.x) + "/" + (p3.y - p2.y) +
                           "Edge 3: " + (p4.x - p3.x) + "/" + (p4.y - p3.y) +
                           "Edge 4: " + (p4.x - p1.x) + "/" + (p4.y - p1.y));
        return 0;
    }

    public class Entrance{
        public Point coordinate;
        public double angle;
    }

    enum Unit{
        Canteen,
        Library
    }
}