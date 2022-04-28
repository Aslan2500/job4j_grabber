package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.HabrCareerDateTimeParser;

import java.io.IOException;
import java.time.LocalDateTime;

public class HabrCareerParse {

    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);

    private final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 6; i++) {
            Connection connection = Jsoup.connect(PAGE_LINK + "?page=" + i);
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                HabrCareerDateTimeParser habrCareerDateTimeParser = new HabrCareerDateTimeParser();
                HabrCareerParse habrCareerParse = new HabrCareerParse(habrCareerDateTimeParser);
                Element titleElement = row.select(".vacancy-card__title").first();
                Element timeElement = row.select(".vacancy-card__date").first().child(0);
                Element linkElement = titleElement.child(0);
                String vacancyName = titleElement.text();
                LocalDateTime localDateTime = habrCareerParse.dateTimeParser.parse(timeElement.attr("datetime"));
                String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
                String description = habrCareerParse.retrieveDescription(link);
                System.out.printf("%s -  %s%n%s%n%s%n%n", vacancyName, localDateTime, description, link);
            });
        }
    }

    private String retrieveDescription(String link) {
        String rsl = null;
        try {
            Connection connection = Jsoup.connect(link);
            Document document = connection.get();
            Element descriptionElement = document.selectFirst(".style-ugc");
            rsl = descriptionElement.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
