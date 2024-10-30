package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo {
    private int cargaToneladas = 0;

    public Camioneta(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase, int cargaToneladas) {
        super(matricula, marca, modelo, añoFabricacion, tarifaBase);
        setCargaToneladas(cargaToneladas); // Usar el setter para validar
    }

    public int getCargaToneladas() {
        return cargaToneladas;
    }

    public void setCargaToneladas(int cargaToneladas) {
        if (cargaToneladas < 0) {
            throw new IllegalArgumentException("La capacidad de carga debe ser mayor o igual a cero.");
        }
        this.cargaToneladas = cargaToneladas;
    }

    @Override
    public double calcularCostoReserva(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("El número de días debe ser mayor que cero.");
        }
        double incremento = 0;
        // Cálculo de incremento basado en la capacidad de carga
        for (int i = 0; i < cargaToneladas; i++) {
            incremento += i; // Puede variar según la lógica que definas
        }
        double porcentajeIncremento = incremento / 100;
        double costo = (tarifaBase + (tarifaBase * porcentajeIncremento)) * dias;
        return costo;
    }

    @Override
    public String toString() {
        return "Camioneta [cargaToneladas=" + cargaToneladas + "]";
    }
}
