package by.bsuir.poit.dsp.lab2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JPanel contentPolyh;
	private JPanel contentFilter;
	private JPanel basePanel;
	public JSlider slider;
	private JTabbedPane jtp;

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
		
		basePanel = new JPanel();
		
		content = new JPanel(new BorderLayout());
		content.add(formControlPanel() );
		contentPolyh = new JPanel(new BorderLayout());
		contentPolyh.add(formControlPanelPolyHarmonic());
		contentFilter = new JPanel(new BorderLayout());
		contentFilter.add(formControlFilter());
		basePanel.add(content);
		basePanel.add(contentPolyh);
		basePanel.add(contentFilter);
		setContentPane(basePanel);
		
	}

	private JPanel formControlPanel() {

		JPanel controlPanel;
		
		final JLabel label = new JLabel();
		
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

		chartPanel = createDemoPanel(null);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		basePanel.add(chartPanel);
		
		
         slider = new JSlider(1, 10, 1);
         slider.setMajorTickSpacing(1);
         slider.setPaintTicks(true);
         
		controlPanel = new JPanel(new FlowLayout());
		controlPanel.setPreferredSize(new Dimension(200, 200));
		basePanel.add(slider);
		controlPanel.add(button);
		controlPanel.add(button2);
		controlPanel.add(button3);
		controlPanel.add(button4);
		return controlPanel;
	}
	
	private JPanel formControlPanelPolyHarmonic() {

		JPanel controlPanel;
		
		
		final JButton button = new JButton("PolyHarmonic Signal");
		button.setActionCommand("polyhSignal");
		button.addActionListener(this);

		final JButton button3 = new JButton("Amplitude");
		button3.setActionCommand("polyhAmplitude");
		button3.addActionListener(this);

		final JButton button4 = new JButton("Phase");
		button4.setActionCommand("polyhPhase");
		button4.addActionListener(this);

         
		controlPanel = new JPanel(new FlowLayout());
		controlPanel.setPreferredSize(new Dimension(200, 200));
		controlPanel.add(button);
		controlPanel.add(button3);
		controlPanel.add(button4);
		return controlPanel;
	}
	
	
	private JPanel formControlFilter() {

		JPanel controlPanel;
		
		
		final JButton button = new JButton("Filter");
		button.setActionCommand("filter");
		button.addActionListener(this);

	

         
		controlPanel = new JPanel(new FlowLayout());
		controlPanel.setPreferredSize(new Dimension(200, 200));
		controlPanel.add(button);
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

		
		basePanel.remove(chartPanel);
		chartPanel = createDemoPanel(dataset);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		basePanel.add(chartPanel);
		setContentPane(basePanel);
		
	}

	private static JFreeChart createChart(XYDataset dataset) {

		return ChartFactory.createXYLineChart("Lab 2 DSP", "n", "x(n)", dataset, PlotOrientation.VERTICAL, true, true,
				false);
	}


	

}
