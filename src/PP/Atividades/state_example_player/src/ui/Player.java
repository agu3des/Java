package ui;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private State state;
	private boolean playing = false;
	List<String> playlist = new ArrayList<>();
	private int currentTrack = 0;

	public Player() {// tinha instanciado no construtor, mas está errado
		this.state = new ReadyState(this);
		setPlaying(true); // errei colocando o this.playing

		playlist.add(0, "Imagine - John Lennon");
		playlist.add(1, "Bohemian Rhapsody - Queen");
		playlist.add(2, "Hotel California - Eagles");
		playlist.add(3, "Hey Jude - The Beatles");
	}

	public void changeState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public boolean isPlaying() {
		return playing;
	}

	public String startPlayback() {
		return playlist.get(currentTrack);
	}

	public String nextTrack() {
		// return playlist.get(currentTrack+1);
		currentTrack++;
		if (currentTrack > playlist.size() - 1) { // verificação do máximo de músicas
			currentTrack = 0;
		}
		return playlist.get(currentTrack);
	}

	public String previousTrack() {
		// return playlist.get(currentTrack-1);
		currentTrack--;
		if (currentTrack < 0) { // verificação do mínimo de músicas
			currentTrack = playlist.size() - 1;
		}
		return playlist.get(currentTrack);
	}

	public void setCurrentTrackAfterStop() {
		// currentTrack = playlist.get(currentTrack);
		// startPlayback();
		this.currentTrack = 0;
	}
}
