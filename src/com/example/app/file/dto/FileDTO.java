package com.example.app.file.dto;
//-- 서버에 저장되는 파일명
//file_system_name varchar(300) primary key,
//-- 원본 파일 명
//file_original_name varchar(300),
//board_number int unsigned,
public class FileDTO {

	private String fileSystemName;
	private String fileOriginalName;
	private int boardNumber;
	
	public FileDTO() {}

	public String getFileSystemName() {
		return fileSystemName;
	}

	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}

	public String getFileOriginalName() {
		return fileOriginalName;
	}

	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	@Override
	public String toString() {
		return "FileDTO [fileSystemName=" + fileSystemName + ", fileOriginalName=" + fileOriginalName + ", boardNumber="
				+ boardNumber + "]";
	}
	
	
}
