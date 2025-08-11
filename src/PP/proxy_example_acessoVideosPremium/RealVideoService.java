package PP.proxy_example_acessoVideosPremium;

import java.util.HashMap;
import java.util.Map;

public class RealVideoService implements VideoService {
    private Map<Integer, Video> videoDatabase;

    public RealVideoService() {
        System.out.println("Inicializando o serviço real de vídeo (pode ser custoso)...");
        videoDatabase = new HashMap<>();
        // Simulação de base de dados de vídeos
        videoDatabase.put(1, new Video(1, "Documentário Natureza", "10min", false));
        videoDatabase.put(2, new Video(2, "Curso Avançado de Java", "2h", true));
        videoDatabase.put(3, new Video(3, "Show de Música", "1h30", false));
        videoDatabase.put(4, new Video(4, "Aula Premium de Design Patterns", "1h", true));
    }

    @Override
    public void playVideo(int videoId) {
        Video video = videoDatabase.get(videoId);
        if (video != null) {
            System.out.println("▶ Reproduzindo vídeo: " + video.getTitle());
        } else {
            System.out.println("Vídeo não encontrado.");
        }
    }

    @Override
    public String getVideoInfo(int videoId) {
        Video video = videoDatabase.get(videoId);
        if (video != null) {
            return "Título: " + video.getTitle() + " | Duração: " + video.getDuration() +
                   (video.isPremium() ? " | PREMIUM" : " | Gratuito");
        }
        return "Vídeo não encontrado.";
    }

    public boolean isVideoPremium(int videoId) {
        Video video = videoDatabase.get(videoId);
        return video != null && video.isPremium();
    }
}
