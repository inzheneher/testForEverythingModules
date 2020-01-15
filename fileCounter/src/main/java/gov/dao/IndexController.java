package gov.dao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/input_path")
    public String showSubmitForm(Model model) {
        model.addAttribute("paths", new PathCollector());
        return "input_path";
    }
}
