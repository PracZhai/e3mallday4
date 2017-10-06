package com.e3mall.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.common.pojo.DataGridResult;
import com.e3mall.common.pojo.E3Result;
import com.e3mall.mapper.TbItemDescMapper;
import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemDesc;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.service.ItemService;
import com.e3mall.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
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
	
	/**
	 * 查询商品列表
	 */
	@Override
	public DataGridResult findItemList(int page,int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		//查询商品列表
		List<TbItem> list = itemMapper.selectByExample(example);
		//取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		//创建组合对象
		DataGridResult dataGridResult = new DataGridResult();
		dataGridResult.setTotal(pageInfo.getTotal());
		dataGridResult.setRows(list);
		return dataGridResult;
	}

	/**
	 * 添加商品
	 */
	@Override
	public E3Result addItem(TbItem item, String desc) {
		//生成商品id
		long itemId = IDUtils.genItemId();
		//补全商品信息
		item.setId(itemId);
		//商品状态 1正常 2下架 3删除
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//将该商品插入到数据库中
		itemMapper.insert(item);
		//商品描述对象的信息补全及插入
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDesc.setItemDesc(desc);
		itemDescMapper.insert(itemDesc);
		return E3Result.ok();
	}

}
