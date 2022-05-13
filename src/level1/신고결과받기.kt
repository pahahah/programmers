package level1

class 신고결과받기_kotlin {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = IntArray(id_list.size) {0}
        var distinctReport = report.distinct()

        val notifier = Array(distinctReport.size){""}
        val notified = Array(distinctReport.size){""}

        var reportedCnt = IntArray(id_list.size){0}

        for(i in distinctReport.indices){
            notifier[i] = distinctReport[i].trim().split(" ")[0]
            notified[i] = distinctReport[i].trim().split(" ")[1]
        }

        for(i in distinctReport.indices){
            reportedCnt[id_list.indexOf(notified[i])]++
        }

        for(i in notified.indices){
            if(reportedCnt[id_list.indexOf(notified[i])] >= k){
                answer[id_list.indexOf(notified[i])]++
            }
        }
        return answer
    }
}