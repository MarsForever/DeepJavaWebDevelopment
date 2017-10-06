package org.it315;
import java.util.logging.Logger;

public class LogTest {
	private static Logger log = Logger.getLogger("org.it315.xxx");
	public static void main(String args[])
	{
		log.finest("the finest message");
		log.finer("finer message");
		log.fine("a fine message");
		log.config("some configuration message");
		log.info("a little bit of information");
		log.warning("a warning message");
		log.severe("a severe message");
	}
}