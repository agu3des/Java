package PP.proxy_example_acessoVideosPremium;

public class Client {
    public static void main(String[] args) {
        System.out.println("Usuário COMUM:");
        VideoService proxyComum = new ProxyVideoService(false);

        System.out.println(proxyComum.getVideoInfo(2)); // Curso Java (Premium)
        proxyComum.playVideo(2); // Bloqueado
        proxyComum.playVideo(3); // Permitido

        System.out.println("\nUsuário PREMIUM:");
        VideoService proxyPremium = new ProxyVideoService(true);

        System.out.println(proxyPremium.getVideoInfo(4)); // Aula Premium
        proxyPremium.playVideo(4); // Permitido
    }
}
