package eulerProject.problems.problems1To100.problems11To20.problem19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem19 {

	public static void main(String[] args) {
		List<Integer> anios = new ArrayList<>(100);
		List<Integer> bisiestos = new ArrayList<>(25);
		List<Integer> primerosDias = new ArrayList<>(12);
		List<Integer> primerosDiasBisiesto = new ArrayList<>(12);
		List<Integer> listadoPrimerosDias = new ArrayList<>(1200);
		List<Integer> domingos = new ArrayList<>(5210);
		List<Integer> resultado = new ArrayList<>(1200);
		
		// años y bisiestos
		for (int i=1901;i<=2000;i++) {
			anios.add(i);
			if (esBisiesto(i)) {
				bisiestos.add(i);
			}
		}
		
		// primeros días
		Integer[] pdarray = new Integer[]{1,32,60,91,121,152,182,213,244,274,305,335};
		primerosDias.addAll(Arrays.asList(pdarray));
		Integer[] pdbarray = new Integer[]{1,32,61,92,122,153,183,214,245,275,306,336};
		primerosDiasBisiesto.addAll(Arrays.asList(pdbarray));
		
		// total de dias del periodo (1/1/1901 al 31/12/2000)
		int totalDias = 0;
		
		for (int anio=1901;anio<=2000;anio++) {
			totalDias+=365;

			if (esBisiesto(anio)) {
				totalDias+=1;
			}
		}
		
		System.out.println("total días:" + totalDias);
		
		System.out.print("domingos:");
		// la serie de dias domingo
		for (int k=0;7*k+6<=totalDias;k++) {
			domingos.add(7*k+6);
		}
		System.out.println("domingos " + domingos.toString());

		// calcular primeros dias de cada mes a lo largo de los años
		for (Integer anio : anios) {
			if (bisiestos.contains(anio)) {
				for (Integer primerdia : primerosDiasBisiesto) {
					primerdia+=(365*cantidadNoBisiestosEntreDosAnios(anios.get(0), anio)
							+366*cantidadBisiestosEntreDosAnios(anios.get(0), anio));
					listadoPrimerosDias.add(primerdia);
				}
			} else {
				for (Integer primerdia : primerosDias) {
					primerdia+=(365*cantidadNoBisiestosEntreDosAnios(anios.get(0), anio)
							+366*cantidadBisiestosEntreDosAnios(anios.get(0), anio));
					listadoPrimerosDias.add(primerdia);
				}
			}
		}
		System.out.println("primeros dias:" + listadoPrimerosDias.toString());

		// reviso el listado de domingos y lo comparo con los primeros dias de mes
		// los que coincidan son los domingos primeros dias de mes
		for (Integer diaDomingo: domingos) {
			if (listadoPrimerosDias.contains(diaDomingo)) {
				resultado.add(diaDomingo);
			}
		}
		
		System.out.println("Dias domingo que caen primero de mes:" + resultado.toString());
		System.out.println("Total de días:" + resultado.size());
	}

	private static boolean esBisiesto(int anio) {
		return (anio%4==0);
	}
	
	/**
	 * Sirve para calcular el desfase de los primeros dias del mes
	 * @param anioIni se incluye año de inicio (minimo 1901)
	 * @param anioFin no se incluye (maximo 2000)
	 * @return
	 */
	public static int cantidadBisiestosEntreDosAnios(int anioIni, int anioFin) {
		int cont = 0;
		
		for (int j=anioIni;j<anioFin;j++) {
			if (esBisiesto(j)) {
				cont++;
			}
		}
		
		return cont;
	}
	
	/**
	 * Sirve para calcular el desfase de los primeros dias del mes
	 * @param anioIni se incluye año de inicio (minimo 1901)
	 * @param anioFin no se incluye (maximo 2000)
	 * @return
	 */
	public static int cantidadNoBisiestosEntreDosAnios(int anioIni, int anioFin) {
		return anioFin-anioIni-cantidadBisiestosEntreDosAnios(anioIni, anioFin);
	}
}
