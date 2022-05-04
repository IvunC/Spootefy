public abstract class Recording implements Playable{

	private final String Artist;
	private final String Name;
	private final int durationInSeconds;
	int NOP; //number of plays
	
	public Recording() {
		Artist="Unknown";
		Name = "Unknown";
		durationInSeconds =0;
		NOP=0;
		
	}
	public Recording(String inputArtist, String inputName, int inputDuration) {
		if (inputArtist!=null && inputName!=null && inputDuration>0) {
			Artist = inputArtist;
			 Name = inputName;
			durationInSeconds = inputDuration;
		}else {
			Artist="Unknown";
			Name = "Unknown";
			durationInSeconds =0;
		}
	}

	public String getArtist() {
		return Artist;
	}public String getName() {
		return Name;
	}public int getDuration() {
		return durationInSeconds;
	}


	public void play() {
		if (durationInSeconds>0) {
			System.out.println("Now playing:" + this.toString());
			NOP++;
		} else {
			System.out.println("Error: Cannot play recording");
		}
	}


	public String toString() {
		String out ="";
		out = " " + Artist + " - " +  Name + "[" + durationInSeconds/60 +
				"m"+ durationInSeconds%60+"s]";
		return out;
	}
	
}
