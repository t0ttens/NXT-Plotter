package nxt.lejos.imagetool.model;

import nxt.lejos.data.Constants;
import nxt.lejos.data.Constants.ValidatorResults;

public class Validator
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
	
	public static ValidatorResults validateVectorInput(int x, int y)
	{
		if (x < Constants.XMIN || x > Constants.XMAX)
		{	
			return ValidatorResults.X_INVALID;
		}
		if (y < Constants.YMIN || y > Constants.YMAX)
		{
			return ValidatorResults.Y_INVALID;
		}
		return ValidatorResults.TRUE;
	}
}
