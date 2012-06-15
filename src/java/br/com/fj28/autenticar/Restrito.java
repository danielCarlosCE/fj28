/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fj28.autenticar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //a anotação vai ficar disponível em tempo de execucao
@Target(ElementType.METHOD) // anotação para métodos
public @interface Restrito {
    
}