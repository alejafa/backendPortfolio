/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotNull
    private String titulo;
    @NotNull
    private String descripcion;
    @NotNull
    private String url;    
    private String imagenProject;

    public Proyecto() {
    }

    public Proyecto(String titulo, String descripcion, String url, String imagenProject) {        
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.imagenProject = imagenProject;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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
