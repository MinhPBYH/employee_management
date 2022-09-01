/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.helper;

import java.awt.Color;
import java.util.regex.Matcher;
import javax.swing.JTextField;
import org.w3c.dom.css.RGBColor;
import java.util.regex.Pattern;
/**
 *
 * @author Admin
 */
public class Validator {
    public static boolean checkEmpty(JTextField text,StringBuilder sb,String message){
        boolean check = true;
        if(text.getText().equals("")){
            sb.append(message);
            text.setBackground(new Color(255,231,190));
            check = false;
        }else{
            text.setBackground(Color.WHITE);
        }
        return check;
    }
    public static boolean checkAge(JTextField textAge,StringBuilder sb){
        boolean check = true;
        if(!checkEmpty(textAge,sb,"Age input box is still empty. \n")){
            return false;
        }
        try {
            int age = Integer.parseInt(textAge.getText());
            if(age < 16 || age > 55){
                textAge.setBackground(new Color(255,231,190));
                sb.append("Invalid age!(16 to 55 years old). \n");
                return false;
            }else{
                textAge.setBackground(Color.WHITE);
            }
        } catch (Exception e) {
            sb.append("Error: ").append(e.getMessage());
        }
        return check;
    }
    public static boolean checkSalary(JTextField textSalary,StringBuilder sb){
        boolean check = true;
        if(!checkEmpty(textSalary,sb,"Salary input box is still empty. \n")){
            return false;
        }
        try {
            int salary = Integer.parseInt(textSalary.getText());
            if(salary < 5000000){
                textSalary.setBackground(new Color(255,231,190));
                sb.append("Invalid salary!(>5000000). \n");
                return false;
            }else{
                textSalary.setBackground(Color.WHITE);
            }
        } catch (Exception e) {
            sb.append("Error: ").append(e.getMessage());
        }
        return check;
    }
    public static boolean checkEmail(JTextField textEmail,StringBuilder sb){
        boolean check = true;
        if(!checkEmpty(textEmail,sb,"Email input box is still empty.\n")){
            return false;
        }
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(textEmail.getText());
        if(!matcher.find()){
            sb.append("Invalid email!! ").append("\n");
            textEmail.setBackground(new Color(255,231,190));
            check = false;
        }else{
            textEmail.setBackground(Color.WHITE);
        }
        return check;
    }
}
