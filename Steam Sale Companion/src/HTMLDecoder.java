
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class HTMLDecoder 
{   
    /**
     * returns the input String with the HTML
     * tags accounted for in format or removes them
     * @param input
     * @return 
     */
    public static String decode(String input)
    {
        String[] split = input.split(" ");
        String result = "";
        for(String string : split)
        {
            if(string.contains("<"))
                string += string.replace("<br/>", "\n") + " ";
            result += string + " ";
        }
        
        return result;
    }

    private static String tageHandler(String string) 
    {
        String result = string;
        
        return result;
    }
}
