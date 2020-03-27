package com.logistics.manage.util;


public class HouseConstant {

	public static final String BACKUP_SESSION = "memberPOForBackup";

	public static final String MESSAGE_LOGIN_FAILED = "登录账号或密码不正确！请核对后再登录！";
	
	public static final String MESSAGE_INPUT_INVALID = "请输入有效的信息";
	public static final String MESSAGE_REGISTER_LOGINACCT_ALREADY_EXIST = "注册账户已存在！";
	public static final String MESSAGE_REGISTER_SUCCESS = "注册成功！请登录！";
	public static final String MESSAGE_ID_INVALID = "Id不得为空！";
	public static final String MESSAGE_ERROR_INTERNAL = "发生服务器内部错误！请重新输入！";
	public static final String MESSAGE_LOGIN_SUCCESS = "登录成功！";
	public static final String MESSAGE_DATA_EMPTY = "用户不存在！";
	public static final String MESSAGE_MEMBER_DO_NOT_BE_USE = "用户不能使用！请联系管理员！";
	public static final String NOT_MANAGER = "暂时不是管理员！不得登录后台！";

	public static final class PathUrl{

		//backup
		public static final String BACKUP_LOGIN_DERECTION = "/go/to/login";
		public static final String BACKUP_LOGIN = "/backup/member-login";



    }
}
