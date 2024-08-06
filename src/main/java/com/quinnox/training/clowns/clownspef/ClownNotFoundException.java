package com.quinnox.training.clowns.clownspef;


@SuppressWarnings("serial")
public class ClownNotFoundException extends RuntimeException{
    ClownNotFoundException(Long id) {
        super("Could not find clown " + id);
    }
}
