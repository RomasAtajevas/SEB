package com.seb.comparator;

import com.seb.model.ExchangeRatesDifference;
import java.util.Comparator;

/**
 *
 * @author rataj
 */
public class ExchangeRateComparator implements Comparator<ExchangeRatesDifference> {

    @Override
    public int compare(ExchangeRatesDifference o1, ExchangeRatesDifference o2) {
        return o1.getDifference() > o2.getDifference() ? -1 : (o1.getDifference() < o2.getDifference() ? 1 : 0);
    }
}
