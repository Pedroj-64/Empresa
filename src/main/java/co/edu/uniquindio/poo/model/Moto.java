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
    public String toString() {
        return "Moto [esCajaAutomatica=" + esCajaAutomatica + "]";
    }

    
    
}
