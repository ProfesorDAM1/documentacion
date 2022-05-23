/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesroqueamagro1dam.mavenproject1;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
/**
 *
 * @author Ivan
 */
public class Cliente {
    private String clientName;
    private String CCC;
    private float balance;

    /*Constructor del cliente*/
    public Cliente(){
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
      while ((!CCC_Check(CCC_Cli))/*(CCC_Cli.compareTo("NO"))*/){
        
        System.out.println("Cuenta erronea. Comprobar cuenta de cliente");
        //System.out.println("En caso de no querer introducirla, escribir NO.");
        System.out.println("");

        System.out.print("Introduzca cuenta cliente: ");
        CCC_Cli = Scan.nextLine();
      } 
      
      /*Si el CCC es correcto lo asigna a la variable CCC del objeto*/
      if (CCC_Check(CCC_Cli)){
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

    public boolean CCC_Check(String CCC){
        //boolean check = true;
        
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
