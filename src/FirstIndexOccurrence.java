public class FirstIndexOccurrence {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        String[][][] worlds = {{{"sadbutsad"}, {"sad"}}, {{"leetcode"}, {"leeto"}}, {{"hello"}, {"ll"}}};
        for (String[][] world : worlds) {
            result.append(strStr(world[0][0], world[1][0])).append(" ");
        }
        System.out.println(result);
    }

    private static int strStr(String haystack, String needle) {
        if (!haystack.isEmpty() && !needle.isEmpty()) {
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0) && haystack.length() - i >= needle.length()) {
                    boolean isFound = checkWord(haystack.substring(i, i + needle.length()), needle);
                    if (isFound) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean checkWord(String substring, String needle) {
        boolean eq = false;
        for (int i = 0; i < needle.length(); i++) {
            if (substring.charAt(i) == needle.charAt(i)) {
                eq = true;
            } else {
                eq = false;
                break;
            }
        }
        return eq;
    }

}
