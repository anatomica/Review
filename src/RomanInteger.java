public class RomanInteger {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        String[] romans = {"III", "LVIII", "MCMXCIV"};
        for (String rom : romans) {
            result.append(romanToInt(rom)).append(" ");
        }
        System.out.println(result);
    }

    private static int romanToInt(String rom) {
        int result = 0;
        for (int i = 0; i < rom.length(); i++) {
            boolean finalChar = i == rom.length() - 1;
            String nextChar = !finalChar ? String.valueOf(rom.charAt(i + 1)) : "";
            switch (rom.charAt(i)) {
                case 'I': {
                    result += Roman.X.name().equals(nextChar) ? Roman.X.getNumber() - Roman.I.getNumber()
                            : (Roman.V.name().equals(nextChar) ? Roman.V.getNumber() - Roman.I.getNumber()
                            : Roman.I.getNumber());
                    if (Roman.X.name().equals(nextChar) || Roman.V.name().equals(nextChar)) i++;
                    break;
                }
                case 'X': {
                    result += Roman.L.name().equals(nextChar) ? Roman.L.getNumber() - Roman.X.getNumber()
                            : (Roman.C.name().equals(nextChar) ? Roman.C.getNumber() - Roman.X.getNumber()
                            : Roman.X.getNumber());
                    if (Roman.L.name().equals(nextChar) || Roman.C.name().equals(nextChar)) i++;
                    break;
                }
                case 'C': {
                    result += Roman.D.name().equals(nextChar) ? Roman.D.getNumber() - Roman.C.getNumber()
                            : (Roman.M.name().equals(nextChar) ? Roman.M.getNumber() - Roman.C.getNumber()
                            : Roman.C.getNumber());
                    if (Roman.D.name().equals(nextChar) || Roman.M.name().equals(nextChar)) i++;
                    break;
                }
                case 'V': {
                    result += Roman.V.getNumber();
                    break;
                }
                case 'L': {
                    result += Roman.L.getNumber();
                    break;
                }
                case 'D': {
                    result += Roman.D.getNumber();
                    break;
                }
                case 'M': {
                    result += Roman.M.getNumber();
                    break;
                }
            }
        }
        return result;
    }

    private enum Roman {

        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private final int number;

        Roman(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

}
