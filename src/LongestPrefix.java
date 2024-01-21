public class LongestPrefix {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        String[][] words = {{"flower", "flow", "flight"}, {"dog", "racecar", "car"}, {""}, {"a"}, {"ab", "a"}};
        for (String[] word : words) {
            result.append("\"").append(longestCommonPrefix(word)).append("\" ");
        }
        System.out.println(result);
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int indexOfChar = 0;

        if (strs.length > 0 && strs[0].length() > 0) {
            l:
            while (true) {
                String charForEquals = "";
                for (int i = 0; i < strs.length; i++) {
                    boolean lastWord = i == strs.length - 1;
                    String str = strs[i];
                    if (i == 0 && str.length() > indexOfChar) {
                        charForEquals = String.valueOf(str.charAt(indexOfChar));
                    } else if (str.length() <= indexOfChar) {
                        break l;
                    }
                    String currentChar = String.valueOf(str.charAt(indexOfChar));
                    if (charForEquals.equals(currentChar)) {
                        charForEquals = currentChar;
                    } else {
                        break l;
                    }
                    if (lastWord) {
                        result.append(charForEquals);
                        indexOfChar++;
                    }
                }
            }
        }

        return result.toString();
    }

}
