/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Security.Repository;

import com.portfolio.alejandroPortfolio.Entity.Persona;
import com.portfolio.alejandroPortfolio.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario,Integer>{
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
        
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    
    public Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
