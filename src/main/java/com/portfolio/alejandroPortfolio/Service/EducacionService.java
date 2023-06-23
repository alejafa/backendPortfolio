/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Service;

import com.portfolio.alejandroPortfolio.Entity.Educacion;
import com.portfolio.alejandroPortfolio.Repository.IEducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    IEducacionRepository ieducacionRepository;
    
    public List<Educacion> list(){
        return ieducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return ieducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return ieducacionRepository.findByNombreEd(nombreEdu);
    }
    
    public void save(Educacion educacion){
        ieducacionRepository.save(educacion);
    }
    
    public void delete(int id){
        ieducacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ieducacionRepository.existsById(id);
    }
    
    public boolean existeByNombreEdu(String nombreEdu){
        return ieducacionRepository.existsByNombreEd(nombreEdu);
    }
}
