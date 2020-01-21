package com.example.retry;

import org.springframework.stereotype.Service;

@Service
public class Servicio {

    public String metodo(String evaluacion){

        if (evaluacion.equals("error")) {

            System.out.println("----------------- error -----------------");
            throw new RuntimeException("Exeption");
        } else {
            return "Paso Ok";
        }
    }

}
