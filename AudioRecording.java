

public class AudioRecording extends Recording{

	double bitRate =0;
	String Artist;
	String Name;
	int durationInSeconds;
	
	
	public AudioRecording() {
		Artist="Unknown";
		Name = "Unknown";
		durationInSeconds =0;
	}
	public AudioRecording(String inputArtist, String inputName, int inputDuration, double inputBitRate) {
		super(inputArtist, inputName, inputDuration);
		Artist = inputArtist;
		Name = inputName;
		durationInSeconds = inputDuration;
	
		if (inputBitRate>0) {
		bitRate = inputBitRate;
		}
	}
	
	public double getBitRate() {
		return bitRate;
	}
	
	public void play() {
		if (durationInSeconds>0) {
			System.out.println("Now playing:" + this.toString());
		} else {
			System.out.println("Error: Cannot play recording");
		}
	}
	
	@Override
	public String toString () {
		String out ="";
		out = Artist + " - " +  Name + "[" + durationInSeconds/60 +
				"m"+ durationInSeconds%60+"s]" + " Audio, BitRate:" + bitRate;
		return out;
	}
}
