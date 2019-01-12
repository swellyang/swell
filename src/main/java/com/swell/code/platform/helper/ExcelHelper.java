package com.swell.code.platform.helper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


/**
 * Excel辅助类，不做过多的封装，只是把创建行和创建单元格简单封装下<br>
 * 步骤：<br>
 * 1、创建excel<br>
 * 2、创建sheet<br>
 * 3、填充数据，创建行和单元格<br>
 * 4、设置列宽，不设置则默认<br>
 * 5、导出excel<br>
 */
public class ExcelHelper {

    private static final Log logger = LogFactory.getLog(ExcelHelper.class);

    public static final float rowHeadHeight = 20;//表头行高
    public static final float rowBodyHeight = 16;//普通行高
    public static final int cellWidth = 20 * 256;//列宽

    public static CellStyle headStyle;//表头样式
    public static CellStyle bodyStyle;//主体样式

    private HSSFWorkbook workbook = null;//当前excel
    private HSSFSheet sheet = null;//当前sheet
    private Row row = null;//当前行对象
    private Cell cell = null;//当前列对象


    /**
     * 初始化实例,会自动创建excel对象
     */
    public ExcelHelper() {
        headStyle = null;
        bodyStyle = null;
        this.workbook = new HSSFWorkbook();
    }

    /**
     * 创建sheet
     *
     * @param sheetName
     */
    public void createSheet(String sheetName) {
        this.sheet = this.workbook.createSheet(sheetName);
    }

    /**
     * 创建行，是否为标题行，标题行行高大
     *
     * @param rowIndex
     * @param isHeader
     */
    public void createRow(int rowIndex, boolean isHeader) {
        if (this.sheet == null) {
            logger.error("%%%创建Excel出错%%% 请先创建sheet");
            return;
        }
        this.row = this.sheet.createRow(rowIndex);
        if (isHeader) {
            this.row.setHeightInPoints(rowHeadHeight);
        } else {
            this.row.setHeightInPoints(rowBodyHeight);
        }
    }

    /**
     * 创建单元格
     *
     * @param cellIndex
     * @param content
     * @param isHeader
     */
    public void createCell(int cellIndex, String content, boolean isHeader) {
        if (this.row == null) {
            logger.error("%%%创建Excel出错%%% 请先创建row");
            return;
        }
        this.cell = this.row.createCell(cellIndex, CellType.STRING);
        cell.setCellValue(content);
        if (isHeader) {
            cell.setCellStyle(getHeadStyle());
        } else {
            cell.setCellStyle(getBodyStyle());
        }
    }

    /**
     * 创建合并单元格
     *
     * @param fromRowIndex
     * @param toRowIndex
     * @param fromColIndex
     * @param toColIndex
     * @param content
     * @param isHeader
     */
    public void createMergeCell(int fromRowIndex, int toRowIndex, int fromColIndex, int toColIndex, String content, boolean isHeader) {
        if (this.row == null) {
            logger.error("%%%创建Excel出错%%% 请先创建row");
            return;
        }
        CellRangeAddress cra = new CellRangeAddress(fromRowIndex, toRowIndex, fromColIndex, toColIndex);
        sheet.addMergedRegion(cra);
        this.cell = this.row.createCell(fromColIndex, CellType.STRING);
        cell.setCellValue(content);
        if (isHeader) {
            cell.setCellStyle(getHeadStyle());
        } else {
            cell.setCellStyle(getBodyStyle());
        }
    }

    /**
     * 创建列宽,在填充完数据之后在设置列宽
     *
     * @param cellWidths
     * @return
     */
    public ExcelHelper setColumnWidths(int[] cellWidths) {
        for (int i = 0; i < cellWidths.length; i++) {
            this.sheet.setColumnWidth(i, cellWidths[i]);
        }
        return this;
    }

    /**
     * 返回表头单元格样式
     *
     * @return
     */
    private CellStyle getHeadStyle() {
        if (headStyle == null) {
            headStyle = this.workbook.createCellStyle();
            Font font = this.workbook.createFont();
            font.setFontHeightInPoints((short) 10);
            font.setBold(true);
            font.setColor(HSSFColor.WHITE.index);
            font.setFontName("宋体");
            headStyle.setFont(font);
            //自定义表体背景色
            headStyle.setFillForegroundColor(HSSFColor.SEA_GREEN.index);
            HSSFPalette palette = this.workbook.getCustomPalette();
            palette.setColorAtIndex(HSSFColor.SEA_GREEN.index, (byte) 68, (byte) 114, (byte) 196);
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headStyle.setAlignment(HorizontalAlignment.CENTER);
            headStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            headStyle.setBorderBottom(BorderStyle.THIN);
            headStyle.setBorderLeft(BorderStyle.THIN);
            headStyle.setBorderRight(BorderStyle.THIN);
            headStyle.setBorderTop(BorderStyle.THIN);
            headStyle.setTopBorderColor(HSSFColor.BLACK.index);
            headStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            headStyle.setLeftBorderColor(HSSFColor.BLACK.index);
            headStyle.setRightBorderColor(HSSFColor.BLACK.index);
        }
        return headStyle;
    }

    /**
     * 返回主体单元格样式
     *
     * @return
     */
    private CellStyle getBodyStyle() {
        if (bodyStyle == null) {
            bodyStyle = this.workbook.createCellStyle();
            Font font = this.workbook.createFont();
            font.setFontName("宋体");
            bodyStyle.setAlignment(HorizontalAlignment.CENTER);
            bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            bodyStyle.setBorderBottom(BorderStyle.THIN);
            bodyStyle.setBorderLeft(BorderStyle.THIN);
            bodyStyle.setBorderRight(BorderStyle.THIN);
            bodyStyle.setBorderTop(BorderStyle.THIN);
            bodyStyle.setTopBorderColor(HSSFColor.BLACK.index);
            bodyStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            bodyStyle.setLeftBorderColor(HSSFColor.BLACK.index);
            bodyStyle.setRightBorderColor(HSSFColor.BLACK.index);
        }
        return bodyStyle;
    }

    /**
     * 导出
     *
     * @param response 文件名
     * @param fileName
     */
    public void export(HttpServletResponse response, String fileName) {
        try {
            response.setContentType("application/octet;charset=UTF-8");
            fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1") + ".xls";
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
            OutputStream out = response.getOutputStream();
            this.workbook.write(out);
            this.workbook.close();
            out.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
