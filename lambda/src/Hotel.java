import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private Integer price;
    private HotelType hotelType;
    private Integer rating;


    public Hotel(Integer price, HotelType hotelType, Integer rating) {
        this.price = price;
        this.hotelType = hotelType;
        this.rating = rating;
    }


    public Integer getPrice(){
        return price;
    }

    public String toString(){
        return "Hotel price: " + price + " " +
                "Hotel Rating: " + rating +
                " Hotel Type: " + hotelType;
    }





}
