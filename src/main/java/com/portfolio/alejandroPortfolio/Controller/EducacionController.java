package com.portfolio.alejandroPortfolio.Controller;


import com.portfolio.alejandroPortfolio.Dto.dtoEducacion;
import com.portfolio.alejandroPortfolio.Entity.Educacion;
import com.portfolio.alejandroPortfolio.Security.Controller.Mensaje;
import com.portfolio.alejandroPortfolio.Service.EducacionService;

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
@RequestMapping("/educacion")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EducacionController {
    @Autowired
    EducacionService educacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalles/{id}")
    public ResponseEntity<Educacion> getByUd(@PathVariable("id") int id){        
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.getOne(id).get();
        
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        
        if(StringUtils.isBlank(dtoeducacion.getTituloEd())){
            return new ResponseEntity(new Mensaje("El campo título es requerido"),HttpStatus.NOT_FOUND);
        }        
        if(StringUtils.isBlank(dtoeducacion.getNombreEd())){
            return new ResponseEntity(new Mensaje("El campo nombre es requerido"),HttpStatus.NOT_FOUND);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getDescripcionEd())){
            return new ResponseEntity(new Mensaje("El campo descripción es requerido"),HttpStatus.NOT_FOUND);
        }
        
        if(educacionService.existeByNombreEdu(dtoeducacion.getNombreEd())){
            return new ResponseEntity(new Mensaje("El dato nombre existe"),HttpStatus.NOT_FOUND);
        }              
        
       Educacion educacion = new Educacion(dtoeducacion.getNombreEd(),dtoeducacion.getTituloEd(), dtoeducacion.getDescripcionEd(), dtoeducacion.getImagenEd());
        
       educacionService.save(educacion);
       return new ResponseEntity(new Mensaje("Registro agregado"), HttpStatus.OK);         
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
         if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(educacionService.existeByNombreEdu(dtoeducacion.getNombreEd()) && educacionService.getByNombreEdu(dtoeducacion.getNombreEd()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombreEd())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.getOne(id).get();
        
        educacion.setNombreEd(dtoeducacion.getNombreEd());
        educacion.setTituloEd(dtoeducacion.getTituloEd());
        educacion.setDescripcionEd(dtoeducacion.getDescripcionEd());
        educacion.setImagenEd(dtoeducacion.getImagenEd());
        
        educacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Registro educación actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Registro educación eliminado"),HttpStatus.OK);
    }
}
