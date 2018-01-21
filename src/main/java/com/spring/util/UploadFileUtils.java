package com.spring.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

//1. 자동적인 폴더의 생성 
//2. 파일 저장은 UUID 사용하기
//3. 썸네일 이미지를 생성하는 기능
public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

	// 파일을 저장하기위해 필요한 것
	// 1. 파일의 저장 경로
	// 2. 원본 파일의 이름
	// 3. 파일 데이터
	// 별도의 데이터가 보관될 필요가 없기 때문에 static으로 설계함
	// 기본 경로(data/upload) + 폴더 경로(년/월/일) + 파일 이름(uuid+원래 이름)으로 파일 저장
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);

		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);

		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		String uploadedFileName = null;

		if (MediaUtils.getMediaType(formatName) != null) {
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		} else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}

		return uploadedFileName;

	}

	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {
		String iconName = uploadPath + path + File.separator + fileName;

		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, datePath);

		logger.info(datePath);

		return datePath;
	}

	private static void makeDir(String uploadPath, String... paths) {

		// 이미 해당 폴더가 있을 경우 폴더를 다시 만들지 않고 return 시킨다.
		if (new File(uploadPath + paths[paths.length - 1]).exists()) {
			return;
		}
		// /년/월/일을 하나씩 비교해 보아 없으면 폴더를 생성한다
		for (String path : paths) {

			File dirPath = new File(uploadPath + path);

			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}

	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {

		// BufferedImage는 실제 이미지가 아닌 메모리상의 이미지를 의미하는 객체이다.
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));

		// 원본 파일을 메모리상으로 로딩하고, 정해진 크기에 맞게 작은 이미지 파일에 원본 이미지를 복사한다.
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);

		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;

		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

}
