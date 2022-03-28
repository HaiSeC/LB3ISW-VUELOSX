/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTS;

import NEG.Var;
import OBJS.ObjVar;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Guerrero
 */
public class PieChart extends JFrame{
    Var LV = new Var();
    
   public void BarChartz(){
       ObjVar.Var = new ArrayList<>();
            //<editor-fold defaultstate="collapsed" desc=" Vars ">
        int pasPANTaca = 0;
        int pasUSATaca = 0;
        int pasMEXTaca = 0;
        int pasCLTaca = 0;
        int pasCRTaca = 0;
        
        int pasTaca = 0;
                
        int pasMEXCopa = 0;
        int pasPANCopa = 0;
        int pasUSACopa = 0;
        int pasCLCopa = 0;
        int pasCRCopa = 0;
        
        int pasCopa = 0;
        
        int pasPANAvianca = 0;
        int pasUSAAvianca = 0;
        int pasMEXAvianca = 0;
        int pasCRAvianca = 0;
        int pasCLAvianca = 0;
        
        int pasAvianca = 0;
        
        int pasPANAeMEX = 0;
        int pasUSAAeMEX = 0;
        int pasMEXAeMEX = 0;
        int pasCRAeMEX = 0;
        int pasCLAeMEX = 0;
        
        int pasAeMEX = 0;
        //</editor-fold>
        ArrayList<ObjVar> Varz = LV.loadVar();  
        for (int i = 0; i < Varz.size(); i++) {
            //<editor-fold defaultstate="collapsed" desc=" Taca ">
                if (Varz.get(i).getAERName().equals("Aero_Panama") && Varz.get(i).getAEName().equals("Taca")){
                    pasPANTaca = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_USA") && Varz.get(i).getAEName().equals("Taca")){
                    pasUSATaca = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_Mexico") && Varz.get(i).getAEName().equals("Taca")){
                    pasMEXTaca = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_CR") && Varz.get(i).getAEName().equals("Taca")){
                    pasCRTaca = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_Colombia") && Varz.get(i).getAEName().equals("Taca")){
                    pasCLTaca = Varz.get(i).getPASCant();
                }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Copa ">
                if (Varz.get(i).getAERName().equals("Aero_Panama") && Varz.get(i).getAEName().equals("Copa")){
                    pasPANCopa = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_USA") && Varz.get(i).getAEName().equals("Copa")){
                    pasUSACopa = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_Mexico") && Varz.get(i).getAEName().equals("Copa")){
                    pasMEXCopa = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_CR") && Varz.get(i).getAEName().equals("Copa")){
                    pasCRCopa = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_Colombia") && Varz.get(i).getAEName().equals("Copa")){
                    pasCLCopa = Varz.get(i).getPASCant();
                }
             //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Avianca ">
                if (Varz.get(i).getAERName().equals("Aero_Panama") && Varz.get(i).getAEName().equals("Avianca")){
                    pasPANAvianca = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_USA") && Varz.get(i).getAEName().equals("Avianca")){
                    pasUSAAvianca = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_Mexico") && Varz.get(i).getAEName().equals("Avianca")){
                    pasMEXAvianca = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_CR") && Varz.get(i).getAEName().equals("Avianca")){
                    pasCRAvianca = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_Colombia") && Varz.get(i).getAEName().equals("Avianca")){
                    pasCLAvianca = Varz.get(i).getPASCant();
                }
             //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" AeMEX ">
                if (Varz.get(i).getAERName().equals("Aero_Panama") && Varz.get(i).getAEName().equals("Aero Mexico")){
                    pasPANAeMEX = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_USA") && Varz.get(i).getAEName().equals("Aero Mexico")){
                    pasUSAAeMEX = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_Mexico") && Varz.get(i).getAEName().equals("Aero Mexico")){
                    pasMEXAeMEX = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_CR") && Varz.get(i).getAEName().equals("Aero Mexico")){
                    pasCRAeMEX = Varz.get(i).getPASCant();
                }
                if (Varz.get(i).getAERName().equals("Aero_Colombia") && Varz.get(i).getAEName().equals("Aero Mexico")){
                    pasCLAeMEX = Varz.get(i).getPASCant();
                }
             //</editor-fold>
        
    }
       pasTaca = pasPANTaca + pasCRTaca + pasMEXTaca + pasCLTaca;
       pasAvianca = pasPANAvianca + pasCRAvianca + pasMEXAvianca + pasCLAvianca;
       pasCopa = pasPANCopa + pasCRCopa + pasMEXCopa + pasCLCopa;
       pasAeMEX = pasPANAeMEX  + pasCRAeMEX  + pasMEXAeMEX  + pasCLAeMEX ;
       System.out.println(pasTaca);
       System.out.println(pasAvianca);
       System.out.println(pasCopa);
       System.out.println(pasAeMEX);
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       dataset.setValue(pasTaca, "Pasajeros","Taca");
       dataset.setValue(pasAvianca, "Pasajeros","Avianca");
       dataset.setValue(pasCopa, "Pasajeros","Copa");
       dataset.setValue(pasAeMEX, "Pasajeros","AeMEX");
       JFreeChart chart =ChartFactory.createBarChart("Cantidad de Pasajaros por Aerolinea", "Aerolinea", "Cantidad", dataset,PlotOrientation.VERTICAL,false,true,false);
       CategoryPlot p=chart.getCategoryPlot();
       p .setRangeGridlinePaint(Color.black);
       ChartFrame frame = new ChartFrame("Gráfico de Pasajeros", chart);
       frame.setVisible(true);
       frame.setLocationRelativeTo(null);
       frame.setSize(450,350);
   }

    
}
