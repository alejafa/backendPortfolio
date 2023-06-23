/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Controller;

import com.portfolio.alejandroPortfolio.Dto.dtoExperiencia;
import com.portfolio.alejandroPortfolio.Entity.Experiencia;
import com.portfolio.alejandroPortfolio.Security.Controller.Mensaje;
import com.portfolio.alejandroPortfolio.Service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ExperienciaController {
    
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalles/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el Id"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
   @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getTituloEx())){
            return new ResponseEntity(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        }
        if(experienciaService.existsByTituloEx(dtoexp.getTituloEx())){
            return new ResponseEntity(new Mensaje("Ya existe este registro"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(dtoexp.getTituloEx(), dtoexp.getDescripcionEx());
        
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Su registro quedo guardado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        
        experiencia.setTituloEx(dtoexp.getTituloEx());
        experiencia.setDescripcionEx(dtoexp.getDescripcionEx());
        
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el registro ID"), HttpStatus.NOT_FOUND);            
        }
        experienciaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Registro Eliminado"), HttpStatus.OK);
    }
}
