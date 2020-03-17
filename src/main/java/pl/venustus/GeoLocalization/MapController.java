package pl.venustus.GeoLocalization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MapController {

    private Covid19Parser covid19Parser;

    public MapController(Covid19Parser covid19Parser) {
        this.covid19Parser = covid19Parser;
    }

    @GetMapping
    public String getMap(Model model//, @RequestParam String x, @RequestParam String y
    ) throws IOException {
        // model.addAttribute("x", x);
        // model.addAttribute("y", y);
        model.addAttribute("points", covid19Parser.getCovidData());

        return "index";

    }
}
