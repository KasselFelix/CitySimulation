
import java.util.ArrayList;

public class Route extends Elements {
	private ArrayList<Direction> directions;
	public Route() {
		super();
		directions=new ArrayList<Direction>(); 
	}
	
	public void addN(){
		Direction n=new Direction(-1,0);
		directions.add(n);
	}
	public void addS(){
		Direction s=new Direction(1,0);
		directions.add(s);
	}
	public void addE(){
		Direction e=new Direction(0,1);
		directions.add(e);
	}
	public void addW(){
		Direction w=new Direction(0,-1);
		directions.add(w);
	}

	public ArrayList<Direction> getDirections() {
		return directions;
	}
	
	public String toString() {
		if (this.isEmpty())	return ".";
		return super.get(super.size()-1).toString();
	}
	
}
