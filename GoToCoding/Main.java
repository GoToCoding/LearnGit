package GoToCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Hi");

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        gameHelper.createMap();

        System.out.println("The game has begun! 3 Ship 4 cells long established\n" +
        "We have a map 7x7\n" +
        "You can shot writing A1, A2 or G7\nWe have map A1-G7\n");
        int userStep = 0;
        while (true) {
            userStep++;
            System.out.println("Enter the coordinates: ");
            String userString = sc.readLine();
            String res = gameHelper.giveResult(userString);
            System.out.println(res);
            if(res.equals("You have flooded all ships!")) {
                System.out.println("You`re used " + userStep + " shots");
                break;
            }
        }
        sc.readLine();
    }
}
