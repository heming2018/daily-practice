package cn.heming.excel;


import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author heming1
 * @date 2018/11/22 15:51
 * @description TODO
 */
public class ExcelReader {

    @Test
    public static void main(String[] args) {

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("D:\\workspace\\idea\\personal-project\\daily-practice\\unit-test\\src\\main\\java\\cn\\heming\\excel\\fail post.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        com.alibaba.excel.ExcelReader excelReader = new com.alibaba.excel.ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, new ExcelListener());
        excelReader.read();
    }
}
