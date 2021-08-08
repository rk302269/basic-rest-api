package com.practice.demorest.service;

import com.practice.demorest.model.Vehicle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

  private static final Map<String, Vehicle> vehicleMap = new HashMap<>();

  static {
    vehicleMap.put("VIN12345",
        Vehicle.builder().vin("VIN12345").make("FORD").model("F150-Lightening").year(2021).build());
    vehicleMap.put("VIN007", Vehicle.builder().vin("VIN007").make("LINCOLN").model("NAVIGATOR").year(2022).build());
  }

  @Override
  public Optional<Vehicle> getVehicleByVin(String vin) {

    return Optional.ofNullable(vehicleMap.get(vin));
  }

  @Override
  public List<Vehicle> getAllVehicles() {
    return new ArrayList<>(vehicleMap.values());
  }

  @Override
  public Vehicle addVehicle(Vehicle vehicle) {
    vehicleMap.put(vehicle.getVin(), vehicle);
    return vehicleMap.get(vehicle.getVin());
  }

  @Override
  public void deleteVehicle(String vin) {

    vehicleMap.remove(vin);

  }
}
