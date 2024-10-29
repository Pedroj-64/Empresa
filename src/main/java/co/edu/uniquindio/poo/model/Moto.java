package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {

    private boolean esCajaAutomatica;

    /**
     * @param esCajaAutomatica
     */
    public Moto(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase,boolean esCajaAutomatica ){
        super(matricula,marca,modelo,añoFabricacion,tarifaBase);
        this.esCajaAutomatica=esCajaAutomatica;
    
    }

    public boolean isEsCajaAutomatica() {
        return esCajaAutomatica;
    }

    public void setEsCajaAutomatica(boolean esCajaAutomatica) {
        this.esCajaAutomatica = esCajaAutomatica;
    }
    @Override
    public double calcularCostoReserva(int dias) {
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
