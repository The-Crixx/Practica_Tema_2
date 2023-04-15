package Ejecutables;
import javax.swing.*;
import SalidaM.SJOPI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TDA.*;
import java.awt.Color;

public class interfazAsistentes extends JFrame implements ActionListener{
    private ListaAsistentes lista=new ListaAsistentes();
    private JLabel l1,l2,l3,l4,estadisticas;
    private JTextField nom,edad;
    private JButton añadir,mostrarS,eliminar,eliminarT,mostrarE;
    private JRadioButton soltero,casado,divorciado,viudo;
    private ButtonGroup estadocivil,sexo;
    private JCheckBox mas,fem;
    private JList listaAsistentes; 
    private DefaultListModel modelo; 
    private JScrollPane scrollLista;
    private String sex, ecivil;
    

    public interfazAsistentes() {
        super("ASISTENTES");
        setSize(490,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1= new JLabel("Nombre ");
        l1.setBounds(40, 5, 100, 30);
        add(l1);
        l2= new JLabel("Edad: ");
        l2.setBounds(40, 35, 100, 30);
        add(l2);
        l3= new JLabel("Sexo: ");
        l3.setBounds(40, 65, 100, 30);
        add(l3);
        l4= new JLabel("Estado Civil: ");
        l4.setBounds(40, 105, 80, 30);
        add(l4);
        estadisticas= new JLabel("ESTADISTICAS");
        estadisticas.setBounds(40, 290, 150, 30);
        add(estadisticas);
        
        nom=new JTextField();
        nom.setBounds(140, 10, 120, 20);
        add(nom);
        edad=new JTextField();
        edad.setBounds(140, 40, 120, 20);
        add(edad);
        
        mas=new JCheckBox("Masculino");
        mas.setBounds(80, 65, 90, 30);
        mas.addActionListener(this);
        add(mas);
        
        fem=new JCheckBox("Femenino");
        fem.setBounds(170, 65, 90, 30);
        fem.addActionListener(this);
        add(fem);
        
        soltero=new JRadioButton("Soltero");
        soltero.setBounds(120, 105, 70, 30);
        soltero.addActionListener(this);
        add(soltero);
        
        casado=new JRadioButton("Casado");
        casado.setBounds(190, 105, 70, 30);
        casado.addActionListener(this);
        add(casado);
        
        divorciado=new JRadioButton("Divorciado");
        divorciado.setBounds(260, 105, 85, 30);
        divorciado.addActionListener(this);
        add(divorciado);
        
        viudo=new JRadioButton("Viudo");
        viudo.setBounds(350, 105, 70, 30);
        viudo.addActionListener(this);
        add(viudo);
        
        estadocivil=new ButtonGroup();
        estadocivil.add(soltero);
        estadocivil.add(casado);
        estadocivil.add(divorciado);
        estadocivil.add(viudo);
        sexo=new ButtonGroup();
        sexo.add(mas);
        sexo.add(fem);
        
        listaAsistentes=new JList();
        listaAsistentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo=new DefaultListModel();
        
        scrollLista = new JScrollPane();
        scrollLista.setBounds(40, 180 ,400, 100);
        scrollLista.setViewportView(listaAsistentes);
        add(scrollLista);
        
        añadir=new JButton("Añadir");
        añadir.setBounds(40, 140, 80, 30);
        añadir.setBackground(Color.green);
        add(añadir);
        
        eliminar=new JButton("Eliminar");
        eliminar.setBounds(130, 140, 80, 30);
        eliminar.setBackground(Color.orange);
        add(eliminar);
        
        eliminarT=new JButton("Eliminar Todos");
        eliminarT.setBounds(220, 140, 120, 30);
        eliminarT.setBackground(Color.red);
        add(eliminarT);
        
        mostrarE=new JButton("Generar Estadisticas");
        mostrarE.setBounds(150, 320, 200, 30);
        mostrarE.setBackground(Color.green);
        add(mostrarE);
        
        añadir.addActionListener(this);
        eliminar.addActionListener(this);
        eliminarT.addActionListener(this);
        mostrarE.addActionListener(this);
        
        setVisible(true);
    }  
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==añadir)
            añadirAsistente();
        if(e.getSource()==eliminar)
            eliminaAsistente(listaAsistentes.getSelectedIndex());
        if(e.getSource()==eliminarT)
            EliminarTodo();
        if(e.getSource()==mostrarE)
            lista.graficarAsis(lista.creaDatosA());
        if (mas.isSelected()){
            sex="MASCULINO";
        }
        if (fem.isSelected()){
            sex="FEMENINO";
        }
        
        if(soltero.isSelected()){
            ecivil="SOLTERO";
        }
        if(casado.isSelected()){
            ecivil="CASADO";
        }
        if(divorciado.isSelected()){
            ecivil="DIVORCIADO";
        }
        if(viudo.isSelected()){
            ecivil="VIUDO";
        }
    }
    
    public void añadirAsistente(){
        asistente a = new asistente(nom.getText(),Byte.parseByte(edad.getText()), 
        sex,ecivil);
        lista.añadir(a);
        String cad = nom.getText() + " | " +edad.getText() + " | " + 
        sex + " | " + ecivil;
        modelo.addElement(cad);
        listaAsistentes.setModel(modelo);
        int x = modelo.getSize();
        nom.setText("");
        edad.setText("");
        sexo.clearSelection();
        estadocivil.clearSelection();
        nom.requestFocus();
    }
    
    public void eliminaAsistente(int i){
        if (i >= 0) { 
            modelo.removeElementAt(i); 
            lista.eliminar(i); 
            int x = modelo.getSize();
        }else { 
            SJOPI.SJOPI("Seleccione un elemento");
        }
        nom.requestFocus();
    }
    
    public void EliminarTodo(){
        lista.eliminartodo();
        modelo.clear(); 
        int x = modelo.getSize();
        nom.requestFocus();
    }
    
    }
        

