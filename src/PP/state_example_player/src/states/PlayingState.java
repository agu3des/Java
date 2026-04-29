public class PlayingState extends State {

	public PlayingState(Player player) {
		super(player);
	}

	@Override
	public String onLock() {
		player.setPlaying(false);
		player.changeState(new LockedState(player));
		player.setCurrentTrackAfterStop();
		return "Recebeu stop, o estado está locked e a reprodução parada";
	}

	@Override
	public String onPlay() {
		// player.setPlaying(true);
		player.changeState(new ReadyState(player));
		// player.startPlayback();
		return "Pausa";
	}

	@Override
	public String onNext() {
		return player.nextTrack(); // errei

	}

	@Override
	public String onPrevious() {
		return player.previousTrack(); // errei

	}
}
