/**
 * 
 */
package stockprocessor.stock.source;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stockprocessor.data.StockData;
import stockprocessor.gui.processor.BaseElement;
import stockprocessor.processor.StockDataReceiver;
import stockprocessor.source.AbstractStockDataSource;

/**
 * @author anti
 */
public class ChartElementDataSource extends AbstractStockDataSource<StockData<?>>
{
	public static final String CHART_ELEMENTS = "Chart elements";

	private final Map<String, BaseElement> elementMap = new HashMap<String, BaseElement>();

	private final List<String> elementNameList = new ArrayList<String>();

	/*
	 * (non-Javadoc)
	 * @see hu.bogar.anti.stock.source.StockDataSource#getAvailableInstruments()
	 */
	@Override
	public String[] getAvailableInstruments()
	{
		return elementNameList.toArray(new String[elementNameList.size()]);
	}

	/*
	 * (non-Javadoc)
	 * @see hu.bogar.anti.stock.source.StockDataSource#getName()
	 */
	@Override
	public String getName()
	{
		return "Chart elements";
	}

	public void registerElement(BaseElement element)
	{
		String name = element.getName();
		elementMap.put(name, element);
		elementNameList.add(name);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * hu.bogar.anti.stock.source.AbstractStockDataSource#registerDataReceiver
	 * (java.lang.String, hu.bogar.anti.stock.processor.StockDataReceiver)
	 */
	@Override
	public void registerDataReceiver(String instrument, StockDataReceiver<StockData<?>> dataReceiver)
	{
		BaseElement element = elementMap.get(instrument);
		element.registerDataReceiver(instrument, dataReceiver);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * hu.bogar.anti.stock.source.AbstractStockDataSource#removeDataReceiver
	 * (java.lang.String, hu.bogar.anti.stock.processor.StockDataReceiver)
	 */
	@Override
	public void removeDataReceiver(String instrument, StockDataReceiver<StockData<?>> dataReceiver)
	{
		BaseElement element = elementMap.get(instrument);
		element.removeDataReceiver(instrument, dataReceiver);
	}
}