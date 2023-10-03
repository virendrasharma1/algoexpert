package strings;

public class runLengthEncoding {

    public static String runLengthEncodingImpl(String string) {
        int numberOfLetters = 1;
        StringBuilder letter = new StringBuilder();


        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(i - 1) || (numberOfLetters == 9)) {
                letter.append(numberOfLetters).append(string.charAt(i-1));
                numberOfLetters = 0;
            }
            numberOfLetters++;
        }
        letter.append(numberOfLetters).append(string.charAt(string.length()-1));
        // Write your code here.
        return letter.toString();
    }

    public static void main(String[] args) {
        System.out.println(runLengthEncodingImpl("aA"));
    }
}
