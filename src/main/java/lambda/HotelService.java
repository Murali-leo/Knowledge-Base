package main.java.lambda;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    List<Hotel> hotels;

    HotelService() {
        hotels = new ArrayList<>();
        Hotel hotel1 = new Hotel();
        hotel1.hotelName = "Grand Palace";
        hotel1.hotelRating = HotelType.FIVE_STAR;
        hotel1.hotelRoomPrice = 500;

        Hotel hotel2 = new Hotel();
        hotel2.hotelName = "City Inn";
        hotel2.hotelRating = HotelType.FOUR_STAR;
        hotel2.hotelRoomPrice = 300;

        Hotel hotel3 = new Hotel();
        hotel3.hotelName = "Budget Stay";
        hotel3.hotelRating = HotelType.THREE_STAR;
        hotel3.hotelRoomPrice = 100;

        hotels.add(hotel1);
        hotels.add(hotel2);
        hotels.add(hotel3);
    }

    List<Hotel> filterHotels(HotelFilter hotelFilter) {
        List<Hotel> filteredHotels = new ArrayList<>();
        if(hotels != null && !hotels.isEmpty()) {
            for(Hotel hotel : hotels) {
                if(hotelFilter.filter(hotel)) {
                    filteredHotels.add(hotel);
                }
            }
        }
        return filteredHotels;
    }
}
