package com.seb.service.impl;

import com.seb.comparator.ExchangeRateComparator;
import com.seb.model.Chart;
import com.seb.model.Currencies;
import com.seb.model.ExchangeRates;
import com.seb.model.ExchangeRatesDifference;
import com.seb.service.ExchangeRatesService;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

/**
 *
 * @author rataj
 */
@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

    @Override
    public ExchangeRates exchangeRatesByDate(String date) {
        try {
            JAXBContext context = JAXBContext.newInstance(ExchangeRates.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            String url = "http://www.lb.lt/webservices/ExchangeRates/ExchangeRates.asmx/getExchangeRatesByDate?Date=" + date;
            return (ExchangeRates) unmarshaller.unmarshal(new URL(url).openStream());
        } catch (JAXBException | IOException ex) {
            return null;
        }
    }

    @Override
    public ExchangeRates exchangeRatesByCurrency(String currency, String from, String to) {
        try {
            JAXBContext context = JAXBContext.newInstance(ExchangeRates.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            String url = "http://www.lb.lt/webservices/ExchangeRates/ExchangeRates.asmx/getExchangeRatesByCurrency?Currency=" + currency + "&DateLow=" + from + "&DateHigh=" + to;
            return (ExchangeRates) unmarshaller.unmarshal(new URL(url).openStream());
        } catch (JAXBException | IOException ex) {
            return null;
        }
    }

    @Override
    public List<ExchangeRatesDifference> calculateDifferences(String selectedDate) {
        ExchangeRates previousRates = exchangeRatesByDate(LocalDate.parse(selectedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")).minusDays(1).toString());
        ExchangeRates selectedRates = exchangeRatesByDate(selectedDate);

        List<ExchangeRatesDifference> differences = new ArrayList<>();

        int index = 0;
        for (ExchangeRates.Item previousItem : previousRates.getItems()) {
            ExchangeRates.Item selectedItem = selectedRates.getItems().get(index);

            ExchangeRatesDifference difference = new ExchangeRatesDifference();
            difference.setCurrency(previousItem.getCurrency());
            difference.setPrevRate(previousItem.getRate());
            difference.setCurRate(selectedItem.getRate());
            difference.setDifference((selectedItem.getRate() - previousItem.getRate()) / previousItem.getRate() * 100);
            differences.add(difference);

            index++;
        }

        Collections.sort(differences, new ExchangeRateComparator());

        return differences;
    }

    @Override
    public Currencies currencies() {
        try {
            JAXBContext context = JAXBContext.newInstance(Currencies.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            String url = "http://www.lb.lt/webservices/ExchangeRates/ExchangeRates.asmx/getListOfCurrencies?";
            return (Currencies) unmarshaller.unmarshal(new URL(url).openStream());
        } catch (JAXBException | IOException ex) {
            return null;
        }
    }

    @Override
    public Chart chart(String currency, String from, String to) {
        ExchangeRates rates = exchangeRatesByCurrency(currency, from, to);

        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        rates.getItems().stream().forEach(i -> {
            labels.add(i.getDate());
            data.add(i.getRate());
        });

        Chart chart = new Chart();

        Chart.Dataset dataset = new Chart.Dataset();
        dataset.setLabel("Rate");
        dataset.setFill(true);
        dataset.setBackgroundColor("rgba(220,220,220,0.2)");
        dataset.setBorderColor("rgba(220,220,220,1)");
        dataset.setPointBorderColor("rgba(220,220,220,1)");
        dataset.setPointBackgroundColor("#fff");
        dataset.setPointBorderWidth(0);
        dataset.setPointHoverRadius(0);
        dataset.setPointHoverBackgroundColor("rgba(220,220,220,1)");
        dataset.setPointHoverBorderColor("rgba(220,220,220,1)");
        dataset.setPointHoverBorderWidth(0);
        dataset.setData(data);

        chart.setDatasets(Arrays.asList(dataset));
        chart.setLabels(labels);

        return chart;
    }
}
