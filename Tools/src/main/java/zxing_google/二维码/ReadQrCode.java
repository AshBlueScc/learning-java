package zxing_google.二维码;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ReadQrCode
 * @Description: 解析二维码
 * @date 2018/7/12 10:55
 */
public class ReadQrCode {
    private static final Logger logger = LoggerFactory.getLogger(ReadQrCode.class);

    public static Result readQrCode(String path){
        Result result = null;
        try {
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            //定义二维码参数
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
            //获取读取二维码结果
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            result = multiFormatReader.decode(binaryBitmap, hints);
        } catch (Exception e) {
            logger.error("找不到对应文件！");
        }
        return result;
    }

    public static void main(String[] args) {
        Result result = readQrCode("/Users/chengzhen/workAndLearning_cz/idea-workspace/learning-java/Tools/src/main/java/zxing_google.二维码/have_logo_word.png");
        System.out.println("读取二维码： " + result.toString());
        System.out.println("二维码格式： " + result.getBarcodeFormat());
        System.out.println("二维码内容： " + result.getText());
    }

}