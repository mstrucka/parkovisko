package org.example.repository;

import java.util.*;

public class ParkingHouse {

    private final int PRICE_HOUR = 3;
    private final int PRICE_DAY = 20;
    private final int PRICE_WEEK = 100;
    public List<Vehicle> parkedCars;
    public HashMap<Vehicle, Integer> parking;
    Scanner s;
    public MyJDBC database;





    String name;
    int vehicleLicensePlate;

    public ParkingHouse() {
        parkedCars = new ArrayList<>();
        parking = new HashMap<>();
        this.database = new MyJDBC();
    }

    public boolean addVehicle(Vehicle v, int parkingDays) {
        if (payment(v) && isEmpty()) {
            parking.put(v, parkingDays);
            return (parkedCars.add(v));
        } else {
            return false;
        }
    }

    public boolean payment(Vehicle v) {
        return true;
    }

    public boolean isEmpty() {
        return parkedCars.size() < 2;
    }

    //TODO: pozri ci to returnne, ak nie zmen nejak na String.
    // formatting nech to pise line by line ze parkuje tu auto X
    public StringBuilder listParkedVehicles() {
        StringBuilder haha = new StringBuilder();
        for (Vehicle v : parkedCars) {
            haha.append("There is a vehicle with LP").append(v.getLicensePlate()).append("parked.");
        }
        return haha;
    }


    public boolean startParking() {



        Scanner scanner = new Scanner(System.in);
        Set<String> licensePlates = new TreeSet<>();
        System.out.println("If you want to park a car please press YES,if not please press NO" + " ");
        String userAnswer = scanner.nextLine();
        while (isEmpty() && userAnswer.equals("yes"))



//        Scanner scanner = new Scanner(System.in);
//        String userAnswer = scanner.nextLine();
            if (userAnswer.contains("yes")) {


            System.out.println("Is that a car(car) or bus(bus)? : ");
            String input = scanner.nextLine();
            Vehicle v = new Vehicle();


            // TODO: okej, ak je empty, zaciname parkovat, else napiseme ze sme full, to mame

            // TODO: ak to NENI auto, zmenime isCar na false, vytvorime set licensePlates

            if (input !="car" || input != "bus") {

                v.setName(input);



                System.out.println("Enter your license plate:");
                String licensePlate = scanner.nextLine();
                // TODO: neviem preco ten if erroruje, ale zistujeme ci uz je licenseplate registered, ak hej prejeb
                // TODO: ak nie, pridame LP do setu a vehiclu nastavime LP
                if (licensePlates.contains(licensePlate)) {
                    System.out.println("This car is already parked");
                } else {
                    licensePlates.add(licensePlate);
                    v.setLicensePlate(licensePlate);

                    startPaying();
                    database.update(v);

                    }
                System.out.println("If you want to park a car please press YES,if not please press NO" + " ");
                String lastInput = scanner.nextLine();
                if (lastInput.contains("no")){

                    database.update(v);
                    break;


                }else{
                    continue;
                }
            }



//            } else{
//                System.out.println("Have a nice day");
//                System.exit(0);

            }

            return false;
        }


        // database.add(v);



        public void startPaying () {
            Scanner scanner = new Scanner(System.in);

            // TODO: teraz platime, treba zaplatit, zavolat addVehicle a mohli by sme byt hotovi, cas parkingu up to you ci riesime
            System.out.println("Enter the amount of days that you plan to park your car for(if only hours please press 0): ");

            String amountOfParkingDays = scanner.nextLine();
            Integer amountOfParkingDaysInDigits = Integer.valueOf(amountOfParkingDays);

            Integer finalCost = 0;
            Integer finalCostHours = 0;
            if (amountOfParkingDaysInDigits > 0) {
                finalCost = PRICE_DAY * amountOfParkingDaysInDigits;
                System.out.println("Your bill will be " + finalCost + " $" + "for " + amountOfParkingDaysInDigits + " days");

            } else if (amountOfParkingDaysInDigits == 0) {

                System.out.println("Enter the amount of hours that you plan to park your car for :");
                String amountofParkingHours = scanner.nextLine();
                Integer amountOfParkingHoursInDigits = Integer.valueOf(amountofParkingHours);
                finalCostHours = PRICE_HOUR * amountOfParkingHoursInDigits;
                System.out.println("The final price is  " + finalCostHours + " $" + " for " + amountOfParkingHoursInDigits + " hours,which your car will be parked in the parking lot");


                // TODO: potom uz len while loop nad to cele aby to bezalo vkuse a zavolat to v maine a simple verzia je done.


                // TODO: tazsia verzia, vypytaj si input ako "car, bus,trolejbus", vytvor konkretnu triedu
                // TODO: check if 3, 20, 100, tu budes mat hotove vehicle, addVehicle


            } else {

                System.out.println("The parking is full, sorry. ");


            }
        }



        @Override
        public String toString () {
            String result = "";
            result = "\nName:" + name + "\nLicenseplate" + vehicleLicensePlate;


            return result;
        }

//    public String getParkedCars() {
//        return database.getCars();
//    }

//    public String getVehicles() {
//        //TODO: return databse.getAll() returnujuca string
//    }

    }






// TODO: future: nejaka metoda ktora pretoci hodinky a ked auto pojde vyparkovat tak cekne v tej hashMap ci ma stale zaplatene, ak ako pekny den ak nie zaplat, staci vypisat

