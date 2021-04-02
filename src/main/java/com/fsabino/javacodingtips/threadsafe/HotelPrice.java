package com.fsabino.javacodingtips.threadsafe;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class HotelPrice {

    private BigDecimal price;
    private ZonedDateTime dateTime;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public HotelPrice(BigDecimal price, ZonedDateTime dateTime) {
        this.price = price;
        this.dateTime = dateTime;
    }
}
