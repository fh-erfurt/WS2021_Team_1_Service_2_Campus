    package de.fherfurt.campus;


    public class rooms {
        
        //Basic values to generate the address
        public int building;
        public int floor;
        public int roomNumber;

        //Creates an address for a room based on int values in which the room type will later be saved
        public String[][][] roomAddress = new String[building][floor][roomNumber];
        
        //Enum with different types of rooms, May need expansion
        //Needs refinement
        public enum roomType {
            Men("Mensa"),
            Bib("Bibliothek"),
            Vor("Vorlesungsaal"),
            Pru("Pruefungsraum"),
            Sem("Seminarraum"),
            Sek("Sekreteriat"),
            Com("Computerpool"),
            Toi("Toilette"),
            HuG("Haus- und Gebaeudetechnick")
        }

    }
