package com.example.retry;

import org.springframework.stereotype.Service;

@Service
public class Servicio {

    public String metodo(String evaluacion, int conteo){

        if (conteo < 3) {

            System.out.println("----------------- error -----------------");
            throw new RuntimeException("Exeption");
        } else {
            return "evaluacion: " + evaluacion;
        }
    }

}
