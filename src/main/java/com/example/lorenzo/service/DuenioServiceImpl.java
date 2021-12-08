package com.example.lorenzo.service;

import com.example.lorenzo.Repositorio.DuenioRepositorio;
import com.example.lorenzo.modelo.Duenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DuenioServiceImpl implements DuenioService {

    @Autowired
    private DuenioRepositorio duenioRepositorio;

    @Override
    public Iterable<Duenio> findAll() {
        return duenioRepositorio.findAll();
    }

    @Override
    public Optional<Duenio> findById(Integer Id) {
        return duenioRepositorio.findById(Id);
    }

    @Override
    public Duenio save(Duenio duenio) {
        return duenioRepositorio.save(duenio);
    }

    @Override
    public void deletedById(Integer Id) {
    duenioRepositorio.deleteById(Id);

    }
}
