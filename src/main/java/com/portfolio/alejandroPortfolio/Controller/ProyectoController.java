/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Controller;

import com.portfolio.alejandroPortfolio.Dto.dtoProyecto;
import com.portfolio.alejandroPortfolio.Entity.Proyecto;
import com.portfolio.alejandroPortfolio.Security.Controller.Mensaje;
import com.portfolio.alejandroPortfolio.Service.ProyectoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProyectoController {
    
    @Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detalles/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto){
        
        
        
        Proyecto proyecto = new Proyecto(dtoproyecto.getTitulo(), dtoproyecto.getDescripcion(), dtoproyecto.getUrl(), dtoproyecto.getImagenProject());
        
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Registro creado"), HttpStatus.OK);
        
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto){
        
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        /*if(proyectoService.existsByTitulo(dtoproyecto.getTitulo()) && proyectoService.getByTitulo(dtoproyecto.getTitulo()).get().getId()!=id){
            return new ResponseEntity(new Mensaje("Este proyecto existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoproyecto.getTitulo())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }*/
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        
        proyecto.setTitulo(dtoproyecto.getTitulo());
        proyecto.setDescripcion(dtoproyecto.getDescripcion());
        proyecto.setUrl(dtoproyecto.getUrl());
        proyecto.setImagenProject(dtoproyecto.getImagenProject());
        
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") int id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el registro"), HttpStatus.BAD_REQUEST);
        }
        
        proyectoService.delete(id);
        
        return new ResponseEntity(new Mensaje("Registro proyecto eliminado"), HttpStatus.OK);
    }
    
}
