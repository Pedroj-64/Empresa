package co.edu.uniquindio.poo.model;

// Clase abstracta Vehiculo
public abstract class Vehiculo {
    // Atributos de la clase Vehiculo
    private String matricula, marca, modelo; // Matricula, marca y modelo del vehículo
    private int añoFabricacion; // Año de fabricación del vehículo
    protected double tarifaBase; // Tarifa base del vehículo

    // Constructor de la clase Vehiculo
    public Vehiculo(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase) {
        setMatricula(matricula); // Asigna la matrícula utilizando el método setMatricula
        setMarca(marca); // Asigna la marca utilizando el método setMarca
        setModelo(modelo); // Asigna el modelo utilizando el método setModelo
        setAñoFabricacion(añoFabricacion); // Asigna el año de fabricación utilizando el método setAñoFabricacion
        setTarifaBase(tarifaBase); // Asigna la tarifa base utilizando el método setTarifaBase
    }

    // Método para obtener la matrícula
    public String getMatricula() {
        return matricula;
    }

    // Método para asignar la matrícula con validación
    public void setMatricula(String matricula) {
        if (matricula == null || matricula.isEmpty()) { // Validación para que la matrícula no sea nula o vacía
            throw new IllegalArgumentException("La matrícula no puede ser nula o vacía.");
        }
        this.matricula = matricula;
    }

    // Método para obtener la marca
    public String getMarca() {
        return marca;
    }

    // Método para asignar la marca con validación
    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty()) { // Validación para que la marca no sea nula o vacía
            throw new IllegalArgumentException("La marca no puede ser nula o vacía.");
        }
        this.marca = marca;
    }

    // Método para obtener el modelo
    public String getModelo() {
        return modelo;
    }

    // Método para asignar el modelo con validación
    public void setModelo(String modelo) {
        if (modelo == null || modelo.isEmpty()) { // Validación para que el modelo no sea nulo o vacío
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío.");
        }
        this.modelo = modelo;
    }

    // Método para obtener el año de fabricación
    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    // Método para asignar el año de fabricación con validación
    public void setAñoFabricacion(int añoFabricacion) {
        if (añoFabricacion <= 0) { // Validación para que el año de fabricación sea mayor que cero
            throw new IllegalArgumentException("El año de fabricación debe ser mayor que cero.");
        }
        this.añoFabricacion = añoFabricacion;
    }

    // Método para obtener la tarifa base
    public double getTarifaBase() {
        return tarifaBase;
    }

    // Método para asignar la tarifa base con validación
    public void setTarifaBase(double tarifaBase) {
        if (tarifaBase < 0) { // Validación para que la tarifa base no sea negativa
            throw new IllegalArgumentException("La tarifa base no puede ser negativa.");
        }
        this.tarifaBase = tarifaBase;
    }

    // Método abstracto que calculará el costo de la reserva en función de los días
    public abstract double calcularCostoReserva(int dias);

    // Método toString que devuelve una representación en cadena del vehículo
    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", añoFabricacion="
                + añoFabricacion + ", tarifaBase=" + tarifaBase + "]";
        // Devuelve una cadena con los atributos del vehículo
    }
}
