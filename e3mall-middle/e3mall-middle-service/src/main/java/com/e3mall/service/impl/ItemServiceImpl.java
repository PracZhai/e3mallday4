package com.e3mall.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private TbItemMapper itemMapper;
	/**
	 * 根据id查询商品信息
	 * 框架搭建测试
	 */
	@Override
	public TbItem findItemById(Long id) {
		//TbItem tbItem = itemMapper.selectByPrimaryKey(id);
		//工具类
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		//执行查询
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list != null&& list.size()>0){
			TbItem tbItem = list.get(0);
			return tbItem;
		}
		return null;
	}

}
