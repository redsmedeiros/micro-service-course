package com.rodolpho.service.impl;

import org.springframework.stereotype.Service;

import com.rodolpho.entity.Nurse;
import com.rodolpho.payload.NurseDto;
import com.rodolpho.repository.NurseRepository;
import com.rodolpho.service.NurseService;

@Service
public class NurseServiceImpl implements NurseService {

    private NurseRepository nurseRepository;

    public NurseServiceImpl(NurseRepository nurseRepository){

        this.nurseRepository = nurseRepository;
    }

    @Override
    public NurseDto createNurse(NurseDto nurseDto) {

        Nurse nurse = new Nurse();

        nurse.setId(nurseDto.getId());
        nurse.setName(nurseDto.getName());
        nurse.setEmail(nurseDto.getEmail());
        nurse.setDescription(nurseDto.getDescription());
        nurse.setPhone(nurseDto.getPhone());
        nurse.setGender(nurseDto.getGender());
        nurse.setCity(nurseDto.getCity());
        nurse.setAge(nurseDto.getAge());
        nurse.setGraduation(nurseDto.getGraduation());
        nurse.setExperienceYears(nurseDto.getExperienceYears());

        Nurse newNurse = nurseRepository.save(nurse);

        NurseDto nurseResponse = new NurseDto();

        nurseResponse.setId(newNurse.getId());
        nurseResponse.setName(newNurse.getName());
        nurseResponse.setEmail(newNurse.getEmail());
        nurseResponse.setDescription(newNurse.getDescription());
        nurseResponse.setPhone(newNurse.getPhone());
        nurseResponse.setGender(newNurse.getGender());
        nurseResponse.setCity(newNurse.getCity());
        nurseResponse.setAge(newNurse.getAge());
        nurseResponse.setGraduation(newNurse.getGraduation());
        nurseResponse.setExperienceYears(newNurse.getExperienceYears());

        
        return nurseResponse;
    }
    
}
