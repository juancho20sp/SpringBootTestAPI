package edu.escuelaing.arep.firsttask.repositories;

import edu.escuelaing.arep.firsttask.models.TestModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TestRepository extends CrudRepository<TestModel, Long> {
    // Con poner el nombre de la variable del modelo, ya hace consultas
    public abstract ArrayList<TestModel> findByParam1(String param1);
}
