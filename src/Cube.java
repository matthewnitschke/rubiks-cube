import java.util.ArrayList;

public class Cube {
//       +-----+
//       | WWW |
//       | WWW |
//       | WWW | 
// +-----+-----+-----+
// | GGG | RRR | BBB |
// | GGG | RRR | BBB |
// | GGG | RRR | BBB |
// +-----+-----+-----+
//       | YYY |
//       | YYY |
//       | YYY |
//       +-----+
//       | OOO |
//       | OOO |
//       | OOO |
//       +-----+
	
	private CubeSide[][] cubeData = new CubeSide[4][3];
	
	public CubeSide front;
	public CubeSide left;
	public CubeSide right;
	public CubeSide top;
	public CubeSide bottom;
	public CubeSide back;
		
	public Cube(){
		initCube();
	}
	
	public void rotateY(int col){
		String previousCol = cubeData[1][1].getColumn(col);
		String nextCol = "";
		
		for(int i : new int[] {2,3,0,1} ){
			nextCol = cubeData[i][1].getColumn(col);
			cubeData[i][1].setColumn(col, previousCol);
			previousCol = nextCol;
		}
	}
	
	public void rotateX(int row){
		String previousRow = cubeData[1][0].getRow(row);
		String nextRow = "";
		
		int[][] rowSequence = new int[4][2];
		rowSequence[0] = new int[] { 1, 1 };
		rowSequence[1] = new int[] { 1, 2 };
		rowSequence[2] = new int[] { 3, 1 };
		rowSequence[3] = new int[] { 1, 0 };
		
		for(int[] faceCords : rowSequence){
			nextRow = cubeData[faceCords[0]][faceCords[1]].getRow(row);
			cubeData[faceCords[0]][faceCords[1]].setRow(row, previousRow);
			previousRow = nextRow;
		}
	}
	
	public void initCube(){
		cubeData[0][1] = new CubeSide(CubeColor.W);
		cubeData[1][0] = new CubeSide(CubeColor.G);
		cubeData[1][1] = new CubeSide(CubeColor.R);
		cubeData[1][2] = new CubeSide(CubeColor.B);
		cubeData[2][1] = new CubeSide(CubeColor.Y);
		cubeData[3][1] = new CubeSide(CubeColor.O);
		
		front = cubeData[1][1];
		left = cubeData[1][0];
		right = cubeData[1][2];
		top = cubeData[0][1];
		bottom = cubeData[2][1];
		back = cubeData[3][1];
		
	}
	
	public boolean isSolved(){
		for(int r = 0; r < 4; r ++){
			for(int c = 0; c < 3; c ++){
				if (cubeData[r][c] != null){
					if (!cubeData[r][c].isSideSame()){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void printCube(){
		System.out.printf("      +-----+      \n");
		System.out.printf("      | %s |   \n", top.getTopRow());
		System.out.printf("      | %s |   \n", top.getMiddleRow());
		System.out.printf("      | %s |   \n", top.getBottomRow());
		
		System.out.printf("+-----+-----+-----+\n");
		
		System.out.printf("| %s | %s | %s |\n", left.getTopRow(), front.getTopRow(), right.getTopRow());
		System.out.printf("| %s | %s | %s |\n", left.getMiddleRow(), front.getMiddleRow(), right.getMiddleRow());
		System.out.printf("| %s | %s | %s |\n", left.getBottomRow(), front.getBottomRow(), right.getBottomRow());
		
		System.out.printf("+-----+-----+-----+\n");
		
		System.out.printf("      | %s |   \n", bottom.getTopRow());
		System.out.printf("      | %s |   \n", bottom.getMiddleRow());
		System.out.printf("      | %s |   \n", bottom.getBottomRow());
		System.out.printf("      +-----+      \n");
		
		System.out.printf("      | %s |   \n", back.getTopRow());
		System.out.printf("      | %s |   \n", back.getMiddleRow());
		System.out.printf("      | %s |   \n", back.getBottomRow());
		System.out.printf("      +-----+      \n");
		
	}
	
}
