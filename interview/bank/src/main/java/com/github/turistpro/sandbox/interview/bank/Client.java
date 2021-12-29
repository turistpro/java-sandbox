package com.github.turistpro.sandbox.interview.bank;

public class Client {

    public Documents documents;

    public String type;

    public static class Documents {
        public Passport passport;
    }

    public static class Passport {
        public SeriesAndNumber seriesAndNumber;
    }

    public static class SeriesAndNumber {
        public void validate() {

        }
    }
}
