package by.bsuir.dsp.lab;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class FormStructure extends ApplicationFrame implements ActionListener {

	private ChartPanel chartPanel;
	private JPanel content;

	private Map<String, DatasetXY> buttonListners;

	public FormStructure(String title) {
		super(title);
		initUI();
	}

	private void initUI() {

		buttonListners = new HashMap<>();
		buttonListners.put("task1", new Part1Task1());
		buttonListners.put("task2", new Part1Task2());

		content = new JPanel(new BorderLayout());
		content.add(formControlPanel(), BorderLayout.SOUTH);
		setContentPane(content);
	}

	private JPanel formControlPanel() {

		JPanel controlPanel;

		final JButton button = new JButton("Variable fi");
		button.setActionCommand("task1");
		button.addActionListener(this);

		final JButton button2 = new JButton("Variable f");
		button2.setActionCommand("task2");
		button2.addActionListener(this);

		chartPanel = createDemoPanel(null);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		content.add(chartPanel);

		controlPanel = new JPanel(new FlowLayout());
		controlPanel.add(button);
		controlPanel.add(button2);
		return controlPanel;
	}

	public static ChartPanel createDemoPanel(XYDataset dataset) {
		JFreeChart chart = createChart(dataset);
		return new ChartPanel(chart);
	}

	public static void main(final String[] args) {

		final FormStructure demo = new FormStructure("Lab 1");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		buttonListners.keySet().stream().filter(a -> e.getActionCommand().equals(a))
				.forEach(a -> repaintChart(buttonListners.get(a).createDataset()));
	}

	private void repaintChart(XYDataset dataset) {

		content.remove(chartPanel);
		chartPanel = createDemoPanel(dataset);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		content.add(chartPanel);
		setContentPane(content);
	}

	private static JFreeChart createChart(XYDataset dataset) {

		return ChartFactory.createXYLineChart("Chart", "n", "x(n)", dataset, PlotOrientation.VERTICAL, true, true,
				false);
	}

}
