package GoToCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        SuperShip ship = new SuperShip(3);
        
        System.out.println("The game has begun! Ship 3 cells long established");
        int userStep = 0;
        while(true) {
            userStep++;
            System.out.println("Enter the coordinate: ");
            String userString = sc.readLine();
            String res = ship.Action(userString);
            System.out.println(res);
            if(res.equals("Flooded the entire ship!")) {
                System.out.println("You`re used " + userStep + " shots");
                break;
            }
        }
    }
}
