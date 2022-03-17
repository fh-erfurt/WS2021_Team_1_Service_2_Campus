    package de.fherfurt.campus.Rooms;

    public class Rooms {
        
        //Basic values to generate the address
        public int building;
        public int floor;
        public int roomNumber;

        //Creates an address for a room based on int values in which the room type will later be saved
        public String[][][] roomAddress = new String[building][floor][roomNumber];


        public String roomType;
        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        //Enum with different types of rooms, May need expansion
        //Needs refinement
        public enum roomTypeCheck {
            Mensa,
            Bibliothek,
            Vorlesungsraum,
            Pruefungsraum,
            Seminarraum,
            Sekretariat,
            Computerpool,
            Toilette,
            Haustechnick
        }

    }
