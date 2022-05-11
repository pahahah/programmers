package level2;

import java.util.Arrays;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book){
        boolean result = true;

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++){
            int num_length = phone_book[i].length();
            String num = phone_book[i];

            for (int j = i + 1; j < phone_book.length; j++){
                if(num.equals(phone_book[j])){
                    return false;
                }
                if(num_length < phone_book[j].length()){
                    if(phone_book[j].startsWith(num)){
                        return false;
                    }else {
                        i = j - 1;
                        break;
                    }
                }else {
                    i = j - 1;
                    break;
                }
            }
        }

        return result;
    }
}
