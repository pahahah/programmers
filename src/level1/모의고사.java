package level1;

import java.util.*;

public class 모의고사 {
    public static int[] solution(int[] answers) {

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};



        int [] scores = {0, 0, 0};
        for (int i = 0; i < answers.length; i++ ){
            if (p1[i % 5] == answers[i]){
                scores[0]++;
            }
            if(p2[i % 8] == answers[i]){
                scores[1]++;
            }
            if(p3[i% 10] == answers[i]){
                scores[2]++;
            }
        }

        int[] arr = new int[scores.length];
        for (int i = 0; i < scores.length; i++){
            arr[i] = scores[i];
        }

        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(scores[i] == arr[2]){
                ans.add(i + 1);
            }
        }

        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }

}
