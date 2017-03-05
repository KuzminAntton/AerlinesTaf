package com.epam.tat.airlines.taf.bean.flight;

public class FlightSearchParameters {
    private FlightType flightType;
    private String departure;
    private String destination;
    private String departureDate;
    private String returnDate;
    private String secondDeparture;
    private String secondDestination;
    private int adultsAmount;
    private int childrenAmount;
    private int infantsAmount;

    public FlightSearchParameters() {}

    public int getAdultsAmount() {
        return adultsAmount;
    }

    public int getChildrenAmount() {
        return childrenAmount;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public int getInfantsAmount() {
        return infantsAmount;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getSecondDeparture() {
        return secondDeparture;
    }

    public String getSecondDestination() {
        return secondDestination;
    }

    public void setAdultsAmount(int adultsAmount) {
        this.adultsAmount = adultsAmount;
    }

    public void setChildrenAmount(int childrenAmount) {
        this.childrenAmount = childrenAmount;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public void setInfantsAmount(int infantsAmount) {
        this.infantsAmount = infantsAmount;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setSecondDeparture(String secondDeparture) {
        this.secondDeparture = secondDeparture;
    }

    public void setSecondDestination(String secondDestination) {
        this.secondDestination = secondDestination;
    }
}