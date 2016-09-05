package finalproject;

public class Inventory {
	
	// initialize variables
	public String[][] itemList;
	public int itemsAmt;
	public Char player;
	public int numOfItems;
	boolean addNew;
	boolean remNew;
	
	// constructor class
	public Inventory (String[][] newItemList, Char ofPlayer) {
		itemList = newItemList;
		itemsAmt = 0;
		player = ofPlayer;
		
		
	}
	
	public void newItem (String newItem) {
		
		if (itemsAmt > 9) {
			System.out.println("You cannot pick this up. Your inventory is full.");
		}
		
		else {
			
			for (int i = 0; i < itemList.length; i++) {
				if (newItem.equals(itemList[i][0])) {
					numOfItems = Integer.parseInt(itemList[i][1]);
					numOfItems += 1;
					addNew = true;
				}
				
				else {
					addNew = false;
				}
			}
			
			if (addNew) {
				System.out.println("Workds");
				itemList[itemsAmt][1] = Integer.toString(numOfItems);
			}
			
			else {
				itemList[itemsAmt][0] = newItem;
				itemList[itemsAmt][1] = "1";
				itemsAmt++;
			}
		}
	}
	
	public void remItem (String itemToRem) {
		for (int i = 0; i < itemList.length; i++) {
			if (itemToRem.equals(itemList[i][0])) {
				numOfItems = Integer.parseInt(itemList[i][1]);
				numOfItems -= 1;
				remNew = false;
			}
			
			else {
				remNew = true;
			}
		}
		
		if (remNew) {
			itemList[itemsAmt][0] = null;
			itemList[itemsAmt][1] = null;
			itemsAmt--;
		}
	}
	
	public void sayOwner () {
		System.out.println("This inventory is owned by " + player.name + ".");
	}
	
	public void sayItemAmt () {
		System.out.println("You have " + itemsAmt + " items in your inventory.");
	}
	
	public void view () {
		System.out.println("Inventory (" + itemsAmt + " items): ");
		for (int i = 0; i < itemList.length; i++) {
			if (itemList[i][0] == null) {
				
			}
			else {
				System.out.println((i + 1) + ": " + itemList[i][0] + " (" + itemList[i][1] + ")");
			}
		}
	}
}
