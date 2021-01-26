package boardGame.model;

import com.alibaba.excel.annotation.ExcelProperty;

public class EasyExcelUseData {
	
	@ExcelProperty(value="a時間")
	private String MonthOrDate;
	@ExcelProperty(value="b收入")
	private String Income;
	@ExcelProperty(value="c地區")
	private String Area;
	
	public EasyExcelUseData() {
		super();
	}
	
	public EasyExcelUseData(String monthOrDate, String income, String area) {
		super();
		MonthOrDate = monthOrDate;
		Income = income;
		Area = area;
	}
	
	public String getMonthOrDate() {
		return MonthOrDate;
	}
	public void setMonthOrDate(String monthOrDate) {
		MonthOrDate = monthOrDate;
	}
	public String getIncome() {
		return Income;
	}
	public void setIncome(String income) {
		Income = income;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	
	
}
