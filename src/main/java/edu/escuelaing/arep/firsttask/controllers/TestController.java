package edu.escuelaing.arep.firsttask.controllers;

import edu.escuelaing.arep.firsttask.models.TestModel;
import edu.escuelaing.arep.firsttask.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tests")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping()
    public ArrayList<TestModel> getTests() {
        return testService.getTests();
    }

    @PostMapping()
    public TestModel saveTest(@RequestBody TestModel test){
        return this.testService.saveTest(test);
    }

    @GetMapping(path="/{id}")
    public Optional<TestModel> getTestById(@PathVariable("id") Long id){
        return this.testService.getTestById(id);
    }

    @GetMapping("/query")
    public ArrayList<TestModel> getTestByParam1(@RequestParam("param1") String param1){
        return this.testService.getTestByParam1(param1);
    }

    @DeleteMapping("/{id}")
    public String deleteTestById(@PathVariable("id") Long id){
        boolean success = this.testService.deleteTest(id);

        if (success) {
            return "Deleted test with ID: " + id;
        } else {
            return "Something went wrong deleting the test with ID: " + id;
        }
    }

}
