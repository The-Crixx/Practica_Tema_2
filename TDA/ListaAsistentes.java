package TDA;
import static DurasPruebas.PruebasGrafiquiñas.grabaFileJPG;
import static DurasPruebas.PruebasGrafiquiñas.panelJframe;
import EntradaDatos.EDJOPI;
import SalidaM.*;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ListaAsistentes {
    ArrayList <asistente> lista;
    int tPma=0,tPme=0,tH=0,tM=0,tS=0,tC=0,tV=0,tD=0;
    float pH=0,pM=0;
    
    public ListaAsistentes(){
        lista=new <asistente> ArrayList();
    }
    
    public void añadir(asistente a){
        lista.add(a);
    }
    
    public void eliminar(int pos){
        lista.remove(pos);
    }
    
    public void eliminartodo(){
        lista.removeAll(lista);
    }
    
    public asistente crearAsistente(){
        asistente aux=new asistente();
        aux.setNombre(EDJOPI.cadena("Ingrese el nombre"));
        aux.setEdad(EDJOPI.Byte("Ingrese la edad"));
        aux.setSexo(EDJOPI.cadena("Ingrese su sexo"));
        aux.seteCivil(EDJOPI.cadena("Estado civil"));
        return aux;
    }
    
    public void validaEdad(){
        tPma=0;tPme=0;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getEdad()>=18)
                tPma++;
            else
                tPme++;
        }
    }
    
    public void validaSexo(){
        tH=0;tM=0;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getSexo().toLowerCase().equals("masculino"))
                tH++;
            else{
              if(lista.get(i).getSexo().toLowerCase().equals("femenino"))
                tM++;
            }
        }
        Porcentajes();
    }
    
    public void ValidaEstado(){
        tS=0;tC=0;tV=0;tD=0;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).geteCivil().equals("SOLTERO"))
                tS++;
            else
                if(lista.get(i).geteCivil().equals("CASADO"))
                    tC++;
                else    
                    if(lista.get(i).geteCivil().equals("VIUDO"))
                    tV++;
                    else
                        if(lista.get(i).geteCivil().equals("DIVORCIADO"))
                        tD++;
            }
        }
    
    public void Porcentajes(){
        pH=(float)(tH*100/lista.size());
        pM=(float)(tM*100/lista.size());
        }
    
    public String imprimir(){
        validaEdad();
        ValidaEstado();
        validaSexo();
        String cadena="";
        cadena="Total de Asistentes: "+lista.size()+"\r\n"+
                "Total de personas Mayores de edad: "+tPma+"\r\n"+
                "Total de personas Menores de edad: "+tPme+"\r\n"+
                "Total de hombre: "+tH+"\r\n"+
                "Total de mujeres: "+tM+"\r\n"+
                "Total de solteros: "+tS+"\r\n"+
                "Total de casados: "+tC+"\r\n"+
                "Total de viudos: "+tV+"\r\n"+
                "Total de divorciados: "+tD+"\r\n"+
                "Porcentaje de hombres: "+pH+"%\r\n"+
                "Porcentaje de mujeres: "+pM+"%\r\n";
        return cadena;
    }
    
    public int tamaño(){
       return lista.size();
    }
    
    public CategoryDataset creaDatosA(){ 
        DefaultCategoryDataset datos=new DefaultCategoryDataset();
        validaEdad();
        validaSexo();
        ValidaEstado();
        datos.setValue(tPma,"Edad","Mayores de edad");
        datos.setValue(tPme,"Edad","Menores de edad");
        datos.setValue(tH,"Sexo","Masculino");
        datos.setValue(tM, "Sexo", "Femenino");
        datos.setValue(tS,"Estado Civil","Soltero");
        datos.setValue(tD,"Estado Civil","Divorciado");
        datos.setValue(tC,"Estado Civil","Casado");
        datos.setValue(tV,"Estado Civil","Viudo");
        return datos;
    }
    
    public void graficarAsis(CategoryDataset datos){
        JFreeChart grafico;
        grafico=ChartFactory.createBarChart3D(
        "ESTADISTICAS ",
        "CRITERIO",
        "ASISTENTES",
        datos,
        PlotOrientation.VERTICAL,
        true,
        true,
        false
        );
        panelJframe(grafico);
        grabaFileJPG(grafico);
    }
    
    public static void panelJframe(JFreeChart grafica){ 
        ChartPanel panel= new ChartPanel(grafica);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(500,300));
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.add(panel);
    }
    
    public static void grabaFileJPG(JFreeChart grafica){ 
        try {
            ChartUtilities.saveChartAsJPEG(new File("D:\\Imagenes\\Grafica.jpg"), grafica, 800,500);
        } catch (IOException e) {
            System.err.println("Error creando grafico.");
        }
    }
}
