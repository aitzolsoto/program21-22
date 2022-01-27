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
public class Entrenador extends IntegranteSeleccion{
    private String idFederacion;
    
    public Entrenador(){
        this.idFederacion = "000000";
    }
    
    public Entrenador(String idFederacion){
        super();
        this.idFederacion = idFederacion;
    }
    
    public Entrenador(int id, String nombre, String apellido, int edad, String idFederacion){
        super(id,nombre,apellido,edad);
        this.idFederacion = idFederacion;
    } 

    public String getIdFederacion() {
        return idFederacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void dirigirEntrenamiento(){
        System.out.println("Dirigiendo entrenamiento");
    }
    
    public void dirigirPartido(){
        System.out.println("Dirigiendo partido");
    }

    @Override
    public String toString() {
        return "Entrenador{id = " + super.getId() + ",nombre = "+ super.getNombre() + ",apellido = " + super.getApellido() + ",edad = " + super.getEdad() + ", idFederacion = " + idFederacion + '}';
    }
    
}
