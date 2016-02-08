package com.seb.controller;

import com.seb.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rataj
 */
@Controller
public class FirstPageController {

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @RequestMapping(value = {"/", "/firstPage"}, method = RequestMethod.GET)
    public String firstPage(@RequestParam(value = "date", required = false) String date, Model model) throws Exception {
        if (date == null) {
            date = "2014-12-31";
        }

        model.addAttribute("date", date);
        model.addAttribute("differences", exchangeRatesService.calculateDifferences(date));

        return "firstPage";
    }
}
