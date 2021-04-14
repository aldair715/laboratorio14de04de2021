/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.defensa13de04de21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP 8va Gen
 */
public class operaciones {
    //crearemos una lista para las operaciones
    //atributos
    private List<seguro> listaSeguro;
    private seguroAccidentes seg1;
    private seguroVida seg2;
    Scanner leer=new Scanner(System.in);
    public operaciones()
    {
         listaSeguro=new ArrayList<>();
    }
    //verificar fecha
    public boolean verificarFecha(String fecha)
    {
        boolean p;
        try{DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaInicio=LocalDate.parse(fecha,format);
        return p=true;}
        catch(Exception error){
        return p=false;
        }
       
       
        
    }
    public boolean verificarFechaTiempo(String fechainicio,String fechafinal)
    {
         boolean p;
        try{DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaInicio=LocalDate.parse(fechainicio,format);
        LocalDate fechaFinal=LocalDate.parse(fechafinal,format);
        long antiguedad=ChronoUnit.DAYS.between(fechaInicio, fechaFinal);
        if(antiguedad>0)
        {
            return p=true;
        }
        else
        {
            return p=false;
        }
        }
        catch(Exception error){
        return p=false;
        }
    }
    //ESTOS SON LOS METODOS DE LOS ARCHIVOS
    public void crearCarpeta()
    {
        try{
            String ruta="C:\\programacion";
            Path path=Paths.get(ruta);
            if(!Files.exists(path))
            {
                Files.createDirectories(path);
            }
        }catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
        
    }
    public void crearArchivo()
    {
        try{
            String ruta="C:\\programacion\\archivo_Seguro.txt";
            Path path=Paths.get(ruta);
            if(!Files.exists(path))
            {
                Files.createFile(path);
            }
        }catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
    }
    //metodos de archivo para leer y guardar en archivo
    public void guardarArchivo() throws IOException
    {
        crearCarpeta();
        crearArchivo();
        String ruta="C:\\programacion\\archivo_Seguro.txt";
        try{
            FileOutputStream file=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(file);
            oos.writeObject(listaSeguro);
            oos.close();
            file.close();
        }
         catch(FileNotFoundException ex)
        {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE,null,ex);
        } catch (IOException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void leerArchivo()
    {
        crearCarpeta();
        crearArchivo();
        String ruta="C:\\programacion\\archivo_Seguro.txt";
        try{
            
            FileInputStream file=new FileInputStream(ruta);
            ObjectInputStream ios=new ObjectInputStream(file);
        
            if(ios!=null)
            {
                listaSeguro=(List<seguro>)ios.readObject();
            }
            else
            {
                System.out.println("ARCHIVO VACIO");
            }
            
        }
        catch(FileNotFoundException e)
        {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null,e);

        } catch (IOException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //metodo para crear seguro
    public void registrarSeguro(seguro seg)
    {
        leerArchivo();
        try{
            if(seg instanceof seguroAccidentes)
            {
                String nombre,monto,fecha;
                double pago;
                System.out.println("==================REGISTRO DE SEGURO DE ACCIDENTES==========");
                System.out.println("1.INGRESE EL NOMBRE DEL ASEGURADO");
                nombre=leer.nextLine().toUpperCase();
                System.out.println("2.INGRESE EL MONTO ASEGURADO");
                monto=leer.nextLine();
                System.out.println("3.INGRESA  LA FECHA DE INICIO DEL SEGURO");
                fecha=leer.nextLine();
                System.out.println("4.INGRESA EL PAGO DEL SEGURO");
                pago=leer.nextDouble();
                System.out.println("===========================================================");
                if(pago>0 && verificarFecha(fecha)==true)
                {
                    seguroAccidentes segAcci=(seguroAccidentes)seg;
                    segAcci.llenar(nombre, monto, fecha, pago);
                    listaSeguro.add(segAcci);
                    guardarArchivo();
                    System.out.println(".............REGISTRO REALIZADO........");
                }
                else
                {
                    System.out.println("ERROR EN UN DATO");
                }
            }
            if(seg instanceof seguroVida)
            {
                String nombre,monto,fecha,fechafin,nombreben;
                int costo;
                leer.nextLine();
                System.out.println("==================REGISTRO DE SEGURO DE VIDA==========");
                System.out.println("1.INGRESE EL NOMBRE DEL ASEGURADO");
                nombre=leer.nextLine().toUpperCase();
                System.out.println("2.INGRESE EL MONTO ASEGURADO");
                monto=leer.nextLine();
                System.out.println("3.INGRESA  LA FECHA DE INICIO DEL SEGURO");
                fecha=leer.nextLine();
                System.out.println("4.INGRESA LA FECHA FINAL DEL SEGURO");
                fechafin=leer.nextLine();
                System.out.println("5.INGRESA EL NOMBRE DEL BENEFICIARIO(el que se queda el dinero)");
                nombreben=leer.nextLine().toUpperCase();
                System.out.println("6.INGRESE EL COSTO DEL SEGURO");
                costo=leer.nextInt();
                System.out.println("===========================================================");
                if(costo>0 && verificarFecha(fecha)==true && verificarFecha(fechafin) && verificarFechaTiempo(fecha,fechafin)==true)
                {
                    seguroVida segVida=(seguroVida)seg;
                    segVida.llenar(nombre, monto, fecha, fechafin, nombreben, costo);
                    listaSeguro.add(segVida);
                    guardarArchivo();
                    System.out.println("....................REGISTRO REALIZADO.............");
                }
                else
                {
                    System.out.println("ERROR EN UN DATO");
                }
            }
        }catch(Exception error)
        {
            System.out.println("ERROR"+error);
        }
        
    }
    
    //metodo para mostrar seguro de accidentes
    public void mostrar(int opcion)
    {
        leerArchivo();
        try{
            if(listaSeguro!=null)
            { System.out.println("***********LISTA SEGURO*******");
                for(seguro seg:listaSeguro)
                {
                   
                    if(opcion==1)
                    {
                      if(seg instanceof seguroVida)
                        {
                            System.out.println("******SEGURO****");
                            seguroVida segVida=(seguroVida)seg;
                            segVida.mostrar();
                            System.out.println("****************");
                        }  
                    }
                    if(opcion==2)
                    {
                        if(seg instanceof seguroAccidentes)
                        {
                            System.out.println("******SEGURO*****");
                            seguroAccidentes segAcci=(seguroAccidentes)seg;
                            segAcci.mostrar();
                            System.out.println("*****************");
                        } 
                    }
                    
                   
                }
            }
            
        }catch(Exception error){
            System.out.println("ERROR:"+error);
        }
    }
    //metodos para calcular la cuota mensual
    public void calcularCuota(String nombre)
    {
        leerArchivo();
        boolean p=false;
        try{
            if(listaSeguro!=null)
            {
                for(seguro seg:listaSeguro)
                {
                    
                    if(seg instanceof seguroVida)
                    {
                        
                        seguroVida segVida=(seguroVida)seg;
                        if(segVida.getNombreAsegurado().equalsIgnoreCase(nombre))
                        {System.out.println("******SEGURO****");
                            p=true;
                            segVida.mostrar();
                            double cuota=segVida.cuotaMensual();
                            long tiempo=segVida.calculoTiempo();
                            System.err.println("TIEMPO:\t"+tiempo);
                            System.out.println("CUOTA MENSUAL:\t"+cuota);
                            System.out.println("****************");
                            break;
                            
                        }
                        
                    }
                   
                }
                if(p==false)
                {
                    System.out.println("NOMBRE ASEGURADO NO ENCONTRADO");
                }
            }
            
        }catch(Exception error){
            System.out.println("ERROR:"+error);
        }
    }
    public void calcularfechafinal(String nombre)
    {
        leerArchivo();
        boolean p=false;
        try{
            if(listaSeguro!=null)
            {
                for(seguro seg:listaSeguro)
                {
                    
                    if(seg instanceof seguroAccidentes)
                    {
                        
                        seguroAccidentes segAc=(seguroAccidentes)seg;
                        if(segAc.getNombreAsegurado().equalsIgnoreCase(nombre))
                        {System.out.println("******SEGURO****");
                            p=true;
                            segAc.mostrar();
                            String fecha=segAc.fechaFinal();
                            System.out.println("FECHA FINAL:\t"+fecha);
                            System.out.println("****************");
                            break;
                            
                        }
                        
                    }
                   
                }
                if(p==false)
                {
                    System.out.println("NOMBRE ASEGURADO NO ENCONTRADO");
                }
            }
            
        }catch(Exception error){
            System.out.println("ERROR:"+error);
        }
    }
    
    
}
