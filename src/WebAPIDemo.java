import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class WebAPIDemo {

    public static void main(String[] args)
    {
        String APIkey = "COPY/PASTE YOUR MOVIES DATABASE API KEY HERE";

        String urlNowPlaying = "https://api.themoviedb.org/3/movie/550?api_key=619ae770e092971c49bb9f6679b39c76" + APIkey + "&language=en-US";
        makeAPICall(urlNowPlaying);

        System.out.print("Which movie (enter ID)? ");
        Scanner s = new Scanner(System.in);
        String movieID = s.nextLine();

        String movieURL = "https://api.themoviedb.org/3/movie/" + movieID + "?api_key=" + APIkey + "&language=en-US";
        makeAPICall(movieURL);
    }

    public static void makeAPICall(String url)
    {
        try {
            URI myUri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}