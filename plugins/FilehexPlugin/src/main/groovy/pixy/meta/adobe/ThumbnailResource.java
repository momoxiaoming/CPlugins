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
 * ThumbnailResource.java
 * <p>
 * Adobe thumbnail resource wrapper
 *
 * Who   Date       Description
 * ====  =========  ===================================================
 * WY    09Apr2016  Added new constructor
 * WY    14Apr2015  Fixed a bug with super() call, changed data to null 
 * WY    14Apr2015  Added new constructor
 * WY    13Apr2015  Initial creation
 */

package pixy.meta.adobe;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import pixy.io.IOUtils;
import pixy.meta.Thumbnail;
import pixy.util.ArrayUtils;

public class ThumbnailResource extends _8BIM {
	// Check to make sure id is either ImageResourceID.THUMBNAIL_RESOURCE_PS4
	// or ImageResourceID.THUMBNAIL_RESOURCE_PS5
	private static ImageResourceID validateID(ImageResourceID id) {
		if(id != ImageResourceID.THUMBNAIL_RESOURCE_PS4 && id != ImageResourceID.THUMBNAIL_RESOURCE_PS5)
			throw new IllegalArgumentException("Unsupported thumbnail ImageResourceID: " + id);
		
		return id;
	}	
	// Fields
	private int width;
	private int height;
	//Padded row bytes = (width * bits per pixel + 31) / 32 * 4.
	private int paddedRowBytes;
	// Total size = widthbytes * height * planes
	private int totalSize;
	// Size after compression. Used for consistency check.
	private int compressedSize;
	// Bits per pixel. = 24
	private int bitsPerPixel;
	// Number of planes. = 1
	private int numOfPlanes;
	private ImageResourceID id;
	private int dataType;
	// Thumbnail
	private IRBThumbnail thumbnail = new IRBThumbnail();
	

	
	// id is either ImageResourceID.THUMBNAIL_RESOURCE_PS4 or ImageResourceID.THUMBNAIL_RESOURCE_PS5
	public ThumbnailResource(ImageResourceID id, int dataType, int width, int height, byte[] thumbnailData) {
		super(validateID(id), "THUMBNAIL_RESOURCE", null);
		// Initialize fields
		this.id = id;
		this.dataType = dataType;
		/** Sometimes, we don't have information about width and height */
		this.width = (width > 0)? width : 0; 
		this.height = (height > 0)? height : 0;
		// paddedRowBytes = (width * bitsPerPixel + 31) / 32 * 4.
		// totalSize = paddedRowBytes * height * numOfPlanes
		this.paddedRowBytes = (width * 24 + 31)/32 * 4;
		this.totalSize = paddedRowBytes * height * numOfPlanes;
		this.compressedSize = thumbnailData.length;
		this.bitsPerPixel = 24;
		this.numOfPlanes = 1;
	}
		
	public ThumbnailResource(ImageResourceID id, byte[] data) {
		super(validateID(id), "THUMBNAIL_RESOURCE", data);
		this.id = id;
		read();
	}
	
	public ThumbnailResource(ImageResourceID id,Thumbnail thumbnail) {
		this(id, thumbnail.getDataType(), thumbnail.getWidth(), thumbnail.getHeight(), thumbnail.getCompressedImage());
	}
		

	public int getBitsPerPixel() {
		return bitsPerPixel;
	}
	
	public int getCompressedSize() {
		return compressedSize;
	}
	
	public int getDataType() {
		return dataType;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getNumOfPlanes() {
		return numOfPlanes;
	}
	
	public int getPaddedRowBytes() {
		return paddedRowBytes;
	}
	
	public ImageResourceID getResouceID() {
		return id;
	}
	

	public int getTotalSize() {
		return totalSize;		
	}
	
	public int getWidth() {
		return width;
	}
		

	
	private void read() {
		this.dataType = IOUtils.readIntMM(data, 0); //1 = kJpegRGB. Also supports kRawRGB (0).
		this.width = IOUtils.readIntMM(data, 4);
		this.height = IOUtils.readIntMM(data, 8);
		// Padded row bytes = (width * bits per pixel + 31) / 32 * 4.
		this.paddedRowBytes = IOUtils.readIntMM(data, 12);
		// Total size = widthbytes * height * planes
		this.totalSize = IOUtils.readIntMM(data, 16);
		// Size after compression. Used for consistency check.
		this.compressedSize = IOUtils.readIntMM(data, 20);
		this.bitsPerPixel = IOUtils.readShortMM(data, 24); // Bits per pixel. = 24
		this.numOfPlanes = IOUtils.readShortMM(data, 26); // Number of planes. = 1
		byte[] thumbnailData = null;
		if(dataType == Thumbnail.DATA_TYPE_KJpegRGB)
			thumbnailData = ArrayUtils.subArray(data, 28, compressedSize);
		else if(dataType == Thumbnail.DATA_TYPE_KRawRGB)
			thumbnailData = ArrayUtils.subArray(data, 28, totalSize);
	}
	
	public void write(OutputStream os) throws IOException {
		if(data == null) {			
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] compressedData = bout.toByteArray();
			bout.reset();
			// Write thumbnail format
			IOUtils.writeIntMM(bout, dataType);
			IOUtils.writeIntMM(bout, width);
			IOUtils.writeIntMM(bout, height);
			IOUtils.writeIntMM(bout, paddedRowBytes);
			// Total size = widthbytes * height * planes
			IOUtils.writeIntMM(bout, totalSize);
			// Size after compression. Used for consistency check.
			IOUtils.writeIntMM(bout, compressedData.length);
			IOUtils.writeShortMM(bout, bitsPerPixel);
			IOUtils.writeShortMM(bout, numOfPlanes);
			bout.write(compressedData);
			data = bout.toByteArray();
			size = data.length;
		}
		super.write(os);
	}	
}
