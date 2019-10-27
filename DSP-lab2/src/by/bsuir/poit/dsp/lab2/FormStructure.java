package by.bsuir.poit.dsp.lab2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import by.bsuir.poit.dsp.lab2.datasets.Amplitude;
import by.bsuir.poit.dsp.lab2.datasets.DatasetXY;
import by.bsuir.poit.dsp.lab2.datasets.Filter;
import by.bsuir.poit.dsp.lab2.datasets.Phase;
import by.bsuir.poit.dsp.lab2.datasets.PolyhAmplitude;
import by.bsuir.poit.dsp.lab2.datasets.PolyhPhase;
import by.bsuir.poit.dsp.lab2.datasets.PolyhSignalValue;
import by.bsuir.poit.dsp.lab2.datasets.RestoredSignal;
import by.bsuir.poit.dsp.lab2.datasets.SignalValues;

public class FormStructure extends ApplicationFrame implements ActionListener{

	private ChartPanel chartPanel;	
	private JPanel content;
	private JPanel basePanel;
	public JSlider slider;

	private Map<String, DatasetXY> buttonListners;

	public FormStructure(String title) {
		super(title);
		initUI();
	}

	private void initUI() {

		
		buttonListners = new HashMap<>();
		buttonListners.put("task1", new SignalValues());
		buttonListners.put("task2", new RestoredSignal());
		buttonListners.put("task3", new Amplitude());
		buttonListners.put("phase", new Phase());
		buttonListners.put("polyhSignal", new PolyhSignalValue());
		buttonListners.put("polyhAmplitude", new PolyhAmplitude());
		buttonListners.put("polyhPhase", new PolyhPhase());
		buttonListners.put("filter", new Filter());
		
		content = new JPanel(new BorderLayout());
		
		     slider = new JSlider(1, 10, 1);
	         slider.setMajorTickSpacing(1);
	         slider.setPaintTicks(true);
	         
			basePanel = new JPanel(new FlowLayout());
			basePanel.setPreferredSize(new Dimension(200, 100));
			basePanel.add(slider);
			
		content.add(basePanel, BorderLayout.SOUTH);
		content.add(formControlPanel(), BorderLayout.AFTER_LINE_ENDS );
	
		setContentPane(content);
		
	}

	private JPanel formControlPanel() {

		JPanel controlPanel;
		
		
		
		final JButton button = new JButton("Signal");
		button.setActionCommand("task1");
		button.addActionListener(this);

		final JButton button2 = new JButton("Restored signal");
		button2.setActionCommand("task2");
		button2.addActionListener(this);

		final JButton button3 = new JButton("Amplitude");
		button3.setActionCommand("task3");
		button3.addActionListener(this);

		final JButton button4 = new JButton("Phase");
		button4.setActionCommand("phase");
		button4.addActionListener(this);
		
		final JButton buttonFilter = new JButton("Filter");
		buttonFilter.setActionCommand("filter");
		buttonFilter.addActionListener(this);
		
		final JButton buttonPolyhSignal = new JButton("Polyharmonic Signal");
		buttonPolyhSignal.setActionCommand("polyhSignal");
		buttonPolyhSignal.addActionListener(this);

		final JButton buttonPolyhAmpl = new JButton("Polyharmonic Amplitude");
		buttonPolyhAmpl.setActionCommand("polyhAmplitude");
		buttonPolyhAmpl.addActionListener(this);

		final JButton buttonPolyhPhase = new JButton("Polyharmonic Phase");
		buttonPolyhPhase.setActionCommand("polyhPhase");
		buttonPolyhPhase.addActionListener(this);

		chartPanel = createDemoPanel(null);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	    content.add(chartPanel);
		
		
		controlPanel = new JPanel( new GridLayout(0,2));
		controlPanel.setPreferredSize(new Dimension(300, 100));

		controlPanel.add(buttonPolyhSignal);
		
		controlPanel.add(button);
		controlPanel.add(buttonPolyhAmpl);
		
		controlPanel.add(button4);
		controlPanel.add(buttonFilter);
		
		controlPanel.add(button3);
		controlPanel.add(buttonPolyhPhase);
		controlPanel.add(button2);
	
		return controlPanel;
	}
	
	public static ChartPanel createDemoPanel(XYDataset dataset) {
		JFreeChart chart = createChart(dataset);
		return new ChartPanel(chart);
	}

	public static void main(final String[] args) {

		final FormStructure demo = new FormStructure("Lab 2");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
		
		 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		buttonListners.keySet().stream().filter(a -> e.getActionCommand().equals(a))
				.forEach(a -> repaintChart(buttonListners.get(a).createDataset(slider.getValue())));
	}

	private void repaintChart(XYDataset dataset) {

		
		content.remove(chartPanel);
		chartPanel = createDemoPanel(dataset);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		content.add(chartPanel);
		setContentPane(content);
		
	}

	private static JFreeChart createChart(XYDataset dataset) {

		return ChartFactory.createXYLineChart("Lab 2 DSP", "n", "x(n)", dataset, PlotOrientation.VERTICAL, true, true,
				false);
	}


	

}
