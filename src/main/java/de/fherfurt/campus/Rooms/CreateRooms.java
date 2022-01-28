package de.fherfurt.campus;

public class createRoom{
  
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
  
  private int building;
  private int floor;
  private int roomNumber;
}
