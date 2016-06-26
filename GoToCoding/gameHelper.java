package GoToCoding;

import java.util.ArrayList;

/**
 * Created by User-pc on 22.06.2016.
 */
public class gameHelper {
    private static boolean goodCoordinates(boolean[][] used, int tx, int ty) {
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int x = tx + i;
                int y = ty + j;
                if ((x >= 0 && x < 7 && y >= 0 && y < 7 && used[x][y])) return false;
            }
        }
        return true;
    }
    public static ArrayList<SuperShip> ships;
    public static void createMap() {
        ArrayList<SuperShip> res = new ArrayList<>();
        boolean[][] used = new boolean[7][7];
        for (int i = 0; i < 3; i++) {
            //For each ship: we will create it and put them to map randomly
            for(int pi = 0; pi < 1000; pi++) {
                //coordinates of head
                int x = (int) (Math.random() * 7);
                int y = (int) (Math.random() * 7);
                int v = (int) (Math.random() * 2); // 0 - horizontal / 1 - vertical
                // Is ShipEnd out of Map?
                if (x + 3 * (v ^ 1) >= 7 || y + 3 * v >= 7) continue;
                boolean goodPlace = true;
                for (int j = 0; j < 4; j++) {
                    int tx = x + j * (v ^ 1);
                    int ty = y + j * v;
                    if (!goodCoordinates(used, tx, ty)) {
                        goodPlace = false;
                        break;
                    }
                }
                if (goodPlace) {
                    //And now, when we sure if this putting is good, we put them

                    String[] place = new String[4];
                    for(int j = 0; j < 4; j++) {
                        int tx = x + j * (v ^ 1);
                        int ty = y + j * v + 1; // index 0 + 1;
                        char cx = (char) ('A' + tx);
                        place[j] = new String(String.valueOf(cx));
                        place[j] += ty;
                        used[tx][ty - 1] = true;
                        //System.out.println(place[j]);
                    }
                    res.add(new SuperShip(place));

                    break;
                }

            }
        }
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
