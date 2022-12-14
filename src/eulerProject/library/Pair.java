package eulerProject.library;

public class Pair<T> {
	private T base;
	private T exp;

	public Pair(T base, T exp) {
		this.base = base;
		this.exp = exp;
	}

	public T getBase() {
		return base;
	}

	public void setBase(T base) {
		this.base = base;
	}

	public T getExp() {
		return exp;
	}

	public void setExp(T exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "(" + base + ", " + exp + ")";
	}
	
	
}
