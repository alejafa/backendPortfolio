/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Security.Service;

import com.portfolio.alejandroPortfolio.Entity.Persona;
import com.portfolio.alejandroPortfolio.Security.Entity.Usuario;
import com.portfolio.alejandroPortfolio.Security.Repository.iUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public List<Usuario> list(){
        return iusuarioRepository.findAll();
    }
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    
    public boolean existsById(int id){
        return iusuarioRepository.existsById(id);
    }
    
    public Optional<Usuario> getOne(int id){
        return iusuarioRepository.findById(id);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
