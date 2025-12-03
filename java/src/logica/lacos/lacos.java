
package logica.lacos;
import java.util.Scanner;
public class lacos {
    public static void main(String[] args) {
 Scanner fabio = new Scanner(System.in);
    System.out.println("Digite um numero para ver sua tabuada: ");
    int num = fabio.nextInt();

    for (int i = 1; i <= 10; i++) {
        System.out.println( num + "x"+ i + " = " + (i * num));
    }
    fabio.close();
}
}