package level1

class lotto_kotlin {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = IntArray(2) {0}

        var unknown = 0
        var match_num = 0
        var rest_num = 6;
        for(i in lottos){
            if(i == 0){
                unknown++
            }else{
                if(win_nums.contains(i)){
                    match_num++
                }else{
                    rest_num--
                }
            }
        }
        if(unknown == 6){
            return IntArray(2) {1; 6}
        }
        if(match_num == 6){
            return IntArray(2){1;1}
        }
        if(match_num == 0 && unknown ==0){
            return IntArray(2){6;6}
        }
        answer[1] = 6 - match_num + 1
        if (unknown <= rest_num) {
            answer[0] = 6 - match_num - unknown + 1
        } else {
            answer[0] = 6 - match_num - rest_num + 1
        }
        return answer
    }
}