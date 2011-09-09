package threedc.github.com.amf;

import org.xml.sax.Attributes;

public class TriangleHandler extends Handler
{
	@Override
	public void endElement(ParserState parserState, String currentValue)
	{
		parserState.endTriangle();
	}

	@Override
	public ParserState startElement(ParserState parserState, Attributes attributes)
	{
		parserState.startTriangle();
		return parserState;
	}


}
