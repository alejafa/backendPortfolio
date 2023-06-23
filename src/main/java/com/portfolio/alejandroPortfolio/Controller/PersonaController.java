/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Controller;

import com.portfolio.alejandroPortfolio.Dto.dtoPersona;
import com.portfolio.alejandroPortfolio.Entity.Persona;
import com.portfolio.alejandroPortfolio.Security.Controller.Mensaje;
import com.portfolio.alejandroPortfolio.Security.Entity.Usuario;
import com.portfolio.alejandroPortfolio.Security.Service.UsuarioService;
import com.portfolio.alejandroPortfolio.Service.PersonaService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class PersonaController {
    
     @Autowired
        UsuarioService usuarioService;    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> list(){
        List<Usuario> list = usuarioService.list();        
        
	return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalles/{user}")
    public ResponseEntity<Usuario> getByNombreUsuario(@PathVariable("user") String nombreUsuario){        
        if(!usuarioService.existsByNombreUsuario(nombreUsuario)){
            return new ResponseEntity(new Mensaje("No existe el nombre usuario"), HttpStatus.OK);
        }
        //Usuario usuario = usuarioService.getOne(id).get();
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
    
    /*@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,  @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId()!= id ){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImagen(dtopersona.getImagen());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Datos actualizado"), HttpStatus.OK);
        
    }*/
    
    
}
