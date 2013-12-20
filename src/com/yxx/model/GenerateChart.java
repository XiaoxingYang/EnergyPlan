package com.yxx.model;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

/**
* A line chart demo showing the use of a custom drawing supplier.
*
*/
public class GenerateChart{

	
	private static XYDataset createDataset(String username) {
		
		XYSeries xy = new XYSeries("Decision");
		final String series1 = "Decisions";
		
		DecisionBeanOperator dbo = new DecisionBeanOperator();
		int count = dbo.getDecisionCount(username);
		ArrayList al = dbo.getAllDecisions(username);
		for(int i = 0; i <= count; i ++){
			xy.add(i, dbo.getCarbonAccumulation(i));
		}
		XYSeriesCollection xyseriescollection = new XYSeriesCollection(); 
		xyseriescollection.addSeries(xy);
		return xyseriescollection;
		
	}
	public static JFreeChart createChart(XYDataset xydataset)
	{
	JFreeChart jfreechart = ChartFactory.createXYLineChart(
			"Transport Carbon Accumulation",
			"X",
			"Y",
			xydataset,
			PlotOrientation.VERTICAL,
			true,
			true,
			false);
	jfreechart.setBackgroundPaint(Color.white);
	XYPlot xyplot = (XYPlot)jfreechart.getPlot(); 
	xyplot.setBackgroundPaint(Color.lightGray); 
	xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D)); 
	xyplot.setDomainGridlinePaint(Color.white); 
	xyplot.setRangeGridlinePaint(Color.white);
	XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
	xylineandshaperenderer.setShapesVisible(true); 
	xylineandshaperenderer.setShapesFilled(true); 
	NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
	numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	return jfreechart;
	}
	
	public void generateChart(String username){
//	public static void main(String[] args){
	JFreeChart j = createChart(createDataset(username));
	try {
		ChartUtilities.saveChartAsJPEG(new File("E:/EnergyService/EnergyService/WebRoot/img/lineChart.jpg"), j, 800, 600);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}

}

