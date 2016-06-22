package GoToCoding;

import java.util.HashSet;

/**
 * Created by User-pc on 21.06.2016.
 */
public class SuperShip {
    private HashSet<String> place;
    public String Action(String act) {

        //TODO: check string(is it correct action? (C5, A5, A1), not(C 5, 5C, A0, CC5, c5 etc))

        String res = "Missed.";

        if (place.contains(act)) {
            res = "Right on target!";
            place.remove(act);
        }

        if (place.isEmpty()) {
            res = "Flooded the entire ship!";
        }

        return res;
    }
    public SuperShip(int length) {
        this.place = new HashSet<>();
        Integer randomX = (int) (Math.random() * 5) + 1;
        for (int i = 0; i < length; i++) {
            this.place.add(String.valueOf(randomX + i));
        }
    }
    public SuperShip(String[] coordinates) {
        this.place = new HashSet<>();
        for (String s : coordinates) {
            this.place.add(s);
        }
    }
}
