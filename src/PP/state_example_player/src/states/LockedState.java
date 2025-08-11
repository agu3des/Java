public class LockedState extends State {

	public LockedState(Player player) {
		super(player);
		player.setPlaying(false); // não fiz
	}

	@Override
	public String onLock() {
		String res;
		if (player.isPlaying()) {
			player.changeState(new ReadyState(player));
			res = "Parando a música";
		} else {
			res = "Está travado";
		}
		return res;
	}

	@Override
	public String onPlay() {
		player.changeState(new ReadyState(player));
		return "Recebeu play, o estado está ready";
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
