package de.fherfurt.campus.building;

public class Building {
    public String streetOrientation;
    public int buildingNumber;
    public Unit type;

    public int[] drawTriangle(Point position, int angle){
        /**draws Triangle that points in direction*/
        int[] ans = new int[3];
        ans[0] = position.getX();
        ans[1]= position.getY();
        ans[2] = angle;
        return ans;
    }

    public int[]  drawPoint(Point position){
        /**draws Point at position*/
        int[] ans = new int[2];
        ans[0] = position.getX();
        ans[1]= position.getY();
        return ans;
    }

    public int[] drawRectangle(Point p1, Point p2, Point p3, Point p4){
        /**calculates vectors between four points and draws them*/
        int[] ans = new int[8];
        ans[0] =(p1.getX() - p2.getX());
        ans[1] = (p1.getY() - p2.getY());
        ans[2] = (p3.getX() - p2.getX());
        ans[3] = (p3.getY() - p2.getY());
        ans[4] = (p4.getX() - p3.getX());
        ans[5] = (p4.getY() - p3.getY());
        ans[6] = (p4.getX() - p1.getX());
        ans[7] = (p4.getY() - p1.getY());
        return ans;
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