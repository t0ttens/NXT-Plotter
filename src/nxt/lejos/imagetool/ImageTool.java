package nxt.lejos.imagetool;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nxt.lejos.imagetool.controller.Controller;
import nxt.lejos.imagetool.model.Constants;

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
	
	public static void main(String[] args) throws IOException
	{
		Logger logger = LoggerFactory.getLogger(ImageTool.class.getName());
		logger.debug("ImageTool " + Constants.version + " startet");

		Controller.getInstance();
	}
}
