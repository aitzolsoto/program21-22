/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author soto.aitzol
 */
public class Futbolista extends IntegranteSeleccion{
    private int dorsal;
    private Demarcacion demarcacion;
    
    public Futbolista(int dorsal, Demarcacion demarcacion){
        super();
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }
    
    public Futbolista(int id,String nombre, String apellido, int edad, int dorsal, Demarcacion demarcacion){
        super(id,nombre,apellido,edad);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public Demarcacion getDemarcacion() {
        return demarcacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setDemarcacion(Demarcacion demarcacion) {
        this.demarcacion = demarcacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void entrenar(){
        System.out.println("Entrenando");
    }
    
    public void jugarPartido(){
        System.out.println("Jugando partido");
    }

    @Override
    public String toString() {
        return "Futbolista{id = " + super.getId() + ",nombre = " + super.getNombre() + ",apellido = " + super.getApellido() + ",edad = " + super.getEdad() +",dorsal = " + dorsal + ", demarcacion=" + demarcacion + '}';
    }
    
}
