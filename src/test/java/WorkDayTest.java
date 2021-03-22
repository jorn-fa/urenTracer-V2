import jorn.hiel.urentracker.business.entities.WorkDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class WorkDayTest {

    private WorkDay workDay;
    private final LocalDateTime testDate = LocalDateTime.now();
    private final LocalTime worked = LocalTime.now();
    private final LocalTime extras = LocalTime.of(0,45);


    @BeforeEach
    void setup(){
        workDay=new WorkDay();
    }

    @Test
    void doesExist(){
        assertNotNull(workDay);
    }

    @Test
    void standardValueTest(){
        assertNotNull(workDay);
        workDay.setDay(testDate).setWorked(worked).setExtraWorked(extras);
        assertEquals(testDate,workDay.getDay());
       assertEquals(worked,workDay.getWorked());
       assertEquals(extras, workDay.getExtraWorked());

    }


}
