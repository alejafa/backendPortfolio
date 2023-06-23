/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Service;

import com.portfolio.alejandroPortfolio.Entity.Proyecto;
import com.portfolio.alejandroPortfolio.Repository.IProyectoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    IProyectoRepository iproyectoRepository;
   
    public List<Proyecto> list(){
        return iproyectoRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return iproyectoRepository.findById(id);
    }
    
    public Optional<Proyecto> getByTitulo(String titulo){
        return iproyectoRepository.findByTitulo(titulo);
    }
    
    public void save(Proyecto proyecto){
        iproyectoRepository.save(proyecto);
    }
    
    public void delete(int id){
        iproyectoRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iproyectoRepository.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return iproyectoRepository.existsByTitulo(titulo);
    }
}
