/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreEd;
    @NotBlank
    private String tituloEd;
    @NotBlank
    private String descripcionEd;
    @NotBlank
    private String imagenEd;
    
    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEd, String tituloEd, String descripcionEd, String imagenEd) {
        this.nombreEd = nombreEd;
        this.tituloEd = tituloEd;
        this.descripcionEd = descripcionEd;
        this.imagenEd = imagenEd;
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
