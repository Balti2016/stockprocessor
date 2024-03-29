/**
 * 
 */
package stockprocessor.gui.handler.receiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Second;

import stockprocessor.data.ShareData;
import stockprocessor.data.information.ParameterInformation;
import stockprocessor.handler.receiver.AbstractDataReceiver;

/**
 * @author anti
 */
public abstract class BaseElement<T> extends AbstractDataReceiver<T> implements Element
{
	protected final String instrument;

	/**
	 * 
	 */
	public BaseElement(String instrument)
	{
		this.instrument = instrument;
	}

	protected RegularTimePeriod getTimePeriod(ShareData<?> stockData)
	{
		return new Second(stockData.getTimeStamp());
	}

	@Override
	public String toString()
	{
		return getName();
	}

	public String getName()
	{
		return instrument;
	}

	/*
	 * (non-Javadoc)
	 * @see stockprocessor.data.handler.DataHandler#getDescription()
	 */
	@Override
	public String getDescription()
	{
		return "Draw data onto chart";
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * stockprocessor.handler.receiver.AbstractDataReceiver#createOptionalParameters
	 * ()
	 */
	@Override
	protected List<ParameterInformation> createOptionalParameters()
	{
		List<ParameterInformation> list = new ArrayList<ParameterInformation>();

		return list;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * stockprocessor.handler.receiver.DataReceiver#setOptionalParameterInformations
	 * (java.util.Map)
	 */
	@Override
	public void setOptionalParameters(Map<String, Object> optionalParameters)
	{
		// NOP
	}

	protected int getFreeRendererPosition(XYPlot plot)
	{
		for (int i = 0; i < 255; i++)
		{
			if (plot.getRenderer(i) == null)
				return i;
		}

		// TODO message
		throw new RuntimeException("No more free renderer position on chart");
	}
}