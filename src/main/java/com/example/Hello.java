package com.example;

import uk.autores.Texts;

@Texts("world.txt")
public class Hello {
    public static void main( String[] args ) {
        // Uses package name for generated class if not set explicitly
        String value = Example.world();
        System.out.println("Hello " + value);
    }
}
