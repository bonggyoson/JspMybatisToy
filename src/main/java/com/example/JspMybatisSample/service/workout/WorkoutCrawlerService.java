package com.example.JspMybatisSample.service.workout;

import com.example.JspMybatisSample.domain.workout.WorkoutCrawler;
import com.example.JspMybatisSample.mapper.workout.WorkoutMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutCrawlerService {

    private final WorkoutMapper workoutMapper;
    private final String BASE_URL = "https://www.crossfit.com/heroes/";

    public void crawlWods() {

        String url = BASE_URL;
        List<WorkoutCrawler> wods = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();

            Elements wodElements = doc.select("main ._component_1ent8_1 ._wrapper_1ijtm_18");

            for (Element element : wodElements) {
                String name =
                    element.select("h3 > strong").text() == ""
                        ? element.select("h3 > a > strong").text()
                        : element.select("h3 > strong").text();
                String description = element.select("h3 + p").text();

                WorkoutCrawler wod = new WorkoutCrawler();
                wod.setName(name);
                wod.setDescription(description);
                wods.add(wod);
            }

//            String description = doc.select("._wrapper_1ijtm_18 > h3 > p").text();
//
//            WorkoutCralwer wod = new WorkoutCralwer();
//            wod.setDate(date);
//            wod.setName(name);
//            wod.setDescription(description);
        } catch (IOException e) {
            e.printStackTrace();
        }
        workoutMapper.insertWorkout(wods);
    }

}
