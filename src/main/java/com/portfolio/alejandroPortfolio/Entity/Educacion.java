/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Entity;

import com.portfolio.alejandroPortfolio.Security.Entity.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String tituloEd;
    private String descripcionEd;
    private String imagenEd;

    public Educacion() {
    }

    public Educacion(String nombreEd, String tituloEd, String descripcionEd, String imagenEd) {
        this.nombreEd = nombreEd;
        this.tituloEd = tituloEd;
        this.descripcionEd = descripcionEd;        
        this.imagenEd = imagenEd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEd() {
        return nombreEd;
    }

    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }   

    public String getTituloEd() {
        return tituloEd;
    }

    public void setTituloEd(String tituloEd) {
        this.tituloEd = tituloEd;
    }

    public String getImagenEd() {
        return imagenEd;
    }

    public void setImagenEd(String imagenEd) {
        this.imagenEd = imagenEd;
    }
    
    
}
