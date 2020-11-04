package calcapp;
import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.stream.IntStream;
//import java.io.*;

public class program {
	

	static String romeNum[]  =  { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX","X"};
	static String arabNum[]  =  { "1", "2", "3", "4", "5", "6", "7", "8", "9","10"};
	//static String simbol[] = {"+","-","*","/"};
	
	    public static void main(String[] args) {
	    	
	    	int z = 1;
	    	Scanner scanner = new Scanner(System.in);
	    	
	while(z > 0){
		
			boolean Flag = false;
			System.out.print(" ");
    		String inputString = scanner.next();
    		
    		String string1 = "0";
    		String string2 = "0";
    		
    		int Num1 = 0;
    		int Num2 = 0;
    		
    		if(OperatorIndex(inputString) < 0) {
    			System.out.println("Вы не ввели оператор >> ");
    			break;
    		}else {
    			string1 = num1(inputString);
    		}
    		
    		if(string1.length() < 1) {
    			System.out.println("Вы не ввели первый символ >>");
    			break;
    		}else {
    			string2 = num2(inputString);
    		}
    		
    		if(string2.length() < 1) {
    			System.out.println("Вы не ввели второй символ >>");
    			break;
    		}
    			
    		if(Arrays.asList(romeNum).contains(string1) & Arrays.asList(romeNum).contains(string2)){
    			Flag = false;
    			Num1 = romanToNumber(string1);
    			Num2 = romanToNumber(string2);
    			
    		}else if(Arrays.asList(romeNum).contains(string1) != Arrays.asList(romeNum).contains(string2)){
    			System.out.println("Такой формат ввода исключен: "+string1+" и "+string2+", только римские или арабские >>");
    		}
    		
    		if(Arrays.asList(arabNum).contains(string1) & Arrays.asList(arabNum).contains(string2)){
    			Flag = true;
    			Num1 = Integer.parseInt(string1);
    			Num2 = Integer.parseInt(string2);
    		}
    		
    		if(Num1 < 1 || Num1 > 10) {
    			System.out.println("Только целые числа от 1 до 10 >>");
    		}
    		
    		int answer = calculate(Num1, Num2, Operator(inputString));
    		
    		if(Flag == true) {
    			System.out.println(answer);
    		}
    		if(Flag == false) {
    			System.out.println(RomanNumerals(answer));
    		}
    
   
	    	
	}	        
} 
	    
	 	
	    //Ввод
	    public static String getInput() {
	    	
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
	    	String result = "0";
	    	int index = OperatorIndex(inputString);
	    	if(OperatorIndex(inputString) != -1) {
	    		result = inputString.substring(index+1, inputString.length());
	    		return result;
	    	}else {
	    		return "0";
	    	}
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
