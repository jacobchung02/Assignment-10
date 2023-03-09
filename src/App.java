import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;


public class App 
{
    public static void main(String[] args) throws Exception 
    {
        // Check if user entered anything at all.
        String errorMsg = "Try again. Please input a valid password.";
        if(args.length == 0)
        {
            System.out.println(errorMsg);
            System.exit(1);
        }

        String password = args[0];  // Set password to first argument given.
        System.out.println("Your password is: " + password);

        // Test password length. 8-16 characters accepted (inclusive).
        int len = password.length();
        if (len < 8 || len > 16)
        {
            System.out.println(errorMsg);
            System.exit(0);
        }

        // Sets in this example are small, could use Hash or Tree.
        Set<Character> upperCaseLetters = new TreeSet<>();
        Set<Character> lowerCaseLetters = new TreeSet<>();
        Set<Character> numbers = new TreeSet<>();
        Set<Character> symbols = new TreeSet<>();

        Map<String, Integer> count = new TreeMap<>();

        // Add upper and lowecase letters to their corresponding sets.
        for (int i = (int)'A'; i <= (int)'Z'; i++)
        {
            Character c = (char) i;
            upperCaseLetters.add(c);
            lowerCaseLetters.add(Character.toLowerCase(c));
        }

        // Add digits into set of numbers.
        for (int i = (int)'0'; i <= (int)'9'; i++)
        {
            Character c = (char) i;
            numbers.add(c);
        }

        // Add symbols into set of symbols.
        String str = "~!@#$%^&*()-=+_";
        for (Character c: str.toCharArray())
        {
            symbols.add(c);
        }

        // Check each character in password and track which category each belongs to.
        for (Character c: password.toCharArray())
        {
            String key = "lowerCaseLetters";
            if (lowerCaseLetters.contains(c))
            {
                if (count.containsKey(key))  // Additional occurences.
                {
                    count.put(key, count.get(key) + 1);
                }
                else  // First occurrence.
                {
                    count.put(key, 1);
                }
            }

            key = "upperCaseLetters";
            if (upperCaseLetters.contains(c))
            {
                if (count.containsKey(key))  
                {
                    count.put(key, count.get(key) + 1);
                }
                else 
                {
                    count.put(key, 1);
                }
            }

            key = "numbers";
            if (numbers.contains(c))
            {
                if (count.containsKey(key))  
                {
                    count.put(key, count.get(key) + 1);
                }
                else  
                {
                    count.put(key, 1);
                }
            }

            key = "symbols";
            if (symbols.contains(c))
            {
                if (count.containsKey(key)) 
                {
                    count.put(key, count.get(key) + 1);
                }
                else 
                {
                    count.put(key, 1);
                }
            }
        }

        for (Entry<String, Integer> entry : count.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Check if at least 3 categories are satisfied.
        if (count.size() < 3)
        {
            System.out.println("Try again. Please input a valid password with a combination of at least three different categories of characters.");
            System.exit(0);
        }

        System.out.println("Password satisfies all requirements.");
    }
}
