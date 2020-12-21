package com.example.demo.Service;

import com.example.demo.Model.Supervisor;
import org.springframework.data.repository.CrudRepository;

public interface SupervisorService extends CrudRepository<Supervisor, Long> {
}
