package cn.longQ.Pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.longQ.mapper.TbItemMapper;
import cn.longQ.pojo.TbItem;
import cn.longQ.pojo.TbItemExample;

public class PagehelperControllertest {
	
	@Test
	public void PageHelpertest() {
		//初始化spring容器
		ClassPathXmlApplicationContext classpath=
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemMapper itemMapper = classpath.getBean(TbItemMapper.class);
		PageHelper.startPage(1, 10);
		
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(list.size());
	}

}
