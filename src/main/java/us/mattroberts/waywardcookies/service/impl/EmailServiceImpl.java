package us.mattroberts.waywardcookies.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import us.mattroberts.waywardcookies.model.entity.Order;
import us.mattroberts.waywardcookies.service.EmailService;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    @Async
    public void notifyNewOrder(Order order) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("christina@waywardcookies.com");
        message.setTo("christina@waywardcookies.com");
        message.setSubject("A new order was entered through the website.");
        message.setText(buildOrderDetails(order));
        emailSender.send(message);
    }

    private String buildOrderDetails(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM / dd / yyyy HH:mm");
        String formattedDueDate = order.getDueDate().format(formatter);
        return "Order Number: " + order.getId() + System.lineSeparator() + System.lineSeparator() +
                "First Name: " + order.getFirstName() + System.lineSeparator() + System.lineSeparator() +
                "Last Name: " + order.getLastName() + System.lineSeparator() + System.lineSeparator() +
                "Phone: " + order.getPhone() + System.lineSeparator() + System.lineSeparator() +
                "Email: " + order.getEmail() + System.lineSeparator() + System.lineSeparator() +
                "Quantity: " + order.getCookieQuantity() + System.lineSeparator() + System.lineSeparator() +
                "Date: " + formattedDueDate + System.lineSeparator() + System.lineSeparator() +
                "Delivery Option: " + order.getLogistics().getLogisticsType().getCode() + System.lineSeparator() + System.lineSeparator() +
                "Order Details: " + order.getOrderDetails();
    }
}
