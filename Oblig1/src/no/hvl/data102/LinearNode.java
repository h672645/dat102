package no.hvl.data102;

public class LinearNode<T> {
	
	private LinearNode<T> neste;
	private T element;
	
	public LinearNode<T> getNeste(){
		return neste;
	}
	
	public T getElement() {
		return element;
	}
	
	public void setNeste(LinearNode<T> neste){
		this.neste = neste;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
}
