/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafik_batang;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;


/**
 *
 * @author mrroot
 */
public class Grafik_Garis extends ApplicationFrame {
    
    public Grafik_Garis(String title) {
super(title);
ChartPanel chartPanel = (ChartPanel) createDemoPanel();
chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
chartPanel.setMouseZoomable(true, false);
setContentPane(chartPanel);
}
private static JFreeChart createChart(XYDataset dataset) {
JFreeChart chart = ChartFactory.createTimeSeriesChart(
        
"Grafik Akurasi Terhadap Jumlah Noise",
"Noise",
// x
"Akurasi",
// y
dataset,
// data
true,
// legend
true,
// gtooltips
false);
// URLs
// Judul
chart.setBackgroundPaint(Color.white);
XYPlot plot = (XYPlot) chart.getPlot();
plot.setBackgroundPaint(Color.lightGray);
plot.setDomainGridlinePaint(Color.white);
plot.setRangeGridlinePaint(Color.white);
plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
plot.setDomainCrosshairVisible(true);
plot.setRangeCrosshairVisible(true);
XYItemRenderer r = plot.getRenderer();
if (r instanceof XYLineAndShapeRenderer) {
XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
renderer.setBaseShapesVisible(true);
renderer.setBaseShapesFilled(true);
}
NumberAxis axis = new NumberAxis("Jumlah Noise (persen)");
axis.setAutoRangeIncludesZero(true);
plot.setDomainAxis(axis);
return chart;
}
private static XYDataset createDataset() {
XYSeries s1 = new XYSeries("NNGE");
s1.add(0,100);
s1.add(5,98.83);
s1.add(10,97.11);
s1.add(15,96.02);
s1.add(20,89.33);
s1.add(25,88.52);
XYSeries s2 = new XYSeries("IB3");
s2.add(0,87.25);
s2.add(5,94.39);
s2.add(10,97.92);
s2.add(15,97.11);
s2.add(20,93.13);
s2.add(25,91.68);
XYSeries s3 = new XYSeries("NNGEs");
s3.add(0,100);
s3.add(5,100);
s3.add(10,100);
s3.add(15,100);
s3.add(20,100);
s3.add(25,94.58);
XYSeriesCollection dataset = new XYSeriesCollection();
dataset.addSeries(s1);
dataset.addSeries(s2);
dataset.addSeries(s3);
return dataset;

}
public static JPanel createDemoPanel() {
JFreeChart chart = createChart(createDataset());
return new ChartPanel(chart);
}
public static void main(String[] args) {
Grafik_Garis demo = new Grafik_Garis("Demo Grafik Garis");
demo.pack();
RefineryUtilities.centerFrameOnScreen(demo);
demo.setVisible(true);
}

    
}
