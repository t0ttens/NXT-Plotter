package nxt.lejos.imagetool;

import nxt.lejos.imagetool.controller.Controller;
import nxt.lejos.imagetool.model.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Christopher Ottens
 * 2013
 */

public class ImageTool
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------
	
	private static final Logger logger = LoggerFactory.getLogger(ImageTool.class.getName());
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	public static void main(String[] args)
	{
//		StatusPrinter.print((LoggerContext) LoggerFactory.getILoggerFactory());
		
		logger.info("ImageTool " + Constants.version + " startet");
		Controller.getInstance();
	}
}
