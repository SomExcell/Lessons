import Hash.File;

import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        var file = new File("abacaba");
        System.out.println(file.containsSubstring("cac"));
        System.out.println(file.containsSubstring("bab"));
        System.out.println(file.containsSubstring("abacabaa"));
    }
}