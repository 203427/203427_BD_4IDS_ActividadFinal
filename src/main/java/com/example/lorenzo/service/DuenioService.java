package com.example.lorenzo.service;

import com.example.lorenzo.modelo.Duenio;

import java.util.Optional;

public interface DuenioService  {


    public Iterable <Duenio>findAll();

    public Optional<Duenio> findById(Integer Id);

    public Duenio save(Duenio duenio);

    public void deletedById(Integer Id);
}
