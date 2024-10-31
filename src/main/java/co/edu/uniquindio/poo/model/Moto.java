package co.edu.uniquindio.poo.model;

// La clase Moto extiende la clase Vehiculo
public class Moto extends Vehiculo {
    // Atributo que indica si la moto tiene caja automática
    private boolean esCajaAutomatica;

    // Constructor de la clase Moto
    public Moto(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase,
            boolean esCajaAutomatica) {
        super(matricula, marca, modelo, añoFabricacion, tarifaBase); // Llamada al constructor de la clase padre
                                                                     // Vehiculo
        this.esCajaAutomatica = esCajaAutomatica; // Asignación del valor de esCajaAutomatica
    }

    // Método que devuelve si la moto tiene caja automática
    public boolean isEsCajaAutomatica() {
        return esCajaAutomatica;
    }

    // Método que asigna si la moto tiene caja automática
    public void setEsCajaAutomatica(boolean esCajaAutomatica) {
        this.esCajaAutomatica = esCajaAutomatica;
    }

    // Método que calcula el costo de la reserva en función de los días y si tiene
    // caja automática
    @Override
    public double calcularCostoReserva(int dias) {
        if (dias <= 0) { // Validación de que los días sean mayor que cero
            throw new IllegalArgumentException("El número de días debe ser mayor que cero.");
        }
        double costo = this.tarifaBase * dias; // Cálculo del costo base
        if (esCajaAutomatica) { // Si la moto tiene caja automática, se añade un costo adicional
            costo += tarifaBase * 0.21; // Costo adicional por caja automática
        }
        return costo; // Retorno del costo total
    }

    // Método toString que devuelve una representación en cadena de la moto
    @Override
    public String toString() {
        return "Moto [esCajaAutomatica=" + esCajaAutomatica + "]"; // Devuelve si la moto tiene caja automática
    }
}
