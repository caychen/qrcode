package org.com.cay.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//生成二维码
public class CreateQRCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int width = 300;
		int height = 300;
		String format = "png";
		String contents = "I Love You!";
		
		//定义二维码参数
		Map hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			
			Path file = new File("img.png").toPath();
			
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
