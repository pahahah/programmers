package sort;


import java.util.*;

public class 가장_큰_수 {
    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();
        int i = 0;
        for (int num : numbers){
            strings.add(String.valueOf(num));
            i++;
        }

        Collections.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        if (strings.get(0).equals("0")){
            return "0";
        }
        for(String a : strings){
            sb.append(a);
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};

        System.out.println(solution(numbers));

        int[] numbers1 = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers1));

        int[] numbers2 = {0, 0};

        System.out.println(solution(numbers2));


        int[] numbers3 = {21, 22, 23, 2, 10, 221, 212};

        System.out.println(solution(numbers3));


        int[] numbers4 = {1, 11, 110, 1011};

        System.out.println(solution(numbers4));
    }
}
