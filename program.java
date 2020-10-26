package calcapp;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.io.*;

public class program {
	
	static int last = 10;
	static int numbers[]  =     {1,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 };
	static String letters[]  =  { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX","X"};
	 
	    public static void main(String[] args) {
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print(">> ");
	    	String inputString = getInput();
	    	
	 
	    	
	    	String operator = Operator(inputString);
	    	int num = Integer.parseInt(Num(inputString));
	    	int num1 = Num1(inputString);
	    	
	    	int res = num+num1;
	    	String numRome = Integer.toString(res);
	    	
	    	System.out.print(inRome(numRome));
	    

			    
	    	
	}
	    
	    
	    //Ввод
	    public static String getInput() {
	    	try (Scanner scanner = new Scanner(System.in)) {
	    		return scanner.next();
	        }
	    }
	    
	    //Первое вхождение
	    public static String Num(String inputString) {
	        String pattern = ("\\d+");
	        Pattern ptrn = Pattern.compile(pattern);
	        Matcher matcher = ptrn.matcher(inputString);
	        String result = "";
	        if(matcher.find()){
	        	result = matcher.group(0);
	        }
	    return result;	
	    }
	        
	    //Оператор
	    public static String Operator(String inputString) {
	        String pattern = "(\\D)";
	        Pattern ptrn = Pattern.compile(pattern);
	        Matcher matcher = ptrn.matcher(inputString);
	        String result = "";
	        if(matcher.find()){
	        	result = matcher.group(0);
	        }
	    return result;	
	    }
	    
	    //оператор для рим 
	    public static String OperatorRome(String inputString) {
	        String pattern = "([^IVX])";
	        Pattern ptrn = Pattern.compile(pattern);
	        Matcher matcher = ptrn.matcher(inputString);
	        String result = "";
	        if(matcher.find()){
	        	result = matcher.group(0);
	        }
	    return result;	
	    }
	    
	    //Второе вхождение
	    public static int Num1(String inputString) {
	        int result = 0;
	        int start = 0;
	        Pattern pattern = Pattern.compile("\\d+");
	        Matcher matcher = pattern.matcher(inputString);
	        
	        while (matcher.find(start)) {
	           String value = inputString.substring(matcher.start(), matcher.end());
	           result = Integer.parseInt(value);
	           start = matcher.end();
	        }
		return result;	
		}
	    
	    //"I", "II", "II", "IV", "V", "VI", "VII", "VIII", "IX","X"
	    private static int inArab(String letter){
	        if(letter.equals("I") )
	                return 1;
	        else if(letter.equals("II"))
	            return 2;
	        else if(letter.equals("III"))
	            return 3;
	        else if(letter.equals("IV"))
	            return 4;
	        else if(letter.equals("V"))
	            return 5;
	        else if(letter.equals("VI"))
	            return 6;
	        else if(letter.equals("VII"))
	            return 7;
	        else if(letter.equals("VIII"))
	            return 8;
	        else if(letter.equals("IX"))
	            return 9;
	        else if(letter.equals("X"))
	            return 10;
	        else return -1;
	    }
	    
	    private static String inRome(String letter){
	        if(letter.equals("1") )
	                return ("I");
	        else if(letter.equals("2"))
	            return ("II");
	        else if(letter.equals("3"))
	            return ("III");
	        else if(letter.equals("4"))
	            return ("IV");
	        else if(letter.equals("5"))
	            return ("V");
	        else if(letter.equals("6"))
	            return ("VI");
	        else if(letter.equals("7"))
	            return "VII";
	        else if(letter.equals("8"))
	            return "VIII";
	        else if(letter.equals("9"))
	            return ("IX");
	        else if(letter.equals("10"))
	            return ("X");
	        else return "Нет такой цифры";
	    }
}
	   
