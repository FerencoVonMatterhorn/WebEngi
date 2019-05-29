package main.java.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public interface LoggingUtil {

	Marker M_DO_GET = MarkerManager.getMarker(MarkerNames.DO_GET);
	Marker M_DO_POST = MarkerManager.getMarker(MarkerNames.DO_POST);
	Marker M_AUTH = MarkerManager.getMarker(MarkerNames.AUTH);

	interface MarkerNames {

		String DO_GET = "DOGET =>";
		String DO_POST = "DOPOST =>";
		String AUTH = "AUTH";

	}

	public class LoggerFactory {

		private LoggerFactory() {
			// Constructor may be empty.
		}

		public static Logger getLogger(Class<?> clazz) {
			return LogManager.getLogger(clazz);
		}

	}

}
