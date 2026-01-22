package org.example.upload.listener;


import org.example.upload.util.FileUtils;
import org.example.upload.util.UploadUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

@WebListener
public class FileUploadListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public FileUploadListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */

        InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties");

        Properties properties = new Properties();
        try {
            properties.load(in);

            for (Map.Entry<Object, Object> prop : properties.entrySet()) {
                String propertyName = (String) prop.getKey();
                String propertyValue = (String) prop.getValue();
                UploadUtils.getMap().put(propertyName, propertyValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
