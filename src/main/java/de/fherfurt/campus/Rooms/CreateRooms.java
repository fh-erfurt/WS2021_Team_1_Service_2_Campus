package de.fherfurt.campus.rooms;


/*
* CreateRooms creates room with building, floor and roomNumber as variables
*/

public class CreateRooms {
  
  private int building;
  private int floor;
  private int roomNumber;

  public int getBuilding(){
      return building;
    }
  
  public void setBuilding(int building){
    this.building = building;
  }

  public int getFloor(){
    return floor;
  }
  
  public void setFloor(int floor){
    this.floor = floor;
  }
  
  public int getRoomNumber(){
    return roomNumber;
  }
  
  public void setRoomNumber(int roomNumber){
    this.roomNumber = roomNumber;
  }
  
}
