package dev.hust.funnyfarm.display;

import java.awt.*;
import java.awt.event.*;

public class ControlWindow {

   private Frame mainFrame;
   private Panel controlPanel;

   public ControlWindow(){
      prepareGUI();
   }
   
   private void prepareGUI(){
      mainFrame = new Frame("Control the Farm!");
      mainFrame.setSize(250,400);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);  
   }

   public void showControlWindow(){


      final TextArea statusTextArea = new TextArea("Welcome to FunnyFarm 1.0\n"
      		+ "by ICT K60 - HUST" ,10 ,30);

      Button addCreature = new Button("Add Creature");
      Button feedCreature = new Button("Feed");
      Button resetTimeSpeed = new Button("Reset Time Speed");
      Button setTimeSpeed = new Button("Set Time Speed");
      Button calculateFood = new Button("Calculate Food");

      addCreature.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
           
         }
      }); 

      controlPanel.add(statusTextArea);    
      controlPanel.add(addCreature);
      controlPanel.add(feedCreature);
      controlPanel.add(resetTimeSpeed);
      controlPanel.add(setTimeSpeed);
      controlPanel.add(calculateFood);
      
      mainFrame.setVisible(true);  
   }
}