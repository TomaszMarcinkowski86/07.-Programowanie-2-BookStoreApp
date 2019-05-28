package extras;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

    class FlatMap_ {

        public static void main(String[] args) {
            List<String> names1 = Arrays.asList("Adam", "Marta");
            List<String> names2 = Arrays.asList("Marcin", "Agata");
            List<String> names3 = Arrays.asList("Marek", "Karolina");

            List<List<String>> names = Arrays.asList(names1, names2, names3);
            System.out.println(names.stream().flatMap(list -> list.stream()).collect(Collectors.toList()));

        }
    }
