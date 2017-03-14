
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
            string = tagCheck(string);
            result += string + " ";
        }
        
        return result;
    }
    
    /**
     * returns the provided string with the HTML
     * tags accounted for and dealt with 
     * @param string
     * @return 
     */
    private static String tagCheck(String string)
    {
        tagAssignment(string, "<br>", "\n");
        tagAssignment(string, "<li>", "");
        tagAssignment(string, "</li>", "");
        
        
        
        return string;
    }
    
    /**
     * returns the input string with the HTML tags provided with
     * with the provided string to replace them
     * @param string
     * @param tag
     * @param replaceWith
     * @return 
     */
    private static String tagAssignment(String string, String tag, String replaceWith)
    {
        String result = string;
        if(string.contains(tag))
            result = string.replace(tag, replaceWith);
        return result;
    }
}
