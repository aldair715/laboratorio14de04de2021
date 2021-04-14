/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.defensa13de04de21;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author HP 8va Gen
 */
public class seguroVida extends seguro {
    //creamos atributos para nuestro seguro de vida
    private String fechaFinal;
    private String nombreBeneficiario;
    private int costoSeguro;
    //override super de seguro llenar
    public void llenar(String nombre,String monto,String fecha,String fechafin,String nombreben,int costo)
    {
        super.llenar(nombre, monto, fecha);
        this.fechaFinal=fechafin;
        this.nombreBeneficiario=nombreben;
        this.costoSeguro=costo;
        
    }
    //metodo para mostrar
    public void mostrar()
    {
        super.mostrar();
        System.out.println("FECHA FINAL:\t"+this.fechaFinal);
        System.out.println("NOMBRE BENERFICIARIO:\t"+this.nombreBeneficiario);
        System.out.println("COSTO SEGURO:\t"+this.costoSeguro);
    }
    //creando metodo cuota mensual
    public double cuotaMensual()
    {
        long tiempo=calculoTiempo();
        double cuotaMensual=((double)this.costoSeguro)/((double)(tiempo));
        return cuotaMensual;
    }
    //metodo para verificar que la fecha de inicio sea menor y correcta
    public long calculoTiempo()
    {
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaInicio=LocalDate.parse(super.getFechaInicio(),format);
        LocalDate fechaFinal=LocalDate.parse(this.fechaFinal,format);
        long tiempo=ChronoUnit.MONTHS.between(fechaInicio,fechaFinal);
        return tiempo;
        
    }
    //getter and setter

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public int getCostoSeguro() {
        return costoSeguro;
    }

    public void setCostoSeguro(int costoSeguro) {
        this.costoSeguro = costoSeguro;
    }
    
}
