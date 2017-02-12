/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Clases;

import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author Luis
 */
public class Gasolinera {
   //Variable del precio del combustible
   double prec1=2.50,prec2=2.80,prec3=3.5;

    public double getPrec1() {
        return prec1;
    }

    public double getPrec2() {
        return prec2;
    }

    public double getPrec3() {
        return prec3;
    }
   //Variable para manejar los valores a llevar
   double cantidad;
   //Variables para llevar el control de disponible
   double dispo1,dispo2,dispo3;
   //Maneja el precio a pagar
   double pago;
   double tipo;


    public double getTipo() {
        return tipo;
    }

    public void setTipo(double tipo) {
        this.tipo = tipo;
    }
   String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getDispo1() {
        return dispo1;
    }

    public void setDispo1(double dispo1) {
        this.dispo1 = dispo1;
    }

    public double getDispo2() {
        return dispo2;
    }

    public void setDispo2(double dispo2) {
        this.dispo2 = dispo2;
    }

    public double getDispo3() {
        return dispo3;
    }

    public void setDispo3(double dispo3) {
        this.dispo3 = dispo3;
    }
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    
    public double ventaGalones(double cantidad,double tipo)
    {
    this.tipo = tipo;
       DecimalFormat df2 = new DecimalFormat("#.##");
    if(tipo == 1)
    {
    tipo = this.prec1;
     this.dispo1 = Double.parseDouble(df2.format(this.dispo1 - cantidad));
    
    }
     if(tipo == 2)
    {
    tipo = this.prec2;
     this.dispo2 = Double.parseDouble(df2.format(this.dispo2 - cantidad));
    }
      if(tipo == 3)
    {
    tipo = this.prec3;
     this.dispo3 = Double.parseDouble(df2.format(this.dispo3 - cantidad));
    }
    DecimalFormat df = new DecimalFormat("#.##");
    this.cantidad = Double.parseDouble(df.format(cantidad));
    this.pago = Double.parseDouble(df.format(cantidad * tipo));
   
    return 0;
    }
    public double ventaDinero(double cantidad, double tipo)
    {
        this.tipo = tipo;
    if(tipo == 1)
    {
    tipo = this.prec1;
    }
     if(tipo == 2)
    {
    tipo = this.prec2;
    }
      if(tipo == 3)
    {
    tipo = this.prec3;
    }
      DecimalFormat df = new DecimalFormat("#.##");
    this.pago = Double.parseDouble(df.format(cantidad));
    this.cantidad = Double.parseDouble(df.format(cantidad / tipo));
      if(this.tipo == 1)
    {
    this.dispo1 = Double.parseDouble(df.format(this.dispo1 - this.cantidad));
    }
     if(this.tipo == 2)
    {
  this.dispo2 = Double.parseDouble(df.format(this.dispo2 - this.cantidad));
    }
      if(this.tipo == 3)
    {
    this.dispo3 = Double.parseDouble(df.format(this.dispo3 - this.cantidad));
    }
    return 0;
    }
}
