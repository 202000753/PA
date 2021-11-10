public class main {
    public static void main(String[] args) {

        MyRectangle m1 = new MyRectangle(5, 10, 6, 8, "Nice Rice");
        System.out.println(m1.toString());

        MyRectangle m2 = new MyRectangle(3.8, 9, "Ugly Rect");
        System.out.println(m2.toString());

        MySquare s1 = new MySquare(5, 6, 10,"Q-Linux");
        System.out.println(s1.toString());

        MySquare s2 = new MySquare(7.071, "Q-Dark");
        System.out.println(s2.toString());

        MySquare s3 = new MySquare(7.76933979345, "Q-Perfect");
        System.out.println(s3.toString());
    }
}

/*
MyRectangle{name='Nice Rect', x=5.0, y=10.0, width=6.0, height=8.0, area=48,00, perimeter=28,00, hypotenuse=10,00000000,
isPerfect=YES}
MyRectangle{name='Ugly Rect', x=0.0, y=0.0, width=3.8, height=9.0, area=34,20, perimeter=25,60, hypotenuse=9,76933979,
isPerfect=NO}
 */