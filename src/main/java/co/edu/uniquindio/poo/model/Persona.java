package co.edu.uniquindio.poo.model;

// Clase abstracta Persona
public abstract class Persona {
    // Atributos de la clase Persona
    private String nombre, apellido, cedula;
    private int edad;

    // Constructor de la clase Persona
    public Persona(String nombre, String apellido, String cedula, int edad) {
        setNombre(nombre); // Asigna el nombre utilizando el método setNombre
        setApellido(apellido); // Asigna el apellido utilizando el método setApellido
        setCedula(cedula); // Asigna la cédula utilizando el método setCedula
        setEdad(edad); // Asigna la edad utilizando el método setEdad
    }

    // Método para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método para asignar el nombre con validación
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) { // Validación para que el nombre no sea nulo o vacío
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    // Método para obtener el apellido
    public String getApellido() {
        return apellido;
    }

    // Método para asignar el apellido con validación
    public void setApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) { // Validación para que el apellido no sea nulo o vacío
            throw new IllegalArgumentException("El apellido no puede ser nulo o vacío.");
        }
        this.apellido = apellido;
    }

    // Método para obtener la cédula
    public String getCedula() {
        return cedula;
    }

    // Método para asignar la cédula con validación
    public void setCedula(String cedula) {
        if (cedula == null || cedula.isEmpty()) { // Validación para que la cédula no sea nula o vacía
            throw new IllegalArgumentException("La cédula no puede ser nula o vacía.");
        }
        this.cedula = cedula;
    }

    // Método para obtener la edad
    public int getEdad() {
        return edad;
    }

    // Método para asignar la edad con validación
    public void setEdad(int edad) {
        if (edad <= 0) { // Validación para que la edad sea mayor que cero
            throw new IllegalArgumentException("La edad debe ser mayor que cero.");
        }
        this.edad = edad;
    }

    // Método toString que devuelve una representación en cadena de la persona
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", edad=" + edad + "]";
        // Devuelve una cadena con los atributos de la persona
    }
}
