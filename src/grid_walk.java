import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;




public class grid_walk {
	static class Position{
		int x;
		int y;
		Position(int a,int b){
			this.x=a;
			this.y=b;
		}
		public boolean equals(Object in) {
			Position arg = (Position) in;
			if (arg == null) return false;
			return (x == arg.x && y == arg.y);
		}
		
		public int hashCode() {
			return this.x + this.y;
		}
	}
	static List<Position> list=new LinkedList<Position>();
	static Map<Position, Boolean> visited = new HashMap<Position, Boolean>();
	public static void main(String[] args){
		grid_walk solver=new grid_walk();
//		Position position=new Position(59,79);
//		System.out.println(isValid(position));
		Position start=new Position(0,0);
		list.add(start);
		int index = 0;
		while (true) {
			if (index >= list.size())
				break;
			solver.getallpoints(list.get(index));
			index++;
			
		}
		System.out.println(list.size());
		
		
	}
	void getallpoints(Position point){
		visited.put(point, true);
		Position up=new Position(point.x,point.y+1);
		Position down=new Position(point.x,point.y-1);
		Position left=new Position(point.x-1,point.y);
		Position right=new Position(point.x+1,point.y);
		addit(up);
		addit(down);
		addit(left);
		addit(right);
		
	}
	void addit(Position position){
		if (!visited.containsKey(position) && isValid(position)) {
			list.add(position);
			visited.put(position, false);
		}
	}
	boolean isValid(Position p){
		int x=Math.abs(p.x);
		int y=Math.abs(p.y);
		int sum=0;
		while(x>0){
			sum+=x%10;
			x/=10;
		}
		while(y>0){
			sum+=y%10;
			y/=10;
		}
		return sum<=19?true:false;
	}
}
