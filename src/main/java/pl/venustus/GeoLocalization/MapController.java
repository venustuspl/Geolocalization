package pl.venustus.GeoLocalization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MapController {

    @RequestMapping(method = RequestMethod.GET)
    public String getMap(Model model, @RequestParam String x, @RequestParam String y) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "map";

    }
}
