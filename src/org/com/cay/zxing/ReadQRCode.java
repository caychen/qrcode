package org.com.cay.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

//读取二维码
public class ReadQRCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MultiFormatReader formatReader = new MultiFormatReader();
			
			File file = new File("img.png");
			BufferedImage image = ImageIO.read(file);
			
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			
			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");		
					
			Result result = formatReader.decode(binaryBitmap, hints);
			
			//解析结果
			System.out.println("解析结果: " + result.toString());
			System.out.println("二维码格式类型: " + result.getBarcodeFormat());
			System.out.println("二维码文本内容: " + result.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
