package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Vehiculo;



public class MenuRegistroVehicularController {
    Empresa empresa;

    public void instancia() {
        empresa = Empresa.getInstance("mi empresa");
        if (!empresa.tieneVehiculos()) {
            agregarVehiculosEjemplo();
        }
    }
    
    public boolean registrarVehiculo(String matricula, String marca, String modelo, int año, boolean esAutomatica,
                                     String tipoVehiculo, double tarifaBase, Integer numeroDePuertas, int capacidadDeCarga) {
        Vehiculo vehiculo;
    
        switch (tipoVehiculo) {
            case "Auto":
                if (numeroDePuertas == null) {
                    throw new IllegalArgumentException("El número de puertas no puede ser nulo para un Auto.");
                }
                vehiculo = new Auto(matricula, marca, modelo, año, tarifaBase, numeroDePuertas);
                break;
            case "Moto":
                vehiculo = new Moto(matricula, marca, modelo, año, tarifaBase, esAutomatica);
                break;
            case "Camioneta":
                if (capacidadDeCarga == 0) {
                    throw new IllegalArgumentException("La capacidad de carga no puede ser nula para una Camioneta.");
                }
                vehiculo = new Camioneta(matricula, marca, modelo, año, tarifaBase, capacidadDeCarga);
                break;
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido: " + tipoVehiculo);
        }
        agregarVehiculo(vehiculo);
        return true;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        empresa.agregarVehiculo(vehiculo);
    }

    public void agregarVehiculosEjemplo() {
        // Ejemplo de vehículos
        registrarVehiculo("ABC123", "Toyota", "Corolla", 2020, true, "Auto", 10000, 4, 0);
        registrarVehiculo("XYZ789", "Yamaha", "YZF-R3", 2019, false, "Moto", 5000, null, 0);
        registrarVehiculo("LMN456", "Ford", "F-150", 2021, false, "Camioneta", 15000, null, 1000);
    }
}