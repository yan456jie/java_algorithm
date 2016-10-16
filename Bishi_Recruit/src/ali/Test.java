package ali;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String s = "s55yy55zxv85w5581";
        System.out.println(fun(s));
    }
    
        
    public static int fun(String s){
    	Map<String,Integer> map = new HashMap<String, Integer>();
    	Pattern p=Pattern.compile("(\\d+)");   
        Matcher m=p.matcher(s);
        while(m.find()){
        	String temp = m.group(1);
            if(map.containsKey(temp)){
            	map.put(temp, map.get(temp)+1);
            }else{
            	map.put(temp, 1);
            }
        }
        int max=0;
        String su = "";
        for (Entry<String, Integer> entry : map.entrySet()) {
        	if(entry.getValue()>max){
        		max=entry.getValue();
        		su = entry.getKey();
        	}
        }
        return Integer.parseInt(su)*max;
    }
}
