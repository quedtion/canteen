package com.example.canteen.utils;

import com.example.canteen.model.Validation;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验相关功能类
 */
public class ValidationUtils {
	
	/**
	 * 按类型固定长度正则表达式校验数据
	 * @param field 字段名
	 * @param value 字段值
	 * @param type 类型 number：只能数字；letters：只能字母；letters.number 只能数字加字母；
	 * 				chinese：只能中文字符；char：数字加汉字；validation:任意类型
	 * @param size 长度
	 * @return 正确返回true，错误返回false
	 */
	private boolean regex(String field, String value, String type, int size){
		String st_regex = "";
		switch(type){
			case "number" :
				st_regex = "^\\d{"+size+"}$";
				break;
			case "letters":
				st_regex = "^[A-Za-z]{"+size+"}";
				break;
			case "letters.number":
				st_regex = "^\\w{"+size+"}";
				break;
			case "chinese":
				st_regex = "^[\\u4e00-\\u9fa5]{"+size+"}";
				break;
			case "char":
				st_regex = "^[\\u4e00-\\u9fa5\\w{"+size+"}]";
				break;
			case "validation":
				st_regex = "^.{"+size+"}";
				break;
		}
		return regex(value, st_regex);
	}
	
	/**
	 * 按类型固定长度正则表达式校验数据
	 * @param field 字段名
	 * @param value 字段值
	 * @param type 类型 number：只能数字；letters：只能字母；letters.number：只能数字加字母；
	 * 				chinese：只能中文字符；char：数字加汉字；validation:任意类型
	 * @param min 最小长度
	 * @param max 最大长度
	 * @return 正确返回true，错误返回false
	 */
	private boolean regex(String field, String value, String type, int min, int max){
		String st_regex = "";
		switch(type){
			case "number" :
				st_regex = "^\\d{"+min+","+max+"}$";
				break;
			case "letters":
				st_regex = "^[A-Za-z]{"+min+","+max+"}";
				break;
			case "letters.number":
				st_regex = "^\\w{"+min+","+max+"}";
				break;
			case "chinese":
				st_regex = "^[\\u4e00-\\u9fa5]{"+min+","+max+"}";
				break;
			case "char":
				st_regex = "^[\\u4e00-\\u9fa5\\w]{"+min+","+max+"}";
				break;
			case "validation":
				st_regex = "^.{"+min+","+max+"}";
				break;
		}
		return regex(value, st_regex);
	}
	
