
import java.util.ArrayList;

public class Elements {
	private ArrayList<Object> liste ;
		
	public Elements() {
		liste = new ArrayList<Object>();
	}
		
	public boolean isEmpty () {
		return liste.size() == 0;
	}
		
	public int size() {
		return liste.size();
	}
		
	public void push(Object o) {
		liste.add(o);
	}
		
	public void pop() {
		liste.remove(liste.size()-1);
	}
	
	public boolean erased(Object o) {
		return liste.remove(o);
	}
	
	public Object get(int i){
		return liste.get(i);
	}
	
	public ArrayList<Object> getListe() {
		return liste;
	}

	public String print(){
		String s="";
		for(int i=0; i<liste.size();i++) {
			s+=liste.get(i)+"\n";
		}
		return s;
	}

	public String toString() {
		if(this.isEmpty())return "#";
		return liste.get(liste.size()-1).toString();
	}
}
