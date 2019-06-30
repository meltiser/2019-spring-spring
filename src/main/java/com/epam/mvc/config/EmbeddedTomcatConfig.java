package com.epam.mvc.config;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;

public class EmbeddedTomcatConfig {
    private static final int PORT = getPort();

    public static void run() {
        try {
            String appBase = ".";
            Tomcat tomcat = new Tomcat();
            tomcat.setBaseDir(createTempDir());
            tomcat.setPort(PORT);
            tomcat.getHost().setAppBase(appBase);
            tomcat.addWebapp("", ".");
            tomcat.start();
            tomcat.getServer().await();
        } catch (ServletException | LifecycleException e) {
            throw new RuntimeException("Cannot run embedded tomcat");
        }
    }

    private static int getPort() {
        String port = System.getenv("PORT");
        if (port != null) {
            return Integer.valueOf(port);
        }
        return 8080;
    }

    private static String createTempDir() {
        try {
            File tempDir = File.createTempFile("tomcat.", "." + PORT);
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir.getAbsolutePath();
        } catch (IOException ex) {
            throw new RuntimeException(
                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"),
                    ex
            );
        }
    }
}
