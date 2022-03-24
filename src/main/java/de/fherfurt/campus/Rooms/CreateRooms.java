package de.fherfurt.campus.Rooms;

public class CreateRooms {

  public int getBuilding() {
    return building;
  }

  public void setBuilding(int building) {
    this.building = building;
  }

  public int getFloor() {
    return floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }


  private int building;
  private int floor;
  private int roomNumber;

  /*
  This Comment is to show how the enum of the package Rooms was intended to be used.

  Scanner roomTypeInput = new Scanner(System.in);

  if (roomTypeCheck.valueOf(roomTypeInput))
  {
  roomType = roomTypeInput;
  System.out.println("Success!");
  }
  else
  {
  System.out.println("Error! Invalid room type.")
  }
   */
}

