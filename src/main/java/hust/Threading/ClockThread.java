/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.Threading;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;


/**
 *
 * @author Admin
 */
public class ClockThread extends Thread{
    private JLabel clock;
    
    public JLabel getClock() {
        return clock;
    }

    public ClockThread(JLabel clock) {
        this.clock = clock;
    }
    
    
    
    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aaa");
        while(true){
            Date date = new Date();
            String strClock = sdf.format(date);
            clock.setText(strClock);
            clock.setForeground(new Color(128,128,128));
            clock.setFont(new java.awt.Font("Tahoma", 1,16));
            try {
                sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
