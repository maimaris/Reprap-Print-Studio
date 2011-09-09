package threedc.github.com.amf;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;

import threedc.github.com.model.PrintableObject;

public class AmfHandler extends Handler
{
	static Logger logger = Logger.getLogger(AmfHandler.class);

	static int ATTRIBUTE_VERSION = 0;
	static int ATTRIBUTE_UNITS = 1;

	@Override
	public void endElement(ParserState currentState, String currentValue)
	{
	}

	@Override
	public ParserState startElement(ParserState parserState, Attributes attributes)
	{
		parserState = new ParserState();
		String units = attributes.getValue(ATTRIBUTE_UNITS);
		parserState.setUnits(units);
		return parserState;
	}

}
