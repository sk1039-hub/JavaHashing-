import java.util.*;

public class ParkingLotSystem {

    String[] parking = new String[500];

    public int parkVehicle(String plate) {

        int hash = Math.abs(plate.hashCode()) % parking.length;

        while (parking[hash] != null)
            hash = (hash + 1) % parking.length;

        parking[hash] = plate;

        return hash;
    }

    public void exitVehicle(String plate) {

        for (int i = 0; i < parking.length; i++)
            if (plate.equals(parking[i]))
                parking[i] = null;
    }

    public static void main(String[] args) {

        ParkingLotSystem system = new ParkingLotSystem();

        System.out.println(system.parkVehicle("ABC1234"));
    }
}