package dev.hust.funnyfarm.display;

import java.awt.*;
import java.awt.event.*;

import dev.hust.funnyfarm.Game;

public class ControlWindow {

   private Frame mainFrame;
   private Panel controlPanel;
   Game game;

   public ControlWindow(Game g){
	  game = g;
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
      Button resetTimeSpeed = new Button("Time Speed Normal / Sim Mode");
      Button addTimeSpeed = new Button("++ Time Speed");
      Button subTimeSpeed = new Button("-- Time Speed");
      Button calculateFood = new Button("Calculate Food");
      
      resetTimeSpeed.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {     
            game.setTimeSpeed(game.DEFAULT_TIMESPEED);
            
            statusTextArea.setText(statusTextArea.getText() + "\n" +
         		   "Current Time Speed: " + game.getTimeSpeed()
         		   );
            
            
          }
       }); 

      addTimeSpeed.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
           game.setTimeSpeed(game.getTimeSpeed() + 10);
           
           statusTextArea.setText(statusTextArea.getText() + "\n" +
        		   "Current Time Speed: " + game.getTimeSpeed()
        		   );
           
           
         }
      }); 
      
      subTimeSpeed.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  if (game.getTimeSpeed() > 10) {
        		  game.setTimeSpeed(game.getTimeSpeed() - 10);
        		  
        		  statusTextArea.setText(statusTextArea.getText() + "\n" +
               		   "Current Time Speed: " + game.getTimeSpeed()
               		   );
        		 
        	  } else {
        		  statusTextArea.setText(statusTextArea.getText() + "\n" +
                  		   "Cannot decrease time speed anymore!"
                  		   );
        	  }
          }
      }); 

      controlPanel.add(statusTextArea);    
      controlPanel.add(addCreature);
      controlPanel.add(feedCreature);
      controlPanel.add(resetTimeSpeed);
      controlPanel.add(subTimeSpeed);
      controlPanel.add(addTimeSpeed);
      controlPanel.add(calculateFood);
      
      mainFrame.setVisible(false);  
   }
}