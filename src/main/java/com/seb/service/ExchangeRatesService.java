package com.seb.service;

import com.seb.model.Chart;
import com.seb.model.Currencies;
import com.seb.model.ExchangeRates;
import com.seb.model.ExchangeRatesDifference;
import java.util.List;

/**
 *
 * @author rataj
 */
public interface ExchangeRatesService {

    public ExchangeRates exchangeRatesByDate(String date);

    public ExchangeRates exchangeRatesByCurrency(String currency, String from, String to);

    public List<ExchangeRatesDifference> calculateDifferences(String selectedDate);

    public Currencies currencies();

    public Chart chart(String currency, String from, String to);
}
