import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Application {

	public static void main(String[] args)throws InterruptedException {
		int ID=0;
		User a = new User();
		int stepCounter=00;
		String current= "";
		int currentInt=0;
		 ArrayList<Playlist> list = new ArrayList<Playlist>();
		
		 Playlist p = new Playlist();
		 list.add(0, p);
		 AudioRecording r;
		 Scanner scan1 = new Scanner(System.in);
		 String currentUser="";

		 boolean isRunning=true;
		 while (isRunning==true) {
	
		
	
		
		while (stepCounter==00) {
			System.out.println("Spootefy Menu");
			System.out.println("Press 1 to Add User");
			System.out.println("Press 2 to Remove User");
			System.out.println("Press 3 to List All User");
			System.out.println("Press 4 to Access User");
			System.out.println("Press 5 to Exit");
			boolean goodInput = false;
			do	{
				try	{
					currentInt = scan1.nextInt();
					if (currentInt>0 && currentInt <= 5 ) {
						goodInput = true;
					}else {
						String garbage = scan1.nextLine( );
						System.out.print( "Invalid Input, Try Again");
					}
				}
				catch (InputMismatchException ime) {
					String garbage = scan1.nextLine( );
					System.out.println("Invalid Input, Try Again");
				}
			} while ( !goodInput );
			stepCounter=currentInt*10;
		}
					
		if (stepCounter==10) {	
			while (stepCounter==10) {
				
				System.out.println("Please Enter a Class Appropriate Username");
				int temp=0;
				current=scan1.next();
				p= new Playlist(current);
				for (int i=0;i<a.userList.length;i++) {
					if (current.equals(a.userList[i][1])) {
						temp++;
					}
				}
				if (temp==0) {
					a.add(current);
					list.add(a.getID(current), p);
				
					
					System.out.println(current + " Was Successfully Added!");
					System.out.println("Press 1 to Add Another Username");
					System.out.println("Press 2 to Return To Menu");
					boolean goodInput=false;
					do	{
						try	{
							currentInt = scan1.nextInt();
							if (currentInt>0 && currentInt <= 2 ) {
								goodInput = true;
							}else {
								String garbage = scan1.nextLine( );
								System.out.print( "Invalid Input, Try Again");
							}
						}
						catch (InputMismatchException ime) {
							String garbage = scan1.nextLine( );
							System.out.println("Invalid Input, Try Again");
						}
					} while ( !goodInput );
					if (currentInt==2) {
						stepCounter=00;
					}else;
					
				}else {
						System.out.println("Username Taken. Try Again");
						temp=0;
						
				}
					
			}
		}
					
		else if (stepCounter==20) {
			System.out.println("Users");
			if (a.userList.length==1) {
				System.out.println("List Is Empty. Add A User First");
				stepCounter=00;
			}else {
				a.displayUser();
				try {
					current = scan1.next();
					a.remove(Integer.parseInt(current));
				}catch(NumberFormatException e){
					a.remove(current);
				}finally {		
					System.out.println("Press 1 to Remove Another Username");
					System.out.println("Press 2 to Return To Menu");
					current=scan1.next();
					if (Integer.parseInt(current)==2) {
						stepCounter=00;
					}else;
				}
			}
		}
		else if (stepCounter==30) {
				
			a.displayUser();
			TimeUnit.SECONDS.sleep(3);
			stepCounter=00;
		}
		
		else if (stepCounter==40) {
			if (a.userList.length==1) {
				System.out.println("List Is Empty, Add User First");
				 stepCounter=00;	
			}
			else {
				stepCounter=41;
			}
		}
		else if (stepCounter==41) {
			while (stepCounter==41) {
				System.out.println("Select User By ID");
				a.displayUser();
				boolean goodInput=false;
					do	{
						try	{
							currentInt = scan1.nextInt();
							if (currentInt>0 && currentInt <a.userList.length ) {
								ID=currentInt;
								System.out.println(ID);
								goodInput = true;
							}else {
								String garbage = scan1.nextLine( );			
								System.out.print( "Invalid Input, Try Again");
							}
						}
						catch (InputMismatchException ime) {
							String garbage = scan1.nextLine( );
							System.out.println("Invalid Input, Try Again");
						}
					} while ( !goodInput );	
				System.out.println(a.userList[ID-1][0] + "\t" + a.userList[ID-1][1]);
				stepCounter=42;
			}
		}
		else if (stepCounter==42) {
			while (stepCounter==42) {
				System.out.println("Press 1 To Add Recording");
				System.out.println("Press 2 To Add Playlist From File");
				System.out.println("Press 3 To Add Playlist From Another User");
				System.out.println("Press 4 To Remove Recording");
				System.out.println("Press 5 To Play Recording");
				System.out.println("Press 6 To Play Playlist");
				System.out.println("Press 7 To Play Playlist On Shuffle");
				System.out.println("Press 8 To Save Playlist");
				System.out.println("Press 9 To Display Playlist Stats");
				System.out.println("Press 10 To Return");
				boolean goodInput=false;
				do	{
					try	{
						currentInt = scan1.nextInt();
						if (currentInt>0 && currentInt <12) {
							goodInput = true;
						}else {
							String garbage = scan1.nextLine( );
							System.out.print( "Invalid Input, Try Again");
						}
					}
					catch (InputMismatchException ime) {
						String garbage = scan1.nextLine( );
						System.out.println("Invalid Input, Try Again");
					}
				} while ( !goodInput );
				System.out.println(currentInt);
				switch(currentInt) {
				case 1 :
					stepCounter=61;
					break; 
				case 2 :
					stepCounter=62;
					break;
				case 3 :
					stepCounter=63;
					break;
				case 4 :
					stepCounter=64;
					break;
				case 5 :
					stepCounter=65;
					break;
				case 6 :
					stepCounter=66;
					break;
				case 7 :
					stepCounter=67;
					break;
				case 8 :
					stepCounter=68;
					break;
				case 9 :
					stepCounter=69;
					break;
				case 10 : 
					stepCounter = 00;
					break;
				}
				
				
			}//isRunning = false;
			
		}	
			
		else if (stepCounter==50) {
			for (int i=5;i>=1;i--) {
				System.out.println("Spootefy will self destruct in T-" + i + " seconds");
				TimeUnit.SECONDS.sleep(1);
	
				}
				System.out.println("Lol Just Kidding. I don't know how to program that");
				isRunning = false;		
				
		}
		else if (stepCounter==61) {	
			while (stepCounter==61) {
				System.out.println(ID);
				p = list.get(ID);
				String temp1=""; 
			
				System.out.println ("Insert Recording In The Following Order Without Spaces Between commas");
				System.out.println ("Example: Ivan,Is The Best,260");
				System.out.println ("Artist Name,Song Name,Duration In Seconds");
				boolean Added=false;
			
				do {
					Scanner scan2 = new Scanner(System.in);
					String ta[] ={"", "",""};
					try	{
						temp1 = scan2.nextLine();
						ta = temp1.split(",");
						
						r = new AudioRecording(ta[0], ta[1], Integer.parseInt(ta[2]), 120);
						p.add(r);
						Added=true;
						System.out.println("Successfully Added " + r.toString());
						
					}
					catch (InputMismatchException ime) {
						String garbage = scan2.nextLine();
						System.out.println("Invalid Input, Try Again");
					}catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Invalid Input, Try Again");
					}catch (NumberFormatException e) {
						System.out.println(ta[2] + " Is Not A Number. Try Again");
					}
				} while (!Added);
			
				System.out.println("Press 1 To Add Another Recording");
				System.out.println("Press 2 To Return To User Options");
				System.out.println("Press 3 To Choose Different User");
				System.out.println("Press 4 To Return To Main Menu");
				boolean goodInput=false;
				do	{
					try	{
						currentInt = scan1.nextInt();
						if (currentInt>0 && currentInt <5) {
							goodInput = true;
						}else {
							String garbage = scan1.nextLine( );
							System.out.print( "Invalid Input, Try Again");
						}
					}
					catch (InputMismatchException ime) {
						String garbage = scan1.nextLine( );
						System.out.println("Invalid Input, Try Again");
					}
				} while ( !goodInput );
				if (currentInt==2) {
					stepCounter=42;
				}else if (currentInt==3) {
					stepCounter=41;
				}else if (currentInt==4) {
					stepCounter=00;
				}else continue;
		
			}
		}
		else if (stepCounter==62) {
			p = list.get(ID);
			System.out.println("Enter FileName Of Playlist You Want To Upload");
			System.out.println("Example: IvansPlaylist.csv");
			current = scan1.next();
			p.load(current);
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Now Returning To User Menu");
			stepCounter=42;
			
			
			
			
			
			
		}
		else if (stepCounter==63) {
			a.displayUser();
			p = list.get(ID);
			System.out.println("Enter Which User To Copy Playlist From By ID");
			boolean goodInput=false;
			int temp=0;
			do	{
				try	{
					currentInt = scan1.nextInt();
					if (currentInt==ID) {
						System.out.println("Cannot Copy From Same Playlist");
					}
					if (currentInt>0 && currentInt<a.userList.length && currentInt!=ID) {
						temp = currentInt;
						goodInput = true;
					}else {
						String garbage = scan1.nextLine( );			
						System.out.print( "Invalid Input, Try Again");
					}
				}
				catch (InputMismatchException ime) {
					String garbage = scan1.nextLine( );
					System.out.println("Invalid Input, Try Again");
				}
			} while ( !goodInput );
			p= list.get(temp);
			list.add(ID,p);
			System.out.println("Playlist From " + a.userList[temp-1][1] + " Successfully Copied");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Now Returning To User Menu");
			stepCounter=42;
			
			
		}else if (stepCounter==64) {
			while (stepCounter==64) {
				p=list.get(ID);
			
				System.out.println("Insert The Index Of The Song You Want Removed");
				System.out.println("Or Insert the Artist and Name Of Song You Want Removed");
				System.out.println("Example: 'Mac Miller,Circles' (Case sensitive! Do not include spaces between commas)");
				System.out.println(p.toString());
				scan1 = new Scanner(System.in);
				if (p.getSize()!=0) {
					current = scan1.nextLine();
					try {
						p.remove(Integer.parseInt(current));
						
						
					}catch (NumberFormatException e ) {
						p.remove(current);
					}
				}
				else {
					System.out.println("Playlist Is Empty");
					
				}
			
				System.out.println(p.toString());
	
				System.out.println("Press 1 To Remove Another Recording");
				System.out.println("Press 2 To Return To User Options");
				System.out.println("Press 3 To Choose Different User");
				System.out.println("Press 4 To Return To Main Menu");
				boolean accepted=false;
				do	{
					try	{
						currentInt = scan1.nextInt();
						if (currentInt>0 && currentInt <5) {
							accepted = true;
						}else {
							String garbage = scan1.nextLine( );
							System.out.print("Invalid Input, Try Again");
						}
					}
					catch (InputMismatchException ime) {
						String garbage = scan1.nextLine( );
						System.out.println("Invalid Input, Try Again");
					}
				} while ( !accepted );
				if (currentInt==2) {
					stepCounter=42;
				}else if (currentInt==3) {
					stepCounter=41;
				}else if (currentInt==4) {
					stepCounter=00;
				}else stepCounter=64;
			}
		}
		
		else if (stepCounter==65) {
			
			while (stepCounter==65) {
				p=list.get(ID);
			
				System.out.println("Insert The Index Of The Song You Want Played");
				System.out.println("Or Insert the Artist and Name Of Song You Want Played");
				System.out.println("Example: 'Mac Miller,Circles' (Case sensitive! Do not include spaces between commas)");
				System.out.println(p.toString());
				scan1 = new Scanner(System.in);
				if (p.getSize()!=0) {
					current = scan1.nextLine();
					try {
						p.play(Integer.parseInt(current));
					}catch (NumberFormatException e ) {
						p.play(current);
					}
				}
				else {
					System.out.println("Playlist Is Empty");	
				}
				
				System.out.println("Press 1 To Play Another Recording");
				System.out.println("Press 2 To Return To User Options");
				System.out.println("Press 3 To Choose Different User");
				System.out.println("Press 4 To Return To Main Menu");
				boolean accepted=false;
				do	{
					try	{
						currentInt = scan1.nextInt();
						if (currentInt>0 && currentInt <5) {
							accepted = true;
						}else {
							String garbage = scan1.nextLine( );
							System.out.print("Invalid Input, Try Again");
						}
					}
					catch (InputMismatchException ime) {
						String garbage = scan1.nextLine( );
						System.out.println("Invalid Input, Try Again");
					}
				} while ( !accepted );
				if (currentInt==2) {
					stepCounter=42;
				}else if (currentInt==3) {
					stepCounter=41;
				}else if (currentInt==4) {
					stepCounter=00;
				}else continue;
			}
			
	
		}else if (stepCounter==66) {
			p = list.get(ID);
			p.play();
			TimeUnit.SECONDS.sleep(4);
			System.out.println("Now Returning To User Menu");
			stepCounter=42;

		}else if (stepCounter==67) {
			p = list.get(ID);
			p.shuffle();
			TimeUnit.SECONDS.sleep(4);
			System.out.println("Now Returning To User Menu");
			stepCounter=42;
			
		}else if (stepCounter==68) {
			p = list.get(ID);
			System.out.println("Insert File To Save To");
			current = scan1.next();
			p.Save();
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Now Returning To User Menu");
			stepCounter=42;
			
			
		}else if (stepCounter==69) {
			p = list.get(ID);
			System.out.println(p.stats());
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Now Returning To User Menu");
			stepCounter=42;
			
		}else {
			
		}
	
		
	}
		
	}

}