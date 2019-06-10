package com.hotels.mongodb;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotels> getAll(){
        List<Hotels> hotels= this.hotelRepository.findAll();
        return hotels;
    }
   @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.hotelRepository.deleteById(id);
    }

    @PutMapping
    public void insert(@RequestBody Hotels hotel){
        this.hotelRepository.insert(hotel);
    }

    @PostMapping
    public void update(@RequestBody Hotels hotel){
        this.hotelRepository.save(hotel);
    }

    @GetMapping("/price/{max}")
    public List<Hotels> getByRate(@PathVariable("max") int max){
        List<Hotels> hotels = this.hotelRepository.findByrateLessThan(max);
        return hotels;
    }

    @GetMapping("/{id}")
    public Hotels getById(@PathVariable("id") String id){
        Hotels hotel= this.hotelRepository.findByid(id);
        return hotel;
    }

    @GetMapping("/address/{city}")
    public List<Hotels> getByCity(@PathVariable("city") String city){
        QHotels qHotels=new QHotels("hotel");
        BooleanExpression filterByCity=qHotels.address.city.eq(city);
        List<Hotels> hotels=(List<Hotels>)this.hotelRepository.findAll(filterByCity);
        return hotels;
    }

    @GetMapping("/recommended/{rating}")
    public List<Hotels> getByRating(@PathVariable("rating")int rating){

        final int price=4000;
        QHotels qhotels= new QHotels("Hotel");
        BooleanExpression filterByPrice= qhotels.rate.lt(price);
        BooleanExpression filterByRating= qhotels.reviews.any().rating.goe(rating);
        List<Hotels> hotels=(List<Hotels>)this.hotelRepository.findAll(filterByPrice.and(filterByRating));
        return hotels;
    }
}
