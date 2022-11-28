package com.myy803.coursesmanagement.service.statistics;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;

public class PercentilesStatisticStrategy extends TemplateStatisticStrategy {

	@Override
	public void doActualCalculation() {
		Percentile percentiles = new Percentile();
		
		super.setStatisticNum(percentiles.evaluate(getFinalGrades()));
	}

}
