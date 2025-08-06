package com.lsjglobal;

import com.google.zxing.common.BitMatrix;

public class SvgUtil {
    public static String toSvg(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();

        StringBuilder svg = new StringBuilder();
        svg.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        svg.append("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" ")
                .append("width=\"").append(width).append("\" height=\"").append(height).append("\" ")
                .append("shape-rendering=\"crispEdges\">\n");
        svg.append("<rect width=\"100%\" height=\"100%\" fill=\"white\"/>\n");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    svg.append("<rect x=\"").append(x).append("\" y=\"").append(y)
                            .append("\" width=\"1\" height=\"1\" fill=\"black\"/>\n");
                }
            }
        }

        svg.append("</svg>");
        return svg.toString();
    }
}