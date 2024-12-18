package tacos.kitchen;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import tacos.Order;

@Profile({"jms-template", "rabbitmq-template"})
@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderReceiverController {

  private final OrderReceiver orderReceiver;
  
  @GetMapping("/receive")
  public String receiveOrder(Model model) {
    Order order = orderReceiver.receiveOrder();  // 최대 5초까지 대기...큐에 데이터가 있을 때까지...
    if (order != null) {
      model.addAttribute("order", order);
      return "receiveOrder";
    }
    return "noOrder";
  }
  
  
}
