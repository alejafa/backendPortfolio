/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Security.Controller;

import com.portfolio.alejandroPortfolio.Security.Dto.LoginUsuario;
import com.portfolio.alejandroPortfolio.Security.Dto.NuevoUsuario;
import com.portfolio.alejandroPortfolio.Security.Entity.Rol;
import com.portfolio.alejandroPortfolio.Security.Entity.Usuario;
import com.portfolio.alejandroPortfolio.Security.Enums.RolPerfil;
import com.portfolio.alejandroPortfolio.Security.Service.RolService;
import com.portfolio.alejandroPortfolio.Security.Service.UsuarioService;
import com.portfolio.alejandroPortfolio.Security.jwt.JwtProvider;
import jakarta.validation.Valid;
import java.util.HashSet;
//import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.alejandroPortfolio.Security.Dto.JwtDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*",methods={RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;    
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Campos invalidos o email invalido"),HttpStatus.BAD_REQUEST);
        }
        
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity(new Mensaje("Ese nombre de usaurio no existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity(new Mensaje("Este email ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));                
        
        Set<Rol> roles = new HashSet<>();
        
        roles.add(rolService.getByRolPerfil(RolPerfil.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin")){
            roles.add(rolService.getByRolPerfil(RolPerfil.ROLE_ADMIN).get());
        }
        
        usuario.setRoles(roles);
        usuarioService.save(usuario);
           
        return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Campos invalidados"), HttpStatus.BAD_REQUEST);
        }
        
        UsernamePasswordAuthenticationToken  UpaToken =  new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword());        
                
        Authentication authentication = authenticationManager.authenticate(UpaToken);                
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        System.out.println(jwt);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();        
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(),userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody NuevoUsuario newUsuario, BindingResult bindingResult){

        if(!usuarioService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(usuarioService.existsByNombreUsuario(newUsuario.getNombreUsuario()) && usuarioService.getByNombreUsuario(newUsuario.getNombreUsuario()).get().getId()!= id){
             return new ResponseEntity(new Mensaje("Ese nombre usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(newUsuario.getApellido())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Usuario usuario = usuarioService.getOne(id).get();
        
        usuario.setApellido(newUsuario.getApellido());
        usuario.setDescripcion(newUsuario.getDescripcion());
        usuario.setProfesion(newUsuario.getProfesion());
        usuario.setImagen(newUsuario.getImagen());
        
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Registro usuario actualizado"), HttpStatus.OK);
        
        
    }   
}
