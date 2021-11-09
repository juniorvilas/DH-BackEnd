package com.example.trainerdh.service;


import com.example.trainerdh.domain.Trainer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    @Override
    public List<Trainer> listTrainer(){
        return Arrays.asList(
                new Trainer("Simone"),
                new Trainer("Carla"),
                new Trainer("Jessica")
        );
    }

}
