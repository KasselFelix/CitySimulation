
public class Direction {
	private int []direction;
	public Direction(int i,int j){
		direction=new int[2];
		direction[0]=i;
		direction[1]=j;
	}
	public int getI(){
		return direction[0];
	}
	
	public int getJ(){
		return direction[1];
	}
}
