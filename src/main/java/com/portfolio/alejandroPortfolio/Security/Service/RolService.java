/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Security.Service;

import com.portfolio.alejandroPortfolio.Security.Entity.Rol;
import com.portfolio.alejandroPortfolio.Security.Enums.RolPerfil;
import com.portfolio.alejandroPortfolio.Security.Repository.iRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolPerfil(RolPerfil rolPerfil){
        
        return irolRepository.findByRolPerfil(rolPerfil);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
    
}
