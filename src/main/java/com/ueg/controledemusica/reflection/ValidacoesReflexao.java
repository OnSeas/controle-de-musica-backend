package com.ueg.controledemusica.reflection;

import com.ueg.controledemusica.anotation.DuracaoMin;
import com.ueg.controledemusica.exceptions.service.ServiceException;
import com.ueg.controledemusica.model.AbstractModel;

import java.lang.reflect.Field;

public class ValidacoesReflexao {
    public static void validarDuracao(AbstractModel model){
        Class<?> cls = model.getClass();
        for (Field field: cls.getDeclaredFields()){
            if(field.isAnnotationPresent(DuracaoMin.class)){ // iterando em todos os campos da cls procurando pela anotação
                DuracaoMin duracaoMin = field.getAnnotation(DuracaoMin.class); // Cria uma instancia da anotação e pega as informações da anotação utilizada na cls
                try{
                    field.setAccessible(true); // pq o atributo é privado
                    Integer duracao = (int) field.get(model); // pegar a duração do campo
                    if(duracao < duracaoMin.tempo()){
                        throw new ServiceException("O tempo da música não atingiu o tempo mínimo de " + duracaoMin.tempo() + "!");
                    }
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Duração Mínima validada!");
    }
}
