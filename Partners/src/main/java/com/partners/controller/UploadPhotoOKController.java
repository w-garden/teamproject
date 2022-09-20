package com.partners.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadPhotoOKController implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String saveFolder = request.getRealPath("upload");
		
		int fileSize = 10*1024*1024; //이진 파일 업로드 최대크기를 5M
		MultipartRequest multi = null;  // 이진 파일 업로드
		
		multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8");
		
		
		
		
		
		/**
		 * 폴더명 수정 해야함
		 */
		String homedir=saveFolder+"/"+"두집파트너스";/* 업체명 폴더 */
		
		File UpFile = multi.getFile("photo01"); // 첨부한 이진파일을 가져옴
		
		
		if(UpFile != null) {
			String fileName = UpFile.getName(); //첨부
			
			File path01 = new File(homedir); // 첨부할 사진 폴더 생성

			
			
			int index=fileName.lastIndexOf("."); //첨부파일에서 마침표 위치를 구함
			String fileExtendsion = fileName.substring(index+1); //마침표 이후부터 마지막 문자까지 구함. 즉 파일의 확장자를 구함

			String refileName ="수정파일"+"."+fileExtendsion;

			
			
			if(!(path01.exists())) { //첨부할 폴더가 없다면 
				path01.mkdir(); // 해당 포트폴리오 폴더 생성
			}
		
			
			
			UpFile.renameTo(new File(homedir+"/"+refileName));  //새롭게 생성된 폴더 경로에 업로드

		}
		
		return null;
	}
	
}
