package com.challenge.desafio;

import com.challenge.interfaces.Calculavel;

import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.Class;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

public class CalculadorDeClasses implements Calculavel {

    public BigDecimal somar(Object anObject) {
        Class className = anObject.getClass();
        Field[] classFields =  className.getDeclaredFields();// array com os fields presentes no objeto
        BigDecimal countSoma = BigDecimal.ZERO;
        for ( Field f:classFields){// iteração sobre cada field presente no objeto
            f.setAccessible(true);
            if (f.getType().equals(BigDecimal.class) && (f.getAnnotation(Somar.class))!=null){//field deve ser do tipo BigDecila e ter annotation @Somar
                try {
                    countSoma = countSoma.add((BigDecimal) f.get(anObject));// adição dos valores BigDecimal
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return countSoma;
    }


    public BigDecimal subtrair(Object anObject)  {
        Class className = anObject.getClass();
        Field[] classFields =  className.getDeclaredFields();// array com os fields presentes no objeto
        BigDecimal countSubtrai = BigDecimal.ZERO;
        for ( Field f:classFields){// iteração sobre cada field presente no objeto
            f.setAccessible(true);
            if (f.getType().equals(BigDecimal.class) && (f.getAnnotation(Subtrair.class))!=null){//field deve ser do tipo BigDecila e ter annotation @Subtrair
                try {
                    countSubtrai = countSubtrai.add(((BigDecimal) f.get(anObject)));// adição dos valores BigDecimal
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        return countSubtrai;

    }

    public BigDecimal totalizar(Object anObject) {
        return somar(anObject).subtract(subtrair(anObject));
    }
}
