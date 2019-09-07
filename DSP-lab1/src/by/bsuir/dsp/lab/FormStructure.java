package by.bsuir.dsp.lab;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;



public class FormStructure extends ApplicationFrame implements ActionListener {
			
			   private JFrame mainFrame;
			   private Container container;
			   private JPanel controlPanel;
			   private TimeSeries series;  
			   private double lastValue = 100.0;
		
			public FormStructure(String title) {
				super(title);
				initUI();
			}
			
		 private void initUI() {

		        final ChartPanel chartPanel = StartCharting.paint();
		        final JButton button = new JButton("Add New Data Item");
		        button.setActionCommand("ADD_DATA");
		        button.addActionListener(this);

		        final JPanel content = new JPanel(new BorderLayout());
		        content.add(chartPanel);
		        content.add(button, BorderLayout.SOUTH);
		        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		        setContentPane(content);
			 
		 }
		
    
		   
		    /**
		     * Handles a click on the button by adding new (random) data.
		     *
		     * @param e  the action event.
		     */
		    public void actionPerformed(final ActionEvent e) {
		        if (e.getActionCommand().equals("ADD_DATA")) {
		            final double factor = 0.90 + 0.2 * Math.random();
		            this.lastValue = this.lastValue * factor;
		            final Millisecond now = new Millisecond();
		            System.out.println("Now = " + now.toString());
		            this.series.add(new Millisecond(), this.lastValue);
		        }
		    }

		    /**
		     * Starting point for the demonstration application.
		     *
		     * @param args  ignored.
		     */
		    public static void main(final String[] args) {

		        final FormStructure demo = new FormStructure("Dynamic Data Demo");
		        demo.pack();
		        RefineryUtilities.centerFrameOnScreen(demo);
		        demo.setVisible(true);

		    }

		 
		 
}
