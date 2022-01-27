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
public class IntegranteSeleccion {
    protected int id;
    protected String nombre;
    private String apellido;
    private int edad;
    
    public IntegranteSeleccion(){
        this.id = 0;
        this.nombre = "null";
        this.apellido = "null";
        this.edad = 0;
    }
    
    public IntegranteSeleccion(int id, String nombre, String apellido, int edad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void concentrarse(){
        System.out.println("Concentrandose");
    }
    
    public void viajar(){
        System.out.println("Viajando");
    }

    @Override
    public String toString() {
        return "IntegranteSeleccion{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
    }
    
   
}
