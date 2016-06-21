package GoToCoding;

import java.util.HashSet;

/**
 * Created by User-pc on 21.06.2016.
 */
public class SuperShip {
    private HashSet<Integer> place;
    public String Action(String act) {
        String res = "Missed.";
        int x;
        try {
            x = Integer.parseInt(act);
        }
        catch (Exception e) {
            return "You`ve entered not a number";
        }

        if(place.contains(x)) {
            res = "Right on target!";
            place.remove(x);
        }

        if(place.isEmpty()) {
            res = "Flooded the entire ship!";
        }

        return res;
    }
    public SuperShip(int length) {
        this.place = new HashSet<>();
        int randomX = (int) (Math.random() * 5) + 1;
        for(int i = 0; i < length; i++) {
            this.place.add(randomX + i);
        }
    }
}
