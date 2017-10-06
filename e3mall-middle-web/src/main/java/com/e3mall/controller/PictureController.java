package com.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.e3mall.utils.FastDFSClient;
import com.e3mall.utils.JsonUtils;

@Controller
public class PictureController {
	
	@Value("${image.server.url}")
	private String imageUrl;
	
	@RequestMapping(value="/pic/upload",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String uploadPicture(MultipartFile uploadFile){
		try {
			//获取文件名称
			String filename = uploadFile.getOriginalFilename();
			//获取文件后缀名
			String substring = filename.substring(filename.lastIndexOf(".")+1);
			//上传图片
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			String file = fastDFSClient.uploadFile(uploadFile.getBytes(), substring);
			//补充url
			String url = imageUrl+file;
			System.out.println(url);
			//创建map 
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
			
			return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "文件上传失败"+e.getMessage());
			e.printStackTrace();
			return JsonUtils.objectToJson(result);
		}
	}
}
