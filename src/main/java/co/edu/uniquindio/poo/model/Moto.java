package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {
    private boolean esCajaAutomatica;

    public Moto(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase, boolean esCajaAutomatica) {
        super(matricula, marca, modelo, añoFabricacion, tarifaBase);
        this.esCajaAutomatica = esCajaAutomatica; // Validación no necesaria ya que es boolean
    }

    public boolean isEsCajaAutomatica() {
        return esCajaAutomatica;
    }

    public void setEsCajaAutomatica(boolean esCajaAutomatica) {
        this.esCajaAutomatica = esCajaAutomatica;
    }

    @Override
    public double calcularCostoReserva(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("El número de días debe ser mayor que cero.");
        }
        double costo = this.tarifaBase * dias;
        if (esCajaAutomatica) {
            costo += tarifaBase * 0.21; // Costo adicional
        }
        return costo;
    }

    @Override
    public String toString() {
        return "Moto [esCajaAutomatica=" + esCajaAutomatica + "]";
    }
}
