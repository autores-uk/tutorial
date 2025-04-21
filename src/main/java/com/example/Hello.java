package com.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import uk.autores.Messages;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

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
            String s = I18N.iso80000Defines(l, "GB", 1024*1024*1024);
            blackhole.consume(s);
        }
    }

    @Benchmark
    public void bundle(Blackhole blackhole) {
        for (Locale l : LOCALES) {
            ResourceBundle bundle = ResourceBundle.getBundle("com.example.i18n", l);
            String template = bundle.getString("iso-80000-defines");
            MessageFormat m = new MessageFormat(template, l);
            String s = m.format(new Object[]{"GB", 1024*1024*1024});
            blackhole.consume(s);
        }
    }
}
