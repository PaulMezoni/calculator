package calcapp;
import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
//import java.io.*;

public class program {
	

	static String romeNumArr[]  =  { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX","X"};

	    public static void main(String[] args) {
	    	//int number1 = 0;
	    	//int number2 = 0;
	    	int counter = 0;
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print(">> ");
	    	String inputString = getInput();
	    	
	    	int operator = Operator(inputString);
	    	String Num1 = num1(inputString);
	    	String Num2 = num2(inputString);
	    	
            System.out.println(operator);
            System.out.println(Num1);
            System.out.println(Num2);
            
            
            
	    	
	}
	    
	    
	    
	    
	    //Ввод
	    public static String getInput() {
	    	try (Scanner scanner = new Scanner(System.in)) {
	    		return scanner.next();
	        }
	    }
	    
	    //оператор
	    public static int Operator(String inputString) {

	    	int index1 = inputString.indexOf('+');
	    	int index2 = inputString.indexOf('-');
	    	int index3 = inputString.indexOf('*');
	    	int index4 = inputString.indexOf('/');
	    	
	    	if(index1 > 0) {
	    		return 1;
	    	}
	    	else if(index2 > 0) {
	    		return 2;
	    	}
	    	else if(index3 > 0) {
	    		return 3;
	    	}
	    	else if(index4 > 0) {
	    		return 4;
	    	}else {
	    		return -1;
	    	}
	    	
	    	
	    }
	    
	    
	    //индекс оператора в строке
	    public static int OperatorIndex(String inputString) {

	    	int index1 = inputString.indexOf('+');
	    	int index2 = inputString.indexOf('-');
	    	int index3 = inputString.indexOf('*');
	    	int index4 = inputString.indexOf('/');
	    	
	     	if(index1 > 0) {
	    		return index1;
	    	}
	    	else if(index2 > 0) {
	    		return index2;
	    	}
	    	else if(index3 > 0) {
	    		return index3;
	    	}
	    	else if(index4 > 0) {
	    		return index4;
	    	}else {
	    		return -1;
	    	}
	    	
	    }
	    //Строка 1
	    public static String num1(String inputString) {
	    	
	    	int index = OperatorIndex(inputString);
	    	String result = inputString.substring(0, index);
	    	return result;
	    }
	    //Строка 2
	    public static String num2(String inputString) {
	    	
	    	int InputStringLength = inputString.length();
	    	int index = OperatorIndex(inputString);
	    	String result = inputString.substring(index+1, inputString.length());
	    	return result;
	    }
	     
	    private static int romanToNumber(String roman) {
	        if (roman.equals("I")) {
	            return 1;
	        } else if (roman.equals("II")) {
	            return 2;
	        } else if (roman.equals("III")) {
	            return 3;
	        } else if (roman.equals("IV")) {
	            return 4;
	        } else if (roman.equals("V")) {
	            return 5;
	        } else if (roman.equals("VI")) {
	            return 6;
	        } else if (roman.equals("VII")) {
	            return 7;
	        } else if (roman.equals("VIII")) {
	            return 8;
	        } else if (roman.equals("IX")) {
	            return 9;
	        } else if (roman.equals("X")) {
	            return 10;
	        } else {
	            return -1;
	        }
	    }

	    
	    
		  public static String RomanNumerals(int Int) {
			    LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
			    roman_numerals.put("M", 1000);
			    roman_numerals.put("CM", 900);
			    roman_numerals.put("D", 500);
			    roman_numerals.put("CD", 400);
			    roman_numerals.put("C", 100);
			    roman_numerals.put("XC", 90);
			    roman_numerals.put("L", 50);
			    roman_numerals.put("XL", 40);
			    roman_numerals.put("X", 10);
			    roman_numerals.put("IX", 9);
			    roman_numerals.put("V", 5);
			    roman_numerals.put("IV", 4);
			    roman_numerals.put("I", 1);
			    String res = "";
			    for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
			      int matches = Int/entry.getValue();
			      res += repeat(entry.getKey(), matches);
			      Int = Int % entry.getValue();
			    }
			    return res;
			  }
		  
		  public static String repeat(String s, int n) {
			    if(s == null) {
			        return null;
			    }
			    final StringBuilder sb = new StringBuilder();
			    for(int i = 0; i < n; i++) {
			        sb.append(s);
			    }
			    return sb.toString();
			  }
		  
		  
		  
	    }

	   
	   

	    
	    
	 

	   
