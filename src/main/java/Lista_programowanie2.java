import java.util.*;

public class Lista_programowanie2 {

    public static void main(String[] args) {

//    Stwórz listę imion, i dodaj do niej 5 elementów (Marek, Aleksandra, Marta, Jakub, Bartosz).
        List<String> listaImion = new ArrayList<>();
        listaImion.add("Marek");
        listaImion.add("Aleksandra");
        listaImion.add("Marta");
        listaImion.add("Jakub");
        listaImion.add("Bartosz");

//Wyświetl całą listę.
        System.out.println(listaImion);

        //Wyświetl rozmiar listy.
        System.out.println("rozmiar listy  = " + listaImion.size());

        //Wyświetl trzeci element.
        System.out.println("trzeci element liast to : " + listaImion.get(2));

        //Wyświetl informacje o tym czy lista zawiera imię Sylwia.
        System.out.println("Czy jest imię Sylwia? - " + listaImion.contains("Sylwia"));

        //Wyświetl informacje o tym czy lista zawiera imię Marta.
        System.out.println("Czy jest imię Marta? - " + listaImion.contains("Marta"));

        //Wyświetl na którym miejscu w liście jest Jakub.
        System.out.println("Na którym indeksie jest Jakub? - " + listaImion.indexOf("Jakub"));

        //Wyświetl pierwsze 2 elementy.
        System.out.println(listaImion.get(0) + ", " + listaImion.get(1)); //TODO co jakby bylo pierwsze 50? DONE!
        System.out.println("pierwsze 2 elementy");
        for (int i = 0; i < 2; i++) {
            System.out.println(listaImion.get(i));
        }

        //Wyświetl pierwsze imię z listy od ostatniego do pierwszego znaku. „marek” -> „keram” bez StringBuildera.
        String marekName = listaImion.get(0);
        char[] marekTemp = marekName.toCharArray();

        for (int i = marekTemp.length - 1; i >= 0; i--)
            System.out.print(marekTemp[i]);

        //Wyświetl pierwsze imię z listy od ostatniego do pierwszego znaku. „marek” -> „keram”
        String reversed = new StringBuilder(listaImion.get(0)).reverse().toString();
        System.out.println(reversed);

//        Zamień w liście imię Marek na Sebastian.
        System.out.println("ArrayList przed zmianą: " + listaImion);
        listaImion.set(listaImion.indexOf("Marek"), "Sebastian");
        System.out.println("ArrayList po podmianie: " + listaImion);

//        Wyświetl ostatnie 2 elementy.
        System.out.println(listaImion.get(listaImion.size() - 2) + ", " +
                listaImion.get(listaImion.size() - 1));

//        Połącz wszystkie imiona z listy w jednego stringa i wyświetl.
        String allTogether = "";

        for (String oneWordInarray : listaImion) {
            allTogether += oneWordInarray;
        }
        System.out.println("jeden string : " + allTogether);


//        Połącz wszystkie imiona z listy, które zawierają literę „s” w jednego stringa i wyświetl.

        StringBuilder allTogetherifHaveS = new StringBuilder();

        for (String s3 : listaImion) {
            if (s3.contains("s")) {
                allTogetherifHaveS.append(s3);
            }

        }
        System.out.println(allTogetherifHaveS);

//        Wyświetl drugą i trzecią literę każdego imienia z listy.

        for (String s2 : listaImion) { //TODO foreach
            System.out.println("druga i trzecia litera: " + s2.substring(1, 3));
        }

//        Wyświetl listę w odwrotnej kolejności.

        Collections.reverse(listaImion);
        System.out.println("lista w odwrotnej kolejnosci" + listaImion);

//        Wyświetl imiona z listy, które zaczynają się na „M” lub kończą na „A”.


        for (String s1 : listaImion) {
            if (s1.startsWith("M") && s1.endsWith("A")) ;
            System.out.println(s1);
        }

//        Wyświetl wszystkie imiona łącznie z ilością znaków, z których się składają.

        System.out.println("Z ILOśCIĄ ");
        for (String s : listaImion) {
            System.out.println(s + " " + s.length());
        }

        //        Stwórz nową listę zawierającą 2 imiona (Anna, Maciej) i dodaj tę listę do naszej pierwszej listy.
        List<String> listaImion2 = new ArrayList<>();
        listaImion2.add("Anna");
        listaImion2.add("Maciej");
        listaImion.addAll(listaImion2);
        System.out.println(listaImion);

//Wyświetl informacje o tym czy lista zawiera imiona Aleksandra, Marta i Jakub.
        boolean isOla = listaImion.contains("Aleksandra");
        boolean isMarta = listaImion.contains("Marta");
        boolean isJakub = listaImion.contains("Jakub");
        System.out.println("Czy lista zawiera Aleksandra,- " + isOla);
        System.out.println("Czy lista zawiera Marta,- " + isMarta);
        System.out.println("Czy lista zawiera Jakub,- " + isJakub);

//Wyświetl wszystkie imiona z listy w formacie „indeks listy: imię” np. 3: Marta.
        String name;
        for (int i = 0; i < listaImion.size(); i++) {
            name = listaImion.get(i);
            System.out.println(i + ": " + name);

        }

//Usuń z listy pierwszy element i go wyświetl.
        String a = listaImion.remove(0);
        System.out.println(a);
        System.out.println("AAA" + listaImion);

//Usuń imię „Jakub” z listy.
        listaImion.remove("Jakub");
        System.out.println(listaImion);


//Posortuj listę alfabetycznie rosnąco. (*)
        Collections.sort(listaImion);
        System.out.println(listaImion);

//Posortuj listę alfabetycznie malejąco. (*)
        Collections.reverse(listaImion);
        System.out.println(listaImion);

//Sprawdź czy lista jest pusta i wyświetl tę informację.
        System.out.println("czy lista jest pusta? " + listaImion.isEmpty());

//Wyczyść listę i wyświetl jej zawartość.
        listaImion.removeAll(listaImion);
        System.out.println(listaImion);

//Ponownie sprawdź czy lista jest pusta.
        System.out.println("czy lista jest pusta? " + listaImion.isEmpty());

//Stwórz Set imion, i dodaj do niego 5 elementów (Maciej, Anna, Marta, Jakub, Bartosz).
        Set<String> nameSet = new TreeSet<>();
        nameSet.addAll(listaImion2);
        nameSet.add("Marta");
        nameSet.add("Jakub");
        nameSet.add("Bartosz");
        System.out.println(nameSet);

//Dodaj jeszcze raz imię Marek i wyświetl wszystkie elementy.
        nameSet.add("Maciej");
        System.out.println(nameSet);

//Utwórz nową HashMape i uzupełnij ją wartościami (1, Niebieski)(2, Zielony)(3, Czerwony).
        HashMap<Integer, String> mapWithColours = new HashMap<>();
        mapWithColours.put(1, "Niebieski");
        mapWithColours.put(2, "Zielony");
        mapWithColours.put(3, "Czerwony");

//Wyświetl wszystkie kolory.
        System.out.println(mapWithColours.values());

//Wyświetl wszystkie identyfikatory kolorów.
        System.out.println(mapWithColours.keySet());

//Dodaj nowy kolor do mapy za pomocą odpowiedniej metody.
        mapWithColours.put(4, "Czarny");
        System.out.println(mapWithColours.values());

//Wyświetl kolor, który znajdziemy pod id 2.
        System.out.println(mapWithColours.get(2));

//Wyświetl id, które odpowiada za kolor niebieski.
        for (Map.Entry<Integer, String> entry : mapWithColours.entrySet()) {
            if (entry.getValue().equals("Niebieski")) {
                System.out.println(entry.getKey());
            }
        }

//Usuń kolor o identyfikatorze 2 z mapy.
        mapWithColours.remove(2);
        System.out.println(mapWithColours);

//Usuń kolor czerwony z mapy.
        mapWithColours.entrySet().removeIf(color -> (color.getValue().equals("Czerwony")));
        System.out.println(mapWithColours.values());

//nt usun = 0;
//       for (Map.Entry<Integer, String> kolor : mapaKolorow.entrySet()) {
//           if (kolor.getValue().equalsIgnoreCase("czerwony"))
//               usun = kolor.getKey();
//       }
//       mapaKolorow.remove(usun);
    }

}

