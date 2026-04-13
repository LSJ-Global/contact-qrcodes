package com.lsjglobal;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LeeJaeGooQrGenerator {
    public static void main(String[] args) {
        try {
            String qrUrl = SvgUtil.qrUrl("Lee_jae_goo.vcf");
            int size = 300;

            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 1);

            BitMatrix matrix = new MultiFormatWriter().encode(qrUrl, BarcodeFormat.QR_CODE, size, size, hints);

            String svgFileName = "Lee_jae_goo_qr.svg";
            SvgUtil.writeSvg(matrix, svgFileName);
            System.out.println("✅ QR 생성 완료: qr/" + svgFileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
