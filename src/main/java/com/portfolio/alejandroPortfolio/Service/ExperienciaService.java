/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Service;

import com.portfolio.alejandroPortfolio.Entity.Experiencia;
import com.portfolio.alejandroPortfolio.Repository.IExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    IExperienciaRepository iexperienciaRepository;
    
    public List<Experiencia> list(){
        
        return iexperienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return iexperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByTituloEx(String tituloEx){
        
        return iexperienciaRepository.findByTituloEx(tituloEx);
    }
    
    public void save(Experiencia experiencia){
        iexperienciaRepository.save(experiencia);
    }
    
    public void delete(int id){
        
        iexperienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        
        return iexperienciaRepository.existsById(id);
    }
    
    public boolean existsByTituloEx(String tituloEx){
        
        return iexperienciaRepository.existsByTituloEx(tituloEx);
    }    
    
}
