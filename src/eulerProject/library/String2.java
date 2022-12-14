package eulerProject.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class String2 {
	private String2() {}

	// This function returns repeating
    // sequence of a fraction. If
    // repeating sequence doesn't
    // exits, then returns empty String
    public static String[] fractionToDecimal(int numr, int denr)
    {
        // Initialize result
        String res = "";
 
        // Create a map to store already
        // seen remainders. Remainder is
        // used as key and its position in
        // result is stored as value.
        // Note that we need position for
        // cases like 1/6.  In this case,
        // the recurring sequence doesn't
        // start from first remainder.
        Map<Integer, Integer> mp = new HashMap<>();
        mp.clear();
 
        // Find first remainder
        int rem = numr % denr;
 
        // Keep finding remainder until
        //  either remainder becomes 0 or repeats
        while ((rem != 0) && (!mp.containsKey(rem)))
        {
            // Store this remainder
            mp.put(rem, res.length());
 
            // Multiply remainder with 10
            rem = rem * 10;
 
            // Append rem / denr to result
            int res_part = rem / denr;
            res += String.valueOf(res_part);
 
            // Update remainder
            rem = rem % denr;
        }
 
        if (rem == 0)
            return new String[]{res, ""};
        else if (mp.containsKey(rem))
            return new String[] {res.substring(0,mp.get(rem)).concat("(").concat(res.substring(mp.get(rem))).concat(")"), res.substring(mp.get(rem))};
 
        return new String[]{res, ""};
    }	
	
	public static String getBinario(Number num) {
		String res="";
		
		if (num instanceof Integer) {
			int nx = num.intValue();
			
			while (nx>1) {
				int n = (nx%2);
				res=res.concat(String.valueOf(n));
				nx=nx/2;
			}	
		} else if (num instanceof Long) {
			long nx = num.longValue();
			
			while (nx>1) {
				long n = (nx%2L);
				res=res.concat(String.valueOf(n));
				nx=nx/2;
			}	
		} else {
			return res;
		}
		
		res=res.concat("1");
		
		return new StringBuilder(res).reverse().toString();
	}
	
	public static int getNumberOfWord(String word) {
		int res = 0;
		
		for (int i = 0; i < word.length(); i++) {
			//System.out.println(word.charAt(i));
			res += ((word.charAt(i)-'A')+1);
		}
		
		return res;
	}
	
	public static boolean isPalindrome(String texto) {
		int largo = texto.length();
		boolean result = true;
		char[] arr = texto.toCharArray();

		if (largo % 2 == 0) {
			for (int i = 0; i < largo / 2; i++) {
				result = result && (arr[i] == arr[largo - 1 - i]);

				if (!result) {
					break;
				}
			}
		} else {
			for (int i = 0; i <= (largo / 2); i++) {
				result = result && (arr[i] == arr[largo - 1 - i]);

				if (!result) {
					break;
				}
			}
		}

		return result;
	}	
	
	public static List<String> permutaciones(String str) {
		Set<String> resultado = new HashSet<>();

		permutaciones(str, "", resultado);
		//System.out.println("largo del set:" + resultado);
		return new ArrayList<>(resultado);
	}

	private static void permutaciones(String texto, String answer, Set<String> lista) {
		if (texto.isEmpty()) {
			lista.add(answer);
			return;
		}

		for (int i = 0; i < texto.length(); i++) {
			// ith character of str
			char ch = texto.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = texto.substring(0, i) + texto.substring(i + 1);

			// Recursive call
			permutaciones(ros, answer + ch, lista);
		}
	}

	public static String[] rotaciones(String palabra) {
		String[] resultado = new String[palabra.length()];

		resultado[0] = palabra;
		if (palabra.length() > 1) {
			for (int i = 1; i < palabra.length(); i++) {
				String prefix = palabra.substring(0, 1);
				String suffix = palabra.substring(1);
				palabra = suffix.concat(prefix);
				resultado[i] = palabra;
			}
		}
		return resultado;
	}

	public static boolean containsSameDigits(String text1, String text2) {
		if (text1.length()!=text2.length()) {return false;}
		
		boolean result = true;
		
		for (int i=0;i<text1.length();i++) {
			result = result && text2.contains(text1.subSequence(i, i+1));
			
			if (!result) {break;}
		}
		
		return result;
	}

	public static List<List<String>> partitions(String str) {
	    List<List<String>> result = new ArrayList<>();

	    if (str.length() == 1) {
	        result.add(new ArrayList<>());
	        result.get(0).add(str);
	        return result;
	    }

	    for (List<String> list : partitions(str.substring(1))) {
	        List<String> append = new ArrayList<>(list);
	        append.set(0, str.substring(0, 1) + append.get(0));
	        List<String> add = new ArrayList<>(list);
	        add.add(0, str.substring(0, 1));
	        result.add(append);
	        result.add(add);
	    }
	    
	    return result;
	}

	public static String reverse(String text) {
		if (text==null) {return null;}
		else if (text.length()==1) {return text;}
		else return reverse(text.substring(1)).concat(text.substring(0, 1));
	}

	public static String swapElements(String texto, int idx0, int idx1) {
		int minIdx = Math.min(idx0, idx1);
		int maxIdx = Math.max(idx0, idx1);
		String a = texto.substring(minIdx, minIdx+1);
		String b = texto.substring(maxIdx, maxIdx+1);
		
		if (minIdx==0) {
			if (maxIdx==texto.length()-1) {
				return b.concat(texto.substring(minIdx+1, maxIdx)).concat(a);
			} else {
				return b.concat(texto.substring(minIdx+1, maxIdx)).concat(a).concat(texto.substring(maxIdx+1));
			}
		} else {
			if (maxIdx==texto.length()-1) {
				return texto.substring(0, minIdx).concat(b).concat(texto.substring(minIdx+1, maxIdx)).concat(a);
			} else {
				return texto.substring(0, minIdx).concat(b).concat(texto.substring(minIdx+1, maxIdx)).concat(a).concat(texto.substring(maxIdx+1));
			}			
		}
	}

	public static String insert(String texto, int idx, String element) {
		if (idx==0) {
			return element.concat(texto);
		} else if (idx==texto.length()){
			return texto.concat(element);
		} else {
			return texto.substring(0, idx).concat(element).concat(texto.substring(idx));
		}
	}
	
	public static String move(String texto, int fromId, int toId) {
		String a = texto.substring(fromId, fromId+1);
		
		if (toId==0) {
			texto = texto.substring(0, fromId).concat(texto.substring(fromId+1));
			return a.concat(texto);
		} else if (toId==texto.length()){
			texto = texto.substring(0, fromId).concat(texto.substring(fromId+1));
			return texto.concat(a);
		} else if (toId < fromId) {
			return texto.substring(0, toId).concat(a).concat(texto.substring(toId, fromId)).concat(texto.substring(fromId+1));
		} else if (fromId < toId) {
			return texto.substring(0, fromId).concat(texto.substring(fromId+1, toId)).concat(a).concat(texto.substring(toId));
		} else {
			return texto;
		}
	}
}
