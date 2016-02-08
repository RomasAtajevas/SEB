package com.seb.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rataj
 */
@XmlRootElement(name = "ExchangeRates")
public class ExchangeRates {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    @XmlElementRef
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @XmlRootElement
    public static class Item {

        private String date;
        private String currency;
        private int quantity;
        private double rate;
        private String unit;

        public String getDate() {
            return date;
        }

        @XmlElement
        public void setDate(String date) {
            this.date = date;
        }

        public String getCurrency() {
            return currency;
        }

        @XmlElement
        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getQuantity() {
            return quantity;
        }

        @XmlElement
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getRate() {
            return rate;
        }

        @XmlElement
        public void setRate(double rate) {
            this.rate = rate;
        }

        public String getUnit() {
            return unit;
        }

        @XmlElement
        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
}
