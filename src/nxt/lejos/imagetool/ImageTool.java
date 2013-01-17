package nxt.lejos.imagetool;

import nxt.lejos.imagetool.controller.Controller;
import nxt.lejos.imagetool.model.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * Christopher Ottens
 * 2013
 */

public class ImageTool
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	public static void main(String[] args)
	{
		StatusPrinter.print((LoggerContext) LoggerFactory.getILoggerFactory());
		
		Logger logger = LoggerFactory.getLogger(ImageTool.class.getName());
		logger.debug("ImageTool " + Constants.version + " startet");
		
//		Controller.getInstance();
	}
}
