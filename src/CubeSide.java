
public class CubeSide {
	private CubeColor[][] sideData = new CubeColor[3][3];
	
	public CubeSide(CubeColor color){
		initCubeSide(color);
	}
	
	private void initCubeSide(CubeColor color){
		for(int r = 0; r < 3; r ++){
			for(int c = 0; c < 3; c++){
				sideData[r][c] = color;
			}		
		}
	}
	
	public String getTopRow(){
		return getRow(0);
	}
	
	public String getMiddleRow(){
		return getRow(1);
	}
	
	public String getBottomRow(){
		return getRow(2);
	}
	
	public String getRow(int r){
		String retString = "";
		for(int i = 0; i < 3; i ++){
			retString += sideData[r][i].name();
		}
		return retString;
	}
	
	public String getLeftColumn(){
		return getColumn(0);
	}
	
	public String getMiddleColumn(){
		return getColumn(1);
	}
	
	public String getRightColumn(){
		return getColumn(2);
	}

	public String getColumn(int c){
		String retString = "";
		for(int i = 0; i < 3; i ++){
			retString += sideData[i][c].name();
		}
		return retString;
	}

	public void setColumn(int c, String data){
		for(int i = 0; i < 3; i ++){
			sideData[i][c] = CubeColor.valueOf(""+data.charAt(i));
		}	
	}
	
	public void setRow(int r, String data){
		for(int i = 0; i < 3; i ++){
			sideData[r][i] = CubeColor.valueOf(""+data.charAt(i));
		}
	}
	
	public boolean isSideSame(){
		CubeColor sideColor = sideData[0][0];
		for(int r = 0; r < 3; r ++){
			for(int c = 0; c < 3; c++){
				if (sideColor != sideData[r][c]){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void printSide(){
		System.out.printf("+-----+\n");
		System.out.printf("| %s |\n", getTopRow());
		System.out.printf("| %s |\n", getMiddleRow());
		System.out.printf("| %s |\n", getBottomRow());
		System.out.printf("+-----+\n");
	}
}
