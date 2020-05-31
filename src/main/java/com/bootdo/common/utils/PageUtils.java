package com.bootdo.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @Author huamu.com
 */
public class  PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	// 总行数
	private int total;
	// 每页展示的数量 对象是一个泛型
	private List<?> rows;

	public PageUtils(List<?> list, int total) {
		this.rows = list;
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
