package nus.iss.ais.petoria.service.iml;

import lombok.extern.slf4j.Slf4j;
import nus.iss.ais.petoria.config.TelegramBotConfig;
import nus.iss.ais.petoria.service.PictureService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@Slf4j
public class PictureServiceIml implements PictureService {
    @Autowired
    private TelegramBotConfig telegramBotConfig;

    @Override
    public String getPictureIdFromTelegram(Update update) {
        List<PhotoSize> photoList = update.getMessage().getPhoto();

        PhotoSize largestPhoto = photoList.get(photoList.size() - 1);

        return largestPhoto.getFileId();
    }

    @Override
    public String getPicturePath(String pictureId) throws Exception {
        String BOT_TOKEN = telegramBotConfig.getToken();
        String TELEGRAM_API_BASE_URL = "https://api.telegram.org/bot" + BOT_TOKEN;
        HttpClient client = HttpClient.newHttpClient();

        String getFileUrl = TELEGRAM_API_BASE_URL + "/getFile?file_id=" + pictureId;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(getFileUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Failed to get file path: " + response.body());
        }
        JSONObject jsonResponse = new JSONObject(response.body());
        return jsonResponse.getJSONObject("result").getString("file_path");
    }

    @Override
    public String downloadAndSendToFlask(String filePath) throws Exception {
        String BOT_TOKEN = telegramBotConfig.getToken();
        String TELEGRAM_FILE_BASE_URL = "https://api.telegram.org/file/bot" + BOT_TOKEN + "/";

        String fileUrl = TELEGRAM_FILE_BASE_URL + filePath;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fileUrl))
                .build();

        HttpResponse<InputStream> imageResponse = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        String localImagePath = "downloaded_image.jpg";
        Files.copy(imageResponse.body(), Paths.get(localImagePath), StandardCopyOption.REPLACE_EXISTING);

        return sendImageToFlask(localImagePath);
    }

    private String sendImageToFlask(String imagePath) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String flaskUrl = "http://localhost:5000/process_image";

        Path imageFile = Paths.get(imagePath);
        String boundary = "Boundary-" + System.currentTimeMillis();

        byte[] imageBytes = Files.readAllBytes(imageFile);

        String body = "--" + boundary + "\r\n" +
                "Content-Disposition: form-data; name=\"file\"; filename=\"" + imageFile.getFileName() + "\"\r\n" +
                "Content-Type: image/jpeg\r\n\r\n";

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofByteArrays(
                List.of(
                        body.getBytes(),
                        imageBytes,
                        ("\r\n--" + boundary + "--\r\n").getBytes()
                )
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(flaskUrl))
                .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                .POST(bodyPublisher)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            log.info("Image successfully sent to Flask for processing.");
        } else {
            log.info("Failed to send image to Flask. Response Code: " + response.statusCode());
        }

        return response.body();
    }
}

