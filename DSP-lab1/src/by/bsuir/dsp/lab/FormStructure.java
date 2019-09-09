package by.bsuir.dsp.lab;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class FormStructure extends ApplicationFrame implements ActionListener {

	private JPanel controlPanel;
	private ChartPanel chartPanel;
	private JPanel content;

	public FormStructure(String title) {
		super(title);
		initUI();
	}

	private void initUI() {

		content = new JPanel(new BorderLayout());
		content.add(formControlPanel(), BorderLayout.SOUTH);
		setContentPane(content);
	}

	private JPanel formControlPanel() {

		final JButton button = new JButton("Add New Data Item");
		button.setActionCommand("ADD_DATA");
		button.addActionListener(this);

		final JButton button2 = new JButton("Next graph");
		button2.setActionCommand("NEXT");
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
		JFreeChart chart = StartCharting.paint(dataset);
		return new ChartPanel(chart);
	}

	public static void main(final String[] args) {

		final FormStructure demo = new FormStructure("Dynamic Data Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ADD_DATA") {
			repaintChart(new Part1_Task1().createDataset());
		} else if (e.getActionCommand() == "NEXT") {
			repaintChart(new Part1_Task2().createDataset());
		}

	}

	private void repaintChart(XYDataset dataset) {

		content.remove(chartPanel);
		chartPanel = createDemoPanel(dataset);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		content.add(chartPanel);
		setContentPane(content);
	}

}
