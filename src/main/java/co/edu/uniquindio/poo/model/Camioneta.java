package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo{

    private int cargaToneladas;

    public Camioneta(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase,int cargaToneladas){
        super(matricula, marca, modelo, añoFabricacion,tarifaBase);
        this.cargaToneladas=cargaToneladas;
    }

    public int getCargaToneladas() {
        return cargaToneladas;
    }

    public void setCargaToneladas(int cargaToneladas) {
        this.cargaToneladas = cargaToneladas;
    }

    @Override
    public String toString() {
        return "Camioneta [cargaToneladas=" + cargaToneladas + "]";
    }
    
    
}
