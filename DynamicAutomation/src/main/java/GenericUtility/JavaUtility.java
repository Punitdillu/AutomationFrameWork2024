package GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * generate random number within range 0 to 10000
	  * @return integer
	 */

			public int getRandomNum() {
				
				Random random = new Random();
				int ranNum=random.nextInt(10000);
				return ranNum;
			}
			/**
			 * this method return date and time in IST format
			 * @return String
			 */

				public String getSystemDateAnadTime() 
				{
					Date date = new Date();
					return date.toString();
				}
				/**
				 * used to get system date in yyyy-mm-dd format
				 * @return
				 */
				public String getSystemDateWithFormate() {
					
					Date date = new Date();
					String dateAndtime = date.toString();
					
					String yyyy=dateAndtime.split(" ")[5];
					String dd = dateAndtime.split(" ")[2];
					int mm='0'+(date.getMonth());
					String finalFormate = yyyy+"-"+mm+"-"+dd;
					return finalFormate;
					
				}

}
