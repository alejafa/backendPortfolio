/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.alejandroPortfolio.Repository;

import com.portfolio.alejandroPortfolio.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByTituloEx(String tituloEx);
    public boolean existsByTituloEx(String tituloEx);
}
