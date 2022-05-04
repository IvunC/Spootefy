import java.util.ArrayList;

public class User{

	int size=1;
	int ID =1;

	String userList[][] = new String[size][2];
	
	
	 public void add(String userName) {

		userList[size-1][0] = String.valueOf(ID);
		userList[size-1][1] = userName;
		ID++;
		size++;
		
		String[][] temp = new String[userList.length + 1][2];
	    System.arraycopy(userList, 0, temp, 0, userList.length);
	    userList = temp;
	    
		
	 }
	
	 protected int getID(String input) {
		int temp=0;
		for (int i=0;i<userList.length;i++) {
			if (input.equals(userList[i][1])) {
				temp = Integer.parseInt(userList[i][0]);
			
			}
		}return temp;
	}
	
	 
	 protected void remove(String input) {
		 String [][] temp = new String[userList.length-1][2];
		 try {
				for (int i = 0, k = 0; i <userList.length; i++) { 
					if (input.equals(userList[i][1])) {
						continue;
					}else temp[k++]= userList[i];
					
				}
				userList=temp;
				size--;
				System.out.println("Successfully Removed User " + input);
		 }catch(ArrayIndexOutOfBoundsException e){
				 System.out.println("User " + input + " Does Not Exist");
			 }
		 
	 }
	
	 protected void remove(int inputID) {
			
		 String [][] temp = new String[userList.length-1][2];
		 try {
			for (int i = 0, k = 0; i <userList.length; i++) { 
				if (i==inputID-1) {
					continue;
				}else temp[k++]= userList[i];
				
			}
			userList=temp;
			size--;
			System.out.println("Successfully Removed");
	 }catch(ArrayIndexOutOfBoundsException e){
			 System.out.println("Index of value:"+inputID+ " Out Of Bounds");
		 }
	 }
	 
	 protected void displayUser() {
		
		 for (int i=0;i<userList.length-1;i++) {
			 System.out.println(userList[i][0] + "\t" + userList[i][1] + "\n");
			 
		 }
	 }
}
	 
	
