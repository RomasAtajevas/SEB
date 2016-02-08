package com.seb.controller;

import com.seb.model.Chart;
import com.seb.model.ExchangeRates;
import com.seb.model.ExchangeRates.Item;
import com.seb.service.ExchangeRatesService;
import java.util.List;
import java.util.stream.Collectors;
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
public class PageController {

    private ExchangeRates staticRates;

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

    @RequestMapping(value = {"/secondPage"}, method = RequestMethod.GET)
    public String secondPage(@RequestParam(value = "currency", required = false) String currency, Model model) {
        if (staticRates == null) {
            staticRates = exchangeRatesService.exchangeRatesByDate("2014-12-31");
        }

        List<Item> items = staticRates.getItems();

        if (currency != null) {
            String tmp = currency.trim().toUpperCase();
            if (!tmp.isEmpty()) {
                items = staticRates.getItems().stream().filter(i -> i.getCurrency().equals(tmp)).collect(Collectors.toList());
            }
        }

        model.addAttribute("currency", currency);
        model.addAttribute("items", items);

        return "secondPage";
    }

    @RequestMapping(value = {"/chart"}, method = RequestMethod.GET)
    public String chart(Model model) {
        model.addAttribute("currencies", exchangeRatesService.currencies());
        return "chart";
    }

    @RequestMapping(value = {"/updateRate"}, method = RequestMethod.POST)
    @ResponseBody
    public String updateRate(@RequestParam(value = "currency") String currency, @RequestParam(value = "value") double value) {
        staticRates.getItems().stream().filter(i -> i.getCurrency().equals(currency)).findFirst().ifPresent(i -> {
            i.setRate(value);
        });
        return "";
    }

    @RequestMapping(value = {"/chart/data"}, method = RequestMethod.GET)
    @ResponseBody
    public Chart chart(@RequestParam(value = "currency") String currency, @RequestParam(value = "from") String from, @RequestParam(value = "to") String to) {
        return exchangeRatesService.chart(currency, from, to);
    }
}
