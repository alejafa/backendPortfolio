/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Security.Repository;

import com.portfolio.alejandroPortfolio.Security.Entity.Rol;
import com.portfolio.alejandroPortfolio.Security.Enums.RolPerfil;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    
    Optional<Rol> findByRolPerfil(RolPerfil rolPerfil);
}
