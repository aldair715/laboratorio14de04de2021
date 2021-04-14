/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.defensa13de04de21;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author HP 8va Gen
 */
public class seguroAccidentes extends seguro{
    //atributos del seguro accidentes
    private double pagoSeguro;
    //metodo de llenar
     public void llenar(String nombre,String monto,String fecha,double pagoSeguro)
    {
        super.llenar(nombre, monto, fecha);
        this.pagoSeguro=pagoSeguro;
        
    }
     //metodo para llenar
     public void mostrar()
     {
         super.mostrar();
         System.out.println("PAGO SEGURO:"+this.pagoSeguro);
     }
     //metodo para calcular la fecha final
     public String fechaFinal()
     {
         DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
         LocalDate fechaInicio=LocalDate.parse(super.getFechaInicio(),format);
         LocalDate unAño=fechaInicio.plusDays(365);
         String fecha=String.valueOf(unAño);
         return fecha;
         
     }
     //getter and setter

    public double getPagoSeguro() {
        return pagoSeguro;
    }

    public void setPagoSeguro(double pagoSeguro) {
        this.pagoSeguro = pagoSeguro;
    }
     
}
