package thinkInJava;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static net.mindview.util.Print.*;

public class DateDemo {
	  private static final String DATEFORMAT ="yyyy-MM-dd'T'HH:mm:ss'Z'";
	  
	  public static void main(String[] args)
	  {
		 final String dt = GetUTCdatetimeAsString();
		 print(dt);
	  }
	  
	  public static String GetUTCdatetimeAsString()
	  {
	      final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
	      sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	      final String utcTime = sdf.format(new Date());

	      return utcTime;
	  }
}
