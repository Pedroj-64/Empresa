package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    private String  matricula, marca, modelo;
    private int añoFabricacion;
    private double tarifaBase;

    public Vehiculo(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase){
        this.matricula=matricula;
        this.marca=marca;
        this.modelo=modelo;
        this.añoFabricacion=añoFabricacion;
        this.tarifaBase=tarifaBase;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", añoFabricacion="
                + añoFabricacion + ", tarifaBase=" + tarifaBase + "]";
    }
    

    
}
