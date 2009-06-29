/**
 * 
 */
package stockprocessor.handler.source;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

import stockprocessor.data.ShareData;
import stockprocessor.data.information.DefaultParameterInformation;
import stockprocessor.data.information.ParameterInformation;
import stockprocessor.data.information.ParameterInformation.ParameterType;

/**
 * @author anti
 */
public class RandomStockDataSource extends AbstractDataSource<ShareData<Integer>>
{
	public static final String INSTRUMENT = "RND";

	private int lastValue = 10000;

	private Date baseDate = new Date();

	private final int dateStep;

	/**
	 * @param dateStep in seconds
	 * @param timerStep
	 */
	public RandomStockDataSource(final int dateStep, final long timerStep)
	{
		this.dateStep = dateStep;

		new ImportTimer(getName(), timerStep)
		{
			@Override
			protected void timeTick()
			{
				publishNewData(INSTRUMENT, generateStockData());
			}
		};
	}

	protected ShareData<Integer> generateStockData()
	{
		// set time
		baseDate = DateUtils.addSeconds(baseDate, dateStep);

		double random = Math.random();
		int delta = (int) ((random - 0.5) * 100);
		lastValue = (lastValue + (delta));

		// System.out.println(lastValue + " + " + delta + " [" + random + "/" +
		// (random - 0.5) + "]");

		return new ShareData<Integer>(INSTRUMENT, lastValue, (long) (100 * Math.random()), baseDate);
	}

	/*
	 * (non-Javadoc)
	 * @see hu.bogar.anti.stock.source.StockDataSource#getName()
	 */
	@Override
	public String getName()
	{
		return "Random data Source";
	}

	/*
	 * (non-Javadoc)
	 * @see stockprocessor.source.AbstractDataSource#createOutputParameters()
	 */
	@Override
	protected List<ParameterInformation> createOutputParameters()
	{
		List<ParameterInformation> list = new ArrayList<ParameterInformation>();

		ParameterInformation parameterInformation = new DefaultParameterInformation(INSTRUMENT, ParameterType.STOCK_DATA_NUMBER);
		list.add(parameterInformation);

		return list;
	}

	/*
	 * (non-Javadoc)
	 * @see stockprocessor.data.handler.DataHandler#getDescription()
	 */
	@Override
	public String getDescription()
	{
		return "Generates random stock datas, in stepping " + dateStep + "ms";
	}
}
