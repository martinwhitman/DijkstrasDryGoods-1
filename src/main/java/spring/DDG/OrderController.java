package spring.DDG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	@Autowired OrderDao dao;
	@RequestMapping(value = "/formOrder")
	public ModelAndView order( ){
		ModelAndView modelAndView = new ModelAndView( );
		
		modelAndView.setViewName("orderForm");
		modelAndView.addObject("order", new Order( ));
		
		
		return modelAndView;
	}
	@RequestMapping(value = "/result")
	public ModelAndView processOrder(Order order){
		
		ModelAndView modelAndView = new ModelAndView();
		dao.insertOrder(order);
		modelAndView.setViewName("orderResult");
		modelAndView.addObject("o", order);
		return modelAndView;
	}
	@RequestMapping(value="/trackOrder")
	public ModelAndView trackOrder() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("orderTrack");
		
		return modelAndView;
	}
	@Bean
	public OrderDao dao() {
		OrderDao bean = new OrderDao();
		return bean;
	}
}
