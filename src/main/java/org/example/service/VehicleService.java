package org.example.service;

import org.example.repository.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    void saveVehicle(Vehicle vehicle);
    Vehicle getVehicleById(int id);
    void deleteVehicleById(int id);
}
