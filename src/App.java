import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://imdb-api.com/en/API/Top250Movies/k_zyg9gynt"))
            .version(HttpClient.Version.HTTP_2)
            .GET()
            .build();
        HttpResponse<String> send = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build()
            .send(request, BodyHandlers.ofString());

        System.out.println(send.body());
    }
}
