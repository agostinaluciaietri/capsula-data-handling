package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Answer {
    private HttpStatus status;
    private String answerText;
    private Object data;

    public static Answer ok(String message, Object data){
        Answer answer = new Answer();
        answer.setStatus(HttpStatus.OK);
        answer.setAnswerText(message);
        answer.setData(data);
        return answer;
    }

}
