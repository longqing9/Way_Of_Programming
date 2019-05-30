package cn.longQ.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.longQ.common.utils.CookieUtils;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.common.utils.JsonUtils;
import cn.longQ.pojo.TbItem;
import cn.longQ.service.ItemService;

@Controller
public class CartController {
	@Autowired
	private ItemService itemService;
	@Value("${COOK_TIME_EXPRE}")
	private int cookietime; 

	@RequestMapping("/cart/add/{itemId}")
	public String addCart(@PathVariable Long itemId,@RequestParam(defaultValue="1")Integer num,
			HttpServletRequest request,HttpServletResponse response) {
		List<TbItem> list = getCartListFromCookie(request);
		boolean flag=false;
		for (TbItem tbItem : list) {
			if(tbItem.getId()==itemId.longValue()) {
				flag=true;
				tbItem.setNum(tbItem.getNum()+num);
				break;
			}
		}
		if(!flag) {
			TbItem tbItem = itemService.getItemByid(itemId);
			tbItem.setNum(num);
			String image = tbItem.getImage();
			if(StringUtils.isNoneBlank(image)) {
				String[] split = image.split(",");
				tbItem.setImage(split[0]);
			}
			list.add(tbItem);
		}
		CookieUtils.setCookie(request, response, "cart", JsonUtils.objectToJson(list), cookietime, true);
		return "cartSuccess";
		
	}
	
	
	private List<TbItem> getCartListFromCookie(HttpServletRequest request){
		String json = CookieUtils.getCookieValue(request, "cart",true);
		if(StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		List<TbItem> list = JsonUtils.jsonToList(json, TbItem.class);
		return list;
		
	}
	
	@RequestMapping("/cart/cart")
	public String ShowCartList(HttpServletRequest request) {
		List<TbItem> list = getCartListFromCookie(request);
		request.setAttribute("cartList", list);
		return "cart";
	}
	
	/**
	 * 更新购物车数量
	 * @return
	 */
	@RequestMapping("/cart/update/num/{itemId}/{num}")
	@ResponseBody
	public ElfResult UpdateCartNum(@PathVariable long itemId,@PathVariable Integer num,
			HttpServletRequest request,HttpServletResponse response) {
		List<TbItem> list = getCartListFromCookie(request);
		for (TbItem tbItem : list) {
			if(tbItem.getId().longValue()==itemId) {
				tbItem.setNum(num);
				break;
			}
		}
		CookieUtils.setCookie(request, response, "cart", JsonUtils.objectToJson(list), cookietime, true);
		return ElfResult.ok();
	}
	
	@RequestMapping("/cart/delete/{itemId}")
	public String deleteCartItem(@PathVariable long itemId,
			HttpServletRequest request,HttpServletResponse response) {
		List<TbItem> list = getCartListFromCookie(request);
		for (TbItem tbItem : list) {
			if(tbItem.getId().longValue()==itemId) {
				list.remove(tbItem);
				break;
			}
		}
		CookieUtils.setCookie(request, response, "cart", JsonUtils.objectToJson(list), cookietime, true);
		return "redirect:/cart/cart.html";
	}
	
	
	
}
