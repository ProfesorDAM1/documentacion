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
public class Prueba {
    public static void main(String[] args) {
        boolean a = false;
        CuentaBancaria client1 = new CuentaBancaria();
        String CCC = client1.getClientCCC();

        //Llamada a la funcion que solicita el numbre del cliente.
        client1.setClientName();
        
        //Llamada a la funcion que solicita el codigo de cuenta cliente
        client1.setClientCCC();
        
        /*Estructura de control para que muestre el menu hasta seleccionar la opción 10
            para salir del bucle y finalizar el programa.
        */
        do{ 
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1.  Ver el número de cuenta completo (CCC - Código Cuenta Cliente)");
            System.out.println("2.  Ver el titular de la cuenta");
            System.out.println("3.  Ver el código de la entidad");
            System.out.println("4.  Ver el código de la oficina");
            System.out.println("5.  Ver el número de la cuenta");
            System.out.println("6.  Ver los dígitos de control de la cuenta");
            System.out.println("7.  Realizar un ingreso");
            System.out.println("8.  Retirar efectivo");
            System.out.println("9.  Consultar saldo");
            System.out.println("10. Salir de la aplicación");

            System.out.println("-------------------------------------------------------------------");
            System.out.print("Seleccione una opcion (1 - 10): ");
            
            Scanner Scan = new Scanner(System.in);
            String option = Scan.nextLine();
            System.out.println("");
        
            switch(Integer.parseInt(option)){
                case 1:
                    System.out.println("EL CCC del cliente es: " + client1.getClientCCC());
                break;
                case 2:
                    System.out.println("El nombre del titular es: " + client1.getClientName());
                break;
                case 3:
                    System.out.println("El código de la entidad es: " + client1.getEntidad());
                break;
                case 4:
                    System.out.println("El código de la oficina: " + client1.getOficina());
                break;
                case 5:
                    System.out.println("El número de la cuenta es: " + client1.getNumCuenta());
                break;
                case 6:
                    System.out.println("Los dígitos de control de la cuenta son: " + client1.getDigContol());
                break;
                case 7:
                   client1.inDeposit();
                break;
                case 8:
                    client1.outDeposit();
                break;
                case 9:
                    System.out.println("El saldo de la cuenta es: " + client1.getSaldo()+"€");
                break;
                case 10:
                    a= true;
                break;
                default:
                    System.out.println("Debe seleccionar una opcion valida."); 
            }
        }while(a != true);
    }  
    
}
