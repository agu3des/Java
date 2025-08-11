package PP.proxy_example_acessoVideosPremium;

public class ProxyVideoService implements VideoService {
    private RealVideoService realService;
    private boolean userIsPremium;

    public ProxyVideoService(boolean userIsPremium) {
        this.userIsPremium = userIsPremium;
    }

    @Override
    public void playVideo(int videoId) {
        // Carregamento preguiçoso (lazy loading)
        if (realService == null) {
            realService = new RealVideoService();
        }
        // Verificação de permissão
        if (realService.isVideoPremium(videoId) && !userIsPremium) {
            System.out.println("🚫 Acesso negado: Este vídeo é PREMIUM. Faça upgrade para assistir.");
        } else {
            realService.playVideo(videoId);
        }
    }

    @Override
    public String getVideoInfo(int videoId) {
        // Carregamento preguiçoso somente se necessário
        if (realService == null) {
            realService = new RealVideoService();
        }
        return realService.getVideoInfo(videoId);
    }
}

