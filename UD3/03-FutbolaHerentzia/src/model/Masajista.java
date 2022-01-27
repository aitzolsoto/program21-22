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
public class Masajista extends IntegranteSeleccion{
    private String titulacion;
    private int experientziaUrteak;
    
    public Masajista(){
        titulacion = "null";
        experientziaUrteak = 0;
    }
    
    public Masajista(String titulacion, int experientziaUrteak){
        super();
        this.titulacion = titulacion;
        this.experientziaUrteak = experientziaUrteak;
    }
    
    public Masajista(int id, String nombre, String apellido, int edad, String titulacion, int experientziaUrteak){
        super(id,nombre,apellido,edad);
        this.titulacion = titulacion;
        this.experientziaUrteak = experientziaUrteak;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public int getExperientziaUrteak() {
        return experientziaUrteak;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public void setExperientziaUrteak(int experientziaUrteak) {
        this.experientziaUrteak = experientziaUrteak;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void darMasaje(){
        System.out.println("Dando masaje");
    }

    @Override
    public String toString() {
        return "Masajista{id = " + super.getId() + ",nombre = "+ super.getNombre() + ",apellido = " + super.getApellido() + ",edad = " + super.getEdad() + ",titulacion = " + titulacion + ", experientziaUrteak = " + experientziaUrteak + '}';
    }
    
}
