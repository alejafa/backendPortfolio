/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Security.Entity;

import com.portfolio.alejandroPortfolio.Security.Enums.RolPerfil;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolPerfil rolPerfil;

    public Rol() {
    }

    public Rol(RolPerfil rolPerfil) {        
        this.rolPerfil = rolPerfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolPerfil getRolPerfil() {
        return rolPerfil;
    }

    public void setRolPerfil(RolPerfil rolPerfil) {
        this.rolPerfil = rolPerfil;
    }
}
