/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesroqueamagro1dam.mavenproject1;
import java.util.Scanner;

/**
 *
 * @author Ivan
 */
public class CuentaBancaria {
    private String clientName;
    private String CCC;
    private float balance;

    /*Constructor del cliente*/
    public CuentaBancaria(){
        this.clientName="";
        this.CCC="";
        this.balance=0;
    }
    
    /*Metodo que guarda el nombre del cliente*/
    public void setClientName(){
      Scanner Scan = new Scanner(System.in);

      System.out.print("Introduzca nombre de cliente: ");
      String nameCli = Scan.nextLine();
      
      /*Controla que no se introduzcan mas de 50 carateres en el nombre de cliente*/
      while (nameCli.length()>50){
        System.out.println("");
        System.out.println("Ha exedido el maximo de caracteres, 50");
        System.out.println("");

        System.out.print("Introduzca nombre de cliente: ");
        nameCli = Scan.nextLine();
      }

      this.clientName = nameCli;
    }

    /*Metodo que guarda el codigo cuenta cliente*/
    public void setClientCCC(){
      Scanner Scan = new Scanner(System.in);

      System.out.print("Introduzca cuenta de cliente: ");
      String CCC_Cli = Scan.nextLine();
      
      /*Estructura que controla si el CCC esta correcto. En caso negativo vuelve
      a solicitar el codigo cuenta cliente*/
      while ((!checkCCC(CCC_Cli))/*(CCC_Cli.compareTo("NO"))*/){
        
        System.out.println("Cuenta erronea. Comprobar cuenta de cliente");
        //System.out.println("En caso de no querer introducirla, escribir NO.");
        System.out.println("");

        System.out.print("Introduzca cuenta cliente: ");
        CCC_Cli = Scan.nextLine();
      } 
      
      /*Si el CCC es correcto lo asigna a la variable CCC del objeto*/
      if (checkCCC(CCC_Cli)){
          this.CCC = CCC_Cli;
      }

      
    }
    
    /*Metodo que devuleve el nombre de cliente*/
    public String getClientName(){
      return this.clientName;
    }
    
    /*Metodo que devuelve el codigo cuenta cliente*/
    public String getClientCCC(){
      return this.CCC;
    }

    /*Metodo que devuelve el codigo de entidad*/
    public String getEntidad(){
      return this.CCC.substring(0, 4);
    }

    /*Metodo que devuelve el codigo de oficina */
    public String getOficina(){
      return this.CCC.substring(4, 8);
    }
    
    /*Metodo que devuelve el numero de cuenta*/
    public String getNumCuenta(){
      return this.CCC.substring(10, 20);
    }
       
    /*Metodo que devuelve el codigo de control*/
    public String getDigContol(){
      return this.CCC.substring(8, 10);
    }
    
    /*Metodo que devuelve el saldo de la cuenta*/
    public float getSaldo(){
      return this.balance;
    }
    
    /*Metodo de controla que la cantidad del ingreso es positiva y lo añade al 
    balance del cliente*/
    public void inDeposit(){
        Scanner Scan = new Scanner(System.in);
        System.out.print("Introduzca cantidad a ingresar: ");
        float ingreso = Scan.nextFloat();
        
        //controla que la cantidad introducida no sea negativa
        while (ingreso<0){
            System.out.println("");
            System.out.println("ERROR: La cantidad introducida es negativa");
            System.out.print("Introduzca cantidad correcta a ingresar: ");
            ingreso = Scan.nextFloat();
        }
        this.balance += ingreso;
        System.out.println("El saldo actual de la cuenta es: " +this.balance+"€");
    }
        /*
    Metodo que registra las retiradas de efectivo. Controla que la cantidad
    introducida no sea negativa, que no se retire más cantidad de la disponible
    en el balance
    */
    public void outDeposit(){
        Scanner Scan = new Scanner(System.in);
        System.out.print("Introduzca cantidad a retirar: ");
        float cantidad = Scan.nextFloat();
        
        //controla que la cantidad introducida no sea negativa
        while (cantidad<0){
            System.out.println("");
            System.out.println("ERROR: La cantidad introducida es negativa");
            System.out.print("Introduzca cantidad correcta a retirar: ");
            cantidad = Scan.nextFloat();
        }
        
        /*
        Estructura condicional que controla si se dispone de suficientes fondos 
        para retirar la cantidad introducida por teclado
        */
        if (cantidad>this.balance){
            System.out.println("");
            System.out.println("No se dispone de suficientes fondos");
            System.out.println("El saldo actual de la cuenta es: " +this.balance+"€");
            System.out.println("");
        } else {
            this.balance -= cantidad;
            System.out.println("El saldo actual de la cuenta es: " +this.balance+"€");
        }
    }
    
    
    public static boolean checkCCC(String CCC){
             
        //  Control de la longitud del CCC, en caso de no ser de 20 digitos se muestra
        //  mensaje de error y se devuelve valor falso al contro del CCC.
        if (CCC.length()!=20){
            System.out.println("");
            System.out.println("ERROR: El CCC no dipone de 20 digitos");
            System.out.println("");
            return false;            
        }
       /*
        // Control de en mod11 para comprobar que los 8 primeros digitos son correctos (entidad y oficina)
        if (mod11_CCC("00"+CCC.substring(0, 9))!= (int)(CCC.charAt(8))){
            System.out.println("TEST-1");
            System.out.println("");
            System.out.println((int)(CCC.charAt(8)));
            System.out.println("");
            return true; //Cambiar a false al corregir
        }
        
        
        // Control de en mod11 para comprobar que los 10 digitos del numero de cuenta con correctos
        if (mod11_CCC(CCC.substring(10, 19))!= (int)(CCC.charAt(9))){
            System.out.println("TEST-2");
            return true; //Cambiar a false al corregir
        }
       */
        return true;
    }

    public int mod11_CCC(String CCC){
        int[] cifras = {1,2,4,8,5,10,9,7,3,6};
        int check=0;
        
        
        for ( int i=0; i<10;i++){
            check += (int)CCC.charAt(i) * cifras[1];
        }
        
        check = 11 - (check % 11);
        
        if (check == 11){
            check = 0;
        } 
        if  (check == 10){
            check = 1;
        }
                
        return check;   
    }
        
}
