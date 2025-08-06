package com.lsjglobal;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class KongDoheeQrGenerator {
    public static void main(String[] args) {
        try {
            String qrUrl = "https://lsj-global.github.io/contact-qrcodes/Kong_Dohee.vcf";
            int size = 300;

            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 1);

            BitMatrix matrix = new MultiFormatWriter().encode(qrUrl, BarcodeFormat.QR_CODE, size, size, hints);

            Path svgPath = FileSystems.getDefault().getPath("Kong_Dohee.svg");
            try (FileWriter writer = new FileWriter(svgPath.toFile())) {
                writer.write(SvgUtil.toSvg(matrix));
            }

            System.out.println("✅ QR 생성 완료: Kong_Dohee_qr.svg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
