package nxt.lejos.imagetool.model;

import nxt.lejos.imagetool.model.Constants.ValidatorResults;

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
		if (x < Constants.xMin || x > Constants.xMax)
		{	
			return ValidatorResults.X_INVALID;
		}
		if (y < Constants.yMin || y > Constants.yMax)
		{
			return ValidatorResults.Y_INVALID;
		}
		return ValidatorResults.TRUE;
	}
}
