package co.edu.uniquindio.poo.model;

// La clase Camioneta hereda de Vehiculo
public class Camioneta extends Vehiculo {

    // Atributo que representa la capacidad de carga en toneladas
    private int cargaToneladas = 0;

    /**
     * Constructor de la clase Camioneta.
     * 
     * @param matricula      La matrícula del vehículo.
     * @param marca          La marca del vehículo.
     * @param modelo         El modelo del vehículo.
     * @param añoFabricacion El año de fabricación del vehículo.
     * @param tarifaBase     La tarifa base del vehículo.
     * @param cargaToneladas La capacidad de carga en toneladas.
     */
    public Camioneta(String matricula, String marca, String modelo, int añoFabricacion, double tarifaBase,
            int cargaToneladas) {
        // Llama al constructor de la clase base Vehiculo
        super(matricula, marca, modelo, añoFabricacion, tarifaBase);
        // Usa el setter para validar y asignar la capacidad de carga
        setCargaToneladas(cargaToneladas);
    }

    /**
     * Obtiene la capacidad de carga de la camioneta en toneladas.
     * 
     * @return La capacidad de carga en toneladas.
     */
    public int getCargaToneladas() {
        return cargaToneladas;
    }

    /**
     * Establece la capacidad de carga de la camioneta en toneladas.
     * Si la capacidad de carga es menor que cero, lanza una excepción.
     * 
     * @param cargaToneladas La capacidad de carga en toneladas a establecer.
     */
    public void setCargaToneladas(int cargaToneladas) {
        // Validación para asegurar que la capacidad de carga sea mayor o igual a cero
        if (cargaToneladas < 0) {
            throw new IllegalArgumentException("La capacidad de carga debe ser mayor o igual a cero.");
        }
        this.cargaToneladas = cargaToneladas;
    }

    /**
     * Calcula el costo de la reserva de la camioneta.
     * 
     * @param dias El número de días para los cuales se reserva la camioneta.
     * @return El costo total de la reserva.
     */
    @Override
    public double calcularCostoReserva(int dias) {
        // Validación para asegurar que el número de días sea mayor que cero
        if (dias <= 0) {
            throw new IllegalArgumentException("El número de días debe ser mayor que cero.");
        }
        double incremento = 0;
        // Cálculo de incremento basado en la capacidad de carga
        for (int i = 0; i < cargaToneladas; i++) {
            incremento += i; // Puede variar según la lógica que definas
        }
        double porcentajeIncremento = incremento / 100;
        // Calcula el costo total de la reserva
        double costo = (tarifaBase + (tarifaBase * porcentajeIncremento)) * dias;
        return costo;
    }

    /**
     * Devuelve una representación en cadena del objeto Camioneta.
     * 
     * @return Una cadena que describe la Camioneta.
     */
    @Override
    public String toString() {
        return "Camioneta [cargaToneladas=" + cargaToneladas + "]";
    }
}
