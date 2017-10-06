package com.e3mall.service;

import java.util.List;

import com.e3mall.common.pojo.DataGridResult;
import com.e3mall.common.pojo.E3Result;
import com.e3mall.common.pojo.TreeNode;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemDesc;

public interface ItemService {
	/**
	 * 项目搭建测试
	 * 根据id查询商品
	 * @param id
	 * @return
	 */
	TbItem findItemById(Long id);
	/**
	 * 查询商品列表
	 */
	DataGridResult findItemList(int page,int row);
	/**
	 * 插入数据
	 */
	E3Result addItem(TbItem item,String desc);
}
