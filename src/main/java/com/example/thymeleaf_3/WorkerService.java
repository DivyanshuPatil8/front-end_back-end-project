package com.example.thymeleaf_3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository wrp;

    public List<Worker> getAllWorker()
    {
        return wrp.findAll();
    }
    public void save(Worker worker)
    {
        wrp.save(worker);
    }
    public  Worker getById(Long id)
    {
         Optional<Worker> optional= wrp.findById(id);
         Worker worker=null;
         if(optional.isPresent())
         worker = optional.get();
         else
           throw new RuntimeException(
            "Worker not found for id:" +id);
           return worker;
    }
    public void deleteViaId(long id)
    {
        wrp.deleteById(id);
    }
}
