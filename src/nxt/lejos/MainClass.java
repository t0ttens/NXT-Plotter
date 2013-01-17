package nxt.lejos;

import nxt.lejos.data.Constants;
import nxt.lejos.imagetool.controller.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
//		StatusPrinter.print((LoggerContext) LoggerFactory.getILoggerFactory());
		
		logger.info(Constants.NAME + " " + Constants.VERSION + " startet");
		Controller.getInstance();
	}
}
