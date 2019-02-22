package com.swell.code.business.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class Aodi implements Car{

    @Override
    public String getName() {
        return "this is aodi";
    }
}
