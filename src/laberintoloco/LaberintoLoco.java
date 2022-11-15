package laberintoloco;
import java.util.Scanner;
/**
 *
 * @author diego
 */
public class LaberintoLoco {

    public static void main(String[] args) {
        System.out.println("***  LABERINTO LOCO  ***");
        int valor;
        int columnas = 0, filas = 0;
        System.out.println("Cantidad de columnas: ");
        Scanner escaner = new Scanner(System.in);
        columnas = escaner.nextInt();
        System.out.println("Cantidad de filas: ");
        filas = escaner.nextInt();
        String laberinto[][] = new String[filas][columnas];
        for (int i = 0; i < filas; i++)  for (int j = 0; j < columnas; j++) {
            valor=(int)(Math.random()*5);
            laberinto[i][j]=(valor==0||valor==1)?"*":" ";
            if (i==0 ||j==0 || i==filas-1 || j==columnas-1)laberinto[i][j]="*";
        }
        //valor=(int)(Math.random()*4);
        //laberinto[1][1]=(valor==0)?"*":" ";
        laberinto[1][1]="";
        
        for (int i = 0; i < filas; i++) {   //Impresión de matriz
            for (int j = 0; j < columnas; j++) {
                System.out.print(laberinto[i][j] + " ");
            }System.out.println("");
        }
        
    }
}
