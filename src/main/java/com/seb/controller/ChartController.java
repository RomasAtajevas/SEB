package com.seb.controller;

import com.seb.model.Chart;
import com.seb.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rataj
 */
@Controller
public class ChartController {

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @RequestMapping(value = {"/chart"}, method = RequestMethod.GET)
    public String chart(Model model) {
        model.addAttribute("currencies", exchangeRatesService.currencies());
        return "chart";
    }

    @RequestMapping(value = {"/chart/data"}, method = RequestMethod.GET)
    @ResponseBody
    public Chart chart(@RequestParam(value = "currency") String currency, @RequestParam(value = "from") String from, @RequestParam(value = "to") String to) {
        return exchangeRatesService.chart(currency, from, to);
    }
}
