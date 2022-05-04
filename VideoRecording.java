public class VideoRecording extends Recording{

	double frameRate =0;
	 String Artist;
	 String Name;
	 int durationInSeconds;
	
	 public VideoRecording() {
		 Artist="Unknown";
		Name = "Unknown";
		durationInSeconds =0;
	 }
	public VideoRecording(String inputArtist, String inputName, int inputDuration, double inputFrameRate) {
		super(inputArtist, inputName, inputDuration);
		Artist = inputArtist;
		Name = inputName;
		durationInSeconds = inputDuration;
		if (inputFrameRate>0) {
		frameRate = inputFrameRate;
		}
	}
	
	public double getFrameRate() {
		return frameRate;
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
				"m"+ durationInSeconds%60+"s]" + " Video, FrameRate:" + frameRate;
		return out;
	}

}