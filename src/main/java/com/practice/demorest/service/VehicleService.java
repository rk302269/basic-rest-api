package com.practice.demorest.service;

import com.practice.demorest.model.Vehicle;
import java.util.List;
import java.util.Optional;

public interface VehicleService {

  Optional<Vehicle> getVehicleByVin(String vin);

  List<Vehicle> getAllVehicles();

  Vehicle addVehicle(Vehicle vehicle);

  void deleteVehicle(String vin);


}
