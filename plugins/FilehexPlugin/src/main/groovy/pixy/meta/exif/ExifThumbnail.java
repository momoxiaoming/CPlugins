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
 * ExifThumbnail.java
 *
 * Who   Date       Description
 * ====  =========  =================================================
 * WY    27Apr2015  Added copy constructor
 * WY    10Apr2015  Added new constructor, changed write()
 * WY    09Apr2015  Moved setWriteQuality() to super class
 * WY    14Jan2015  initial creation
 */

package pixy.meta.exif;


import pixy.image.tiff.IFD;

/**
 * Encapsulates image EXIF thumbnail metadata
 *  
 * @author Wen Yu, yuwen_66@yahoo.com
 * @version 1.0 01/08/2014
 */
public class ExifThumbnail  {
	// Comprised of an IFD and an associated image
	// Create thumbnail IFD (IFD1 in the case of JPEG EXIF segment)
	private IFD thumbnailIFD = new IFD(); 
	
	public ExifThumbnail() { }
	

	


}
