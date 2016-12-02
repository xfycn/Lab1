package lab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class sim {
	public static String simplify(String str,String str1,String regex,String replace){
	         
	          Pattern p0 = Pattern.compile(regex);
	          Matcher m2 = p0.matcher(str);
	          str = m2.replaceAll(replace);
	          return str;
	        }

	      
	      
		
	}


