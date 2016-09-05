package finalproject;

public class Riddle {
	
	String[][] riddleArray;
	int rArrPlace = 0;
	
	public Riddle (String[][] newRiddleArray) {
		
		riddleArray = newRiddleArray;
		
	}
	
	public void addNew (String riddle, String answer) {
		
		if (rArrPlace > riddleArray.length) {
			System.out.println("Too many riddles yo");
		}
		
		else {
			riddleArray[rArrPlace][0] = riddle;
			riddleArray[rArrPlace][1] = answer;
			rArrPlace++;
		}
		
	}
	
	public int length () {
		return riddleArray.length;
	}
	
	public void ask (int num) {
		System.out.println(riddleArray[num][0]);
	}
	
	public String correct (int num) {
		
		return riddleArray[num][1];
		
	}
	
}
