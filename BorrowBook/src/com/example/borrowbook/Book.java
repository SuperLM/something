package com.example.borrowbook;

public class Book {
	private String name;
	private String editor;
	private String type;
	private int readerage;
	private int pic;

	public Book() {

	}

	public Book(String name, String editor, String type, int readerage,int pic) {
		this.setEditor(editor);
		this.setName(name);
		this.setReaderage(readerage);
		this.setType(type);
		this.setPic(pic);
	}

	public int getPic() {
		return pic;
	}

	public void setPic(int pic) {
		this.pic = pic;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getReaderage() {
		return readerage;
	}

	public void setReaderage(int readerage) {
		this.readerage = readerage;
	}
}
