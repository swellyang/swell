package com.swell.code.business.dao;

import org.springframework.stereotype.Service;

@Service
public class Baoma implements Car{

    @Override
    public String getName() {
        return "this is baoma";
    }
}
