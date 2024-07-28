package com.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import uk.autores.Messages;
import uk.autores.Texts;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;

@Messages("i18n.properties")
public class Hello {
    public static void main( String[] args ) throws IOException {
//        URLClassLoader classLoader = (URLClassLoader) Hello.class.getClassLoader();
//        StringBuilder classpath = new StringBuilder();
//        for (URL url : classLoader.getURLs()) {
//            classpath.append(url.getPath()).append(File.pathSeparator);
//        }
//        System.setProperty("java.class.path", classpath.toString());

        org.openjdk.jmh.Main.main(args);
    }

    private static final Locale[] LOCALES = {
            Locale.ROOT,
            Locale.ENGLISH,
            Locale.FRENCH,
            Locale.ITALIAN,
            Locale.GERMAN,
    };

    @Benchmark
    public void method(Blackhole blackhole) {
        for (Locale l : LOCALES) {

        }
    }

    @Benchmark
    public void bundle() {
        // Do nothing
    }
}
