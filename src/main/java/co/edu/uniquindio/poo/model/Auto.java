package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {
    private int numeroPuertas;

    public Auto(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase, int numeroPuertas) {
        super(matricula, marca, modelo, añoFabricacion, tarifaBase);
        setNumeroPuertas(numeroPuertas); // Usar el setter para validar
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        if (numeroPuertas <= 0) {
            throw new IllegalArgumentException("El número de puertas debe ser mayor que cero.");
        }
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public double calcularCostoReserva(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("El número de días debe ser mayor que cero.");
        }
        return tarifaBase * dias; // Costo = tarifa base * número de días
    }

    @Override
    public String toString() {
        return "Auto [numeroPuertas=" + numeroPuertas + "]";
    }
}

