package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MurielService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("super strength");
        skills.add("fly");
        skills.add("telekinesis");
        skills.add("teleportation");
        return skills;
    }
}
