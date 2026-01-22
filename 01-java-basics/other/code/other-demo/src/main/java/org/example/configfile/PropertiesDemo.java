package org.example.configfile;


import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/*
 * xml 更加灵活，并且强大，支持较为复杂的配置
 * properties 简单便捷，适合简单的应用配置
 * */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        //read();

        write();
    }

    public static void read() throws IOException {
        FileInputStream in = new FileInputStream("src/1.properties");
        Properties properties = new Properties();
        properties.load(in);

        Iterator<String> iterator = properties.stringPropertyNames().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ": " + properties.getProperty(key));
        }
        in.close();
    }

    public static void write() throws IOException {
        Properties properties = new Properties();

        FileOutputStream out = new FileOutputStream(new File("src/1.properties"), true);
        properties.setProperty("k2", "v2");
        properties.setProperty("k3", "v3");

        properties.store(out, "保存的文件");
        out.close();
    }
}
