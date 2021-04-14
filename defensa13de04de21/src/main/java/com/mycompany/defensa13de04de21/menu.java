/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.defensa13de04de21;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author HP 8va Gen
 */
public class menu {
    //no hay en el menu
    public static void main(String[] args) {
        int N;
        String nombre;
        operaciones oper=new operaciones();
        seguro segVida=new seguroVida();
        seguro segAcci=new seguroAccidentes();
        Scanner leer=new Scanner(System.in);
        boolean p=false;
        try{
            while(p==false)
            {
                System.out.println("****************************MENU*******************************");
                System.out.println("1.AÑADIR SEGURO DE VIDA");
                System.out.println("2.AÑADIR SEGURO DE ACCIDENTES");
                System.out.println("3.MOSTRAR SEGUROS DE VIDA");
                System.out.println("4.MOSTRAR SEGUROS DE ACCIDENTES");
                System.out.println("5.CALCULAR LA CUOTA MENSUAL DE UN SEGURO DE VIDA");
                System.out.println("6.CALCULAR LA FECHA FINAL DE UN SEGURO DE ACCIDENTES");
                System.out.println("7.SALIR");
                System.out.println("****************************************************************");
                N=leer.nextInt();
                leer.nextLine();
                switch(N)
                {
                    case 1:
                        oper.registrarSeguro(segVida);
                    break;
                    case 2:
                        leer.nextLine();
                        oper.registrarSeguro(segAcci);
                    break;
                    case 3:
                        oper.mostrar(1);
                    break;
                    case 4:
                        oper.mostrar(2);
                    break;
                    case 5:
                        System.out.println("ESCRIBA EL NOMBRE DE LA PERSONA A LA CUAL LE PERTENECE EL SEGURO");
                        nombre=leer.nextLine();
                        oper.calcularCuota(nombre);
                    break;
                    case 6:
                        System.out.println("ESCRIBA EL NOMBRE DE LA PERSONA A LA CUAL LE PERTENECE EL SEGURO");
                        nombre=leer.nextLine();
                        oper.calcularfechafinal(nombre);
                    break;
                }
            }
        }catch(Exception error)
        {
               System.out.println("ERROR EN EL MENU:"+error);
        }
        
    }
}
