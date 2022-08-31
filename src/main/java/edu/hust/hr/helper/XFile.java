/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.hust.hr.helper;

import edu.hust.hr.model.Employee;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class XFile {    
    public static Object readObject(String path) throws Exception{
        try (
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ){
            Object obj = ois.readObject();
            ois.close();
            fis.close();
            return obj;
        }
    }
    
    public static void writeObject(String path,Object obj) throws Exception{
        try (
                FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ){
            oos.writeObject(obj);
            oos.close();
            fos.close();
        }
    }

    public static ArrayList<Employee> readObject(String path, ArrayList<Employee> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
