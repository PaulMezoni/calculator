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
	

	static String romeNumArr[]  =  { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX","X","+","-","*","/"};
	static String operArr[]  =  {"+","-","*","/"};

	    public static void main(String[] args) {
	    	//int number1 = 0;
	    	//int number2 = 0;
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print(">> ");
	    	String inputString = getInput();
	    	
	    	
	    	System.out.println(Operator(inputString));

	    	//преобразую в char
	    	char operator = Operator(inputString).charAt(0);
	    	//преобразовываем строку в массив
	    	char[] chArray = inputString.toCharArray();
	    	//перебираем все элементы массива
	    	for(int i = 0; i<chArray.length; i++){
	    		//находим оператор 
	    	if(chArray[i] == (operator)){
	    		//заменяем на пробел
	    		chArray[i] = ' ';

	    		}
	    	}
	    	//Достаем строки
	    	String myStr = String.valueOf(chArray);
	    	String[] word = myStr.split(" ");
	    	//String obj1 = word[0];
	    	//String obj2 = word[1];
	    	
         
              int number1 = romanToNumber(word[0]);
             int  number2 = romanToNumber(word[1]);
     
            
            System.out.println(number1);
            System.out.println(number2);
            
            
            
	    	
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

	   
