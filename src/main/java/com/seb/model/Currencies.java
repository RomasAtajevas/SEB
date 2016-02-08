package com.seb.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rataj
 */
@XmlRootElement(name = "Currencies")
public class Currencies {

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

        private String currency;

        public String getCurrency() {
            return currency;
        }

        @XmlElement
        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
