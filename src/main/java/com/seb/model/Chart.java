package com.seb.model;

import java.util.List;

/**
 *
 * @author rataj
 */
public class Chart {

    private List<String> labels;
    private List<Dataset> datasets;

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public static class Dataset {

        private String label;
        private boolean fill;
        private String backgroundColor;
        private String borderColor;
        private String pointBorderColor;
        private String pointBackgroundColor;
        private int pointBorderWidth;
        private int pointHoverRadius;
        private String pointHoverBackgroundColor;
        private String pointHoverBorderColor;
        private int pointHoverBorderWidth;

        private List<Double> data;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public boolean getFill() {
            return fill;
        }

        public void setFill(boolean fill) {
            this.fill = fill;
        }

        public String getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        public String getBorderColor() {
            return borderColor;
        }

        public void setBorderColor(String borderColor) {
            this.borderColor = borderColor;
        }

        public String getPointBorderColor() {
            return pointBorderColor;
        }

        public void setPointBorderColor(String pointBorderColor) {
            this.pointBorderColor = pointBorderColor;
        }

        public String getPointBackgroundColor() {
            return pointBackgroundColor;
        }

        public void setPointBackgroundColor(String pointBackgroundColor) {
            this.pointBackgroundColor = pointBackgroundColor;
        }

        public int getPointBorderWidth() {
            return pointBorderWidth;
        }

        public void setPointBorderWidth(int pointBorderWidth) {
            this.pointBorderWidth = pointBorderWidth;
        }

        public int getPointHoverRadius() {
            return pointHoverRadius;
        }

        public void setPointHoverRadius(int pointHoverRadius) {
            this.pointHoverRadius = pointHoverRadius;
        }

        public String getPointHoverBackgroundColor() {
            return pointHoverBackgroundColor;
        }

        public void setPointHoverBackgroundColor(String pointHoverBackgroundColor) {
            this.pointHoverBackgroundColor = pointHoverBackgroundColor;
        }

        public String getPointHoverBorderColor() {
            return pointHoverBorderColor;
        }

        public void setPointHoverBorderColor(String pointHoverBorderColor) {
            this.pointHoverBorderColor = pointHoverBorderColor;
        }

        public int getPointHoverBorderWidth() {
            return pointHoverBorderWidth;
        }

        public void setPointHoverBorderWidth(int pointHoverBorderWidth) {
            this.pointHoverBorderWidth = pointHoverBorderWidth;
        }

        public List<Double> getData() {
            return data;
        }

        public void setData(List<Double> data) {
            this.data = data;
        }
    }
}
