/**
 * 
 */
package stockprocessor.handler.processor.logical;

/**
 * @author anti
 */
public class AndProcessor extends TwoInputLogicalProcessor
{
	public AndProcessor()
	{
		setName("AND");
	}

	/*
	 * (non-Javadoc)
	 * @see stockprocessor.processor.DataProcessor#getDescription()
	 */
	@Override
	public String getDescription()
	{
		return "Calculate logical AND";
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * stockprocessor.handler.processor.logical.TwoInputLogicalProcessor#calculate
	 * (java.lang.String, java.lang.Boolean, java.lang.Boolean)
	 */
	@Override
	protected Boolean calculate(Boolean inputDataA, Boolean inputDataB)
	{
		return inputDataA && inputDataB;
	}
}
