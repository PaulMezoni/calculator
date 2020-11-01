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
	

	static String rome[]  =  { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX","X"};
	static String numbers[]  =  { "1", "2", "3", "4", "5", "6", "7", "8", "9","10"};

	    public static void main(String[] args) {
	
	    	Scanner scanner = new Scanner(System.in);
	    	String inputString = getInput();
	    	
	    	int Num1 = 0;
	    	int Num2 = 0;
	    	int answer = 0;
	    	String string1 = "0";
	    	String string2 = "0";
	        int operator = Operator(inputString);
	        
	        //проверяем отсутствие буквенных символов 
	        if(noString(inputString)) {
	        	System.out.println("Введите римские или арабские цыфры >>");
	        }
	        
	        //проверка оператора делим строку
	       	if(operator > 0) {
		       	string1 = num1(inputString);
		       	string2 = num2(inputString);
	       	}else {
	       		System.out.println("Введите оператор >>");
	       	}
	       	//проверка 0 при вводе
	       	if(string1 == "0" & string2 == "0"){
	       		System.out.println("Число не меньше 1 >> ");
	       	}
	       	 	
            //проверка ввода римских чисел
            if(Arrays.asList(rome).contains(string1) & Arrays.asList(rome).contains(string2)) {
            	answer = calculate(romanToNumber(string1), romanToNumber(string2), operator);
            	System.out.print(RomanNumerals(answer));
            }
	       	//проверка ввода арабских чисел
            if(Arrays.asList(numbers).contains(string1) & Arrays.asList(numbers).contains(string2)){
            	answer = calculate(Integer.parseInt(string1), Integer.parseInt(string2), operator);
            	System.out.print(answer);
            }
        
	       	if(Integer.parseInt(string1) > 10 & Integer.parseInt(string2) > 10){
	       		System.out.println("Число не больше 10 >> ");
	       	}

	       	
	        
	        
}    	
	    //Проверка ввода
	    public static boolean noString(String inputString) {
	        return inputString.matches("[a-zA-Z]+");
	    }
	
	    //Ввод
	    public static String getInput() {
	    	System.out.print(": ");
	    	try (Scanner scanner = new Scanner(System.in)) {
	    		return scanner.next();
	        }
	    }
	   
	   //Калькулятор
	    public static int calculate(int number1, int number2, int operation){
	         int result = 0;
	         switch (operation){
	                case 1: result = number1 + number2; break;
	                case 2: result = number1 - number2; break;
	                case 3: result = number1 * number2; break;
	                case 4: result = number1 / number2; break;
	                default:throw  new IllegalArgumentException("Не верный знак операции");
	         }
	         return result;
	    }
	    
	    //оператор
	    public static int Operator(String inputString) {

	    	if(inputString.indexOf('+') != -1) {
	    		return 1;
	    	}
	    	else if(inputString.indexOf('-') != -1) {
	    		return 2;
	    	}
	    	else if(inputString.indexOf('*') != -1) {
	    		return 3;
	    	}
	    	else if(inputString.indexOf('/') != -1) {
	    		return 4;
	    	}else {
	    		return -1;
	    	}
	    	
	    	
	    }
	    
	    //индекс оператора в строке для разбития строки на подстроки.
	    public static int OperatorIndex(String inputString) {

	    	int index1 = inputString.indexOf('+');
	    	int index2 = inputString.indexOf('-');
	    	int index3 = inputString.indexOf('*');
	    	int index4 = inputString.indexOf('/');
	    	
	     	if(inputString.indexOf('+') != -1) {
	    		return index1;
	    	}
	    	else if(inputString.indexOf('-') != -1) {
	    		return index2;
	    	}
	    	else if(inputString.indexOf('*') != -1) {
	    		return index3;
	    	}
	    	else if(inputString.indexOf('/') != -1) {
	    		return index4;
	    	}else {
	    		return -1;
	    	}
	    	
	    }
	    //Строка 1 по опреатору
	    public static String num1(String inputString) {
	    	int index = OperatorIndex(inputString);
	    	String result = inputString.substring(0, index);
	    	return result;
	    }
	    //Строка 2 по оператору
	    public static String num2(String inputString) {
	    	String result = "?";
	    	//int InputStringLength = inputString.length();
	    	int index = OperatorIndex(inputString);
	    	result = inputString.substring(index+1, inputString.length());
	    	return result;
	    }
	    //перевод в арабские )
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

	    
	    //Загуглено и работает перевод в римские
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
