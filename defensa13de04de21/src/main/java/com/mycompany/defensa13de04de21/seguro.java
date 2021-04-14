/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.defensa13de04de21;

import java.io.Serializable;

/**
 *
 * @author HP 8va Gen
 */
public class seguro implements Serializable{
    //colocamos datos principales en el seguor
    private String nombreAsegurado;
    private String montoAsegurado;
    private String fechaInicio;
    // no colocaremos metodos por scanner debido a que 
    //la serializacion y el scanner no se llevan bien
    //metodo para llenado
    public void llenar(String nombre,String monto,String fecha)
    {
        this.nombreAsegurado=nombre;
        this.montoAsegurado=monto;
        this.fechaInicio=fecha;
    }
    //para mostrar
  public void mostrar()
  {
      System.out.println("NOMBRE ASEGURADO:\t"+this.nombreAsegurado);
      System.out.println("MONTO ASEGURADO:\t"+this.montoAsegurado);
      System.out.println("FECHA INICIO:\t"+this.fechaInicio);
  }
    //cramos getter and setter

    public String getNombreAsegurado() {
        return nombreAsegurado;
    }

    public void setNombreAsegurado(String nombreAsegurado) {
        this.nombreAsegurado = nombreAsegurado;
    }

    public String getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(String montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
}
