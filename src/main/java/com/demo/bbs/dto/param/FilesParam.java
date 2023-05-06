package com.demo.bbs.dto.param;

public class FilesParam {

	private String parents_board_seq;
	private String original_file_name;
	private String save_file_name;
	private String file_size;
	private String file_extension;
	private String file_path;
	
	public FilesParam(String parents_board_seq, String original_file_name, String save_file_name, String file_size,
			String file_extension, String file_path) {
		super();
		this.parents_board_seq = parents_board_seq;
		this.original_file_name = original_file_name;
		this.save_file_name = save_file_name;
		this.file_size = file_size;
		this.file_extension = file_extension;
		this.file_path = file_path;
	}
	
	public String getParents_board_seq() {
		return parents_board_seq;
	}
	
	public void setParents_board_seq(String parents_board_seq) {
		this.parents_board_seq = parents_board_seq;
	}
	
	public String getOriginal_file_name() {
		return original_file_name;
	}
	
	public void setOriginal_file_name(String original_file_name) {
		this.original_file_name = original_file_name;
	}
	
	public String getSave_file_name() {
		return save_file_name;
	}
	
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	
	public String getFile_size() {
		return file_size;
	}
	
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	
	public String getFile_extension() {
		return file_extension;
	}
	
	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}
	
	public String getFile_path() {
		return file_path;
	}
	
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	
	
}
