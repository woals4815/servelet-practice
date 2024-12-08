package net.javawebsurvelet;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class WebServerLauncher {
    public static void main(String[] args) {
        try {
            String webappDirLocation = "webapp/";
            Tomcat tomcat = new Tomcat();
            String port = System.getenv("PORT");
            if (port == null || port.isEmpty()) {
                port = "8080";
            }
            tomcat.setPort(Integer.parseInt(port));
            Connector connector = tomcat.getConnector();
            connector.setURIEncoding("UTF-8");
            tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
            System.out.println("configuring app with baseDir: " + new File(webappDirLocation).getAbsolutePath());
            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
