package main.java.lambda;

import java.util.List;

public class Source {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();
        // List<Hotel> hotels = hotelService.filterHotels(new HotelFilter() {

        // @Override
        // public boolean filter(Hotel hotel) {
        // return hotel.getHotelRating() == HotelType.FIVE_STAR;
        // }

        // });

        List<Hotel> hotels = hotelService.filterHotels((hotel) -> {
            return hotel.getHotelRating() == HotelType.THREE_STAR;
        }

        );

        System.out.println(hotels);
    }
}
