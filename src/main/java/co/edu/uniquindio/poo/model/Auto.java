package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {

    private int numeroPuertas;

    public Auto(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase,int numeroPuertas){
        super(matricula, marca, modelo, añoFabricacion,tarifaBase);
        this.numeroPuertas=numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }


    @Override
    public String toString() {
        return "Auto [numeroPuertas=" + numeroPuertas + ", diasReserva=" + "]";
    }
    

    
    
}
