package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

///**
// *
// * @author Casa
// */
public class Main {

//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {
        operacion("C:\\Users\\7mo tecnica\\Documents\\texto.txt");
        
        File oldfile = new File("C:\\Users\\7mo tecnica\\Documents\\texto.txt"); //nombre archivo viejo
        File newfile = new File("C:\\Users\\7mo tecnica\\Documents\\texto.txt.bkp"); //nombre archivo nuevo
		
        if(oldfile.renameTo(newfile)){
            System.out.println("Archivo generado exitosamente!");
        }else{
            System.out.println("Problema al generar archivo!");
        }

        oldfile = new File("C:\\Users\\7mo tecnica\\Documents\\temp.txt"); //nombre archivo viejo
        newfile = new File("C:\\Users\\7mo tecnica\\Documents\\texto.txt"); //nombre archivo nuevo
		
        if(oldfile.renameTo(newfile)){
            System.out.println("Archivo generado exitosamente!");
        }else{
            System.out.println("Problema al generar archivo!");
        }   
        
    }

    public static void appendear_archivo(String texto, String line)
    {
        FileWriter fichero = null;
        Writer pw = null;
        //fichero = new FileWriter(texto);
        //pw = new PrintWriter(fichero);
        try(PrintWriter output = new PrintWriter(new FileWriter(texto,true)))
        {
            output.printf("%s\r\n", line);
        }
        catch (Exception e) {}
        try {
            if (null != fichero)
                fichero.close();
        } catch (IOException e2) {
            System.out.println(e2.toString());
        }
    }
    
    public static void operacion(String texto) {
       File archivo = null;
       FileReader fr = null;
       BufferedReader br = null;
       String textoTemp = "C:\\Users\\7mo tecnica\\Documents\\temp.txt";
       
       try {
          // Apertura del fichero y creacion de BufferedReader para poder
          // hacer una lectura comoda (disponer del metodo readLine()).
          archivo = new File (texto);
          fr = new FileReader (archivo);
          br = new BufferedReader(fr);
          
          // Lectura del fichero
          String linea;
          int pos;
          while((linea=br.readLine())!=null){
            //System.out.println(linea);
             
            pos = 0;
            boolean capitalize = true;
            StringBuilder sb = new StringBuilder(linea);
            while (pos < sb.length()) {
                if (sb.charAt(pos) == '.') {
                   capitalize = true;
                } else if (capitalize && !Character.isWhitespace(sb.charAt(pos))) {
                   sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
                   capitalize = false;
                }
                pos++;
            }
            
            appendear_archivo(textoTemp,sb.toString());
                      
          }
                  
       }
       catch(IOException e){
           System.out.println(e.toString());
       }finally{
          try{                    
             if( null != fr ){   
                fr.close();     
             }                  
          }catch (IOException e2){ 
              System.out.println(e2.toString());
          }
       }
    }
}