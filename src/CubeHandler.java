import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CubeHandler {
	
	Cube cube;
	public CubeHandler(Cube cube){
		this.cube = cube;
	}
	
	public void mix(){
		for(int i = 0; i < 1000; i ++){
			switch(randRange(0,1)){
				case 0: cube.rotateY(randRange(0,2)); break;
				case 1: cube.rotateX(randRange(0,2)); break;
			}
		}
	}
	
	public void bruteForceFront(){
		CubeSide cubeSide = cube.front;
		int turnCount = 0;
		long start = System.currentTimeMillis();
		
		while(!cubeSide.isSideSame()){
			switch(randRange(0,1)){
				case 0: cube.rotateY(randRange(0,2)); break;
				case 1: cube.rotateX(randRange(0,2)); break;
			}
			turnCount++;
		}
		long end = System.currentTimeMillis();
		
		long diff = end - start;
		
		String time = String.format("%d min, %d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(diff),
			    TimeUnit.MILLISECONDS.toSeconds(diff) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff)));
		
		System.out.println("---------- Solved ----------");
		System.out.println();
		cubeSide.printSide();
		System.out.println();
		System.out.println("Solve Time: " + time);
		System.out.println("Turn Count: " + turnCount);
		
	}
	
	public void bruteForceFull(){
		int turnCount = 0;
		long start = System.currentTimeMillis();
		
		while(!cube.isSolved()){
			switch(randRange(0,1)){
				case 0: cube.rotateY(randRange(0,2)); break;
				case 1: cube.rotateX(randRange(0,2)); break;
			}
			turnCount++;
		}
		
		long end = System.currentTimeMillis();
		
		long diff = end - start;
		
		String time = String.format("%d min, %d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(diff),
			    TimeUnit.MILLISECONDS.toSeconds(diff) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff)));
		
		System.out.println("---------- Solved ----------");
		System.out.println();
		cube.printCube();
		System.out.println();
		System.out.println("Solve Time: " + time);
		System.out.println("Turn Count: " + turnCount);
	}
	
	private int randRange(int min, int max){
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}
