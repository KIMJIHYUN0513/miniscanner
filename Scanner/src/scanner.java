import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class scanner {
	public static void main(String[] args) {
		Map<Integer, String> opTable = new HashMap();	// op table 생성
		Map<Integer, String> symbolTable = new HashMap();	// symbol table 생성
		
		// op table key-value 추가
		opTable.put(1,"auto"); 
		opTable.put(2,"break");
		opTable.put(3,"case");
		opTable.put(4,"char");
		opTable.put(5,"const");
		opTable.put(6,"default");
		opTable.put(7,"do");
		opTable.put(8,"double");
		opTable.put(9,"else");
		opTable.put(10,"enum");
		opTable.put(11,"extern");
		opTable.put(12,"short");
		opTable.put(13,"for");
		opTable.put(14,"goto");
		opTable.put(15,"if");
		opTable.put(16,"int");
		opTable.put(17, "long");
		opTable.put(18, "register");
		opTable.put(19, "return");
		opTable.put(20, "float");
		opTable.put(21, "signed");
		opTable.put(22, "sizeof");
		opTable.put(23, "static");
		opTable.put(24, "struct");
		opTable.put(25, "switch");
		opTable.put(26, "typedef");
		opTable.put(27, "union");
		opTable.put(28, "unsigned");
		opTable.put(29, "void");
		opTable.put(30, "volatile");
		opTable.put(31, "while");
		opTable.put(32, "!");
		opTable.put(33, "%");
		opTable.put(34, "&");
		opTable.put(35, "*");
		opTable.put(36, "+");
		opTable.put(37, "-");
		opTable.put(38, "<");
		opTable.put(39, "=");
		opTable.put(40, ">");
		opTable.put(41, "|");
		opTable.put(42, ",");
		opTable.put(43, ";");
		opTable.put(44, "(");
		opTable.put(45, ")");
		opTable.put(46, "[");
		opTable.put(47, "]");
		opTable.put(48, "{");
		opTable.put(49, "}");
		
		// op table 출력
		for(Map.Entry<Integer,String> entry: opTable.entrySet()){
		    System.out.println(entry.getKey()+" - "+ entry.getValue());
		}
		
		try {			
			String fileName = "test.txt";
			
			Scanner scanner = new Scanner(new File(fileName));
			String content;
			for(int i=1; i<110; i++) {
				content = scanner.next();	// spacebar 기준으로 토큰 분리
				System.out.println(content +" is "+ getKey(opTable,content));
				
				// op table에 값이 없는 경우
				if(getKey(opTable,content)==null) {
						symbolTable.put(i,content);		
				}
			}
			// symbol table 출력
			for(Map.Entry<Integer,String> entry: symbolTable.entrySet()){
			    System.out.println(entry.getKey()+" - "+ entry.getValue());
			}

		}catch (FileNotFoundException e) {
			
		}catch (IOException e) {
			System.out.println(e);
		}		
	}
	
	// value로 key 값 검색
	public static <K, V> Integer getKey(Map<Integer, String> opTable, String content) {
		for (Integer key : opTable.keySet()) {
			if (content.equals(opTable.get(key))) {
				return key;
			}
		}
		return null;
	}
}
