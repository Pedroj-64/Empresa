package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {

    private String nombre;
    private Collection<Vehiculo>  vehiculos;
    private Collection<Cliente> clientes;
    private Collection<Reserva> listaReservas;


    public Empresa(String nombre){
        this.nombre=nombre;
        vehiculos=new LinkedList<>();
        clientes=new LinkedList<>();
        listaReservas=new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Collection<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public boolean existeCliente(String cedula){
        boolean banderilla=false;
        for(Cliente cliente: clientes){
            if(cliente.getCedula()==cedula){
                banderilla=true;
                break;
            }
        }
        return banderilla;

    }

    public void agregarCliente(Cliente cliente){
        if(!existeCliente(cliente.getCedula())){
            clientes.add(cliente);
        }
    }

    public void eliminarCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public void setListaReservas(Collection<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public void agregarReserva(Reserva reserva){
        listaReservas.add(reserva);
    }
    public void eliminarReserva(Reserva reserva){
        listaReservas.remove(reserva);
    }

    
    public void calcularCostoReserva(Reserva reserva) {
        double costo=0;
        Vehiculo vehiculo=reserva.getVehiculo();
        if(vehiculo instanceof Auto){
            Auto auto=((Auto)vehiculo);
            int dias=reserva.getDias();
            costo=vehiculo.getTarifaBase()*dias;
            reserva.setCostoTotal(costo);
        }else if(vehiculo instanceof Moto){
            Moto moto=((Moto)vehiculo);
            if(moto.isEsCajaAutomatica()==true){
                double adicional=0.21*moto.getTarifaBase();
                costo=moto.getTarifaBase() +  adicional;
            }
            reserva.setCostoTotal(costo);
        }else if(vehiculo  instanceof Camioneta){
            int incremento=0;
            Camioneta camioneta=((Camioneta)vehiculo);
            double capacidad=camioneta.getCargaToneladas();
            for(int i=0;i<capacidad;i++){
                incremento +=i;
            }
            double porcentajeIncremento=incremento/100;
            costo=camioneta.getTarifaBase()*porcentajeIncremento;
            reserva.setCostoTotal(costo+vehiculo.getTarifaBase());
        }
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + "]";
    }
    
    
}
