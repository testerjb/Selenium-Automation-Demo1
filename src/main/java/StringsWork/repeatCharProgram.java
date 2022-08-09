package StringsWork;

public class repeatCharProgram {
    public static void main(String[] args) {
        repeatCharProgram thisClass = new repeatCharProgram();
        String str1 =  "WinterIsComming";
        System.out.println("The given string is: "+str1);
        System.out.println("The new string is: " + thisClass.repeatAllTwice(str1));

    }

    public static String repeatAllTwice(String someChar) {
        int len = someChar.length();
        String newstring = "";

        for (int i= 0; i< len; i++) {
            newstring += someChar.substring(i,i+1) + someChar.substring(i, i+1);
        }
        return newstring;
    }
}
