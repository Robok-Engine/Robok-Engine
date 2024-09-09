package org.gampiot.robok.feature.editor.languages.java.models;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodOrField {
    
    public String result;
    public Field field;
    public Method method;
    
    public MethodOrField(String result, Field field){
        this.result = result;
        this.field = field;
    }
    
    public MethodOrField(String result, Method method){
        this.result = result;
        this.method = method;
    }
    
    public Field getField(){
        return this.field;
    }
    
    public Method getMethod(){
        return this.method;
    }
}

