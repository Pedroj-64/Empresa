package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    private String matricula, marca, modelo;
    private int añoFabricacion;
    protected double tarifaBase;

    public Vehiculo(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase) {
        setMatricula(matricula);
        setMarca(marca);
        setModelo(modelo);
        setAñoFabricacion(añoFabricacion);
        setTarifaBase(tarifaBase);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("La matrícula no puede ser nula o vacía.");
        }
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca no puede ser nula o vacía.");
        }
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío.");
        }
        this.modelo = modelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        if (añoFabricacion <= 0) {
            throw new IllegalArgumentException("El año de fabricación debe ser mayor que cero.");
        }
        this.añoFabricacion = añoFabricacion;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        if (tarifaBase < 0) {
            throw new IllegalArgumentException("La tarifa base no puede ser negativa.");
        }
        this.tarifaBase = tarifaBase;
    }

    public abstract double calcularCostoReserva(int dias);

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", añoFabricacion=" + añoFabricacion + ", tarifaBase=" + tarifaBase + "]";
    }
}
