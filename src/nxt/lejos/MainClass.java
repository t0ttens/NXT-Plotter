package nxt.lejos;

import java.text.SimpleDateFormat;
import java.util.Date;

import nxt.lejos.data.Constants;
import nxt.lejos.imagetool.controller.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

/**
 * Christopher Ottens
 * 2013
 */

public class MainClass
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------
	
	private static final Logger logger = LoggerFactory.getLogger(MainClass.class.getName());
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	public static void main(String[] args)
	{
		loggerConfig();
		
		logger.info(Constants.NAME + " " + Constants.VERSION + " startet");
		Controller.getInstance();
	}
	
	private static void loggerConfig()
	{
		//Diese Methode konfiguriert den Dateinamen des File-Appenders der logback.xml als Zeitstempel
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD-HH-mm-ss");
		String timestamp = dateFormat.format(new Date());
		
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator jc = new JoranConfigurator();
		jc.setContext(context);
		context.reset();
		context.putProperty("timestamp", timestamp);
		
		try
		{
			jc.doConfigure("src/logback.xml");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
