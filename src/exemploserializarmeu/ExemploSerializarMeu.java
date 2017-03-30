/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploserializarmeu;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ExemploSerializarMeu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int select, leido=0;
        Metodos obj = new Metodos();
        do{
            try{
                obj.ler();
                obj.lerApro();
                leido = 1;
                System.out.println("Datos cargados.");
            }catch(Exception ex){
                obj.escribir();
                obj.escribirCadaNota();
                System.out.println("Cargando...");
            }
        }while(leido==0);
        do{
            select = Integer.parseInt(JOptionPane.showInputDialog("1: Añadir.\n2: Mostrar todo. \n3: Mostrar aprobados.\n4: Salir."));
            switch(select){
                case 1: obj.introducirDato();
                        obj.escribir();
                        obj.escribirCadaNota();
                        break;
                case 2: obj.mostrar();
                        break;
                case 3: obj.mostrarApro();
                        break;
            }
        }while(select<4);
    }
    
}
