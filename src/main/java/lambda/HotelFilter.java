package main.java.lambda;

@FunctionalInterface
public interface HotelFilter {
    public boolean filter(Hotel hotel);
}
