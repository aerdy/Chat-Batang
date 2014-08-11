/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafik_batang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author mrroot
 */
public class Grafik_Batang extends ApplicationFrame {

    /**
     * @param args the command line arguments
     */
  
        
public Grafik_Batang(String title) {
super(title);
CategoryDataset dataset = createDataset();
JFreeChart chart = createChart(dataset);
ChartPanel chartPanel = new ChartPanel(chart, false);
setContentPane(chartPanel);
}
private static CategoryDataset createDataset() {
String series1 = "NaiveBayes";
String series2 = "NearestNeighbor";
String series3 = "C45";
String category5 = "A";

String category1 = "B";

String category2 = "C";

String category3 = "D";

String category4 = "E";

DefaultCategoryDataset dataset = new DefaultCategoryDataset();
dataset.addValue(92.972, series1, category1);
dataset.addValue(77.037, series1, category2);
dataset.addValue(78.67, series1, category3);
dataset.addValue(81.52, series1, category4);
dataset.addValue(78.48, series1, category5);
dataset.addValue(89.89, series2, category1);
dataset.addValue(95.8, series2, category2);
dataset.addValue(89.91, series2, category3);
dataset.addValue(77.96, series2, category4);
dataset.addValue(72.48, series2, category5);
dataset.addValue(91.581, series3, category1);
dataset.addValue(96.17, series3, category2);
dataset.addValue(92, series3, category3);
dataset.addValue(88.36, series3, category4);
dataset.addValue(74.32, series3, category5);
return dataset;
}
private
JFreeChart createChart(CategoryDataset dataset) {
JFreeChart chart = ChartFactory.createBarChart( "Grafik Akurasi", //Judul
"Data",
// Sumbu Y
"Akurasi",
// Sumbu X
dataset,
// data
PlotOrientation.VERTICAL,
// Orientasi
true,
// legend
true,
true);
// tooltips
// URLs
chart.setBackgroundPaint(Color.white);
CategoryPlot plot = (CategoryPlot) chart.getPlot();
plot.setBackgroundPaint(Color.WHITE);//warna Background
plot.setDomainGridlinePaint(Color.BLACK);//warna Grid
plot.setDomainGridlinesVisible(true);
plot.setRangeGridlinePaint(Color.BLACK);
final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
BarRenderer renderer = (BarRenderer) plot.getRenderer();
renderer.setDrawBarOutline(false);
GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.CYAN,0.0f,0.0f, new  Color(0, 0, 64));//warna untuk series1
GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.DARK_GRAY,0.0f,0.0f, new  Color(0, 0, 64));//warna untuk series1
GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.PINK,0.0f,0.0f, new  Color(0, 0, 64));//warna untuk series1

return chart;
}
public static void main(String[] args) {
Grafik_Batang demo = new Grafik_Batang("Demo Grafik");
demo.pack();
RefineryUtilities.centerFrameOnScreen(demo);
demo.setVisible(true);
}
}
