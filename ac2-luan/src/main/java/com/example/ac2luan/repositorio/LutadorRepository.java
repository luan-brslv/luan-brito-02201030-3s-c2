package com.example.ac2luan.repositorio;

import com.example.ac2luan.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {

    List<Lutador> findAll();

    List<Lutador> countByVidaGreaterThan(double n);


    List<Lutador> findByVivoFalse();


}
