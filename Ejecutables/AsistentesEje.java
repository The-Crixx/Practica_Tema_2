package Ejecutables;
import TDA.ListaAsistentes;
import SalidaM.SJOPI;
import EntradaDatos.EDJOPI;

public class AsistentesEje {
    public static void main(String[] args) {
        ListaAsistentes l=new ListaAsistentes();
        byte opc=0;
        do{
        opc=EDJOPI.Byte("Opciones: \n1. Agregar Objeto \n2. mostrar"
                                                            +"\n3. Salir");
        switch(opc){
            case 1:
                l.añadir(l.crearAsistente());
                break;
            case 2:
                SJOPI.SJOPI(l.imprimir());
                break;
            case 3:
                break;
            default:
                SJOPI.SJOPI("Ingrese una opcion valida");
        }
        }while(opc!=3);
    }
}
