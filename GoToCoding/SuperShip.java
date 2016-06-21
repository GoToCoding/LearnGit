package GoToCoding;

/**
 * Created by User-pc on 21.06.2016.
 */
public class SuperShip {
    private int[] place;
    private boolean[] wasKilled;
    private int cnt;
    public String Action(String act) {
        String res = "Missed.";
        int x;
        try {
            x = Integer.parseInt(act);
        }
        catch (Exception e) {
            return "You`ve entered not a number";
        }

        for(int i = 0; i < place.length; i++) {
            if(place[i] == x) {
                if(wasKilled[i]) {
                    res = "You are already shot here! =/";
                } else {
                    wasKilled[i] = true;
                    res = "Right on target!";
                    cnt++;
                }
                break;
            }
        }

        if(cnt == place.length) {
            res = "Flooded the entire ship!";
        }

        return res;
    }
    public SuperShip(int a) {
        place = new int[a];
        wasKilled = new boolean[place.length];
        int randomX = (int)Math.random() * 5 + 1;
        for(int i = 0; i < a; i++) {
            place[i] = randomX + i;
        }
    }
}
