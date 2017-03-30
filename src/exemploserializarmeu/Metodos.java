/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploserializarmeu;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Metodos {
    private ArrayList <Alumno> lista, apro;
    private Scanner scan;
    private PrintWriter escribir;
    private int cont;
    
    public Metodos() {
        lista = new ArrayList<Alumno>();
        apro = new ArrayList<Alumno>();
    }
    
    public void escribir(){
        try{
            escribir = new PrintWriter(new File("alumnos.dat"));
            for(int i = 0; i<lista.size();i++){
                escribir.println(lista.get(i).getNome() + "," + lista.get(i).getNota());
            }
        }catch(Exception ex){
            System.out.println(ex + " no se encuentra fichero.");
        }finally{
            escribir.close();
        }
    }
    
    public void ler(){
        String[]aux;
        try{
            scan = new Scanner(new File("alumnos.dat"));
            while(scan.hasNextLine()){
                aux = scan.nextLine().split(",");
                lista.add(new Alumno(aux[0], Integer.parseInt(aux[1])));
            }
        }catch(Exception ex){
            System.out.println(ex + " fichero no encantrado.");
        }finally{
            scan.close();
        }
        cont = lista.size();
    }
    
    public void lerApro(){
        String[]aux;
        try{
            scan = new Scanner(new File("aprobados.dat"));
            while(scan.hasNextLine()){
                aux = scan.nextLine().split(",");
                apro.add(new Alumno(aux[0], Integer.parseInt(aux[1])));
            }
        }catch(Exception ex){
            System.out.println(ex + " fichero no encantrado.");
        }finally{
            scan.close();
        }
    }
    
    public void escribirCadaNota(){
        Collections.sort(apro);
        try{
            escribir = new PrintWriter(new File("aprobados.dat"));
            for(int i = 0; i<apro.size();i++){
                escribir.println(apro.get(i).getNome() + "," + apro.get(i).getNota());
            }
            escribir.close();
            escribir = new PrintWriter(new File("suspensos.dat"));
            for(int i= 0; i<lista.size(); i++){
                if(lista.get(i).getNota()<5){
                    escribir.println(lista.get(i).getNome() + "," + lista.get(i).getNota());
                }
            }
        }catch(Exception ex){
            System.out.println(ex + " no se encuentra algún fichero.");
        }finally{
            escribir.close();
        }
    }
    
    public void introducirDato(){
        System.out.println(cont);
        lista.add(new Alumno(JOptionPane.showInputDialog("Nome"), Integer.parseInt(JOptionPane.showInputDialog("Nota"))));
        if(lista.get(cont).getNota()>=5){
            apro.add(new Alumno(lista.get(cont).getNome(), lista.get(cont).getNota()));
        }
        cont++;
        
    }
    
    public void mostrar(){
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).getNota()>=5){
                System.out.println(lista.get(i) + " aprobado");
            }else{
                System.out.println(lista.get(i) + " suspenso");
            }
        }
    }
    
    public void mostrarApro(){
        for(int i = 0; i<apro.size(); i++){
            System.out.println(apro.get(i));
        }
    }
}
