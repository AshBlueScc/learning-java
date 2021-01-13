package 读取excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author chengzhen
 * @date 2020/12/5
 * @time 12:11 下午
 */
public class ReadExcel {


    public static void main(String[] args) {

        try {
            // 读取的时候可以使用流，也可以直接使用文件名
            String path = "/Users/chengzhen/Documents/北纬科技-松果智联项目/manage-server/松果平台导卡必要信息-华创第9批卡片-1 尝试10张(2).xlsx";
            FileInputStream is = new FileInputStream(path);
            Workbook xwb = new XSSFWorkbook(is);
            // 仅读取第一个工作表sheet
            Sheet sheet = xwb.getSheetAt(0);
            for (int numRow = 1; numRow <= sheet.getLastRowNum(); numRow++) {
                Row row = sheet.getRow(numRow);

                //读取msisdn
                String iccid = row.getCell(0).getStringCellValue();
                System.out.println("读取excel第"+numRow+"行，第一列:"+ iccid);
                String msisdn = row.getCell(1).getStringCellValue();
                System.out.println("读取excel第"+numRow+"行，第二列:"+ msisdn);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
