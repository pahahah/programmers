package level1;

import java.util.Arrays;

public class K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++){
            int array1Length = commands[i][1] - commands[i][0] + 1;
            int[] array1 = new int[array1Length];
            int startIndex = commands[i][0] - 1;
            //System.out.println(startIndex);
            int endIndex = commands[i][1];
            int index = 0;
            for (int j = startIndex; j < endIndex; j++){
                array1[index] = array[j];
                //System.out.println("i: " + i  + "array"+ array[i]);
                index++;
            }
            Arrays.sort(array1);
            answer[i] = array1[commands[i][2] - 1];


        }
        return answer;
    }

//    public static void main(String[] args) {
//        int[] array = {1, 5, 2, 6, 3, 7, 4};
//        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
//        int[] answer = solution(array, commands);
//        for (int index : answer){
//            System.out.println(index);
//        }
//    }
}
