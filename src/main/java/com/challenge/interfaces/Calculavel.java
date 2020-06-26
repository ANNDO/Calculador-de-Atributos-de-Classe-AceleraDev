package com.challenge.interfaces;

import java.math.BigDecimal;
import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import javax.jws.Oneway;

public interface Calculavel {

    BigDecimal somar(Object anObject);
    BigDecimal subtrair(Object anObject);
    BigDecimal totalizar(Object anObject);
}
