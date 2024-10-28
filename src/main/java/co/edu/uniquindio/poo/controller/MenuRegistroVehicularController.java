package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class MenuRegistroVehicularController {

    private List<Vehicle> vehicles = new ArrayList<>();

    // Método para registrar un vehículo en el sistema
    public boolean registerVehicle(String matricula, String marca, String modelo, int año, boolean esAutomatica, String tipoVehiculo) {
        Vehicle vehicle = new Vehicle(matricula, marca, modelo, año, esAutomatica, tipoVehiculo);
        vehicles.add(vehicle);
        return true; // Indica que el registro fue exitoso
    }

    // Método para obtener la lista de vehículos registrados
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
