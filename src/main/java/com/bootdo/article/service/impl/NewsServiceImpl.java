package com.bootdo.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.bootdo.article.dao.NewsDao;
import com.bootdo.article.domain.NewsDO;
import com.bootdo.article.service.NewsService;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.utils.FileType;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.common.utils.ImageUtils;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.UserDO;



@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsDao newsDao;

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public NewsDO get(Long cid){
		String key = "newsId_"+cid;
		ValueOperations<String, NewsDO> operations = redisTemplate.opsForValue();
		NewsDO newsDO = operations.get(key);
		if (newsDO != null){
			System.out.println("从redis中取");
			return newsDO;

		}else {
			NewsDO newsDO1 = newsDao.get(cid);
			operations.set(key,newsDO1);
			System.out.println("从mysql中取");
			return newsDO1;
		}
	}
	
	@Override
	public List<NewsDO> list(Map<String, Object> map){
		String key = "newsMap_"+map;
		ValueOperations<String,List<NewsDO>> operations = redisTemplate.opsForValue();
		List<NewsDO> listNewsDOS = operations.get(key);
		// 判断redis是否存在
		if(listNewsDOS != null){
			System.out.println(listNewsDOS.size());
			System.out.println("从redis中取");
			return listNewsDOS;
		}
		// 不存在先mysql查询后存redis
		else {
			List<NewsDO> listNewsDOS1 = newsDao.list(map);
			operations.set(key,listNewsDOS1);
			System.out.println("从mysql中取");
			return listNewsDOS1;
		}

	}
	
	@Override
	public int count(Map<String, Object> map){
		return newsDao.count(map);
	}

	@Override
	public int fuzzySearchCount(Map<String, Object> map) {

		return newsDao.fuzzySearchCount(map);
	}

	@Override
	public int save(NewsDO news){
		return newsDao.save(news);
	}
	
	@Override
	public int update(NewsDO news){
		return newsDao.update(news);
	}
	
	@Override
	public int remove(Long cid){
		return newsDao.remove(cid);
	}
	
	@Override
	public int batchRemove(Long[] cids){
		return newsDao.batchRemove(cids);
	}

	@Override
	public List<NewsDO> searchLikeTitle(Map<String, Object> map ) {
		return newsDao.searchLikeTitle(map);
	}




}
