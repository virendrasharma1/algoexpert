package strings;

public class oneEdit {

    public static boolean oneEditImpl(String stringOne, String stringTwo) {


        if (Math.abs(stringOne.length() - stringTwo.length()) > 1) {
            return false;
        }
        int indexOne = 0;
        int indexTwo = 0;

        while (indexOne < stringOne.length() && indexTwo < stringTwo.length()) {
            char characterOne = stringOne.charAt(indexOne);
            char characterTwo = stringTwo.charAt(indexTwo);
            if (!(characterOne == characterTwo)) {
                StringBuilder sbOne = new StringBuilder(stringOne);
                StringBuilder sbTwo = new StringBuilder(stringTwo);
                if (stringOne.length() == stringTwo.length()) {
                    sbOne.deleteCharAt(indexOne);
                    sbTwo.deleteCharAt(indexTwo);
                    return sbOne.compareTo(sbTwo) == 0;
                } else if (stringOne.length() > stringTwo.length()) {
                    sbOne.deleteCharAt(indexOne);
                    return sbOne.compareTo(sbTwo) == 0;
                } else {
                    sbTwo.deleteCharAt(indexTwo);
                    return sbTwo.compareTo(sbOne) == 0;
                }
            } else {
                indexOne++;
                indexTwo++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneEditImpl("abc", "acd"));
    }
}
