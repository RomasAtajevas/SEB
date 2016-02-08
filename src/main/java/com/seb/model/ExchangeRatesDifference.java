package com.seb.model;

/**
 *
 * @author rataj
 */
public class ExchangeRatesDifference {

    private String currency;
    private double prevRate;
    private double curRate;
    private double difference;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrevRate() {
        return prevRate;
    }

    public void setPrevRate(double prevRate) {
        this.prevRate = prevRate;
    }

    public double getCurRate() {
        return curRate;
    }

    public void setCurRate(double curRate) {
        this.curRate = curRate;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }
}
