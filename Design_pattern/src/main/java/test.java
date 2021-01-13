import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created By ChengZhen on 2020/1/9.
 * Author: Ash
 * Date: 2020/1/9
 * Time: 16:25
 * Debug the codes and debug the world!
 */
public class test {

    public static void main(String[] args) throws ParseException {
        String s = "2020-01-09T01:00:00.000000";
        Date today = new Date(System.currentTimeMillis());


        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = test.dealSpecialDateFormat(s);

        Date beforeDate = df2.parse(s1);
        if(today.after(beforeDate)){
            System.out.println("today bigger");
        }else{
            System.out.println("beforeDate bigger");
        }
    }

    public static String dealSpecialDateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return df2.format(date1);
    }
}
