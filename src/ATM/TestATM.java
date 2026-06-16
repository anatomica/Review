package ATM;

import java.util.Map;

public class TestATM {

    private static ATM atm = new ATM();

    public static void main(String[] args) {
        atm.insert(Map.of(50, 3, 100, 5, 1000, 3));
        atm.getMoney(1500);
        atm.getMoney(2000);
        atm.getMoney(1000);
    }
}
