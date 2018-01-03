package com.example.canteen.model;

//校验结果
public class Validation {
	//校验的域
	private String field;
	//错误信息
	private String error;
	//错误码
	private int code;
	
	public Validation(int code, String field , String error){
		this.code = code;
		this.field = field;
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return "[field = "+ field + ", " + "error = "+ error + ", " + "code = " + code + ", "
				+"getCode() = " + getCode() + ", "
				+"getField() = " + getField() + ", "
				+"getError() = " + getError() + ", "
				+"getClass() = " + getClass() + ", "
				+"hashCode() = " + hashCode() + ", "
				+"toString() = " + super.toString()
				+"]";
	}
}
