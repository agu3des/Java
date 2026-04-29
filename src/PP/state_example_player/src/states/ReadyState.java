public class ReadyState extends State {

	public ReadyState(Player player) {
		super(player);
	}

	@Override
	public String onLock() {
		player.setPlaying(false);
		player.changeState(new LockedState(player));
		return "Recebeu stop, o estado está locked";
	}

	@Override
	public String onPlay() {
		player.setPlaying(true);
		player.startPlayback();
		player.changeState(new PlayingState(player));
		return "Recebeu play, o estado está playing a música para rapidamente";
	}

	@Override
	public String onNext() {
		return "Função não disponível";
	}

	@Override
	public String onPrevious() {
		return "Função não disponível";
	}
}
