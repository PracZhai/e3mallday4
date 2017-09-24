package com.e3mall.service;

import com.e3mall.pojo.TbItem;

public interface ItemService {
	/**
	 * 项目搭建测试
	 * 根据id查询商品
	 * @param id
	 * @return
	 */
	TbItem findItemById(Long id);
}
