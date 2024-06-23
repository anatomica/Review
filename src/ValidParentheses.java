public class ValidParentheses {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        String[] words = {"()", "()[]{}", "{[]}", "((", "(]", "([)]", "[", "]", "){", "[({(())}[()])]"};
        for (String word : words) {
            result.append("\"").append(isValid(word)).append("\" ");
        }
        System.out.println(result);
    }

    private static boolean isValid(String s) {
        int[] indicesOpen = new int[10000];
        boolean result = true;
        int haveOpened = 0;
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (result) {
                switch (s.charAt(i)) {
                    case '(':
                    case '[':
                    case '{':
                        indicesOpen[counter] = i;
                        haveOpened++;
                        counter++;
                        break;
                    case ')':
                        if ('(' != (counter > 0 ? s.charAt(indicesOpen[counter - 1]) : 0)) {
                            result = false;
                        }
                        haveOpened--;
                        counter--;
                        break;
                    case ']':
                        if ('[' != (counter > 0 ? s.charAt(indicesOpen[counter - 1]) : 0)) {
                            result = false;
                        }
                        haveOpened--;
                        counter--;
                        break;
                    case '}':
                        if ('{' != (counter > 0 ? s.charAt(indicesOpen[counter - 1]) : 0)) {
                            result = false;
                        }
                        haveOpened--;
                        counter--;
                        break;
                }
            }
        }
        return result && haveOpened == 0;
    }

}