	/**
	 * 执行正则表达式校验
	 * @param value 值
	 * @param st_regex 表达式
	 * @return 正确返回true， 错误返回false
	 */
	private boolean regex(String value, String st_regex){
		Pattern pattern = Pattern.compile(st_regex);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

	/**
	 * 按类型固定长度正则表达式校验数据
	 * @param field 字段名
	 * @param value 字段值
	 * @param type 类型 number：只能数字；letters：只能字母；letters.number 只能数字加字母；
	 * 				chinese：只能中文字符；char：数字加汉字；validation:任意类型
	 * @param size 长度
	 * @param e Spring from errors使用的校验结果
	 */
	public void regex(String field, String value, String type, int size, Errors e) {
		String[] errorarg = {""+size};
		if(regex(field,value,type,size)){
			e.rejectValue(field, type, errorarg, "");
		}
	}

	/**
	 * 按类型长度范围正则表达式校验数据
	 * @param field 字段名
	 * @param value 字段值
	 * @param type 类型 number：只能数字；letters：只能字母；letters.number 只能数字加字母；
	 * 				chinese：只能中文字符；char：数字加汉字；validation:任意类型
	 * @param min 最小长度
	 * @param max 最大长度
	 * @param e Spring from errors 用校验结果
	 */
	public void regex(String field, String value, String type, int min, int max, Errors e) {
		String[] errorarg = {""+min , ""+max};
		if(regex(field, value, type, min, max)){
			e.rejectValue(field, type, errorarg, "");
		}
	}

	/**
	 * 按类型固定长度正则表达式校验数据
	 * @param field 字段名
	 * @param value 字段值
	 * @param type 类型 number：只能数字；letters：只能字母；letters.number 只能数字加字母；
	 * 				chinese：只能中文字符；char：数字加汉字；validation:任意类型
	 * @param size 长度
	 * @param nullable 可以为空的标志
	 * @param validations 使用的校验结果
	 */
	public void verifyString(String field, Object value, String type, int size, boolean nullable,
			List<Validation> validations) {
		if(value == null || "".equals(value.toString().trim())){
			if(!nullable){
				validations.add(new Validation(-200, field , "必须填写"));
			}
		}else{
			String st_message = "";
			if(size == value.toString().length()){
				st_message = "请输入长度为" + size + "的字符串";
				validations.add(new Validation(-210, field , st_message));
			}else{
				if(regex(field, value.toString(), type, size)){

					switch(type){
						case "number" :
							st_message = "只能输入"+size+"位数字";
							break;
						case "letters":
							st_message = "只能输入"+size+"位字母";
							break;
						case "letters.number":
							st_message = "只能输入"+size+"位的数字和字母";
							break;
						case "chinese":
							st_message = "只能输入"+size+"个汉字";
							break;
						case "char":
							st_message = "只能输入"+size+"个文字";
							break;
						case "validation":
							st_message = "只能输入"+size+"位文字";
							break;
					}
					validations.add(new Validation(-240, field , st_message));
				}
			}
		}
	}

	/**
	 * 字符串校验按类型长度范围正则表达式校验数据
	 * @param field 字段名
	 * @param value 字段值
	 * @param type 类型 number：只能数字；letters：只能字母；lettersumber 只能数字加字母；
	 * 				chinese：只能中文字符；char：数字加汉字；validation:任意类型
	 * @param min 最小长度
	 * @param max 最大长度
	 * @param nullable 可以为空的标志
	 * @param validations 使用的校验结果
	 */
	public void verifyString(String field, Object value, String type, int min, int max, boolean nullable,
			List<Validation> validations) {
		if(value == null || "".equals(value.toString().trim())){
			if(!nullable){
				validations.add(new Validation(-200, field , "必须填写"));
			}
		}else{
			String st_message = "";
			int size = value.toString().length();
			if(size > max || size < min){
				st_message = "请输入长度在" + min + "到" + max + "之间的字符串";
				validations.add(new Validation(-210, field , st_message));
			}else{
				if(regex(field, value.toString(), type, min, max)){
					switch(type){
						case "number" :
							st_message = "只能输入"+min+"到"+max+"位数字";
							break;
						case "letters":
							st_message = "只能输入"+min+"到"+max+"位字母";
							break;
						case "letters.number":
							st_message = "只能输入"+min+"到"+max+"位的数字和字母";
							break;
						case "chinese":
							st_message = "只能输入"+min+"到"+max+"个汉字";
							break;
						case "char":
							st_message = "只能输入"+min+"到"+max+"个文字";
							break;
						case "validation":
							st_message = "只能输入"+min+"到"+max+"位文字";
							break;
					}
					validations.add(new Validation(-240, field , st_message));
				}
			}
		}
	}

	/**
	 * 校验int类型
	 * @param field 字段名
	 * @param value 字段值
	 * @param min 最小值
	 * @param max 最大值
	 * @param nullable 可以为空的标志
	 * @param validations 使用的校验结果
	 */
	public void verifyInt(String field, Object value, int min, int max, boolean nullable,
			List<Validation> validations) {
		if(value == null || "".equals(value.toString().trim())){
			if(!nullable){
				validations.add(new Validation(-200, field , "必须填写"));
			}
		}else{
			String st_data = value.toString();
			String st_regEx = "^-?[0-9]\\d*$";
			Pattern p =Pattern.compile(st_regEx);
			Matcher m = p.matcher(st_data);
			if(!m.matches()){
				validations.add(new Validation(-240, field, "只能输入介于"+min+"到"+max+"之间的整数"));
			}else{
				value = Integer.parseInt(st_data);
				if((int)value < min || (int)value > max){
					validations.add(new Validation(-220, field, "只能输入介于"+min+"到"+max+"之间的整数"));
				}
			}
		}
	}

	/**
	 * 校验float类型
	 * @param field 字段名称
	 * @param value 字段值
	 * @param min 最小值
	 * @param max 最大值
	 * @param size 小数点位数最大值
	 * @param nullable 是否可空
	 * @param validations 使用的校验结果
	 */
	public void verifyFloat(String field, Object value, float min, float max, int size,
							boolean nullable, List<Validation> validations) {
		if(value == null || "".equals(value.toString().trim())){
			if(!nullable){
				validations.add(new Validation(-200, field,"必须填写"));
			}
		}else{
			if(size < 0){
				validations.add(new Validation(-1, field, "校验函数使用错误，请检查代码"));
			}else{
				String st_data = value.toString();
				String st_regEx = "^(-?\\d+)(\\.\\d{0,"+ size +"})?$";
				Pattern p =Pattern.compile(st_regEx);
				Matcher m = p.matcher(st_data);
				if(!m.matches()){
					validations.add(new Validation(-240, field, "只能输入至多" + size + "位的浮点数"));
				}else{
					value = Float.parseFloat(st_data);
					if((float)value < min || (float)value > max){
						validations.add(new Validation(-220,
								field, "只能输入介于" + min + "到" + max + "之间的浮点数"));
					}
				}
			}
		}
	}

}
