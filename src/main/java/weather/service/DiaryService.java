package weather.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import weather.domain.Diary;
import weather.repository.DiaryRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    /*
     * open weather map에서 데이터 받아오기
     * 받아온 날씨 데이터 파싱하기
     * 우리 db에 저장하기
     * */
    @Value("${openweathermap.key}")
    private String apiKey;

    public void createDiary(LocalDate date, String text) {
        // #1
        String weatherData = getWeatherString();

        // #2
        Map <String,Object> parseWeather = parseWeather(weatherData);

        // #3
        Diary nowDiary = new Diary();
        nowDiary.setWeather(parseWeather.get("main").toString());
        nowDiary.setIcon(parseWeather.get("icon").toString());
        nowDiary.setTemperature((Double)parseWeather.get("temp"));
        nowDiary.setText(text);
        nowDiary.setDate(date);

        diaryRepository.save(nowDiary);
    }

    public List <Diary> readDiary(LocalDate date) {
       return diaryRepository.findAllByDate(date);
    }

    public List<Diary> readDiares(LocalDate startDate, LocalDate endDate) {
        return diaryRepository.findAllByDateBetween(startDate, endDate);
    }

    private String getWeatherString() {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;

        try {
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }

            br.close();

            return response.toString();
        } catch (Exception e) {
            return "failed to get Response";
        }
    }

    private Map <String,Object> parseWeather(String jsonString) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;

        try {
            jsonObject = (JSONObject) jsonParser.parse(jsonString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Map <String,Object> resultMap = new HashMap <>();
        JSONObject mainData = (JSONObject) jsonObject.get("main");
        resultMap.put("temp", mainData.get("temp"));
        JSONArray weatherArray = (JSONArray) jsonObject.get("weather");
        JSONObject weatherData = (JSONObject) weatherArray.get(0);
        resultMap.put("main", weatherData.get("main"));
        resultMap.put("icon", weatherData.get("icon"));

        return resultMap;

    }

}
