import java.io.File
;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;




public class Playlist implements Playable{


	Random numberGenerator = new Random();
	int position;
	int durationInSeconds = 0;
	ArrayList<Recording> list = new ArrayList<Recording>();
	String pName;
	
	String fileName;
	int current=0;

	public Playlist() {
		pName = "Unknown";
		position =0;
	}
	public Playlist(String input) {
		pName = input;
		position =0;
	}
	protected int getSize() {
		return list.size();
	}
	
	static void thrower(Recording newRecord) throws Unplayable {
		if (newRecord.getDuration()==0) {
			throw new Unplayable("Cannot Add Recording. The Duration is Zero");
		}
	}
	
	protected boolean add(Recording newRecord) {
		boolean state = false;
		int checker=0;
		try {
			if (newRecord!=null) {
				thrower(newRecord);
				for (int i=0;i<position;i++) {
					if (list.get(i).getArtist().equals(newRecord.getArtist()) && list.get(i).getName().equals(newRecord.getName())) {
						checker++;
					}
				}if (checker==0) {
					list.add(newRecord);
					position++;
					durationInSeconds = durationInSeconds + newRecord.getDuration();
					state=  true;
				}else System.out.println("Unable To Add. Already In Playlist");
			}
		}
		catch (Unplayable u) {
			System.out.println("Test threw a " + u.getClass() + " exception");
			System.out.println("with message: " + u.getMessage());
			
			}
			
			return false;
		
	}
	
	
	public void play() {
		if (position>0) {
			for (int i=0;i<position;i++) {
				if (list.get(i).equals(null)){
					continue;
				}
				else list.get(i).play();
		
			}
			System.out.println();
		}else System.out.println("Error: Empty Playlist");
	}
	
	public void play (int input) {
		if (position>0) {
			list.get(input).play();
		}else System.out.println("Error: Empty Playlsit");
	}
	
	public void play (String input) {
		String temp [] = input.split(",");
		if (position>0) {
			for (int i=0;i<position;i++) {
				if ((list.get(i).getArtist().equals(temp[0])) && (list.get(i).getName().equals(temp[1]))) {
					list.get(i).play();	
				}
			}
		}
		else {
			System.out.println("Error: Empty Playlsit");
		}
	}
	
	protected void shuffle() {
		if (position>0) {
			for (int i=0;i<position;i++) {
				list.get(numberGenerator.nextInt(position)).play();
				 
				
			}
		}
	}
	protected void remove(int input) {
		list.remove(input);
		position--;
		
		System.out.println("Succesfully Removed Song At Input " + input);
	
	}
	
	protected void remove(String input) {
		String temp [] = input.split(",");
		for (int i=0;i<position;i++) {
			if ((list.get(i).getArtist().equals(temp[0])) && (list.get(i).getName().equals(temp[1]))) {
				list.remove(i);
				System.out.println("Succesfully Removed " + input);
				position--;
			}else continue;
		}
		
	}
	
	
	protected void load(String input) {
		String [] tempArray = new String[5];
		String temp ="";
		
		try {
			File inputFile = new File(input);
			Scanner fileScanner = new Scanner(inputFile);
			
			
			while (fileScanner.hasNextLine()) {
				
				temp = fileScanner.nextLine();
				if (temp!=null) {
					tempArray = temp.split(",");
					
					try {
						
						if (tempArray[0].equals("V")) {
							VideoRecording newVideo = new VideoRecording(tempArray[2], tempArray[1], Integer.parseInt(tempArray[3]),
									Double.parseDouble(tempArray[4]));
							thrower(newVideo);
							int checker =0;
							for (int i=0;i<position;i++) {
								if (list.get(i).getArtist().equals(newVideo.getArtist()) && list.get(i).getName().equals(newVideo.getName())) {
									checker++;
								}
							}if (checker==0) {
								list.add(newVideo);
								position++;
							}else continue;
							
						}if (tempArray[0].equals("A")) {
							AudioRecording newAudio = new AudioRecording(tempArray[2], tempArray[1], Integer.parseInt(tempArray[3]),
									Double.parseDouble(tempArray[4]));
							thrower(newAudio);
							int checker =0;
							for (int i=0;i<position;i++) {
								if (list.get(i).getArtist().equals(newAudio.getArtist()) && list.get(i).getName().equals(newAudio.getName())) {
									checker++;
								}
							}if (checker==0) {
								list.add(newAudio);
								position++;
							}else continue;
							
						}
					}
					catch (NumberFormatException NFE) {
						System.out.println("Error Number Format Exception. Record: " + temp);
					}catch (ArrayIndexOutOfBoundsException AE) {
						System.out.println("Array Out Of Bounds Error. Record: " + temp);
					}catch (Unplayable u) {
						System.out.println("Test threw a " + u.getClass() + " exception");
						System.out.println("with message: " + u.getMessage());
						
					}
				}
			}
		}catch(FileNotFoundException fnfe){
			System.out.println("Error File:" + input + " Not Found" + "\n");
		}
			
		
	}
	
	public String toString() {
		String output="";
		
		for(int i=0;i<position;i++) {
			if (list.get(i).equals(null)) {
				continue;
			}
			else output = output + i +  " "+  list.get(i).toString() + "\n";
		
		}
		return output;
	}
	
	protected void Save() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_YYYY_HH_mm_ss");  
		LocalDateTime now = LocalDateTime.now();  
	
		try {
			fileName = pName + "_PLAYLIST_ " + dtf.format(now)+".csv";
			FileOutputStream fos = new
			FileOutputStream(fileName, false);
			
		
			PrintWriter pw = new PrintWriter(fos);
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<position;i++) {
				sb.append(list.get(i).getArtist());
				sb.append(',');
				sb.append(list.get(i).getName());
				sb.append(',');
				sb.append(list.get(i).getDuration());
				sb.append('\n');
			}
	
		      pw.write(sb.toString());
		      pw.close();
			} catch (FileNotFoundException e){
			System.out.println("No file!");
			}System.out.println (fileName + " Created");
	}
	
	protected String stats() {
		String output="";
		System.out.println("# of Plays" + "\t" + "Song");
		for(int i=0;i<position;i++) {
			if (list.get(i).equals(null)) {
				continue;
			}
			else output = output + list.get(i).NOP +"\t" + list.get(i).toString() + "\n";
		
		}
		return output;
	}
	
	
	
}

