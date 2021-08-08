package com.practice.demorest.controller;

import com.practice.demorest.model.Vehicle;
import com.practice.demorest.service.VehicleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {

  private final VehicleService vehicleService;

  @GetMapping("/{vin}")
  public ResponseEntity<Vehicle> getVehicleByVin(@PathVariable final String vin) {

    return vehicleService.getVehicleByVin(vin).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());

  }

  @PostMapping()
  public ResponseEntity<Vehicle> addVehicle(@RequestBody final Vehicle vehicle) {
    final var vehicle1 = vehicleService.addVehicle(vehicle);

    return new ResponseEntity<>(vehicle1, HttpStatus.CREATED);
  }

  @GetMapping("/vehicles")
  public ResponseEntity<List<Vehicle>> getAllVehicles() {
    return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
  }

  @DeleteMapping("/{vin}")
  public ResponseEntity<String> deleteVehicle(@PathVariable final String vin) {
    vehicleService.deleteVehicle(vin);
    return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
  }

}
