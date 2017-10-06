package com.e3mall.service;

import java.util.List;
import com.e3mall.common.pojo.TreeNode;
import com.e3mall.pojo.TbItemCat;

public interface ItemCatService {

	/**
	 * 查询商品分类列表
	 */
	List<TreeNode> findItemCatList(Long id);
}
