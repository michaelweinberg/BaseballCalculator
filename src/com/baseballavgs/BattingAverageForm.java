package com.baseballavgs;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BattingAverageForm extends BaseballAverageCalc {
 
//declare app objects	
JFrame frame;
 JPanel panel1;
 JPanel borderPanel;
 JPanel buttonPanel;
 JLabel label1;
 JLabel label2;
 JLabel label3;
 JLabel label4;
 JLabel label5;
 JTextField textName1;
 JTextField textName2;
 JTextField textName3;
 JButton button;
 JButton exitButton;
 private Double hits;
 private Double atbats;
 private Double walks;
 
 public BattingAverageForm(){
  
  createFrame();
  
 }
 
 //create frame windows
 private void createFrame(){
  frame = new JFrame();
  frame.setBounds(100, 100, 400, 200);
  frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
  frame.add(createBorderPanel());
  frame.setVisible(true);
 }
 
 //create border panel
 private JPanel createBorderPanel(){
  borderPanel= new JPanel();
  borderPanel.setLayout(new BorderLayout());
  borderPanel.add(createPanel(), BorderLayout.NORTH);
  borderPanel.add(createButtonPanel(), BorderLayout.SOUTH);
  return borderPanel;
  
 }
 
 //create buttons
 private JPanel createButtonPanel(){
  buttonPanel = new JPanel();
  buttonPanel.setLayout(new FlowLayout());
  button = new JButton("Click");
  button.addActionListener(new ButtonListener());
  exitButton = new JButton("Exit");
  exitButton.addActionListener(new ExitListener());
  buttonPanel.add(button);
  buttonPanel.add(exitButton);
  return buttonPanel;
 }
 
 //create labels and textfields and add them to the JPanel
 private JPanel createPanel(){
  panel1=new JPanel();
  panel1.setLayout(new GridLayout(4,1));
  label1 = new JLabel("Enter Your hits");
  textName1=new JTextField(25);
  label2 = new JLabel("Enter Your atbats");
  textName2=new JTextField(25);
  label3 = new JLabel("Enter Your walks");
  textName3=new JTextField(25);
  
  
  label4=new JLabel();
  label5=new JLabel();
  panel1.add(label1);
  panel1.add(textName1);
  panel1.add(label3);
  panel1.add(textName3);
  panel1.add(label2);
  panel1.add(textName2);
  
  panel1.add(label4);
  panel1.add(label5);
  
  return panel1;
 }
 
 //call the BaseballAverageCalc class 
 private class ButtonListener implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent e) {
	  NumberFormat nf= NumberFormat.getInstance();
	  nf.setMaximumFractionDigits(3);
	  nf.setMinimumFractionDigits(3);
	  nf.setRoundingMode(RoundingMode.HALF_UP);

	 
	  double hits = Double.parseDouble(textName1.getText());
	  double atbats = Double.parseDouble(textName2.getText());
	  double walks = Double.parseDouble(textName3.getText());
	  calculateBA(hits, atbats);
	  calculateOBA(hits, atbats, walks);
   label4.setText("Batting Average: " + nf.format(battingAvg));
   label5.setText("On Base Average: " + nf.format(onbaseAvg));
   
  }
  
 }
 
 private class ExitListener implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent e) {
   System.exit(0);
   
  }
  
 }

}

