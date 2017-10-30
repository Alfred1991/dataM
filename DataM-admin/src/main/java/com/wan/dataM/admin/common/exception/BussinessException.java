package com.wan.dataM.admin.common.exception;


import com.wan.dataM.core.exception.BaseException;

public class BussinessException extends BaseException {

	public BussinessException(BizExceptionEnum bizExceptionEnum) {
		super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
	}
}
