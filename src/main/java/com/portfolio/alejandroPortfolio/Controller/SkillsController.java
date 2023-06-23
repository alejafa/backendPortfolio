/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Controller;

import com.portfolio.alejandroPortfolio.Dto.dtoSkills;
import com.portfolio.alejandroPortfolio.Entity.Skills;
import com.portfolio.alejandroPortfolio.Security.Controller.Mensaje;
import com.portfolio.alejandroPortfolio.Service.SkillsService;
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
@RequestMapping("/skills")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SkillsController {
    @Autowired
    SkillsService skillsService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = skillsService.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalles/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        
        Skills skills = skillsService.getOne(id).get();
        
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody dtoSkills dtoskills){
        Skills skills = new Skills(dtoskills.getNombreSk(), dtoskills.getPorcentaje());
        
        skillsService.save(skills);
        
        return new ResponseEntity(new Mensaje("El registro fue creado"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
        if(!skillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(skillsService.existsByNombreSk(dtoskills.getNombreSk()) && skillsService.getByNombreSk(dtoskills.getNombreSk()).get().getId()!=id){
            return new ResponseEntity(new Mensaje("este skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getNombreSk())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
                
        Skills skills = skillsService.getOne(id).get();
        skills.setNombreSk(dtoskills.getNombreSk());
        skills.setProcentaje(dtoskills.getPorcentaje());
        
        skillsService.save(skills);
        
        return new ResponseEntity(new Mensaje("Registro skills actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!skillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
        }        
        skillsService.delete(id);        
        return new ResponseEntity(new Mensaje("Reigistro skills eliminado"), HttpStatus.OK);
    }
}
