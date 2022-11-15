package LaberintoLQ;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Laberinto {

    public static void main(String[] args) {
        int aleatorio, colInicial, filInicial;
        Scanner escaner = new Scanner(System.in);
        System.out.print("Cantidad de filas: ");
        int filas = escaner.nextInt();
        System.out.print("Cantidad de columnas: ");
        int columnas = escaner.nextInt();
        String laberinto[][] = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {       //RELLENAR LABERINTO CON "US"
            for (int j = 0; j < columnas; j++) {
                laberinto[i][j] = "US";
            }
        }
        //  buscar un LQ aleatorio
        aleatorio=(int) (Math.random()*filas*columnas);
        colInicial=(int) (aleatorio/columnas);
        filInicial=(int) (aleatorio/filas);
        System.out.println("aleatorio: "+aleatorio);
        System.out.println("Col_"+colInicial+" Fila_"+filInicial);
        laberinto[filInicial][colInicial]="LQ";
        
       do{ 
        if(colInicial>0)          if(laberinto[filInicial][colInicial-1].equals("US"))  laberinto[filInicial][colInicial-1]="PE";
        if(colInicial<columnas-1) if(laberinto[filInicial][colInicial+1].equals("US"))  laberinto[filInicial][colInicial+1]="PE";
        if(filInicial>0)          if(laberinto[filInicial-1][colInicial].equals("US"))  laberinto[filInicial-1][colInicial]="PE";
        if(filInicial<filas-1)    if(laberinto[filInicial+1][colInicial].equals("US"))  laberinto[filInicial+1][colInicial]="PE";
        
        for (int i = 0; i < filas; i++) {       //IMPRIMIR LABERINTO
            for (int j = 0; j < columnas; j++) {
                System.out.print(laberinto[i][j] + " ");
            }
            System.out.println("");
        }
        aleatorio=(int) (Math.random()*4);
        System.out.println(aleatorio);
        etiqueta:
        switch(aleatorio)
        {
            case 0: if (colInicial>0 && laberinto[filInicial][colInicial-1]=="PE") {
                            colInicial=colInicial-1;
                            break;
                    }
                    else aleatorio=1;
            case 1: if (colInicial<columnas-1 && laberinto[filInicial][colInicial+1]=="PE") {
                            colInicial=colInicial+1;
                            break;
                    }
                    else aleatorio=2;
            case 2: if (filInicial>0 && laberinto[filInicial-1][colInicial]=="PE") {
                            filInicial=filInicial-1;
                            break;
                    }
                    else aleatorio=3;
            case 3: if(filInicial<filas-1 && laberinto[filInicial+1][colInicial]=="PE"){
                            filInicial=filInicial+1; 
                            break;
                        } 
                    else{aleatorio=0;
                            break etiqueta;}
        }
        laberinto[filInicial][colInicial]="LQ";
        System.out.println("Col_"+colInicial+" Fila_"+filInicial);
        System.out.println(aleatorio);
        limpiarAnt();
           System.out.println("-----------------------");
           System.out.println("-----------------------");
           System.out.println("-----------------------");
           System.out.println("-----------------------");
           System.out.println("-----------------------");
           System.out.println("-----------------------");
        /*
        for (int i = 0; i < filas; i++) {       //IMPRIMIR LABERITNO
            for (int j = 0; j < columnas; j++) {
                System.out.print(laberinto[i][j] + " ");
            }
            System.out.println("");
        }*/
       }while(true) ;
    }


    public static void limpiarAnt(){
        try{
            System.out.println("Presione enter para continuar...");
            new java.util.Scanner(System.in).nextLine();

            Robot limpiar = new Robot();
            limpiar.keyPress(KeyEvent.VK_CONTROL);
            limpiar.keyPress(KeyEvent.VK_L);
            limpiar.keyRelease(KeyEvent.VK_CONTROL);
            limpiar.keyRelease(KeyEvent.VK_L);
            
        }  catch (Exception e) {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());
        }
    }


}