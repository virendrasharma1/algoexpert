package strings;

public class caesarCypherEncryptor {

    public static String caesarCypherEncryptorImpl(String str, int key) {
        char[] characterList = new char[str.length()];
        int keyVal = key % 26;

        for (int i = 0; i <str.length() ; i++) {

            characterList[i] = getNew(keyVal, str.charAt(i));
        }
        return new String(characterList);
    }

    public static char getNew(int key, char character) {
        int newLetterCode = key + character;

        if (newLetterCode > 122) {
            newLetterCode = (char) (96 + newLetterCode % 122);
        }
        return (char) newLetterCode;
    }
    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptorImpl("xyz", 2));
    }
}
