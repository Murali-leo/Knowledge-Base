package main.java.lambda;

public class Hotel {
    HotelType hotelRating;
    String hotelName;
    int hotelRoomPrice;
    
    public HotelType getHotelRating() {
        return hotelRating;
    }
    @Override
    public String toString() {
        return "Hotel [hotelRating=" + hotelRating + ", hotelName=" + hotelName + ", hotelRoomPrice=" + hotelRoomPrice
                + "]";
    }
    public void setHotelRating(HotelType hotelRating) {
        this.hotelRating = hotelRating;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public int getHotelRoomPrice() {
        return hotelRoomPrice;
    }
    public void setHotelRoomPrice(int hotelRoomPrice) {
        this.hotelRoomPrice = hotelRoomPrice;
    }
}
