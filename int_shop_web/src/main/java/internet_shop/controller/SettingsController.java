package internet_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingsController {
    @RequestMapping(value = "/settings")
    public String settingsPage(ModelAndView modelAndView) {
        return "settingsPage";
    }


    @RequestMapping(value = "/settingsSave")
    public ModelAndView register(ModelAndView mav) {
        return mav;
    }

}