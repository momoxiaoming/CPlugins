/**
 * Copyright (C) 2014-2019 by Wen Yu.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Any modifications to this file must keep this entire header intact.
 *
 * Change History - most recent changes go on top of previous changes
 *
 * MetadataUtils.java
 *
 * Who   Date       Description
 * ====  =========  ==============================================================
 * WY    13Mar2015  Initial creation
 */

package pixy.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import pixy.image.ImageType;
import pixy.io.PeekHeadInputStream;

/** 
 * This utility class contains static methods 
 * to help with image manipulation and IO. 
 * <p>
 * 
 * @author Wen Yu, yuwen_66@yahoo.com
 * @version 1.1.2 04/02/2012
 */
public class MetadataUtils {
	// Image magic number constants
	private static byte[] BM = {0x42, 0x4d}; // BM
	private static byte[] GIF = {0x47, 0x49, 0x46, 0x38}; // GIF8
	private static byte[] PNG = {(byte)0x89, 0x50, 0x4e, 0x47}; //.PNG
	private static byte[] TIFF_II = {0x49, 0x49, 0x2a, 0x00}; // II*.
	private static byte[] TIFF_MM = {0x4d, 0x4d, 0x00, 0x2a}; //MM.*
	private static byte[] JPG = {(byte)0xff, (byte)0xd8, (byte)0xff};
	private static byte[] PCX = {0x0a};
	private static byte[] JPG2000 = {0x00, 0x00, 0x00, 0x0C};
	private static byte[] WEBP = {0x52, 0x49, 0x46, 0x46}; //WEBP

	public static final int IMAGE_MAGIC_NUMBER_LEN = 4;
	
	// Obtain a logger instance
//	private static final Logger LOGGER = LoggerFactory.getLogger(MetadataUtils.class);
		
	public static ImageType guessImageType(PeekHeadInputStream is) throws IOException {
		// Read the first ImageIO.IMAGE_MAGIC_NUMBER_LEN bytes
		byte[] magicNumber = is.peek(IMAGE_MAGIC_NUMBER_LEN);
		ImageType imageType = guessImageType(magicNumber);
				
		return imageType;
	}
	
	public static ImageType guessImageType(byte[] magicNumber) {
		ImageType imageType = ImageType.UNKNOWN;
		// Check image type
		if(Arrays.equals(magicNumber, TIFF_II) || Arrays.equals(magicNumber, TIFF_MM))
			imageType = ImageType.TIFF;
		else if(Arrays.equals(magicNumber, PNG))
			imageType = ImageType.PNG;
		else if(Arrays.equals(magicNumber, GIF))
			imageType = ImageType.GIF;
		else if(magicNumber[0] == JPG[0] && magicNumber[1] == JPG[1] && magicNumber[2] == JPG[2])
			imageType = ImageType.JPG;
		else if(magicNumber[0] == BM[0] && magicNumber[1] == BM[1])
			imageType = ImageType.BMP;
		else if(magicNumber[0] == PCX[0])
			imageType = ImageType.PCX;
		else if(Arrays.equals(magicNumber, JPG2000)) {
			imageType = ImageType.JPG2000;
		}else if(Arrays.equals(magicNumber, WEBP)) {
			imageType = ImageType.WEBP;
		} else if(magicNumber[1] == 0 || magicNumber[1] == 1) {
			switch(magicNumber[2]) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 9:
				case 10:
				case 11:
				case 32:
				case 33:
					imageType = ImageType.TGA;					
			}
		} else {
//			LOGGER.error("Unknown format!");
		}
		
		return imageType;
	}
	
//	public static BufferedImage createThumbnail(InputStream is) throws IOException {
//		BufferedImage original = null;
//		if(is instanceof RandomAccessInputStream) {
//			RandomAccessInputStream rin = (RandomAccessInputStream)is;
//			long streamPointer = rin.getStreamPointer();
//			rin.seek(streamPointer);
//			original = javax.imageio.ImageIO.read(rin);
//			// Reset the stream pointer
//			rin.seek(streamPointer);
//		} else {
//			original = javax.imageio.ImageIO.read(is);
//		}
//		int imageWidth = original.getWidth();
//		int imageHeight = original.getHeight();
//		int thumbnailWidth = 160;
//		int thumbnailHeight = 120;
//		if(imageWidth < imageHeight) {
//			// Swap thumbnail width and height to keep a relative aspect ratio
//			int temp = thumbnailWidth;
//			thumbnailWidth = thumbnailHeight;
//			thumbnailHeight = temp;
//		}
//		if(imageWidth < thumbnailWidth) thumbnailWidth = imageWidth;
//		if(imageHeight < thumbnailHeight) thumbnailHeight = imageHeight;
//		BufferedImage thumbnail = new BufferedImage(thumbnailWidth, thumbnailHeight, BufferedImage.TYPE_INT_RGB);
//		Graphics2D g = thumbnail.createGraphics();
//		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//		        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//		g.drawImage(original, 0, 0, thumbnailWidth, thumbnailHeight, null);
//
//		return thumbnail;
//	}
	
	/**
	 * Wraps a BufferedImage inside a Photoshop _8BIM
	 * @param
	 * @return a Photoshop _8BMI
	 * @throws IOException
	 */
