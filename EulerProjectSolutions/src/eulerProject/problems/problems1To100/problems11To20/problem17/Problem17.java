package eulerProject.problems.problems1To100.problems11To20.problem17;

public class Problem17 {
	public static void main(String[] args) {
		int suma = 0;

		for (int i = 1; i <=1000; i++) {
			String numStr = String.format("%04d", i);
			String word = numberToWords(numStr);
			int numberWordLength = word.replace(" ","").length();
			//System.out.println("i="+i+" "+word+" ("+numberWordLength+")");
			suma += numberWordLength;
		}

		System.out.println("La cantidad de letras(en inglés) que tienen los números del 1 al 1000 son:" + suma);
	}

	private static String numberToWords(String num) {
		String texto = "";
		
		try {
			if (Integer.valueOf(num)>1000) {
				throw new NumberFormatException("Número mayor a 1000");
			} else {
				String thousands = num.substring(0, 1);
				String hundreds =  num.substring(1, 2);
				String tens = num.substring(2, 3);
				String units = num.substring(3, 4);
				
				if (!thousands.equals("0")&&!thousands.equals("1")) {
					throw new NumberFormatException("Número inválido");
				}
				
				if (thousands.equals("1") 
						&& hundreds.equals("0")
						&& tens.equals("0")
						&& units.equals("0")) {
					return "one thousand";
				} else {
					texto=texto.concat(convertirCentenas(hundreds));
					
					if (!hundreds.equals("0") && (!tens.equals("0") || !units.equals("0"))) {
						texto=texto.concat(" and ");
					}
					
					switch (tens) {
					case "0":
						texto=texto.concat(convertirUnidades(units));
						break;
					case "1":
						switch(units) {
						case "0":
							texto=texto.concat("ten");
							break;
						case "1":
							texto=texto.concat("eleven");
							break;
						case "2":
							texto=texto.concat("twelve");
							break;
						case "3":
							texto=texto.concat("thirteen");
							break;	
						case "4":
							texto=texto.concat("fourteen");
							break;
						case "5":
							texto=texto.concat("fifteen");
							break;		
						case "6":
							texto=texto.concat("sixteen");
							break;			
						case "7":
							texto=texto.concat("seventeen");
							break;					
						case "8":
							texto=texto.concat("eighteen");
							break;										
						case "9":
							texto=texto.concat("nineteen");
							break;
						default:
							break;
						}
						break;
					case "2":
						texto=texto.concat("twenty");
						texto=texto.concat(convertirUnidades(units));
						break;
					case "3":
						texto=texto.concat("thirty");
						texto=texto.concat(convertirUnidades(units));
						break;
					case "4":
						texto=texto.concat("forty");
						texto=texto.concat(convertirUnidades(units));
						break;
					case "5":
						texto=texto.concat("fifty");
						texto=texto.concat(convertirUnidades(units));
						break;
					case "6":
						texto=texto.concat("sixty");
						texto=texto.concat(convertirUnidades(units));
						break;
					case "7":
						texto=texto.concat("seventy");
						texto=texto.concat(convertirUnidades(units));
						break;
					case "8":
						texto=texto.concat("eighty");
						texto=texto.concat(convertirUnidades(units));
						break;
					case "9":
						texto=texto.concat("ninety");
						texto=texto.concat(convertirUnidades(units));
						break;
					default:
						break;
					}
				}
			}
		} catch (NumberFormatException ex) {
			return "";
		}
		return texto;
	}

	private static String convertirCentenas(String hundreds) {
		switch (hundreds) {
		case "1":
			return "one hundred";
		case "2":
			return "two hundred";
		case "3":
			return "three hundred";
		case "4":
			return "four hundred";
		case "5":
			return "five hundred";
		case "6":
			return "six hundred";
		case "7":
			return "seven hundred";
		case "8":
			return "eight hundred";
		case "9":
			return "nine hundred";
		default:
			return "";
		}
	}

	private static String convertirUnidades(String units) {
		switch (units) {
		case "1":
			return "one";
		case "2":
			return "two";
		case "3":
			return "three";
		case "4":
			return "four";
		case "5":
			return "five";
		case "6":
			return "six";
		case "7":
			return "seven";
		case "8":
			return "eight";
		case "9":
			return "nine";
		default:
			return "";
		}
	}
}