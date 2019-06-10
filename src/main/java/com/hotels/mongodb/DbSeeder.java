package com.hotels.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotels bombay= new Hotels(
                "Bombay",
                1000,
                new Address("Rajasthan","Jaipur"),
                Arrays.asList(
                        new Reviews("Shivam","Cheap Hotel", 3,false),
                        new Reviews("Ram","Not good", 2,true)
                )
                );

        Hotels geet= new Hotels(
                "Geet",
                3000,
                new Address("Uttar Pradesh","Kanpur"),
                Arrays.asList(
                        new Reviews("Shivam","Good hotel with good Location", 4,true)
                )
        );
        //drop all Hotels
        this.hotelRepository.deleteAll();

        // adding our Hotels
        List<Hotels> hotels= Arrays.asList(bombay,geet);
        this.hotelRepository.saveAll(hotels);

    }
}
