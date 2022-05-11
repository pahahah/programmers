package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 신고결과받기 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> reportedNumber = new HashMap<>();
        HashMap<String, ArrayList<String>> reportList = new HashMap<>();
        String[] distReport = Arrays.stream(report).distinct().toArray(String[]::new);
        for (String rep : distReport){
            String reporter = rep.substring(0,rep.lastIndexOf(" "));
            String reportedId = rep.substring(rep.lastIndexOf(" ") + 1);
            if(reportedNumber.containsKey(reportedId)){
                reportedNumber.replace(reportedId, reportedNumber.get(reportedId) + 1);
            }else {
                reportedNumber.put(reportedId, 1);
            }

            if(reportList.containsKey(reporter)){
                ArrayList<String> result = reportList.get(reporter);
                result.add(reportedId);
                reportList.replace(reporter, result);
            }else {
                ArrayList<String> result = new ArrayList<>();
                result.add(reportedId);
                reportList.put(reporter, result);
            }
        }
        int size = 0;
        for (String id : id_list){
            if(reportList.containsKey(id)){
                for(String temp : reportList.get(id)){
                    if(reportedNumber.containsKey(temp)){
                        if(reportedNumber.get(temp) >= k){
                            answer[size]++;
                        }
                    }
                }
            }else {
                answer[size] = 0;
            }
            size++;
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] result = solution(id_list, report, k);
        for (int i : result){
            System.out.println(i);
        }



    }
}
