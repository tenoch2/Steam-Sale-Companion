
public class HTMLDecoder 
{
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
    
    private static String tagCheck(String string)
    {
        tagAssignment(string, "<br>", "\n");
        tagAssignment(string, "<li>", "");
        tagAssignment(string, "</li>", "");
        
        
        
        return string;
    }
    
    private static String tagAssignment(String string, String tag, String replaceWith)
    {
        String result = string;
        if(string.contains(tag))
            result = string.replace(tag, replaceWith);
        return result;
    }
}
