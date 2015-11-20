public class stringMethodsQuizRunner
{

    public static void main (String[] args)
    {
        stringMethodsQuiz a = new stringMethodsQuiz();

        System.out.println(a.makeOutWord("<<>>", "Yay"));// <<Yay>>
        System.out.println(a.makeOutWord("<<>>", "WooHoo"));// <<WooHoo>>
        System.out.println(a.makeOutWord("[[]]", "word"));// [[word]]
        System.out.println(a.makeOutWord("HHoo", "Hello"));// HHHellooo
        System.out.println(a.makeOutWord("abyz", "YAY"));// abYAYyz

        System.out.println(a.endsLy("oddly"));// true
        System.out.println(a.endsLy("lyly"));// true
        System.out.println(a.endsLy("oddl"));// false
        System.out.println(a.endsLy("y"));// false
        System.out.println(a.endsLy(""));// false

        System.out.println(a.conCat("abc", "cat"));// abcat
        System.out.println(a.conCat("dog", "cat"));// dogcat
        System.out.println(a.conCat("abb", "bat"));// abbat
        System.out.println(a.conCat("pig", "g"));// pig
        System.out.println(a.conCat("abc", ""));// abc


        System.out.println(a.catDog("dogcatdogcat"));// true
        System.out.println(a.catDog("dogcat"));// true
        System.out.println(a.catDog("dogdogcat"));// false
        System.out.println(a.catDog("dog"));// false
        System.out.println(a.catDog(""));// true


        System.out.println(a.repeatEnd("Hello", 3));// llollollo
        System.out.println(a.repeatEnd("abc", 3));// abcabcabc
        System.out.println(a.repeatEnd("Hello", 0));// *empty string*
        System.out.println(a.repeatEnd("1234", 2));// 3434
        System.out.println(a.repeatEnd("1234", 1));// 4
    }
}
