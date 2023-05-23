package abc.def.ghi;




public class Extensions01 {
    public static int addNumber(Element01 element, Integer number) {
        return element.data + number;
    }

    public static int addTwo(Element01 element) {
        return addNumber(element, 2);
    }
}
