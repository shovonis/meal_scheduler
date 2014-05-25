package net.therap.mealScheduler.util.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : rifatul.islam
 *         Date: 5/22/14
 *         Time: 11:09 AM
 */
public class DateTimeManager {

    public static Timestamp getTimeStampFromString(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        Timestamp timestamp = null;
        try {
            java.util.Date parsedDate = simpleDateFormat.parse(time);
            timestamp = new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    public static String getDayOfWeek(Timestamp timestamp) {
        return new SimpleDateFormat("EEEE").format(timestamp.getTime());
    }
}
