package org.example;

import org.example.repository.ParkingHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<ParkingHouse> parkingHouses = new ArrayList<>();

        for (int i = 0 ; i <4; i++) {
            ParkingHouse p = new ParkingHouse();
            parkingHouses.add(p);


        }

        if (!parkingHouses.isEmpty()) {
            for (int i = 0; i < parkingHouses.size(); i++) {
                parkingHouses.get(i).startParking();
                System.out.println("Here is your parking lot " + parkingHouses.get(i).toString());



            }

        } else {
            System.out.println("Have a nice day");
            System.exit(0);
//                System.out.println(parkingHouses.get(1).getParkedCars());


        }

    }
}
