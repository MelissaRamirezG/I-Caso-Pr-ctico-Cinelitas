/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cinelitas.service;


import Cinelitas.entity.Sala;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Cinelitas.repository.SalaRepository;

/**
 *
 * @author User
 */
@Service
public class SalaService implements ISalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<Sala> buscartodos() {
        return (List<Sala>) salaRepository.findAll();
    }
}