//	public static _8BIM createThumbnail8BIM(BufferedImage thumbnail) throws IOException {
//		// Create memory buffer to write data
//		ByteArrayOutputStream bout = new ByteArrayOutputStream();
//		// Compress the thumbnail
//		MetadataUtils.saveAsJPEG(thumbnail, bout, 100);
//		byte[] data = bout.toByteArray();
//		bout.reset();
//		// Write thumbnail format
//		IOUtils.writeIntMM(bout, 1); // 1 = kJpegRGB. We are going to write JPEG format thumbnail
//		// Write thumbnail dimension
//		int width = thumbnail.getWidth();
//		int height = thumbnail.getHeight();
//		IOUtils.writeIntMM(bout, width);
//		IOUtils.writeIntMM(bout, height);
//		// Padded row bytes = (width * bits per pixel + 31) / 32 * 4.
//		int bitsPerPixel = 24;
//		int planes = 1;
//		int widthBytes = (width*bitsPerPixel + 31)/32*4;
//		IOUtils.writeIntMM(bout, widthBytes);
//		// Total size = widthbytes * height * planes
//		IOUtils.writeIntMM(bout, widthBytes*height*planes);
//		// Size after compression. Used for consistency check.
//		IOUtils.writeIntMM(bout, data.length);
//		IOUtils.writeShortMM(bout, bitsPerPixel);
//		IOUtils.writeShortMM(bout, planes);
//		bout.write(data);
//		// Create 8BIM
//		_8BIM bim = new _8BIM(ImageResourceID.THUMBNAIL_RESOURCE_PS5, "thumbnail", bout.toByteArray());
//
//		return bim;
//	}
	
	public static int[] toARGB(byte[] rgb) {
		int[] argb = new int[rgb.length / 3];
		int index = 0;
		for(int i = 0; i < argb.length; i++) {
			argb[i] = 0xFF << 24 | (rgb[index++] & 0xFF) << 16 | (rgb[index++] & 0xFF) << 8 | (rgb[index++] & 0xFF);
		}
		
		return argb;
	}
	
	public static int[] bgr2ARGB(byte[] bgr) {
		int[] argb = new int[bgr.length / 3];
		int index = 0;
		for(int i = 0; i < argb.length; i++) {
			argb[i] = 0xFF << 24 | (bgr[index++] & 0xFF) |  (bgr[index++] & 0xFF) << 8 | (bgr[index++] & 0xFF) << 16;
		}
		
		return argb;
	}
	
//	public static void saveAsJPEG(BufferedImage image, OutputStream os, int quality) throws IOException {
//		if ((quality < 0) || (quality > 100)) {
//			throw new IllegalArgumentException("Quality out of bounds!");
//		}
//		float writeQuality = quality / 100f;
//	    ImageWriter jpgWriter = null;
//	    Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
//	    if (iter.hasNext()) {
//	      jpgWriter = (ImageWriter) iter.next();
//	    }
//		ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
//		jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//		jpgWriteParam.setCompressionQuality(writeQuality);
//		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
//		jpgWriter.setOutput(ios);
//		IIOImage outputImage = new IIOImage(image, null, null);
//		jpgWriter.write(null, outputImage, jpgWriteParam);
//		ios.flush();
//	    jpgWriter.dispose();
//	    ios.close();
//	}
	
	// Prevent from instantiation
	private MetadataUtils(){}

	public static String getImageType(InputStream is){

		PeekHeadInputStream peekHeadInputStream = new PeekHeadInputStream(is, IMAGE_MAGIC_NUMBER_LEN);
		ImageType imageType = null;
		try {
			imageType = MetadataUtils.guessImageType(peekHeadInputStream);
		} catch (IOException e) {
			e.printStackTrace();
			return ImageType.UNKNOWN.getExtension();
		}
		assert imageType != null;
		return imageType.getExtension();
	}
}
