import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz {
    private int [] question;
    private int answer;

    public Quiz(int[] question,int answer){
        this.question=question;
        this.answer=answer;
    }

    public String getQuestion() {
        return Arrays.toString(question);
    }



    public int getAnswer() {
        return answer;
    }

    public static List<Quiz> getQuizes(){
        List<Quiz> l=new ArrayList<>();
        l.add(new Quiz(new int[]{1,2,3,4},4 ));
        return l;
    }

}
