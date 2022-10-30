package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stop {
    String location;
    String comment;
    LocalDateTime started;
    LocalDateTime ended;
    SimpleDateFormat totalTime;

}
