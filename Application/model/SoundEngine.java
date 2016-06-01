

/*
 * Ljudmotorn använder sig av klassen AudioClip då den har inbyggd sekvensiering och är lämplig 
 * för korta klipp med bakgrundstrådning.
 * Varje klipp har en playpSound metod, dessa kan kallas globalt via .playAudioClip() metod.
 */


package Application.model;

import java.net.URL;

import javafx.scene.media.AudioClip;

public class SoundEngine {

	private AudioClip pSound0, pSound1, pSound2, pSound3, pSound4;
	private URL pAudioFile0, pAudioFile1, pAudioFile2, pAudioFile3, pAudioFile4;

	public SoundEngine(){
		loadAudioAssets();
	}


	public void loadAudioAssets() {
		System.out.println("loading audio assets");
		pAudioFile0 = getClass().getResource("../resources/ball_start.wav");//relativ sökväg istället för hårdkodat
		pSound0 = new AudioClip(pAudioFile0.toString());
		pAudioFile1 = getClass().getResource("../resources/R_paddle_hit.wav");
		pSound1 = new AudioClip(pAudioFile1.toString());
		pAudioFile2 = getClass().getResource("../resources/L_paddle_hit.wav");
		pSound2 = new AudioClip(pAudioFile2.toString());
		pAudioFile3 = getClass().getResource("../resources/top_bottom_hit.wav");
		pSound3 = new AudioClip(pAudioFile3.toString());
		pAudioFile4 = getClass().getResource("../resources/back_wall_hit.wav");
		pSound4 = new AudioClip(pAudioFile4.toString());
		System.out.println("successfully loaded audio assets");
	}


	public AudioClip getpSound0() {
		return pSound0;
	}


	public void playpSound0() {
		this.pSound0.play();
	}


	public AudioClip getpSound1() {
		return pSound1;
	}


	public void playpSound1() {
		this.pSound1.play();
	}


	public AudioClip getpSound2() {
		return pSound2;
	}


	public void playpSound2() {
		this.pSound2.play();
	}


	public AudioClip getpSound3() {
		return pSound3;
	}


	public void playpSound3() {
		this.pSound3.play();;
	}


	public AudioClip getpSound4() {
		return pSound4;
	}


	public void playpSound4() {
		this.pSound4.play();
	}



}
