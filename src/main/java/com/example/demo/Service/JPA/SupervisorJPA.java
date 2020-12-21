package com.example.demo.Service.JPA;

import com.example.demo.Model.Supervisor;
import com.example.demo.Service.SupervisorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupervisorJPA implements SupervisorService {
    @Override
    public <S extends Supervisor> S save(S s) {
        return null;
    }

    @Override
    public <S extends Supervisor> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Supervisor> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Supervisor> findAll() {
        return null;
    }

    @Override
    public Iterable<Supervisor> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Supervisor supervisor) {

    }

    @Override
    public void deleteAll(Iterable<? extends Supervisor> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
