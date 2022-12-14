package eulerProject.library;

public class Triplet<T extends Number> {
	private T a;
	private T b;
	private T c;
	
	public Triplet(T a, T b, T c) throws Exception {
		if (a instanceof Integer) {
			Integer ax = (Integer)a;
			Integer bx = (Integer)b;
			Integer cx = (Integer)c;
			
			if (Math.pow(ax, 2) + Math.pow(bx, 2) - Math.pow(cx, 2) != 0) {
				throw new Exception("Valores Incorrectos");
			}			
		} else if (a instanceof Long) {
			Long ax = (Long)a;
			Long bx = (Long)b;
			Long cx = (Long)c;
			
			if (Math.pow(ax, 2) + Math.pow(bx, 2) - Math.pow(cx, 2) != 0) {
				throw new Exception("Valores Incorrectos");
			}			
		} else {
			throw new Exception("Solo se permite enteros o Long");
		}
		
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}

	public T getB() {
		return b;
	}

	public void setB(T b) {
		this.b = b;
	}

	public T getC() {
		return c;
	}

	public void setC(T c) {
		this.c = c;
	}

	@Override
	public int hashCode() {
		if (a instanceof Integer) {
			Integer ax = (Integer)a;
			Integer bx = (Integer)b;
			Integer cx = (Integer)c;
			return 7*Integer.hashCode(cx)+31*Integer.hashCode(Math.max(ax, bx))+47*Integer.hashCode(Math.min(ax, bx));			
		} else if (a instanceof Long) {
			Long ax = (Long)a;
			Long bx = (Long)b;
			Long cx = (Long)c;
			return 7*Long.hashCode(cx)+31*Long.hashCode(Math.max(ax, bx))+47*Long.hashCode(Math.min(ax, bx));			
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Triplet)) {
			return false;
		}
		Triplet<?> other = (Triplet<?>) obj;
		return ((c == other.c) && (a == other.a) && (b == other.b))
				|| ((c == other.c) && (a == other.b) && (b == other.a));
	}
	
	public String toString() {
		return "(" + a + "," + b + "," + c + ")";
	}
}
