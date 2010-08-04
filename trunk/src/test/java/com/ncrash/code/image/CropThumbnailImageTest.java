package com.ncrash.code.image;

import java.awt.Image;
import java.io.File;

import org.junit.Test;

import com.ncrash.code.image.CropImage;
import com.ncrash.code.image.ThumbnailGenerator;
import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiException;
import com.sun.jimi.core.JimiUtils;

public class CropThumbnailImageTest {
	
	@Test
	public void testCropImageResource() throws Exception {
		File rolloverImageFile = new File(getClass().getClassLoader().getResource("Layer-Flash.png").getFile());
		
		String rolloverImageFileName = rolloverImageFile.getCanonicalPath();
		String rolloverImageCropFileName = rolloverImageFile.getParent() + System.getProperty("file.separator") + "Layer-Flash-Crop.png"; 
		String rolloverImageCropThumbnailJavaxFileName = rolloverImageFile.getParent() + System.getProperty("file.separator") + "Layer-Flash-Thumb-JAVAX.png"; 
		String rolloverImageCropThumbnailJimiFileName = rolloverImageFile.getParent() + System.getProperty("file.separator") + "Layer-Flash-Thumb-JIMI.png"; 
//		System.out.println(rolloverImageFile.getParent());
		
		/*
		 * Crop image
		 */
		CropImage cropImageInstance = new CropImage();
		cropImageInstance.cropImage(rolloverImageFileName, rolloverImageCropFileName, "png", 120, 0, 120, 90);
		
		/*
		 * Thumbnail Image with javax
		 */
		ThumbnailGenerator tg = new ThumbnailGenerator();
		tg.transform(rolloverImageCropFileName, rolloverImageCropThumbnailJavaxFileName, 56, 56, 1);

		/*
		 * Thumbnail Image with jimi
		 */
        Image thumbnail = JimiUtils.getThumbnail(rolloverImageCropFileName, 56, 56, Jimi.IN_MEMORY);

        try {
            Jimi.putImage(thumbnail, rolloverImageCropThumbnailJimiFileName);
        } catch (JimiException e) {
            e.printStackTrace();
        }
	}
	
//	@Test
//	public void testCropImage() throws Exception {
//		CropImage cropImageInstance = new CropImage("d:\\temp\\crop", "d:\\temp\\crop");
//		cropImageInstance.cropImage("Layer-Flash.png", "Layer-Flash-Crop.png", "png", 120, 0, 120, 90);
//	}
//	
//	@Test
//	public void testThumbnailImageWithJavax() throws Exception {
//		ThumbnailGenerator tg = new ThumbnailGenerator();
//		tg.transform("d:\\temp\\crop\\Layer-Flash-Crop.png", "d:\\temp\\crop\\Layer-Flash-Thumb-JAVAX.png", 56, 56, 1);
//	}
//	
//	@Test
//	public void testThumbnailImageWithJimi() throws Exception {
//        Image thumbnail = JimiUtils.getThumbnail("d:\\temp\\crop\\Layer-Flash-Crop.png", 56, 56, Jimi.IN_MEMORY);
//
//        try {
//            Jimi.putImage(thumbnail, "d:\\temp\\crop\\Layer-Flash-Thumb-JIMI.png");
//        } catch (JimiException e) {
//            e.printStackTrace();
//        }
//	}
}
