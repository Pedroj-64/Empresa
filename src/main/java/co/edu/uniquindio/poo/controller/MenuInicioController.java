package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Empresa;

public class MenuInicioController {

    Empresa empresa;
    public void instancia() {
        try {
            empresa = App.getEmpresa();
            if (empresa == null) {
                throw new IllegalStateException("La empresa no pudo ser inicializada.");
            }
            // Aunque no se use 'empresa', manejamos la posible excepción.
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}
