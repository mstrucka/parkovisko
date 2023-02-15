package org.example.service;

import org.example.repository.Vehicle;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        this.vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(int id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        Vehicle vehicle = null;
        if (optionalVehicle.isPresent()) {
            vehicle = optionalVehicle.get();
        } else {
            throw new RuntimeException("Course not found for id : " + id);
        }
        return vehicle;
    }

    @Override
    public void deleteVehicleById(int id) {
        this.vehicleRepository.deleteById(id);
    }
}
