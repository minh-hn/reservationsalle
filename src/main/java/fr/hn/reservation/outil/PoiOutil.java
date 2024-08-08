package fr.hn.reservation.outil;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class PoiOutil {

	public static int getCellIntegerValue(FormulaEvaluator formulaEvaluator, Cell cell) {
		return (int)(cell.getNumericCellValue());
	}

	public static String getCellStringValue(FormulaEvaluator evaluator, Cell cell) {
		String tmp = getCellStringValueOrNull(evaluator, cell);
		return (tmp == null) ? "" : tmp;
	}

	public static String getCellStringValueOrNull(FormulaEvaluator evaluator, Cell cell) {
		if (cell != null) {
			DecimalFormat df;
			String val;
			switch (cell.getCellType()) {
			case STRING:
				return cell.getRichStringCellValue().getString();
			case NUMERIC:
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat formatTime = new SimpleDateFormat("HHmm");
					return formatTime.format(date);
				}
				df = new DecimalFormat("##.###############");
				val = df.format(cell.getNumericCellValue());
				if (val.endsWith(".0"))
					val = val.substring(0, val.length() - 2);
				return val;
			case BOOLEAN:
				return cell.getBooleanCellValue() ? "true" : "false";
			case FORMULA:
				try {
					if (evaluator != null) {
						CellValue cellValue = evaluator.evaluate(cell);
						return cellValue.getStringValue();
					}
					return null;
				} catch (Throwable e) {
					// FIXME gestion des erreurs à faire
					break;
				}
			}
			return null;
		}
		return null;
	}
}
