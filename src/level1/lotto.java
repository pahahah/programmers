package level1;

import java.util.ArrayList;

public class lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int match_num = 0;
        int unknown = 0;
        ArrayList<Integer> rest_nums = new ArrayList<>();
        for(int num : win_nums){
            rest_nums.add(num);
        }
        for (int num : lottos){
            if(rest_nums.contains(num)){
                rest_nums.remove(rest_nums.indexOf(num));
                match_num++;
            }
            if(num == 0){
                unknown++;
            }
        }

        if (unknown < 1 && match_num < 1){
            return new int[] {6,6};
        }

        if(unknown == 6){
            return new int[] {1,6};
        }

        if(match_num == 6){
            return new int[] {1,1};
        }else {
            answer[1] = 6 - match_num + 1;
            if (unknown <= rest_nums.size()){
                answer[0] = 6 - match_num - unknown + 1;
            }else {
                answer[0] = 6 - match_num - rest_nums.size() + 1;
            }

        }



        return answer;
    }


    public static void main(String[] args) {
        int[] lottos = {97, 96, 99, 98, 95, 94};
        int[] win_nums ={31, 10, 45, 1, 6, 19};
        int[] result = solution(lottos, win_nums);
        System.out.println(result[0] + ", " + result[1]);



    }
}
