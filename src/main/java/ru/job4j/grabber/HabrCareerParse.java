package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrCareerParse {

    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 6; i++) {
            Connection connection = Jsoup.connect(PAGE_LINK + "?page=" + i);
            HabrCareerParse habrCareerParse = new HabrCareerParse();
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                Element titleElement = row.select(".vacancy-card__title").first();
                Element timeElement = row.select(".vacancy-card__date").first().child(0);
                Element linkElement = titleElement.child(0);
                String vacancyName = titleElement.text();
                String vacancyDate = timeElement.attr("datetime");
                String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
                String description = habrCareerParse.retrieveDescription(link);
                System.out.printf("%s -  %s%n%s%n%s%n%n", vacancyName, vacancyDate, description, link);
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
