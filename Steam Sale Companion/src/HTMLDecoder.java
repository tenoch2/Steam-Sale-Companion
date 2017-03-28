
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class HTMLDecoder 
{
    private static final HashMap<String, String> codex = getCodex();
    
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
            String inter = "";
            if(string.contains("<"))
                inter = tagCheck(string);
            result += inter;
        }
        
        return result;
    }
    
    private static String tagCheck(String string)
    {
        String result = string;
        Set s = codex.keySet();
        ArrayList<String> l = (ArrayList) s;
        for(String key : l)
        {
            if(result.contains(key))
                result.replace(key, codex.get(key));
        }
        
        return result;
    }

    
    public static HashMap getCodex()
    {
        HashMap hm = new HashMap();
        
        hm.put("<br>", "\n");
        hm.put("<li>", "");
        hm.put("</li>", "");
        
        return hm;
    }
}
