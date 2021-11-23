package pt.pa.adts;

public class City<E> {
    private E city;

    public City(E city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "'" +  city + "'";
    }

    public E getCity() {
        return city;
    }
}
