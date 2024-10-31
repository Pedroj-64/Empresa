package co.edu.uniquindio.poo.model;

// La clase Auto hereda de Vehiculo
public class Auto extends Vehiculo {

    // Atributo que representa el número de puertas del auto
    private int numeroPuertas;

    /**
     * Constructor de la clase Auto.
     * 
     * @param matricula      La matrícula del vehículo.
     * @param marca          La marca del vehículo.
     * @param modelo         El modelo del vehículo.
     * @param añoFabricacion El año de fabricación del vehículo.
     * @param tarifaBase     La tarifa base del vehículo.
     * @param numeroPuertas  El número de puertas del auto.
     */
    public Auto(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase,
            int numeroPuertas) {
        // Llama al constructor de la clase base Vehiculo
        super(matricula, marca, modelo, añoFabricacion, tarifaBase);
        // Usa el setter para validar y asignar el número de puertas
        setNumeroPuertas(numeroPuertas);
    }

    /**
     * Obtiene el número de puertas del auto.
     * 
     * @return El número de puertas.
     */
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    /**
     * Establece el número de puertas del auto.
     * Si el número de puertas es menor o igual a cero, lanza una excepción.
     * 
     * @param numeroPuertas El número de puertas a establecer.
     */
    public void setNumeroPuertas(int numeroPuertas) {
        // Validación para asegurar que el número de puertas sea mayor que cero
        if (numeroPuertas <= 0) {
            throw new IllegalArgumentException("El número de puertas debe ser mayor que cero.");
        }
        this.numeroPuertas = numeroPuertas;
    }

    /**
     * Calcula el costo de la reserva del auto.
     * 
     * @param dias El número de días para los cuales se reserva el auto.
     * @return El costo total de la reserva.
     */
    @Override
    public double calcularCostoReserva(int dias) {
        // Validación para asegurar que el número de días sea mayor que cero
        if (dias <= 0) {
            throw new IllegalArgumentException("El número de días debe ser mayor que cero.");
        }
        // Calcula el costo total de la reserva multiplicando la tarifa base por el
        // número de días
        return tarifaBase * dias;
    }

    /**
     * Devuelve una representación en cadena del objeto Auto.
     * 
     * @return Una cadena que describe el Auto.
     */
    @Override
    public String toString() {
        return "Auto [numeroPuertas=" + numeroPuertas + "]";
    }
}
