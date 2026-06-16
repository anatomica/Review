package ATM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {

    private static List<Integer> haveNomenclature = List.of(50, 100, 500, 1000, 5000);

    private static Map<Integer, Integer> haveAtmMoney = new HashMap<>();

    public void insert(Map<Integer, Integer> values) {
        haveAtmMoney.putAll(values);
    }

    public void getMoney(Integer value) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = haveNomenclature.size() - 1; i >= 0; i--) {
            int count = value / haveNomenclature.get(i);

            int existVal = result.getOrDefault(haveNomenclature.get(i), 0);
            int existATM = haveAtmMoney.getOrDefault(haveNomenclature.get(i), 0);

            if (existATM >= count) {
                result.put(haveNomenclature.get(i), existVal + count);

                if (count > 0) {
                    value = value - (count * haveNomenclature.get(i));
                }

                haveAtmMoney.put(haveNomenclature.get(i), existATM - count);
            }
        }

        if (value < 0) {
            throw new RuntimeException("Запрашиваемая сумма не может быть выдана.");
        }
        if (value > 0) {
            throw new RuntimeException("Сумма не кратна номиналу банкнот.");
        }

        System.out.println(result);
    }

}
