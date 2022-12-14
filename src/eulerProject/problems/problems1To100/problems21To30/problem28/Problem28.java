package eulerProject.problems.problems1To100.problems21To30.problem28;

public class Problem28 {
	public static void main(String[] args) {
		int[][] box = new int[1001][1001];
		llenarArr(box);
		long suma = sumarDiagonales(box)-box[500][500]; // ya que se suma 2 veces el centro
		System.out.println("La suma de las diagonales es:" + suma);
	}

	private static long sumarDiagonales(int[][] box) {
		long suma = 0L;
		
		for (int i=0;i<box.length;i++) {
			suma+=box[i][i];
		}

		for (int i=0;i<box.length;i++) {
			suma+=box[i][box.length-1-i];
		}
		
		return suma;
	}

	public static void llenarArr(int[][] arr) {
		int n = arr.length * arr.length;
		DIRECTION idxDir = DIRECTION.IZQ;
		// posiciones iniciales
		int maxCol = arr.length - 1;
		int minCol = 0;
		int maxRow = arr.length - 1;
		int minRow = 0;

		int row = 0;
		int col = arr.length - 1;

		while (n > 0) {
			switch (idxDir.toString()) {
			case "IZQ":
				while (col>=minCol) {
					if (arr[row][col]==0) {
						arr[row][col]=n;
					}
					
					n--;
					
					if (col>minCol) {col--;} else {break;}
				}
				
				if (n==0) {break;}
				n++;  // pequeño ajuste al cambiar de direccion
				minRow++;
				idxDir = DIRECTION.ABAJO;
				break;
			case "ABAJO":
				while (row<=maxRow) {
					if (arr[row][col]==0) {
						arr[row][col] = n;						
					}
					
					n--;

					if (row<maxRow) {row++;} else {break;}
				}
				if (n==0) {break;}
				n++;  // pequeño ajuste al cambiar de direccion
				minCol++;
				idxDir = DIRECTION.DER;
				break;
			case "DER":
				while (col<=maxCol) {
					if (arr[row][col]==0) {
						arr[row][col] = n;						
					}
					
					n--;

					if (col<maxCol) {col++;} else {break;}
				}
				if (n==0) {break;}
				n++;  // pequeño ajuste al cambiar de direccion
				maxRow--;
				idxDir = DIRECTION.ARRIBA;
				break;
			case "ARRIBA":
				while (row>=minRow) {
					if (arr[row][col]==0) {
						arr[row][col] = n;						
					}
					
					n--;

					if (row>minRow) {row--;} else {break;}
				}
				if (n==0) {break;}
				n++;  // pequeño ajuste al cambiar de direccion
				maxCol--;
				idxDir = DIRECTION.IZQ;
				break;
			default:
				break;
			}
		}
	}
	
	public static void printArr(int[][] arr) {
		for (int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(String.format("%02d", arr[i][j])+" ");
			}
			System.out.println();
		}
		
	}
}
