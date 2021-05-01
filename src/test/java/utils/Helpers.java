package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.EventsPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Helpers {
    static Logger logger = LogManager.getLogger(Helpers.class);

    public static Date getDateFromString(String dateString) {
        Date date = null;

        // Если указан диапазон дат, то выбираем вторую дату, которую потом будем сравнивать
        if (dateString.contains("-")) {
            dateString = dateString.split("-")[1];
        }
        try {
            date = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dateString);
        } catch (ParseException ex) {
            logger.info(ex.getMessage());
        }

        return date;
    }
}
