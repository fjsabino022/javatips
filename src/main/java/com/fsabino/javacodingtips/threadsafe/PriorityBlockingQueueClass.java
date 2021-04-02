package com.fsabino.javacodingtips.threadsafe;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueClass {

    @Test
    public void given__when__then_() {
        // given
        Comparator<HotelPrice> comparator = Comparator.comparing(HotelPrice::getPrice).reversed().thenComparing(HotelPrice::getDateTime);

        final PriorityBlockingQueue<HotelPrice> repository = new PriorityBlockingQueue<HotelPrice>(1, comparator);
        repository.add(new HotelPrice(BigDecimal.TEN, ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        repository.add(new HotelPrice(new BigDecimal(100), ZonedDateTime.now()));
        
        // when
        HotelPrice hotelResult = repository.poll();
        HotelPrice hotelResult1 = repository.poll();

        // then
    }
}
