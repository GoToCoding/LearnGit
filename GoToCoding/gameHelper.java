package GoToCoding;

import java.util.ArrayList;

/**
 * Created by User-pc on 22.06.2016.
 */
public class gameHelper {
    public static ArrayList<SuperShip> ships;
    public static void createMap() {
        ArrayList<SuperShip> res = new ArrayList<>();
        res.add(new SuperShip(new String[]{"A1", "A2", "A3", "A4"}));
        res.add(new SuperShip(new String[]{"B6", "C6", "D6", "E6"}));
        res.add(new SuperShip(new String[]{"G3", "G4", "G5", "G6"}));
        ships = res;
    }
    public static String giveResult(String userString) {
        String res = "Missed.";
        for (int i = 0; i < ships.size(); i++) {
            String s = ships.get(i).Action(userString);
            if (!s.equals("Missed.")) {
                res = s;
                if (s.equals("Flooded the entire ship!")) {
                    ships.remove(i);
                }
                break;
            }
        }
        if (ships.size() == 0) {
            res = "You have flooded all ships!";
        }
        return res;
    }


}
