    package de.fherfurt.campus.Rooms;
    //Code von Peer Kristian Ebersoll
    public class Rooms {
        
        //Basic values to generate the address
        public int building;
        public int floor;
        public int roomNumber;

        //Creates an address for a room based on int values in which the room type will later be saved
        public String[][][] roomAddress = new String[building][floor][roomNumber];

        //specifying the name/purpose of the room
        public String roomType;
        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        //Enum with different types of rooms, May need expansion
        //Cannot really be used without console inputs as it is there to validate the inputs integrity
        public enum roomTypeCheck {
            men("Mensa"),
            bib("Bibliothek"),
            vor("Vorlesungsraum"),
            pru("Pruefungsraum"),
            sem("Seminarraum"),
            sek("Sekretariat"),
            com("Computerpool"),
            toi("Toilette"),
            hau("Haustechnick");

            public final String Checker;

            private roomTypeCheck(String Checker){
                this.Checker = Checker;
            }
        }

    }
