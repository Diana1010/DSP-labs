package by.bsuir.dsp.lab;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class FormStructure extends ApplicationFrame implements ActionListener {

	private JFrame mainFrame;
	private Container container;
	private JPanel controlPanel;
	private TimeSeries series;
	private double lastValue = 100.0;
	private ChartPanel chartPanel;
	private JPanel content;

	public FormStructure(String title) {
		super(title);
		initUI();
	}

	private void initUI() {

		// chartPanel = StartCharting.paint();
		final JButton button = new JButton("Add New Data Item");
		button.setActionCommand("ADD_DATA");
		button.addActionListener(this);

		final JButton button2 = new JButton("Next graph");
		button2.setActionCommand("NEXT");
		button2.addActionListener(this);

		content = new JPanel(new BorderLayout());
		chartPanel = createDemoPanel(StartCharting.createDataset());
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		content.add(chartPanel);
		controlPanel = new JPanel(new FlowLayout());
		controlPanel.add(button);
		controlPanel.add(button2);
		content.add(controlPanel, BorderLayout.SOUTH);

		setContentPane(content);

	}

	public static ChartPanel createDemoPanel(XYDataset dataset) {
		JFreeChart chart = StartCharting.paint(dataset);
		return new ChartPanel(chart);
	}

	/**
	 * Handles a click on the button by adding new (random) data.
	 *
	 * @param e the action event.
	 */
	public void actionPerformed(final ActionEvent e) {
		if (e.getActionCommand().equals("ADD_DATA")) {
			content.remove(chartPanel);
			content.add(createDemoPanel(createDataset2()));
			setContentPane(content);
		}
	}

	private XYDataset createDataset2() {
		final XYSeries firefox = new XYSeries("Firefox");
		firefox.add(1.0, 1.0);
		firefox.add(2.0, 4.0);
		firefox.add(3.0, 3.0);

		final XYSeries chrome = new XYSeries("Chrome");
		chrome.add(1.0, 4.0);
		chrome.add(2.0, 5.0);
		chrome.add(3.0, 6.0);

		final XYSeries iexplorer = new XYSeries("InternetExplorer");
		iexplorer.add(3.0, 4.0);
		iexplorer.add(4.0, 5.0);
		iexplorer.add(5.0, 4.0);

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(firefox);
		dataset.addSeries(chrome);
		dataset.addSeries(iexplorer);
		return dataset;
	}

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args ignored.
	 */
	public static void main(final String[] args) {

		final FormStructure demo = new FormStructure("Dynamic Data Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}
