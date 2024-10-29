package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Empresa;

public class MenuInicioController {
    Empresa empresa;

    public void instancia(){
        Empresa.getInstance("mi empresa");
    }

    
}

