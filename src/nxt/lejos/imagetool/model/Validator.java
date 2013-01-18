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
		if (x < Constants.X_MIN || x > Constants.X_MAX)
		{	
			return ValidatorResults.X_INVALID;
		}
		if (y < Constants.Y_MIN || y > Constants.Y_MAX)
		{
			return ValidatorResults.Y_INVALID;
		}
		return ValidatorResults.TRUE;
	}
}
