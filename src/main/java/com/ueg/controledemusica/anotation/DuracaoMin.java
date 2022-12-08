package com.ueg.controledemusica.anotation;

import com.ueg.controledemusica.reflection.ValidacoesReflexao;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// Anotação para delimitar o valor minimo da duração

@Retention(RUNTIME)
@Target(FIELD)
public @interface DuracaoMin {
    int tempo() default 0;
}
