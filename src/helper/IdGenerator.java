package helper;

public class IdGenerator {

    // length 3 =>  id: 5  -> 005
    private static int length = 10;

    public static String generate(int number, Class<?> classToGenerate) {

        char fill = '0';

        String toPad = String.valueOf(number);

        if (length < toPad.length()) {
            length = toPad.length();
        }

        return classToGenerate.getSimpleName().charAt(0) +
                new String(new char[length - toPad.length()]).replace('\0', fill) + toPad;
    }

}
