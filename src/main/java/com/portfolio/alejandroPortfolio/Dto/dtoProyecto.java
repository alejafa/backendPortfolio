/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoProyecto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String url;
    private String imagenProject;

    public dtoProyecto() {
    }

    public dtoProyecto(String titulo, String descripcion, String url, String imagenProject) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.imagenProject = imagenProject;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagenProject() {
        return imagenProject;
    }

    public void setImagenProject(String imagenProject) {
        this.imagenProject = imagenProject;
    }
    
    
    
    
}
