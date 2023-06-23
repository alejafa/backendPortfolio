/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Service;

import com.portfolio.alejandroPortfolio.Entity.Skills;
import com.portfolio.alejandroPortfolio.Repository.ISkillsRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService {
    @Autowired
    ISkillsRepository iskillsRepository;
    
    public List<Skills> list(){
        
        return iskillsRepository.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return iskillsRepository.findById(id);
    }
    
    public Optional<Skills> getByNombreSk(String nombreSk){
        return iskillsRepository.findByNombreSk(nombreSk);
    }
    
   public void save(Skills skill){
       iskillsRepository.save(skill);
   }
   
   public void delete(int id){
       iskillsRepository.deleteById(id);
   }
   
   public boolean existsById(int id){
       
       return iskillsRepository.existsById(id);
   }
   
   public boolean existsByNombreSk(String nombreSk){
       
       return iskillsRepository.existsByNombreSk(nombreSk);
   }
    
    
}
