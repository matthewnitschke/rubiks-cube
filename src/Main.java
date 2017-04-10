
public class Main {
	public Main(){
		Cube c = new Cube();
		CubeHandler ch = new CubeHandler(c);
		
		ch.mix();
		
		c.printCube();
		ch.bruteForceFront();
	}
	
	public static void main(String[] args){
		new Main();
	}
}
