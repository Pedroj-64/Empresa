package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Vehiculo;

/**
 * Clase Controller de la interfaz del mismo nombre en esta se controla la
 * conexion con el modelo
 * a la hora de registrar , eliminar, buscar y actualizar vehiculos.
 * 
 */
public class MenuRegistroVehicularController {
    /**
     * Inicializacion de empresa como utilizar la instancia
     */
    Empresa empresa = App.getEmpresa();

    /**
     * Metodo registrarVehiculo el cual recibe los datos que el usuario llena y crea
     * objeto dependiendo
     * lo pedido este metodo tiene una pequeña asemejacion al patron de diseño
     * Factory , haciendo el objeto
     * dependiendo lo pedido
     * 
     * @param matricula
     * @param marca
     * @param modelo
     * @param año
     * @param esAutomatica
     * @param tipoVehiculo
     * @param tarifaBase
     * @param numeroDePuertas
     * @param capacidadDeCarga
     * @return
     */
    public boolean registrarVehiculo(String matricula, String marca, String modelo, int año, boolean esAutomatica,
            String tipoVehiculo, double tarifaBase, Integer numeroDePuertas, int capacidadDeCarga) {
        // Atributos inicilizados para correcto funcionamiento del metodo
        boolean banderilla = true;
        Vehiculo vehiculo;
        // Validacion de datos y instancia antes de llevar a cabo la operacion de crear
        // vehiculo

        if (empresa == null) {
            throw new IllegalStateException("La empresa no puede ser nula.");
        }
        if (matricula == null || matricula.isEmpty() ||
                marca == null || marca.isEmpty() ||
                modelo == null || modelo.isEmpty() ||
                tipoVehiculo == null || tipoVehiculo.isEmpty()) {
            throw new IllegalArgumentException("Los parámetros no pueden ser nulos o vacíos.");
        }
        // Switch con una logica asemejada de Factory

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
                    throw new IllegalArgumentException(
                            "La capacidad de carga debe ser mayor que cero para una Camioneta.");
                }
                vehiculo = new Camioneta(matricula, marca, modelo, año, tarifaBase, capacidadDeCarga);
                break;
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido: " + tipoVehiculo);
        }
        // metodo auxiliar que agregar vehiculo a la empresa

        agregarVehiculo(vehiculo);
        return banderilla;
    }

    /**
     * Metodo auxiliar de registrarVehiculo este solo utiliza la empresa y lo agrega
     * valiendose de que
     * ya esta creado el objeto
     * 
     * @param vehiculo
     */
    public void agregarVehiculo(Vehiculo vehiculo) {
        // Validaciones importantes de datos y instancia para evitar errores
        if (empresa == null) {
            throw new IllegalStateException("La empresa no puede ser nula al agregar un vehículo.");
        }
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }
        empresa.agregarVehiculo(vehiculo);
    }
}
