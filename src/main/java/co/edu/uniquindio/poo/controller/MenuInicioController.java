package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Empresa;

public class MenuInicioController {

    public void instancia(){
        Empresa empresa=App.getEmpresa();
        empresa.crearReservaEjemplo();
    }
    


    
}

