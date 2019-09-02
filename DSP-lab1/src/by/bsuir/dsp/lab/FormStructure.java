package by.bsuir.dsp.lab;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;



public class FormStructure {
			
			   private JFrame mainFrame;
			   private Container container;
			   private JPanel controlPanel;
		
			public FormStructure() {
				initUI();
			}
			
		 private void initUI() {
		     
		 	  mainFrame = new JFrame("Java SWING Examples");
		       mainFrame.setSize(900,900);
		       container = mainFrame.getContentPane();
		       
		      // mainFrame.setLayout(new GridLayout(3, 1));
		
//		       headerLabel = new JLabel("",JLabel.LEFT );
//		       statusLabel = new JLabel("",JLabel.LEFT);        
//		       statusLabel.setSize(50,50);
		       
		        
		       controlPanel = new JPanel();
		       
		
		    //   mainFrame.add(headerLabel);
		       mainFrame.add(controlPanel);
		  //     mainFrame.add(statusLabel);
		       mainFrame.setVisible(true); 
		 }
		
		 public static void main(String[] args) {     
		
			 FormStructure ex = new FormStructure();
		         ex.showEventDemo();
		    
		 }
		 
		 private void showEventDemo(){
		   //  headerLabel.setText("Control in action: Button"); 
		
		     JButton okButton = new JButton("Задаём fi");
		     container.add(okButton, BorderLayout.CENTER);
		     okButton.setActionCommand("func1_1");
		    
		
		     okButton.addActionListener(new ButtonClickListener()); 
		     
		
		     controlPanel.add(okButton);
		
		     mainFrame.setVisible(true);  
		  }
		 
		 
			 private class ButtonClickListener implements ActionListener{
			     public void actionPerformed(ActionEvent e) {
			        
			            container.add(StartCharting.paint(),  BorderLayout.CENTER);
			        
			      	
			   }
			}
}
