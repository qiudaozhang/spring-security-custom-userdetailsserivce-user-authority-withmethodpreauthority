package com.example.demo.commom.exceptions;

/**
 * @author 邱道长
 * 2020/12/30
 */
public class EntityNotExistsException extends RuntimeException {

    public EntityNotExistsException(String message) {
        super(message + "Entity Not Exists!");
    }
}
