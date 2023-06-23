/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String tituloEx;
    @NotBlank
    private String descripcionEx;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreEx, String descripcionEx) {
        this.tituloEx = nombreEx;
        this.descripcionEx = descripcionEx;
    }

    public String getTituloEx() {
        return tituloEx;
    }

    public void setTituloEx(String nombreEx) {
        this.tituloEx = nombreEx;
    }

    public String getDescripcionEx() {
        return descripcionEx;
    }

    public void setDescripcionEx(String descripcionEx) {
        this.descripcionEx = descripcionEx;
    }
    
    
    
}
