package hu.menetrendekplus.backend.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.menetrendekplus.backend.model.request.MenetrendekRequest;
import hu.menetrendekplus.backend.model.response.MenetrendekResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MenetrendekHttpRequestHandler {

    private final ObjectMapper mapper = new ObjectMapper();

    public MenetrendekResponse<?> sendRequest(MenetrendekRequest<?> body) throws IOException, InterruptedException, URISyntaxException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(new URI("https://menetrendek.hu/menetrend/interface/index.php"))
                .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(body)))
                .build();

        return mapper.readValue(client.send(request, HttpResponse.BodyHandlers.ofString()).body(), new TypeReference<>() {});
    }
}
