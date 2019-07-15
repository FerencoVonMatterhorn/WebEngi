package main.java.util;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class MarkerUtil {

	public static final Marker LOGIN_MARKER = MarkerManager.getMarker("Login");
	public static final Marker REGISTER_MARKER = MarkerManager.getMarker("Register");

}
