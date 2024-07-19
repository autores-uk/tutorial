package com.example;

import uk.autores.Texts;

@Texts("world.txt")
public class Hello {
    public static void main( String[] args ) {
        System.out.println("Hello " + World.text());
    }
}
