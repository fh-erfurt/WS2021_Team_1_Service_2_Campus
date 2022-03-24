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

  Scanner roomTypeInput = new Scanner(System.in); //scanner for the type of room to be created

  if (roomTypeCheck.valueOf(roomTypeInput))   //check if the entered value is part of the predetermined types of rooms
  {
  roomType = roomTypeInput;                   //if yes accept the value
  System.out.println("Success!");             //give feedback to the one trying to create a room
  }
  else
  {
  System.out.println("Error! Invalid room type.")   //give feedback that the creation failed due to a not recognized type of room
  }
   */
}

