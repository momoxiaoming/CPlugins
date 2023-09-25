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
 * IRB.java
 *
 * Who   Date       Description
 * ====  =========  ==================================================
 * WY    14Apr2015  Added getThumbnailResource()
 * WY    10Apr2015  Added containsThumbnail() and getThumbnail()
 * WY    13Mar2015  Initial creation
 */

package pixy.meta.adobe;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pixy.io.IOUtils;
import pixy.meta.Metadata;
import pixy.meta.MetadataEntry;
import pixy.meta.MetadataType;
import pixy.util.ArrayUtils;

public class IRB extends Metadata {
	private boolean containsThumbnail;
	private ThumbnailResource thumbnail;
	Map<Short, _8BIM> _8bims = new HashMap<Short, _8BIM>();
	
	// Obtain a logger instance
//	private static final Logger LOGGER = LoggerFactory.getLogger(IRB.class);
	
	public static void showIRB(byte[] data) {
		if(data != null && data.length > 0) {
			IRB irb = new IRB(data);
			try {
				irb.read();
				irb.showMetadata();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
	public static void showIRB(InputStream is) {
		try {
			showIRB(IOUtils.inputStreamToByteArray(is));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public IRB(byte[] data) {
		super(MetadataType.PHOTOSHOP_IRB, data);
	}
	
	public Iterator<MetadataEntry> iterator() {
		ensureDataRead();
		List<MetadataEntry> items = new ArrayList<MetadataEntry>();

		for(_8BIM _8bim : _8bims.values())
			items.add(_8bim.getMetadataEntry());
	
		if(containsThumbnail) {
			int thumbnailFormat = thumbnail.getDataType(); //1 = kJpegRGB. Also supports kRawRGB (0).
//			switch (thumbnailFormat) {
//				case IRBThumbnail.DATA_TYPE_KJpegRGB:
//					items.add(new MetadataEntry("Thumbnail Format: ", "DATA_TYPE_KJpegRGB"));
//					break;
//				case IRBThumbnail.DATA_TYPE_KRawRGB:
//					items.add(new MetadataEntry("Thumbnail Format: ", "DATA_TYPE_KRawRGB"));
//					break;
//			}
			items.add(new MetadataEntry("Thumbnail width:", "" + thumbnail.getWidth()));
			items.add(new MetadataEntry("Thumbnail height: ", "" + thumbnail.getHeight()));
			// Padded row bytes = (width * bits per pixel + 31) / 32 * 4.
			items.add(new MetadataEntry("Thumbnail Padded row bytes:  ", "" + thumbnail.getPaddedRowBytes()));
			// Total size = widthbytes * height * planes
			items.add(new MetadataEntry("Thumbnail Total size: ", "" + thumbnail.getTotalSize()));
			// Size after compression. Used for consistency check.
			items.add(new MetadataEntry("Thumbnail Size after compression: ", "" + thumbnail.getCompressedSize()));
			// Bits per pixel. = 24
			items.add(new MetadataEntry("Thumbnail Bits per pixel: ", "" + thumbnail.getBitsPerPixel()));
			// Number of planes. = 1
			items.add(new MetadataEntry("Thumbnail Number of planes: ", "" + thumbnail.getNumOfPlanes()));
		}
	
		return Collections.unmodifiableList(items).iterator();
	}
	
	public boolean containsThumbnail() {
		ensureDataRead();
		return containsThumbnail;
	}
	
	public Map<Short, _8BIM> get8BIM() {
		ensureDataRead();
		return Collections.unmodifiableMap(_8bims);
	}
	
	public _8BIM get8BIM(short tag) {
		ensureDataRead();
		return _8bims.get(tag);
	}
	
//	public IRBThumbnail getThumbnail()  {
//		ensureDataRead();
//		return thumbnail.getThumbnail();
//	}
	
	public ThumbnailResource getThumbnailResource() {
		ensureDataRead();
		return thumbnail;
	}
	
	public void read() throws IOException {
		if(!isDataRead) {
			int i = 0;
			while((i+4) < data.length) {
				String _8bim = new String(data, i, 4);
				i += 4;			
				if(_8bim.equals("8BIM")) {
					short id = IOUtils.readShortMM(data, i);
					i += 2;
					// Pascal string for name follows
					// First byte denotes string length -
					int nameLen = data[i++]&0xff;
					if((nameLen%2) == 0) nameLen++;
					String name = new String(data, i, nameLen).trim();
					i += nameLen;
					//
					int size = IOUtils.readIntMM(data, i);
					i += 4;
					
					if(size <= 0) continue; //Fix bug with zero size 8BIM
					
					ImageResourceID eId = ImageResourceID.fromShort(id); 
					
					switch(eId) {
						case JPEG_QUALITY:
							_8bims.put(id, new JPGQuality(name, ArrayUtils.subArray(data, i, size)));
							break;
						case VERSION_INFO:
							_8bims.put(id, new VersionInfo(name, ArrayUtils.subArray(data, i, size)));
							break;
						case IPTC_NAA:
							byte[] newData = ArrayUtils.subArray(data, i, size);
							_8BIM iptcBim = _8bims.get(id);
							if(iptcBim != null) {
								byte[] oldData = iptcBim.getData();
								_8bims.put(id, new IPTC_NAA(name, ArrayUtils.concat(oldData, newData)));
							} else
								_8bims.put(id, new IPTC_NAA(name, newData));
							break;
						case THUMBNAIL_RESOURCE_PS4:
						case THUMBNAIL_RESOURCE_PS5:
							containsThumbnail = true;
							thumbnail = new ThumbnailResource(eId, ArrayUtils.subArray(data, i, size));
							_8bims.put(id, thumbnail);
							break;
						default:
							_8bims.put(id, new _8BIM(id, name, size, ArrayUtils.subArray(data, i, size)));
					}				
					
					i += size;
					if(size%2 != 0) i++; // Skip padding byte
				}
			}
			isDataRead = true;
		}
	}
	
	public void showMetadata() {
		ensureDataRead();
//		Log.i("","<<Adobe IRB information starts>>");
		for(_8BIM _8bim : _8bims.values()) {
			_8bim.print();
		}
		if(containsThumbnail) {
//			Log.i("{}", thumbnail.getResouceID()+"");
			int thumbnailFormat = thumbnail.getDataType(); //1 = kJpegRGB. Also supports kRawRGB (0).
//			switch (thumbnailFormat) {
//				case IRBThumbnail.DATA_TYPE_KJpegRGB:
//					Log.i("{}","Thumbnail format: KJpegRGB");
//					break;
//				case IRBThumbnail.DATA_TYPE_KRawRGB:
//					Log.i("{}","Thumbnail format: KRawRGB");
//					break;
//			}
//			Log.i("Thumbnail width: {}", thumbnail.getWidth()+"");
//			Log.i("Thumbnail height: {}", thumbnail.getHeight()+"");
//			// Padded row bytes = (width * bits per pixel + 31) / 32 * 4.
//			Log.i("Padded row bytes: {}", thumbnail.getPaddedRowBytes()+"");
//			// Total size = widthbytes * height * planes
//			Log.i("Total size: {}", thumbnail.getTotalSize()+"");
//			// Size after compression. Used for consistency check.
//			Log.i("Size after compression", thumbnail.getCompressedSize()+"");
//			// Bits per pixel. = 24
//			Log.i("Bits per pixel: {}", thumbnail.getBitsPerPixel()+"");
//			// Number of planes. = 1
//			Log.i("Number of planes: {}", thumbnail.getNumOfPlanes()+"");
		}

//		Log.i("","<<Adobe IRB information ends>>");
	}
}
