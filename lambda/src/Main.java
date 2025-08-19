import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static FilterCondition getLamdaExp(){
        return  hotel->
             hotel.getPrice()<=2000;

    }
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();
        //passing fun as param using interface
        List<Hotel> hotelByPrice2000 = hotelService.filterHotels(new HotelByPrice2000());
        System.out.println(hotelByPrice2000);
        //using anonymous class
        List<Hotel> hotelByPriceGreater2000 = hotelService.filterHotels(new FilterCondition() {
            @Override
            public boolean test(Hotel hotel) {
                return hotel.getPrice()>2000;
            }
        });
        System.out.println(hotelByPriceGreater2000);
        List<Hotel> hotelByPriceGreater3000 = hotelService.filterHotels(hotel ->
             hotel.getPrice()>3000
        );
        System.out.println(hotelByPriceGreater3000);

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        list.sort((a, b) ->
             b - a
        );
        System.out.println(list);
        FilterCondition filterCondition=Main.getLamdaExp();
        List<Hotel> hotelByPriceLess2000=hotelService.filterHotels(filterCondition);
        System.out.println(hotelByPriceLess2000);

        Predicate<Integer> divisibleBy2= num->num%2==0;
        Predicate<Integer> divisibleBy3= num->num%3==0;
        Predicate<Integer> divisibleBy6=divisibleBy2.and(divisibleBy3);
        Consumer<Integer>consumer= l->System.out.print(l+" ");
        list.forEach(consumer);
        System.out.println(divisibleBy6.test(61));

        Function<Integer,Integer> squares= a->a*a;
        Function<Integer,Integer> addOne= a->a+1;
        System.out.println(squares.andThen(addOne).andThen(squares).apply(7));

    }
}