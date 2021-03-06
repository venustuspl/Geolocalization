package pl.venustus.GeoLocalization;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Covid19Parser {

    public static final String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";

    public List<Point> getCovidData() throws IOException {

        List<Point> points = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String values = restTemplate.getForObject(url, String.class);

        StringReader stringReader = new StringReader(values);
        CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

        for (CSVRecord strings : parse) {
            //System.out.println(strings);
            double lat = Double.parseDouble(strings.get("Lat"));
            double lon = Double.parseDouble(strings.get("Long"));
            int month = LocalDate.now().getMonthValue();
            int day = LocalDate.now().getDayOfMonth();
            day--;
            String year = String.valueOf(LocalDate.now().getYear()).substring(2);

            String text = strings.get(month + "/" + day + "/" + year);
            points.add(new Point(lat, lon, text));

        }

        return points;
    }
}
