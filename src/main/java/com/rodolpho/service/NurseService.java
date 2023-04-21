package com.rodolpho.service;

import com.rodolpho.payload.NurseDto;

public interface NurseService {
    
    //recebe um DTO de req e envia um DTO de res
    NurseDto createNurse(NurseDto nurseDto);
}
