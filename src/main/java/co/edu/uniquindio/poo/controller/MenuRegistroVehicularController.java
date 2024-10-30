package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Vehiculo;



public class MenuRegistroVehicularController {
    Empresa empresa = App.getEmpresa();

    public boolean registrarVehiculo(String matricula, String marca, String modelo, int año, boolean esAutomatica,
                                     String tipoVehiculo, double tarifaBase, Integer numeroDePuertas, int capacidadDeCarga) {
        if (empresa == null) {
            throw new IllegalStateException("La empresa no puede ser nula.");
        }

        if (matricula == null || marca == null || modelo == null || tipoVehiculo == null) {
            throw new IllegalArgumentException("Los parámetros no pueden ser nulos.");
        }

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

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (empresa != null) {
            empresa.agregarVehiculo(vehiculo);
        } else {
            throw new IllegalStateException("La empresa no puede ser nula al agregar un vehículo.");
        }
    }
}
