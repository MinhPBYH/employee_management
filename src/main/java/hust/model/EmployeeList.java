/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.model;

import hust.helper.XFile;
import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class EmployeeList {

    private ArrayList<Employee> list = new ArrayList<>();
    private int currentIndex = 0;
    private String path = "C:/java file/HelloJavainVSCode/employeelist.dat";
    
    public void saveToFile()throws Exception{
        XFile.writeObject(path, list);
    }
    
    public void loadFromFile()throws Exception{
        File file = new File(path);
        if(file.exists()){
        list = (ArrayList<Employee>) XFile.readObject(path);
        }
       else{
            initEmpData();
        }
    }
    
    private void initEmpData(){
        list.add(new Employee("ID", "ExampleName", 20, "example@gmail.com", 5000000));
//        list.add(new Employee("13", "minh ta gud", 26, "minhcingf@gmail.com", 20000000));
//        list.add(new Employee("14", "minh ta beo", 50, "minhci@gmail.com", 7000000));
//        list.add(new Employee("15", "minh ta con", 29, "minhcingf@gmail.com", 5000000));
    }
    
    public int getCurrentIndex() {
        return currentIndex;
    }

    public EmployeeList() {
    }
    
    
    public void first(){
        if(currentIndex > 0){
            currentIndex = 0;
        }
    }
    
    public void previous(){
        if(currentIndex > 0){
            currentIndex--;
        }
    }
    
    public void next(){
        if(currentIndex < list.size() - 1){
            currentIndex++;
        }
    }
    
    public void last(){
        currentIndex = list.size() - 1;
    }
    
    public Employee getCurrentEmployee(){
        if(list.size() == 0){
            return null;
        }
        return list.get(currentIndex);
    }
    
    public void add(Employee employee) {
        list.add(employee);
    }
    
    public Employee getEmployeeByIndex(int index){
        if(index >= 0 && index <= list.size() ){
            currentIndex = index;
            return list.get(index);
        }
        return null;
    }
    
    public boolean update(Employee employee){
        Employee existedEmp = findById(employee.getId());
        
        if(existedEmp != null){
            existedEmp.setName(employee.getName());
            existedEmp.setAge(employee.getAge());
            existedEmp.setEmail(employee.getEmail());
            existedEmp.setSalary(employee.getSalary());
            return true;
        }
        return false;
    }
    
    public void renderToTable(DefaultTableModel tblModel){
        tblModel.setRowCount(0);// xóa dữ liệu đang hiển thị trên bảng
        for (Employee employee : list) {
            Object[]row = new Object[]{employee.getId(),employee.getName(),
                employee.getAge(),employee.getEmail(),employee.getSalary()};
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();//phương thức cập nhập dữ liệu lên bảng
    }
    
    public Employee findById(String id){
        for(Employee emp : list) {
            if(emp.getId().equals(id)){
                currentIndex = list.indexOf(emp);
                return emp;
            }
        }
        return null;
    }
    
    public boolean deleteById(String id){
        for(Employee emp: list){
            if(emp.getId().equals(id)){
                list.remove(emp);
                return true;
            }
        }
        return false;
    }
    
    public String getEmployeePossitionInForm(){
        return "record " + (currentIndex+1) + " of " +list.size();
    }    
}

