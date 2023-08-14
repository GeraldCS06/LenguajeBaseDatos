/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author kyran
 */
public class Mascota {

    int id_mascota;
    String dueño;
    String especie;
    int edad;
    String genero;
    String nombre_mascota;
    String raza;
    int peso;
    String esterilizada;

    public Mascota(int id_mascota, String dueño, String especie, int edad, String genero, String nombre_especie, String raza, int peso, String esterilizada) {
        this.id_mascota = id_mascota;
        this.dueño = dueño;
        this.especie = especie;
        this.edad = edad;
        this.genero = genero;
        this.nombre_mascota = nombre_especie;
        this.raza = raza;
        this.peso = peso;
        this.esterilizada = esterilizada;
    }

    public Mascota(String dueño, String especie, int edad, String genero, String nombre_especie, String raza, int peso, String esterilizada) {

        this.dueño = dueño;
        this.especie = especie;
        this.edad = edad;
        this.genero = genero;
        this.nombre_mascota = nombre_especie;
        this.raza = raza;
        this.peso = peso;
        this.esterilizada = esterilizada;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getEsterilizada() {
        return esterilizada;
    }

    public void setEsterilizada(String esterilizada) {
        this.esterilizada = esterilizada;
    }
    
    @Override
    public String toString() {
        return "Mascota{" + "dueño=" + dueño + ", especie=" + especie + ", edad=" + edad + ", genero=" + genero + ", nombre_mascota=" + nombre_mascota + ", raza=" + raza + ",peso=" + peso + ",esterilizada =" + esterilizada +'}';
    }

}
