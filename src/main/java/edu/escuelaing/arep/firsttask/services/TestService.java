package edu.escuelaing.arep.firsttask.services;

import edu.escuelaing.arep.firsttask.models.TestModel;
import edu.escuelaing.arep.firsttask.repositories.TestRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public ArrayList<TestModel> getTests() {
        return (ArrayList<TestModel>) testRepository.findAll();
    }

    public TestModel saveTest(TestModel test){
        return testRepository.save(test);
    }

    public Optional<TestModel> getTestById(Long id){
        return testRepository.findById(id);
    }

    public ArrayList<TestModel> getTestByParam1(String param1){
        return testRepository.findByParam1(param1);
    }

    public boolean deleteTest(Long id){
        try {
            testRepository.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }
}
