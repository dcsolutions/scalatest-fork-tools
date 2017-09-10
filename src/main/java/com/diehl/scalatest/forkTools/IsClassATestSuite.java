package com.diehl.scalatest.forkTools;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Test if a given fully qualified class name is an instance of org.scalatest.Suite.
 */
public class IsClassATestSuite {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Expected exactly two arguments.");
            System.exit(1);
        }
        String classLoaderDirectory = args[0];
        String fullyQualifiedClassName = args[1];

        try {
            URL url = new URL("file://" + classLoaderDirectory);
            URL[] urls = {url};
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class<?> cls = classLoader.loadClass(fullyQualifiedClassName);
            if (org.scalatest.Suite.class.isAssignableFrom(cls)) {
                System.exit(0);
            } else {
                System.exit(2);
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
            System.exit(3);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
            System.exit(4);
        }
    }

}
