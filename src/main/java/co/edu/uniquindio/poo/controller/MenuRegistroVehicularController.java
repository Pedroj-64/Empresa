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
        boolean banderilla=true;
        if (empresa == null) {
            throw new IllegalStateException("La empresa no puede ser nula.");
        }
        if (matricula == null || matricula.isEmpty() ||
            marca == null || marca.isEmpty() ||
            modelo == null || modelo.isEmpty() ||
            tipoVehiculo == null || tipoVehiculo.isEmpty()) {
            throw new IllegalArgumentException("Los parámetros no pueden ser nulos o vacíos.");
        }

        Vehiculo vehiculo;
        switch (tipoVehiculo) {
            case "Auto":
                if (numeroDePuertas == null || numeroDePuertas <= 0) {
                    throw new IllegalArgumentException("El número de puertas debe ser mayor que cero para un Auto.");
                }
                vehiculo = new Auto(matricula, marca, modelo, año, tarifaBase, numeroDePuertas);
                break;
            case "Moto":
                vehiculo = new Moto(matricula, marca, modelo, año, tarifaBase, esAutomatica);
                break;
            case "Camioneta":
                if (capacidadDeCarga <= 0) {
                    throw new IllegalArgumentException("La capacidad de carga debe ser mayor que cero para una Camioneta.");
                }
                vehiculo = new Camioneta(matricula, marca, modelo, año, tarifaBase, capacidadDeCarga);
                break;
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido: " + tipoVehiculo);
        }

        agregarVehiculo(vehiculo);
        return banderilla;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (empresa == null) {
            throw new IllegalStateException("La empresa no puede ser nula al agregar un vehículo.");
        }
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }
        empresa.agregarVehiculo(vehiculo);
    }
}
