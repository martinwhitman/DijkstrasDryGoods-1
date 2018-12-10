package spring.DDG;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	@Autowired OrderDao dao;
	private static final String[ ] products = {"Motherboard", "Processor", "Solid State Drive", "Blue Ray Burner", "CPU Air Cooler", "SDRAM DDR4", "Gaming Video Card", "650W Power Supply", "Steel Tower", "Hard Drive", "Booksize Barebone System", "HDMI Cable"};
	
	/**
	 * Martin
	 * @return
	 */
	@RequestMapping(value = "/formOrder")
	public ModelAndView order(){
		ModelAndView modelAndView = new ModelAndView( );
		modelAndView.setViewName("orderForm");
		modelAndView.addObject("order", new Order( ));
		return modelAndView;
	}
	
	/**
	 * Martin
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/result")
	public ModelAndView processOrder(Order order){
		
		ModelAndView modelAndView = new ModelAndView();
		dao.insertOrder(order);
		modelAndView.setViewName("orderResult");
		modelAndView.addObject("o", order);
		return modelAndView;
	}
	
	/**
	 * Martin
	 * @return
	 */
	@RequestMapping(value="/trackOrder")
	public ModelAndView trackOrder() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("orderTrack");
		modelAndView.addObject("trackingNumber",new OrderTracking());
		return modelAndView;
	}
	
	/**
	 * Martin
	 * @param trackingNumber
	 * @return
	 */
	@RequestMapping(value="/trackResult")
	public ModelAndView trackResult(OrderTracking trackingNumber) {
		ModelAndView modelAndView = new ModelAndView();
		trackingNumber.setDeliveryOrder();
		trackingNumber.setScheduledDelivery();
		modelAndView.setViewName("trackResult");
		modelAndView.addObject("t", trackingNumber);
		return modelAndView;
	}
	
	/**
	 * Mysti **complete**
	 * @return
	 */
	@RequestMapping(value="/serviceSide")
	public ModelAndView serviceSide() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("serviceEntry");
		return modelAndView;
	}
	
	//@RequestMapping(value="/viewByOrder")
	/*public ModelAndView viewByOrder(int orderNo) {
		ModelAndView modelAndView = new ModelAndView();
		dao.viewOrder(orderNo);
		modelAndView.setViewName("orderViewer");
		
		return modelAndView;
	}*/
	
	/**
	 * View a customer order by the order number using orderViewer.jsp, 
	 * 
	 * @return order information
	 */
	@RequestMapping(value="/orderViewForm")
	public ModelAndView orderViewForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("orderViewer");
		modelAndView.addObject("orderView", new Order());
		return modelAndView;
	}
	
	/**
	 * Provides the order information based on the viewOrderForm above
	 * @param on
	 * @return
	 */
	@RequestMapping(value="/orderViewResult")
	public ModelAndView orderViewResult(Integer on) {
		ModelAndView modelAndView = new ModelAndView();
		dao.viewOrder(on);
		modelAndView.setViewName("orderViewResult");
		modelAndView.addObject("o", order());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/editInventory")
	public ModelAndView editInventory() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inventoryEdit");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/viewCurrentInventory")
	public ModelAndView viewCurrentInventory() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Order> fullInventory = dao.generateList();
		modelAndView.setViewName("inventoryView");
		modelAndView.addObject("all", fullInventory);
		return modelAndView;
	}
	
	@RequestMapping(value="/viewPendingDeliveries")
	public ModelAndView viewPendingDeliveries() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deliveryView");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/viewSalesByProd")
	public ModelAndView viewSalesByProd() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("salesView");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/calculateProfitLoss")
	public ModelAndView calculateProfitLoss() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("profitLoss");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/calculateLogistics")
	public ModelAndView calculateLogistics() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("logisticsCalc");
		
		return modelAndView;
	}
	@Bean
	public OrderDao dao() {
		OrderDao bean = new OrderDao();
		return bean;
	}
}
