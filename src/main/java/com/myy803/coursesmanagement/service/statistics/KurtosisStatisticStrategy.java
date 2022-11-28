package com.myy803.coursesmanagement.service.statistics;

import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;

public class KurtosisStatisticStrategy extends TemplateStatisticStrategy{

	@Override
	public void doActualCalculation() {
		Kurtosis kurtosis = new Kurtosis();
		
		kurtosis.incrementAll(super.getFinalGrades());
				
		super.setStatisticNum(kurtosis.getResult());
	}
	
}
